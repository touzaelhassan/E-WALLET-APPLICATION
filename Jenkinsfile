
pipeline {
    agent any
    triggers {
       pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                dir("BACKEND-APPLICATION/"){
                    sh 'mvn install -DskipTests'
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