pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr:'5'))
        disableConcurrentBuilds()
        timeout(time: 30, unit: 'MINUTES')
    }

    stages {
        stage('perparation') {
            steps {
                sh 'echo works'
            }
        }

        stage('code quality') {
            steps {
                sh 'echo code-quality'
            }
        }

        stage('unit tests') {
            steps {
                sh 'echo unit tests'
            }
        }

        stage('build: backend') {
            steps {
                sh 'docker build backend/'
            }
        }

        stage('build: frontend') {
            steps {
                sh 'docker build frontend/'
            }
        }

        stage('approval') {
            steps {
                script {
                    timeout(time: 10, unit: 'MINUTES') {
                        input(id: 'Deploy Gate', message: 'Deploy the builded app?', ok: 'Deploy')
                    }
                }
            }
        }

        stage('push: docker images') {
            when{
                allOf{
                    expression {
                        return env.GIT_BRANCH == "origin/main"
                    }
                }
            }
            steps {
                sh 'echo "here we push the docker images to dockerhub"'
            }
        }

        stage('deploy: app') {
            when{
                allOf{
                    expression {
                        return env.GIT_BRANCH == "origin/main"
                    }
                }
            }
            steps {
                sh 'echo "here we run the newest image"'
            }
        }
    }
}
