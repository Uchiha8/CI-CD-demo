
#!/usr/bin/env groovy
pipeline {
    agent any

    tools {
      maven '3.9.5'
    }

    stages {
        stage('Scan') {
            steps {
                withSonarQubeEnv(installationName: 'sonarqube13'){
                    bat 'mvn clean package sonar:sonar'
                }
            }
        }
    }
}
