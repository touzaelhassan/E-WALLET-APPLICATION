
pipeline {
    agent any
    triggers {
       pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                dir("SPRING-BOOT-APPLICATION/"){

                    sh 'export M2_HOME=/opt/apache-maven-3.9.0 # your Mavan home path'
                    sh 'export PATH=$PATH:$M2_HOME/bin'
                    sh 'mvn --version'
                    sh 'mvn clean install'
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