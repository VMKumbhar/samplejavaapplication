pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Your build steps here (e.g., Maven build)
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // Execute JUnit tests
                bat 'mvn test'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                // Run SonarQube analysis
                script {
                    def scannerHome = tool 'SonarQubeScanner'
                    withSonarQubeEnv(installationName: 'sq1') {
                        bat "mvn clean verify sonar:sonar -Dsonar.projectKey=sonarcodecoverage -Dsonar.projectName='sonarcodecoverage'"
                    }
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
