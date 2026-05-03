# War Game Simulation

A Java-based turn-based strategy game simulation featuring competitive AI algorithms and dynamic gameplay mechanics.

## Project Aim

The goal of War Game Simulation is to:
- **Experiment with AI algorithms** - Implement and compare different decision-making strategies (Minimax, Alpha-Beta Pruning, Random)
- **Develop game mechanics** - Build a robust board-based game system with turn management and state evaluation
- **Learn systems design** - Create scalable, well-structured code for growing complexity
- **Bridge desktop and web** - Eventually transition this to an interactive browser-based web application

## Current State

The project is currently in **early development** as a standalone Java application with:
- ✅ Core game infrastructure (Board, Pieces, Squares)
- ✅ Multiple AI algorithms for move evaluation
- ✅ Maven-based project structure for easy dependency management
- ⚙️ Basic game rendering and player management (in progress)
- ❌ Full game rules and win conditions (not yet implemented)
- ❌ Web UI (planned for future)

## How to Run Locally

### Prerequisites
- **Java 25** installed on your machine
- **Maven 3.6+** installed
- **Git** (optional, for cloning)
- **Docker** (optional, for containerized deployment)
- **Docker Compose** (optional, for simplified Docker setup)

### Setup & Run

1. **Clone or download the project**
   ```bash
   git clone https://github.com/YOUR_USERNAME/war-game.git
   cd war-game
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run Spring Boot Application**
   ```bash
   # Run with default (dev) profile
   mvn spring-boot:run
   
   # Or with specific profile
   mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"
   ```

4. **Run as executable JAR**
   ```bash
   java -jar target/war-game-simulator-engine-1.0.0.jar
   ```

5. **Run tests**
   ```bash
   mvn test
   ```

6. **Access the application**
   - Health endpoint: `http://localhost:8080/api/actuator/health`
   - Metrics endpoint: `http://localhost:8080/api/actuator/metrics`
   - Info endpoint: `http://localhost:8080/api/actuator/info`

### Development in IntelliJ IDEA

1. Open the project in IntelliJ
2. Maven dependencies will automatically download
3. Right-click on `WarGameApplication.java` → **Run 'WarGameApplication.main()'** to start Spring Boot application
4. To pass arguments if needed: Edit run configuration through **Run** → **Edit Configurations**

### Development in Eclipse

1. **Import the project into Eclipse**
   - Open Eclipse and go to **File** → **Import**
   - Select **Maven** → **Existing Maven Projects**
   - Browse to the project root directory and click **Finish**
   - Eclipse will automatically configure the project

2. **Configure JRE (if needed)**
   - Right-click on project → **Properties** → **Project Facets**
   - Ensure Java version is set to 25 or later

3. **Run Spring Boot Application**
   - Right-click on `WarGameApplication.java` → **Run As** → **Java Application**
   - Or right-click on project → **Run As** → **Maven build** and enter goal: `spring-boot:run`

4. **Run tests**
   - Right-click on project → **Run As** → **Maven test**

### Development in VS Code

1. **Install Recommended Extensions**
   - VS Code will prompt you to install recommended extensions (defined in `.vscode/extensions.json`)
   - Or manually install from the Extensions menu
   - Required: `Extension Pack for Java`, `Spring Boot Extension Pack`

2. **Open the project**
   - Open the project folder in VS Code
   - Wait for Java language server to initialize

3. **Run and Debug**
   - Open `WarGameApplication.java`
   - Click **Run** or **Debug** above the main method
   - Or use the Debug panel (**Ctrl+Shift+D**) and select a configuration
   - Debug configurations are defined in `.vscode/launch.json`

4. **Run tests**
   - Use Command Palette (**Cmd+Shift+P**) → `Java: Run All Tests`
   - Or right-click on test file → **Run Tests**

## Project Structure

