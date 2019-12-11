pipeline {
    agent any
    tools { 
        maven 'mvn' 
        jdk 'jdk' 
    }	


    stages {
        stage('Build') {
            steps {
		bat 'echo "Cleaning ..."'
		bat 'cd "./tourPlanningLibrary/" && mvn -B -DskipTests clean package'
            }
        }
        stage('Deploy') {
            steps {
		bat 'cd "./tourPlanningLibrary/" && mvn deploy'
        bat 'echo "Deploying ..."'
            }
        }
	stage('Update') {
            steps {
        bat 'cd ..'
        bat 'cd "./tourPlanningLibrary-mvn-repo/" && git init'
        bat 'cd "./tourPlanningLibrary-mvn-repo/" && git remote add origin git@git.e-science.pl:pjasiczek225933/81c_PJasiczek_Maven.git'
        bat 'cd "./tourPlanningLibrary-mvn-repo/" && git fetch -p'
        bat 'cd "./tourPlanningLibrary-mvn-repo/" && git checkout -b Jenkins'
		bat 'cd "./tourPlanningLibrary-mvn-repo/" && git add .'
		bat 'cd "./tourPlanningLibrary-mvn-repo/" && git commit -m "add Jenkins"'
		bat 'cd "./tourPlanningLibrary-mvn-repo/" && git push origin Jenkins'
            }
        }
    }
}