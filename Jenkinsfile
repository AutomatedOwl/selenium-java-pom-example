pipeline {
    agent {
        kubernetes {
            label "automation-tests-slave"
            containerTemplate {
                name "k8s-slave-jdk12-alpine"
                image "siomiz/chrome"
                ttyEnabled true
                command 'cat'
            }
        }
    }
    stages {
        stage("Prerequisites") {
            steps {
                container('k8s-slave-jdk12-alpine') {
                    sh 'apt update && apt -y install maven git openjdk-8-jdk'
                }
            }
        }
        stage('Git Status') {
            steps {
                sh 'git status'
                echo 'Received Git Status.'
            }
        }
        stage("Build Default") {
            steps {
                container('k8s-slave-jdk12-alpine') {
                    sh "mvn test"
                }
            }
        }
    }
    post {
        always {
            script {
                allure([
                        includeProperties: false,
                        jdk              : '',
                        properties       : [],
                        reportBuildPolicy: 'ALWAYS',
                        results          : [[path: 'target/allure-results']]
                ])
            }
        }
    }
}
