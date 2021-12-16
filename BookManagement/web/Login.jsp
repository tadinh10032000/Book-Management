<%-- 
    Document   : userHome
    Created on : 11-Dec-2021, 09:58:10
    Author     : THEANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Home Page</title>
        <link href="css/userHome.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link href="css/loginlogoutStyle.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div class="head"> B O O K &nbsp;&nbsp; M A N A G E M E N T </div>
        <form  id="onsetform" action="LoginControl" method="post">
            <div class="container">
                <h1> Login </h1>
                <div class="input">
                    <h3>Username:<br> <input type="text" name="username" id="email"></h3>
                </div>
                <div class="input">
                    <h3> Password: <input type="password" name="password" id="password"></h3>
                </div>
                <input type="submit" value="Login" id="btn-login">
            </div>
        </form>
    </body>
</html>
