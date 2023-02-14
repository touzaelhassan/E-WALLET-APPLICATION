
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
                dir("WALLET-SERVICE/"){
                    sh 'mvn install -DskipTests'
                }
                dir("OPERATION-SERVICE/"){
                    sh 'mvn install -DskipTests'
                }
            }
        }
        stage('Deploy') {
            steps{
                sh 'docker-compose --version'
            }
        }
    }
}