```
war-game/
├── .github/                         # GitHub workflows (CI/CD)
├── .vscode/                         # VS Code configuration (tracked for team consistency)
│   ├── settings.json               # Editor and Java settings
│   ├── launch.json                 # Debug configurations
│   └── extensions.json             # Recommended extensions
├── .project                        # Eclipse project configuration
├── .classpath                      # Eclipse classpath configuration
├── .settings/                      # Eclipse IDE settings
│   ├── org.eclipse.jdt.core.prefs
│   └── org.eclipse.m2e.core.prefs
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── algo/               # AI algorithms
│   │   │   │   ├── Minimax.java
│   │   │   │   ├── AlphaBetaPruning.java
│   │   │   │   ├── Random.java
│   │   │   │   └── TreeNode.java
│   │   │   ├── app/                # Application entry points
│   │   │   │   ├── Driver.java     # Legacy CLI entry point
│   │   │   │   ├── MainApp.java    # Core game logic
│   │   │   │   └── WarGameApplication.java  # Spring Boot entry point
│   │   │   └── model/              # Game entities
│   │   │       └── map/
│   │   │           └── Board.java
│   │   └── resources/
│   │       ├── config-sample.json
│   │       ├── application.yml     # Spring Boot configuration
│   │       ├── application-dev.yml # Development profile
│   │       └── application-prod.yml # Production profile
│   └── test/java/                  # Unit tests (with JUnit 4)
├── target/                         # Build output (generated)
├── .gitignore                      # Git ignore rules
├── pom.xml                         # Maven configuration
├── Dockerfile                      # Docker container definition
├── docker-compose.yml              # Docker Compose configuration
├── Jenkinsfile                     # CI/CD pipeline definition
└── README.md                       # This file
```


## Future State: Web Application

The end goal is to transition War Game Simulation into a **browser-based web application** with:

### Phase 2: Enhanced Desktop Version
- Complete game rules and win conditions
- Networked multiplayer support
- GUI using JavaFX or Swing
- Configuration file system for board setup
- Game replay and analysis tools

### Phase 3: Web Migration
- **Backend**: Java Spring Boot REST API
- **Frontend**: React or Vue.js for interactive UI
- **Deployment**: Docker containerization
- **Real-time gameplay**: WebSocket support for live multiplayer
- **Database**: Persistent game state storage
- **Analytics**: Game statistics and AI performance tracking

## Technologies & Dependencies

- **Java 25** - Core language (with preview features enabled)
- **Maven 3.6+** - Build automation & dependency management
- **Spring Boot 3.2** - REST API framework and embedded server
- **JUnit 4** - Testing framework
- **Docker** - Containerization for deployment
- **Jenkins** - CI/CD pipeline automation
- **Jackson** - JSON processing

## Spring Boot Configuration

The application uses Spring Boot profiles for environment-specific configurations:

### Default Configuration (`application.yml`)
- Server port: 8080
- Context path: `/api`
- Actuator endpoints enabled for monitoring
- Default profile: `dev`

### Development Profile (`application-dev.yml`)
- Environment: development
- Debug logging enabled
- Deployment target: local-machine

### Production Profile (`application-prod.yml`)
- Environment: production
- Minimal logging
- File-based logging with rotation
- Deployment target: placeholder-production-server

### Running with Specific Profile
```bash
java -jar war-game-simulator-engine-1.0.0.jar --spring.profiles.active=prod
# or
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=prod"
```

## Docker Deployment

### Build Docker Image
```bash
docker build -t war-game:1.0.0 .
```

### Run Docker Container
```bash
# Development
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=dev war-game:1.0.0

# Production
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=prod war-game:1.0.0
```

### Using Docker Compose (Recommended for local development)
```bash
# Start services
docker-compose up

# Stop services
docker-compose down

# Rebuild images
docker-compose build
```

Access the application at: `http://localhost:8080/api`

## CI/CD Pipeline (Jenkins)

A comprehensive Jenkins pipeline (`Jenkinsfile`) is included for automated deployment:

### Pipeline Stages
1. **Checkout** - Clone source code
2. **Build** - Compile and package application
3. **Test** - Run unit tests
4. **SonarQube Analysis** - Code quality analysis (placeholder)
5. **Build Docker Image** - Create container image
6. **Deploy** - Deploy to dev/staging/prod environments
7. **Health Check** - Verify service availability

### Running the Pipeline
- Deploy to **Development**: `ENVIRONMENT=dev`
- Deploy to **Staging**: `ENVIRONMENT=staging`
- Deploy to **Production**: `ENVIRONMENT=prod` (requires approval)

**Note:** Deployment targets are currently placeholders and should be configured with actual server addresses.

## Contributing

This is a learning-focused project. Contributions and suggestions are welcome!

## License

See [LICENSE](LICENSE) file for details.

---

**Status**: 🚧 Under Development | **Last Updated**: April 2026
