
pipeline {
    agent any
    triggers {
       pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                dir("SPRING-BOOT-APPLICATION/"){


                    sh 'sudo mvn clean install'
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