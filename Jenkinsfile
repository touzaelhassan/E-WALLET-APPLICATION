
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
                    sh 'mvn --version'
                }
            }
        }

    }
}
