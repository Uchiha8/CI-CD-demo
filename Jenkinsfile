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
                withSonarQubeEnv("sonar-server") {
                    bat 'gradle clean assemble sonar:sonar'
                }
            }
        }
    }
}
