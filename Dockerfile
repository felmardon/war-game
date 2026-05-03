FROM openjdk:25-slim

ARG BUILD_VERSION=latest
ARG ENVIRONMENT=dev

WORKDIR /app

COPY target/war-game-simulator-engine-1.0.0.jar war-game.jar

ENV SPRING_PROFILES_ACTIVE=${ENVIRONMENT}
ENV BUILD_VERSION=${BUILD_VERSION}

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=10s --start-period=40s --retries=3 \
    CMD curl -f http://localhost:8080/api/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "war-game.jar"]

