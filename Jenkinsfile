pipeline {
    agent any
    tools { 
        maven 'mvn' 
        jdk 'jdk' 
    }	

    stages {
        stage('Build') {
            steps {
		        bat 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'echo "Testing.."'
            }
        }
        stage('Deploy') {
            steps {
                bat 'echo "Deploying...."'
            }
        }
    }
}