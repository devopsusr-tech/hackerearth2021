pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr:'5'))
        disableConcurrentBuilds()
        timeout(time: 30, unit: 'MINUTES')
    }

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('perparation') {
            steps {
                sh 'echo works'
            }
        }

        stage('code quality') {
            steps {
              withSonarQubeEnv('My SonarQube Server') {
                sh 'mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar'
              }
            }
          }
          stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
        }

        stage('unit tests') {
            steps {
                sh 'echo unit tests'
            }
        }

        stage('build: backend') {
            steps {
                sh 'docker build vaccathon-rest-api/'
            }
        }

        stage('build: frontend') {
            steps {
                sh 'docker build frontend/vaccathon'
            }
        }

        stage('approval') {
            when{
                allOf{
                    expression {
                        return env.GIT_BRANCH == "origin/main"
                    }
                }
            }
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
                sh '''
                docker-compose stop
                docker-compose rm -f
                docker-compose pull
                docker-compose up -d'''
            }
        }
    }
}