pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Check out your project's source code from your version control system (e.g., Git).
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Build your Spring Boot project using Gradle.
                sh './gradlew clean build'
            }
        }

        stage('Unit Tests') {
            steps {
                // Run JUnit tests using Gradle.
                sh './gradlew test'
            }
        }
    }

    post {
        success {
            // Deploy your Spring Boot application or perform other actions if the build and tests succeed.
        }
        failure {
            // Take actions in case of build or test failures.
        }
    }
}

