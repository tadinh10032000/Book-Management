<%-- 
    Document   : Add
    Created on : Oct 16, 2020, 1:28:35 PM
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
        <form action="addBook" method="post">
            <table style="margin: 0 auto">
                <h2 style="text-align: center">Add New Book</h2>
                <tr>
                    <td>Title:</td>
                    <td><input type="text" name="title"></td> 
                </tr>
                <tr>
                    <td>Author:</td>
                    <td><input type="text" name="author"></td> 
                </tr>
                <tr>
                    <td>Brief:</td>
                    <td><input type="text" name="brief"></td> 
                </tr>
                <tr>
                    <td>Publisher:</td>
                    <td><input type="text" name="publisher" ></td> 
                </tr>
                <tr>
                    <td>Content:</td>
                    <td><textarea  rows="4" cols="50" type="text" name="content"></textarea></td> 
                </tr>
                <tr>
                    <td>Category:</td>
                    <td><input type="text" name="category"></td> 
                </tr>
                
                <tr>
                    <td>
                        <button type="submit">OK</button>
                    </td>
                </tr>
            </table>
           
        </form>
    </body>
</html>
