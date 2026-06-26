pipeline {
    agent any
    
    tools {
        maven 'Maven3' // Tells Jenkins to automatically use our configured Maven tool
    }
    
    stages {
        stage('Compile') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }
    }
}
