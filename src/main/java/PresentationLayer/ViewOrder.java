/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import Exceptions.InputException;
import Exceptions.WritingToSQLException;
import FunctionLayer.Bricks;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Simon
 */
public class ViewOrder extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws WritingToSQLException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if ("customer".equals(user.getRole())) {
            int orderid = Integer.parseInt(request.getParameter("orderID"));
            Order order = LogicFacade.getOrderByOrderID(orderid);
            Bricks b = LogicFacade.calculateBricks(user, orderid);
            session.setAttribute("order", order);
            session.setAttribute("orderID", orderid);
            session.setAttribute("bricks", b);
        } else {
            throw new WritingToSQLException("LOLOLOL");
        }
        return "vieworderdetails";
    }
}
