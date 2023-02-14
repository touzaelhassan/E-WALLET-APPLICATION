
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
            steps{
                dir("SPRING-BOOT-APPLICATION/"){
                    sh 'docker-compose up -d'
                }
            }
        }
    }
}
