<%-- 
    Document   : ViewBook
    Created on : Dec 10, 2021, 9:54:05 PM
    Author     : ductd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Book Detail</title>
        <link href="css/userHome.css" rel="stylesheet" type="text/css"/>
        <link href="css/viewBook.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="head"> B O O K &nbsp;&nbsp; M A N A G E M E N T </div>
        <div class="prof">
            <a href="#" class="prof1" >Username</a> &nbsp;&nbsp;
            <a href="#" class="prof2" >Logout</a>
        </div>
        <form id="onsetform">
            <div class="bookcase"><a href="#"> My Book Case </a></div>
            <c:forEach items="${ListBook}" var="o">
                <div class="padding">
                    <a class="title" href="BookDetailController?id=${o.book_id}">${o.book_title}</a>
                    <div class="brief">${o.brief}</div>
                    <div class="author">"${o.author}" - ID Book ${o.book_id}</div>
                </div>
            </c:forEach>
        </form>
    </body>
</html>
