<%-- 
    Document   : Employeepage
    Created on : 11-10-2018, 22:48:30
    Author     : Simon
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="vieworders">
            <input type="submit" value="Go to full orderlist">
        </form>
    </body>
</html>
