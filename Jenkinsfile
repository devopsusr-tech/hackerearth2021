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
                   echo " TEEEST ${env.GIT_BRANCH}"
            }
        }

        stage('apply: docker images'){
            when{
                allOf{
                    expression {
                        return env.GIT_BRANCH == "origin/main"
                    }
                    environment name: 'PLAN_CODE', value: "2"
                }
            }
             steps {
                 build job: 'hackerearth-main'
           }
       }
    }
}