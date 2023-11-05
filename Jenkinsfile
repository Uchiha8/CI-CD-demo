pipeline {
    agent any
    tools {
      gradle 'gradle'
    }

    stages {
       stage('SonarQube Analyze') {
            steps {
                withSonarQubeEnv("soanrqube13") {
                    bat 'gradle clean assemble sonar:sonar'
                }
            }
        }
    }
}
