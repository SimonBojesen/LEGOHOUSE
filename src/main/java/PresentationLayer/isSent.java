/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import Exceptions.InputException;
import Exceptions.WritingToSQLException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Simon
 */
public class isSent extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws WritingToSQLException {
        boolean isSent = Boolean.parseBoolean(request.getParameter("isSent"));
        if (isSent == false) {
            int orderid = Integer.parseInt(request.getParameter("orderID"));
            LogicFacade.updateIsSent(orderid);
            isSent = true;
            Order order = LogicFacade.getOrderByOrderID(orderid);
            order.setIsSent(isSent);
        } else {
            throw new WritingToSQLException("LOLOLOL");
        }
        return "employeepage";
    
    }
}
