pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Your build steps here (e.g., Maven build)
                bat 'mvn clean install'
            }
        }
	stage('Retrieve Git Info') {
             steps {
                 // Execute git commands to retrieve information
                script {
		    bat 'echo %cd%'
                    def lastSuccessfulCommit = bat git diff 'C:\ProgramData\Jenkins\.jenkins\workspace\samplejavaapplication>86b1a7951c994299662fc122a986c39f39752457..C:\ProgramData\Jenkins\.jenkins\workspace\samplejavaapplication rev-parse HEAD  1>git'
                    // Get the commit ID of the last successful build
                    def lastSuccessfulCommit = bat(script: "git rev-parse HEAD", returnStdout: true).trim()

                    // Get the commit ID of the current build
                    def currentCommit = bat(script: "git rev-parse HEAD", returnStdout: true).trim()
      
                    // Get the changed files between the last successful commit and current commit
                    def changedFiles = bat(script: "git diff --name-only ${lastSuccessfulCommit}..${currentCommit}", returnStdout: true).trim()

                    // Get the commit log between the last successful commit and current commit
                    def commitLog = bat(script: "git log --pretty=oneline ${lastSuccessfulCommit}..${currentCommit}", returnStdout: true).trim()

                    // Print the retrieved information
                    println "Last Successful Commit: ${lastSuccessfulCommit}"
                    println "Current Commit: ${currentCommit}"
                    println "Changed Files:"
                    println changedFiles
                    println "Commit Log:"
                    println commitLog
                      }
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
