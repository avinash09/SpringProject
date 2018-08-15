pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'apache-maven-3.5.2') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'apache-maven-3.5.2') {
                    bat 'mvn test'
                }
            }
        }
        
         stage ('Server Start Stage') {

            steps {
                withMaven(maven : 'apache-maven-3.5.2') {
                    bat 'mvn tomcat7:run'
                }
            }
        }
    }
}
