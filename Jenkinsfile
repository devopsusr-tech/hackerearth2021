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
                sh 'docker build frontend/'
            }
        }

        stage('push: docker images'){
        when{
            allOf{
                branch 'main'
                environment name: 'PLAN_CODE', value: "2"
            }
          }
          steps{
              sh 'here images will be pushed if branch is main'
          }
        }
    }
}