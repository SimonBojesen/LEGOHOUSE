<%-- 
    Document   : vieworderdetails
    Created on : 12-10-2018, 15:05:57
    Author     : Simon
--%>

<%@page import="FunctionLayer.Bricks"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            Order order = (Order) session.getAttribute("order");
            Bricks bricks = (Bricks) session.getAttribute("bricks");
        %>
        <table>
            <thead>
                <tr>
                    <th>Length</th>
                    <th>Width</th>
                    <th>Height</th>
                    <th>4x2</th>
                    <th>2x2</th>
                    <th>1x2</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><% out.println(order.getLength()); %></td>
                    <td><% out.println(order.getWidth()); %></td>
                    <td><% out.println(order.getHeight()); %></td>
                    <td><% out.println(bricks.getFour()); %></td>
                    <td><% out.println(bricks.getTwo()); %></td>
                    <td><% out.println(bricks.getOne()); %></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
