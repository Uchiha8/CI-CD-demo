pipeline {
    agent any
    tools {
      gradle 'gradle'
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
