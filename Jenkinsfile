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
		bat 'cd tourPlanningApp && mvn -B -DskipTests clean package'
            }
        }
        stage('Deploy') {
            steps {
		bat 'mvn deploy'
        bat 'echo "Deploying ..."'
            }
        }
	stage('Update') {
            steps {
        bat 'rmdir /s /q "../tourPlanningLibrary-mvn-repo/.git"'
        bat 'cd ../tourPlanningLibrary-mvn-repo && git init'
        bat 'cd ../tourPlanningLibrary-mvn-repo && git remote add origin git@git.e-science.pl:pjasiczek225933/81c_PJasiczek_Maven.git'
        bat 'cd ../tourPlanningLibrary-mvn-repo && git fetch -p'
        bat 'cd ../tourPlanningLibrary-mvn-repo && git checkout Jenkins -f'
		bat 'cd ../tourPlanningLibrary-mvn-repo && git add -A'
		bat 'cd ../tourPlanningLibrary-mvn-repo && git commit -m "add Jenkins"'
		bat 'echo "git push origin jenkins"'
		bat 'cd ../tourPlanningLibrary-mvn-repo && git push origin Jenkins'
            }
        }
    }
}