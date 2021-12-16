<%-- 
    Document   : ViewBookDetail
    Created on : Dec 9, 2021, 9:52:25 AM
    Author     : ductd
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Book Detail Page</title>
        <link href="css/userHome.css" rel="stylesheet" type="text/css"/>
        <link href="css/viewBookDetail.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="head"> B O O K &nbsp;&nbsp; M A N A G E M E N T </div>
        <div class="prof">
            <a href="#" class="prof1" >Username</a> &nbsp;&nbsp;
            <a href="#" class="prof2" >Logout</a>
        </div>
        <form id="onsetform">
            <c:forEach items="${listB}" var="o">
                <div class="padding">
                    <a class="title">${o.book_title}</a>
                    <div class="category">(Category: ${o.category} - Publisher: ${o.publisher}) </div>
                    <br>
                    <div class="content">${o.content}</div>
                    <div class="author" style="">${o.author} </div>
                </div>
            </c:forEach>
        </form>
    </body>
</html>
