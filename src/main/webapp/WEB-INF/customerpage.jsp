<%-- 
    Document   : Customerpage
    Created on : 11-10-2018, 22:48:12
    Author     : Simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to customerpage</h1>
        
        <table>
            <thead>
                <td>Order a legohouse</td>
            </thead>
            <tr>
                <td>
                    <form name="makeorder" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="makeorder">
                        Input desired length counted by dots on the bricks:<br>
                        <input type="number" name="length" min="1">
                        <br>
                        Input desired width counted by dots on the bricks:<br>
                        <input type="number" name="width" min="1">
                        <br>
                        Input desired height in bricks:<br>
                        <input type="number" name="height" min="1">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                    <br>
                    <form name="goToOrdersLink" action="FrontController" method="POST"> 
                        <input type="hidden" name="command" value="vieworders">
                        <input type="submit" value="View previous orders">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
