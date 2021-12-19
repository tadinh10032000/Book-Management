<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : showBookCase
    Created on : Dec 13, 2021, 9:18:28 AM
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
    </head>
    <body>
        <div class="head"> B O O K &nbsp;&nbsp; M A N A G E M E N T </div>
        <div class="prof"> 
            <%=session.getAttribute("username")%>   &nbsp;&nbsp;
            <a href="LogoutController" class="prof2" >Logout</a>
        </div>
        <div id="onsetform">
            <a style="margin-left: 10px;" href="ViewBookController">Show bookcase<a>
            <div class="content">
                <table class="styled-table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="o" items="${listBookCase}">
                        <tr>
                            <td><a href="ContainController?action=show&bookCaseId=${o.bookCaseId}">${o.bookCaseName}</a></td>
                            <td><a href="BookCaseController?action=delete&bookCaseId=${o.bookCaseId}">Delete</a></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div><a href="BookCaseController?action=add">Add new book case</a></div>
            </div>
        </div>

    </body>
</html>
