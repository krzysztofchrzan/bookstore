C:\Users\admin\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup

INSTALL JENKINS
------------------------------------------
C:\Program Files\Jenkins
autostart_jenkins.bat

C:
cd C:\Program Files\Jenkins
powershell -WindowStyle Minimized -Command "(New-Object -ComObject Shell.Application).MinimizeAll()" &
java -jar jenkins.war --httpPort=9191

JENKINS HOME:
d:\programy\jenkins-home\workspace\Bookstore Pipeline\

INSTALL JSON-SERVER
------------------------------------------
D:\programy\json-server
autostart_json-server.bat

D:
cd D:\programy\json-server
powershell -WindowStyle Minimized -Command "(New-Object -ComObject Shell.Application).MinimizeAll()" &
npx json-server db.json

INSTALL ALLURE-REPORTS
------------------------------------------
Download Allure Commandline:
https://github.com/allure-framework/allure2/releases

Extract the downloaded ZIP file to for ex:
D:\programy\allure-2.29.0\bin

Add Allure to Your System's PATH
"Environment Variables".
In the "System variables" section, find and select the Path variable,
then click "Edit".
Click "New" and add the path to the bin directory 
inside your extracted Allure directory, e.g., D:\programy\allure-2.29.0\bin

GENERATE REPORTS MANUALY
d:\programy\allure-2.29.0\bin\allure generate "d:\programy\jenkins-home\workspace\Bookstore Pipeline\target\allure-results" -o "d:\programy\jenkins-home\workspace\Bookstore Pipeline\target\allure-reports" --clean
d:\programy\allure-2.29.0\bin\allure generate "d:\programy\intellij\projekty\bookstore\target\allure-results" -o "d:\programy\intellij\projekty\bookstore\target\allure-reports" --clean

OPEN LOCALLY
allure --version
D:
cd D:\programy\intellij\projekty\bookstore
allure serve target\allure-results
allure open D:\programy\intellij\projekty\bookstore\target\allure-reports
OPEN FROM JENKINS FOLDER:
allure generate target/allure-results -o allure-report
allure open target/allure-report


allure generate "D:\\programy\\jenkins-home\\workspace\\Bookstore Pipeline\\target\\allure-results" -o "D:\\programy\\jenkins-home\\workspace\\Bookstore Pipeline\\allure-report"
allure open "D:\\programy\\jenkins-home\\workspace\\Bookstore Pipeline\\target\\allure-results"
allure serve "D:\\programy\\jenkins-home\\workspace\\Bookstore Pipeline\\target\\allure-results"


d:\programy\allure-2.29.0\bin\allure generate "d:\programy\jenkins-home\workspace\Bookstore Pipeline\target\allure-results" -o "d:\programy\jenkins-home\workspace\Bookstore Pipeline\target\allure-reports" --clean
d:\programy\allure-2.29.0\bin\allure generate "d:\programy\intellij\projekty\bookstore\target\allure-results" -o "d:\programy\intellij\projekty\bookstore\target\allure-reports" --clean

d:\programy\allure-2.29.0\bin\allure open D:\programy\intellij\projekty\bookstore\target\allure-reports
d:\programy\allure-2.29.0\bin\allure open "d:\programy\jenkins-home\workspace\Bookstore Pipeline\target\allure-reports"
------------------------------------------

