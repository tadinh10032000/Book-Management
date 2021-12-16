<%-- 
    Document   : Update
    Created on : Oct 21, 2020, 11:01:07 AM
    Author     : NgocDo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="update" method="post">
            <h2 style="text-align: center"> Update Book Form </h2>
            <table style="margin: 0 auto">
                <tr>
                <td></td>
                <td><input name="uid" type="text" value="${one.book_id}" hidden=""></td>
            </tr>
            
            <tr>
                <td>Book Title:</td>
                <td><input name="utitle" type="text"value="${one.book_title}"></td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><input name="uauthor" type="text" value="${one.author}"></td>
            </tr>
            
            <tr>
                <td>Brief:</td>
                <td><input name="ubrief" type="text"value="${one.brief}"></td>
            </tr>
            <tr>
                <td>Publisher:</td>
                <td><input name="upublisher" type="text" value="${one.publisher}"></td>
            </tr>
            
            <tr>
                <td>Content:</td>
                <td><input name="ucontent" type="text"value="${one.content}"></td>
            </tr>
            <tr>
                <td>Category:</td>
                <td><input name="ucategory" type="text" value="${one.category}" ></td>
            </tr>
            <tr>
                <td><button type="submit">OK</button></td>
            </tr>
            </table>
        </form>
    </body>
</html>
