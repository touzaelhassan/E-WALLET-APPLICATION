
pipeline {
    agent any
    triggers {
       pollSCM '* * * * *'
    }
    tools{
       maven 'maven'
    }
    stages {
        stage('Build') {
            steps {
                dir("SPRING-BOOT-APPLICATION/"){
                    sh 'mvn install -DskipTests'
                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker-compose up'
            }
        }
    }
}
