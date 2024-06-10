pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Your build steps here (e.g., Maven build)
                bat 'mvn clean install'
            }
        }
	
        stage('Git Diff') {
            steps {
                // Checkout the repository
                git branch: 'main', url: 'https://github.com/VMKumbhar/samplejavaapplication.git'
                
                // Run git diff command to get the changes
                bat 'git diff lastSuccessfulCommit'
            }
        }
        stage('Test') {
            steps {
                // Execute JUnit tests
                bat 'mvn test'
            }
        }
        
        stage('JUNit Reports') {
            steps {
                    junit 'target/surefire-reports/*.xml'
		                echo "Publishing JUnit reports"
            }
        }
        
        stage('Jacoco Reports') {
            steps {
                  jacoco()
                  echo "Publishing Jacoco Code Coverage Reports";
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                // Run SonarQube analysis
                    withSonarQubeEnv(installationName: 'sq1') {
                        bat "mvn clean verify sonar:sonar -Dsonar.projectKey=sonarcodecoverage -Dsonar.projectName='sonarcodecoverage'"
                }
            }
        }
    }

    post {
        always {
            // Publish JUnit test results
            junit 'target/surefire-reports/*.xml'
        }
    }
}
