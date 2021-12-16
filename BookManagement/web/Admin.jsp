<%-- 
    Document   : Admin
    Created on : Oct 16, 2020, 1:12:55 PM
    Author     : NgocDo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link href="css/admin.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <style>
            table, tr,th, td{
                border: 1px solid black;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <h2 class="text-center">Welcome to  Admin Page</h2>

            <!--            end of slide-->
            <nav>
                <table >
                    <tr>
                        <th><a href="AddBook.jsp">Add Product</a></th>
                        <th><a href="Login.jsp">LogOut</a></th>
                    </tr>
                </table>
            </nav>
            <form>
                <jsp:useBean id="dao" class="dao.AdminDAO"></jsp:useBean>
                <c:set value="${dao.all}" var="list"></c:set>
                    <table style="border: 1px solid black; margin: 0 auto; background-repeat: no-repeat;">
                        <tr>
                            <th>ID</th>
                            <th>Book Title</th>
                            <th>Author</th>
                            <th>Brief</th>
                            <th>Publisher</th>
                            <th>Category</th>
                        </tr>
                    <c:forEach items="${list}" var="o">
                        <tr>
                            <td>${o.book_id}</td>
                            <td>${o.book_title}</td>
                            <td>${o.author}</td>
                            <td>${o.brief}</td>
                            <td>${o.publisher}</td>
                            <td>${o.category}</td>
                            <td><a href="delete?id=${o.book_id}">Delete</a></td>
                            <td><a href="update?id=${o.book_id}">Update</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
            <div style="text-align: center; color: lightblue">
                    Message : ${message}
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    </body>
</html>
