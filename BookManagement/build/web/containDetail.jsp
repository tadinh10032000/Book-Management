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
            <a href="BookCaseController?action=show">Show bookcase<a>
            <div class="content">
                <table class="styled-table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Points</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="o" items="${books}">
                            <tr>
                                <td>${o.book_title}</td>     
                                <td><a href="ContainController?action=delete&bookCaseId=${bookCaseId}&book_id=${o.book_id}">delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <form action="ContainController" method="post">
                    </br>Add new book to book case:
                    <select name="book_id" class="input_new_item">
                        <c:forEach var="o" items="${allBook}">
                            <option value="${o.book_id}">${o.book_title}</option>
                        </c:forEach>
                    </select>
                    <input class="btn_submit" type="submit" value="ADD" />
                </form>
            </div>

        </div>

    </body>
</html>
