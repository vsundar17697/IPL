In this application, the aim is to implement a simple user authentication system using MVC.

For this two user defined packages are created namely : Bean and Dao.

The structure of the webapp is as follows :

-UserAuth
	|
	|-index.jsp
	|-succ.jsp
	|-fail.jsp
	|-[WEB-INF]
			|
			|-web.xml
			|-[classes]
					|
					|-loginController.java
					|-loginController.class
					|-[Bean]
						|
						|-user.java
					|-[Dao]
						|-loginDao.java
						

To compile [Bean], open a CMD inside the folder, and type the following : 
			javac -d . user.java
							
To compile [Dao], open a CMD inside the folder , and type the following : 

set CLASSPATH=C:\Program Files\apache-tomcat-7.0.79\webapps\UserAuth\WEB-INF\classes\Bean\
			javac -d . loginDao.java
							
To compile loginController.java, open a CMD inside the folder, and then type the follwing : 

set classpath=C:\Program Files\apache-tomcat-7.0.79\webapps\UserAuth\WEB-INF\classes\
			javac loginController.java
							
Then, the usual process of running the web-application.							