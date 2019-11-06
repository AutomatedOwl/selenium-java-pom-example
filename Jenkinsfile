pipeline {
    agent {
        kubernetes {
            label "automation-tests-slave"
            containerTemplate {
                name "k8s-slave-jdk12-alpine"
                image "e2e-tests:1.0.2"
                ttyEnabled true
                command 'cat'
            }
        }
    }
    stages {
        stage('Git Status') {
            steps {
                sh 'git status'
                echo 'Received Git Status.'
            }
        }
        stage("Prerequisites") {
            steps {
                container('k8s-slave-jdk12-alpine') {
                    sh 'apk update && apk add maven git'
                }
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
