pipeline {
    agent any

   tools {
    gradle 'gradle'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, userRemoteConfigs: [[url: 'https://github.com/Uchiha8/CI-CD-demo.git']]], poll: true, pollInterval: 'H/15 * * * *')
            }
        }

        stage('Build and Test') {
            steps {
                // Build your project using Gradle
                sh './gradlew clean build'

                // Run unit tests (if applicable)
                sh './gradlew test'
            }
        }

        stage('Code Analysis') {
            steps {
                // Configure SonarQube Scanner (you must install it on your Jenkins server)
                withSonarQubeEnv('Your_SonarQube_Installation_Name') {
                    // Run SonarQube analysis using Gradle
                    sh './gradlew sonarqube'
                }
            }
        }
    }

    post {
        success {
            // Archive and publish JaCoCo code coverage reports
            archiveArtifacts artifacts: '**/build/reports/jacoco/test/jacocoTestReport.xml', allowEmptyArchive: true
        }
        failure {
            // Actions to perform on build failure
        }
    }
}
