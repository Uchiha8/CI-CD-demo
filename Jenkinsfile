pipeline {
    agent any

   tools {
    gradle 'gradle'
    }
    stage('Scan') {
            steps {
                withSonarQubeEnv(installationName: 'sonar1'){
                    sh './gradlew clean package sonar:sonar'
                }
            }
        }
    }

    post {
        success {
            // Archive and publish JaCoCo code coverage reports
            archiveArtifacts artifacts: '**/build/reports/jacoco/test/jacocoTestReport.xml', allowEmptyArchive: true
        }
    }
}
