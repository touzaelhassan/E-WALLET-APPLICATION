
pipeline {
    agent any
    triggers {
       pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                dir("SPRING-BOOT-APPLICATION/"){


                    sh '/opt/apache-maven-3.9.0/bin/mvn package'
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