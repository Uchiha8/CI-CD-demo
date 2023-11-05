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
                        sh './gradlew clean test --no-daemon' //run a gradle task
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
