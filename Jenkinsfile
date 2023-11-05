pipeline {
    agent any
    tools {
      gradle 'gradle'
    }

    stages {
       stage('SonarQube Analyze') {
            environment {
                scannerHome = tool "sonarqube13"
            }
            steps {
                withSonarQubeEnv("soanrqube13") {
                    bat 'gradle clean assemble sonar:sonar'
                }
            }
        }
    }
}
