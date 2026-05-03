pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 30, unit: 'MINUTES')
        timestamps()
    }

    parameters {
        choice(name: 'ENVIRONMENT', choices: ['dev', 'staging', 'prod'], description: 'Deployment environment')
        booleanParam(name: 'RUN_TESTS', defaultValue: true, description: 'Run unit tests')
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out source code..."
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Building War Game Simulation..."
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            when {
                expression { params.RUN_TESTS == true }
            }
            steps {
                echo "Running unit tests..."
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo "Running SonarQube analysis..."
                script {
                    try {
                        sh '''
                            mvn sonar:sonar \
                                -Dsonar.projectKey=war-game-simulator \
                                -Dsonar.host.url=http://placeholder-sonarqube-server:9000 \
                                -Dsonar.login=PLACEHOLDER_SONARQUBE_TOKEN
                        '''
                    } catch (Exception e) {
                        echo "SonarQube analysis skipped or failed (placeholder config)"
                    }
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Building Docker image..."
                script {
                    sh '''
                        docker build -t war-game:${BUILD_NUMBER} \
                            --build-arg BUILD_VERSION=${BUILD_NUMBER} \
                            --build-arg ENVIRONMENT=${ENVIRONMENT} \
                            .
                    '''
                }
            }
        }

        stage('Deploy to Development') {
            when {
                expression { params.ENVIRONMENT == 'dev' }
            }
            steps {
                echo "Deploying to Development environment..."
                script {
                    sh '''
                        echo "Deploying to: placeholder-dev-server"
                        docker tag war-game:${BUILD_NUMBER} war-game:latest-dev
                        echo "Deployment to dev completed"
                        echo "Access application at: http://placeholder-dev-server:8080/api"
                    '''
                }
            }
        }

        stage('Deploy to Staging') {
            when {
                expression { params.ENVIRONMENT == 'staging' }
            }
            steps {
                echo "Deploying to Staging environment..."
                script {
                    sh '''
                        echo "Deploying to: placeholder-staging-server"
                        docker tag war-game:${BUILD_NUMBER} war-game:latest-staging
                        echo "Deployment to staging completed"
                        echo "Access application at: http://placeholder-staging-server:8080/api"
                    '''
                }
            }
        }

        stage('Deploy to Production') {
            when {
                expression { params.ENVIRONMENT == 'prod' }
            }
            steps {
                echo "Deploying to Production environment..."
                input 'Approve deployment to Production?'
                script {
                    sh '''
                        echo "Deploying to: placeholder-production-server"
                        docker tag war-game:${BUILD_NUMBER} war-game:latest-prod
                        docker tag war-game:${BUILD_NUMBER} war-game:${BUILD_NUMBER}
                        echo "Deployment to production completed"
                        echo "Access application at: http://placeholder-production-server:8080/api"
                    '''
                }
            }
        }

        stage('Health Check') {
            steps {
                echo "Performing health checks..."
                script {
                    sh '''
                        echo "Health check endpoint: /api/actuator/health"
                        echo "Metrics endpoint: /api/actuator/metrics"
                        echo "Info endpoint: /api/actuator/info"
                    '''
                }
            }
        }
    }

    post {
        always {
            echo "Pipeline execution completed"
            junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
        }
        success {
            echo "Build and deployment successful!"
        }
        failure {
            echo "Build or deployment failed!"
        }
        cleanup {
            cleanWs()
        }
    }
}

