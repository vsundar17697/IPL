<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Database Connection Example</title>
</head>
<body>

    <fieldset>
        <h2 style="text-align:center;">User Login</h2>
        <form action="welcome.jsp" method="post">
         Username : <input type="text" name="uname"/><br/><br/>
         Password &nbsp;:&nbsp<input type="text" name="upass"/><br/><br/>   
         <input type="submit" value="Login" />
        </form>
    </fieldset>
</body>
</html>
