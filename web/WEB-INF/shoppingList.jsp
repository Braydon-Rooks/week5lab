<%-- 
    Document   : shoppingList
    Created on : Oct 11, 2017, 1:39:37 PM
    Author     : 671978
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello,<c:out value="${sessionScope.user}"/>  
            <a href="ShoppingList?action=logout">Logout</a>         
       
        <br>
        <form action ="ShoppingList" method="post">
            Item: <input type="text" name="item">
           <input type ="hidden" name="action" value="add">
            <input type="submit" value="Add Item">
        </form>
        
        <form action ="ShoppingList" method="post">
            <table>
                <c:forEach var="list" items="${sessionScope.list}" varStatus="loop">
                    <tr>
                        <td><input type="radio" name="items" value ="${loop.getIndex()}"></td>
                        <td>${list}</td>
                    </tr>    
                </c:forEach>
            </table>
                <input type ="hidden" name="action" value="delete">
                <input type="submit" value="Delete">
        </form>
    </body>
</html>
