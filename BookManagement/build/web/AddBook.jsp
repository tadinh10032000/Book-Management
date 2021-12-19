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
        <link href="css/userHome.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="head"> B O O K &nbsp;&nbsp; M A N A G E M E N T </div>
        <div class="prof"> 
            <%=session.getAttribute("username")%>   &nbsp;&nbsp;
            <a href="LogoutController" class="prof2" >Logout</a>
        </div>
        <form id="onsetform" action="addBook" method="post">            
            <table class="abc" style="margin: 0 auto">
                <h1 style="text-align: center;">Add New Book</h1>
                <tr>
                    <td style="color: green; font-weight: bold;">Title:</td>
                    <td><input style="margin-bottom: 10px; width: 98%; background-color: beige;" type="text" name="title"></td> 
                </tr>
                <tr>
                    <td style="color: green; font-weight: bold;">Author:</td>
                    <td><input style="margin-bottom: 10px; width: 98%; background-color: pink;" type="text" name="author"></td> 
                </tr>
                <tr>
                    <td style="color: green; font-weight: bold;">Brief:</td>
                    <td><input style="margin-bottom: 10px; width: 98%; background-color: orange;" type="text" name="brief"></td> 
                </tr>
                <tr>
                    <td style="color: green; font-weight: bold;">Publisher:</td>
                    <td><input style="margin-bottom: 10px; width: 98%; background-color: #edb2eb;" type="text" name="publisher" ></td> 
                </tr>
                <tr>
                    <td style="color: green; font-weight: bold; ">Content:</td>
                    <td><textarea style="background-color: lightgray;" rows="10" cols="50" type="text" name="content"></textarea></td> 
                </tr>
                <tr>
                    <td style="color: green; font-weight: bold;">Category:</td>
                    <td><input style="margin-top: 10px; margin-bottom: 10px; width: 98%;background-color: khaki;" type="text" name="category"></td> 
                </tr>
                
                <tr>
                    <td></td>
                    <td>
                        <button style="width: 40%;" type="submit">OK</button>
                    </td>
                </tr>
            </table>
           
        </form>
    </body>
</html>
