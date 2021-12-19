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
        <link href="css/userHome.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="head"> B O O K &nbsp;&nbsp; M A N A G E M E N T </div>
        <div class="prof"> 
            <%=session.getAttribute("username")%>   &nbsp;&nbsp;
            <a href="LogoutController" class="prof2" >Logout</a>
        </div>
        <form id="onsetform" action="update" method="post">
            <h1 style="text-align: center"> Update Book Form </h1>
            <table style="margin: 0 auto">
                <tr>
                    <td></td>
                    <td><input name="uid" type="text" value="${one.book_id}" hidden=""></td>
                </tr>

                <tr>
                    <td style="color: green; font-weight: bold;">Book Title:</td>
                    <td><input style="margin-bottom: 10px; width: 98%;" name="utitle" type="text"value="${one.book_title}"></td>
                </tr>
                <tr>
                    <td style="color: green; font-weight: bold;">Author:</td>
                    <td><input style="margin-bottom: 10px; width: 98%;" name="uauthor" type="text" value="${one.author}"></td>
                </tr>

                <tr>
                    <td style="color: green; font-weight: bold;">Brief:</td>
                    <td><input style="margin-bottom: 10px; width: 98%;" name="ubrief" type="text"value="${one.brief}"></td>
                </tr>
                <tr>
                    <td style="color: green; font-weight: bold;">Publisher:</td>
                    <td><input style="margin-bottom: 10px; width: 98%;" name="upublisher" type="text" value="${one.publisher}"></td>
                </tr>

                <tr>
                    <td style="color: green; font-weight: bold;">Content:</td>
                    <td><textarea rows="10" cols="50" name="ucontent" type="text"value="${one.content}"></textarea></td>
                </tr>
                <tr>
                    <td style="color: green; font-weight: bold;">Category:</td>
                    <td><input style="margin-bottom: 10px; width: 98%;" name="ucategory" type="text" value="${one.category}" ></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button style="width: 40%;" type="submit">OK</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
