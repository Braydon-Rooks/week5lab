<%-- 
    Document   : register
    Created on : Oct 11, 2017, 1:39:28 PM
    Author     : 671978
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="Post">
           Username: <input type="text" name="user">
           <input type ="hidden" name="action" value="register">
            <input type="submit" value="Register Username">
        </form>
    </body>
</html>
