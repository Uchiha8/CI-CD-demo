pipeline {
    agent any
    tools {
      gradle 'gradle'
    }

    stages {
       stage('SonarQube Analyze') {
            environment {
                scannerHome = tool "sonar-scanner"
            }
            steps {
                withSonarQubeEnv("soanrqube13") {
                    bat 'gradle clean assemble sonar:sonar'
                }
            }
        }
    }
}
