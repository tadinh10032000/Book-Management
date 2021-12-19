<%-- 
    Document   : addBookCase.jsp
    Created on : Dec 13, 2021, 9:43:29 AM
    Author     : NHD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/userHome.css" rel="stylesheet" type="text/css"/>
        <link href="css/bookcase.css" rel="stylesheet" type="text/css"/>
        <style>

            
            
        </style>
    </head>
    <body>
        <div class="head"> B O O K &nbsp;&nbsp; M A N A G E M E N T </div>
        <div class="prof"> 
            <%=session.getAttribute("username")%>   &nbsp;&nbsp;
            <a href="LogoutController" class="prof2" >Logout</a>
        </div>
        <div id="onsetform">
        <form class="content" action="BookCaseController" method="POST" >
            <h3>ADD NEW BOOK CASE : </h3>
            <input class="input_new_item" type="text" name="bookCaseName" value="" />
            <input class="btn_submit" type="submit" value="ADD" />
        </form>
        </div>
    </body>
</html>
