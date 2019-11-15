pipeline {
    agent {
        kubernetes {
            label "test-runner"
            containerTemplate {
                name "e2e-tests-container"
                image "automatedowl/e2e-tests:1.0.2"
                ttyEnabled true
                command 'cat'
            }
        }
    }
    stages {
        stage('Prerequisites') {
            steps {
                container('e2e-tests-container') {
                    sh 'apt update && apt install maven git -y'
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
                container('e2e-tests-container') {
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
