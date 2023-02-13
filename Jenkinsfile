
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
              dir("SPRING-BOOT-APPLICATION/"){
                   sh 'docker build -t testImage'
                   sh 'docker run -d testImage'
              }
        }
    }
}
