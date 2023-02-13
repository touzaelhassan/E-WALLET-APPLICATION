
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
                sh 'echo $USER'
                sh 'groups $USER'
                sh 'usermod -aG docker $USER'
                sh 'groups $USER'
                sh 'docker-compose up'
            }
        }
    }
}
