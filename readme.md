C:\Users\admin\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup

INSTALL JENKINS
------------------------------------------
Dashboard -> Manage Jenkins -> System -> Home directory
d:\programy\jenkins-home

C:\Program Files\Jenkins
autostart_jenkins.bat
<pre>
C:
cd C:\Program Files\Jenkins
powershell -WindowStyle Minimized -Command "(New-Object -ComObject Shell.Application).MinimizeAll()" &
java -jar jenkins.war --httpPort=9191
</pre>
JENKINS HOME:
d:\programy\jenkins-home\workspace\Bookstore Pipeline\

PIPELINE:
<pre>
pipeline {
    agent any
    environment {
        WORKSPACE_DIR = 'd:\\programy\\jenkins-home\\workspace\\Bookstore_Pipeline\\'
    }
    stages {
        stage('Clone Repository') {
            steps {
                // Clean workspace directory
                deleteDir()
                // Clone GitHub repository into the workspace directory
                git branch: 'master', credentialsId: 'krzysztofchrzan', url: 'https://github.com/krzysztofchrzan/bookstore.git'
            }
        }
        stage('Build') {
            steps {
                // Change directory to the workspace directory where your project is located
                bat "cd /d ${WORKSPACE_DIR}"
                // Run Maven clean and compile commands
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                // Change directory to the workspace directory where your project is located
                bat "cd /d ${WORKSPACE_DIR}"
                // Run Maven test command
                bat 'mvn test'
            }
        }
    }
    post {
        always {
            script {
                def allureDir = "d:\\programy\\allure-2.29.0\\bin\\allure"
                def allureResultsDir = "${WORKSPACE_DIR}target\\allure-results"
                def allureReportDir = "${WORKSPACE_DIR}target\\allure-reports"
                if (fileExists(allureResultsDir)) {
                    // Generate Allure report
                    bat "${allureDir} generate ${allureResultsDir} -o ${allureReportDir} --clean"
                    // Archive Allure report
                    archiveArtifacts artifacts: "target/allure-reports/**/*", allowEmptyArchive: true
                    // Publish Allure report
                    allure includeProperties: false, jdk: '', results: [[path: "target/allure-results"]]
                } else {
                    echo "Allure results directory does not exist."
                }
            }
        }
    }
}
</pre>

INSTALL JSON-SERVER
------------------------------------------
D:\programy\json-server
autostart_json-server.bat
<pre>
D:
cd D:\programy\json-server
powershell -WindowStyle Minimized -Command "(New-Object -ComObject Shell.Application).MinimizeAll()" &
npx json-server db.json
</pre>

INSTALL ALLURE-REPORTS
------------------------------------------
DOWNLOAD ALLURE AND EXTRACT ZIP:
https://github.com/allure-framework/allure2/releases
D:\programy\allure-2.29.0\bin

ADD ALLURE TO YOUR SYSTEM'S PATH
1.Computer -> RMB -> Settings -> Advanced System Settings -> Environment Variables
2.System variables section -> Path ("Edit")
3."New" and add the path to the bin directory "D:\programy\allure-2.29.0\bin"

GENERATE OPEN LOCALLY IN INTELLIJ
d:\programy\allure-2.29.0\bin\allure --version && D: && cd D:\programy\intellij\projekty\bookstore && d:\programy\allure-2.29.0\bin\allure generate "d:\programy\intellij\projekty\bookstore\target\allure-results" -o "D:\programy\intellij\projekty\bookstore\target\allure-reports" --clean && d:\programy\allure-2.29.0\bin\allure open "D:\programy\intellij\projekty\bookstore\target\allure-reports"

GENERATE OPEN LOCALLY IN JENKINS FOLDER:
d:\programy\allure-2.29.0\bin\allure --version && D: && cd "D:\\programy\\jenkins-home\\workspace\\Bookstore_Pipeline" && d:\programy\allure-2.29.0\bin\allure generate "D:\\programy\\jenkins-home\\workspace\\Bookstore_Pipeline\\target\\allure-results" -o "D:\\programy\\jenkins-home\\workspace\\Bookstore_Pipeline\\target\\allure-reports" --clean && d:\programy\allure-2.29.0\bin\allure open "D:\\programy\\jenkins-home\\workspace\\Bookstore_Pipeline\\target\\allure-reports"

ONLY OPEN FROM JENKINS MANUALLY
d:\programy\allure-2.29.0\bin\allure --version && D: && cd "D:\\programy\\jenkins-home\\workspace\\Bookstore_Pipeline" && d:\programy\allure-2.29.0\bin\allure open "D:\\programy\\jenkins-home\\workspace\\Bookstore_Pipeline\\target\\allure-reports"
------------------------------------------

