pipeline {
    agent any
    tools {
        gradle 'gradle'
        git '2.39.1.windows.1'
    }
    options {
        buildDiscarder(logRotator(daysToKeepStr: '10', numToKeepStr: '10'))
        timeout(time: 12, unit: 'HOURS')
        timestamps()
    }
    triggers {
        pollSCM '*/5 * * * *'
    }
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Test') {
            steps { bat 'gradle clean test' }
        }
        stage('Build') {
            steps { bat 'gradle build' }
        }
        stage('Code Coverage') {
            steps {
                bat 'gradle clean'
                bat 'gradlew jacocoTestReport'
                bat 'gradlew jacocoTestReportPublish'
            }
        }
        stage('SonarQube Analyze') {
            environment {
                scannerHome = tool "sonar-scanner"
            }
            steps {
                withSonarQubeEnv("sonar-server") {
                    bat 'gradle clean assemble sonar:sonar'
                }
            }
        }
        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.war', followSymlinks: false
            }
        }
    }
}
