<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
    <head>
        <title>SELECT Operation</title>
    </head>
<body>

<sql:setDataSource var="snap" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/siddharth" user="root" password=""/>

<c:set var="name" value="${param.uname}"/>
<c:set var="pass" value="${param.upass}"/>

<%--
<sql:update dataSource="${snap}" var="count">
    insert into users
    values("U5","Zverev","sascha");
</sql:update>    
--%>

<sql:query dataSource="${snap}" var="result">
SELECT * from users where uname=?;
<sql:param value="${name}"/>
</sql:query>

<c:if test="${result.rowCount!=0}">
 Username exists !! <br/>
    <sql:query dataSource="${snap}" var="result1">
        SELECT * from users where password=?;
        <sql:param value="${pass}"/>
    </sql:query> 
<%-- If the username exists, then check for the existence of the password. --%>
    <c:if test="${result1.rowCount!=0}">
        User successfully authenticated !! <br/>
    </c:if>
    <c:if test="${result1.rowCount==0}">
        Password does not exist !! <br/>
    </c:if>    
</c:if>

<c:if test="${result.rowCount==0}">
 Username does not exist !! <br/>
</c:if>

<%--  COMMENTING !!
<table border="1" width="100%">
<tr> 
    <th>ID</th>
    <th>User_Name</th>
    <th>Password</th>
</tr>

<c:forEach var="row" items="${result.rows}">
    <tr>
        <td><c:out value="${row.id}"/></td>
        <td><c:out value="${row.uname}"/></td>
        <td><c:out value="${row.password}"/></td>
    </tr> 
</c:forEach>
--%>

</table> 
</body>
 </html>