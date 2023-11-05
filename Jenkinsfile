pipeline {
    agent any

   tools {
    gradle 'gradle'
    }

    stages {
        // stage('Checkout') {
        //     steps {
        //         checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, userRemoteConfigs: [[url: 'https://github.com/Uchiha8/CI-CD-demo.git']]], poll: true, pollInterval: 'H/15 * * * *')
        //     }
        // }
stage('Unit & Integration Tests') {
            steps {
                script {
                    try {
                        sh './gradlew clean test --no-daemon' //run a gradle task
                    } finally {
                        junit '**/build/test-results/test/*.xml' //make the junit test results available in any case (success & failure)
                    }
                }
            }
        }
stage('Scan') {
            steps {
                withSonarQubeEnv(installationName: 'sonar1'){
                    sh './gradlew clean package sonar:sonar'
                }
            }
        }
        // stage('Code Analysis') {
        //     steps {
        //         // Configure SonarQube Scanner (you must install it on your Jenkins server)
        //         withSonarQubeEnv('Your_SonarQube_Installation_Name') {
        //             // Run SonarQube analysis using Gradle
        //             sh './gradlew sonarqube'
        //         }
        //     }
        // }
    }

    post {
        success {
            // Archive and publish JaCoCo code coverage reports
            archiveArtifacts artifacts: '**/build/reports/jacoco/test/jacocoTestReport.xml', allowEmptyArchive: true
        }
    }
}
