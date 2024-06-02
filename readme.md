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

------------------------------------------

