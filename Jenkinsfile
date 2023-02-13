
pipeline {
    agent any
    triggers {
       pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                dir("SPRING-BOOT-APPLICATION/"){
                    sh 'echo caling user is'
                    sh 'echo $USER'

                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker-compose build'
                sh 'docker-compose up -d'
            }
        }
    }
}