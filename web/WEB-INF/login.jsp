<%-- 
    Document   : login
    Created on : 17 Jun, 2022, 9:33:36 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        
        <form method="post" action="">
            <label> Username: </label>
            <input type="text" name="username" value="${username}"><br>
            <input type ="text" name="password" value="${password}"><br>
            <input type="submit" value="Login">
        </form>
            
            
        </form>
        
        <p>${message}</p>
            
    </body>
</html>
