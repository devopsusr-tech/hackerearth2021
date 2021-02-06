pipeline {
    agent any
    stages {

        stage('perpartin') {
            steps {
                sh 'echo works'
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
    }
}