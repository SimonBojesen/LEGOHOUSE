/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;
import Exceptions.WritingToSQLException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Simon
 */
public class ViewOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws WritingToSQLException {
        ArrayList<Order> ol = new ArrayList();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if ("customer".equals(user.getRole())) {
            ol = LogicFacade.getOrdersByUserID(user.getId());
            session.setAttribute("ordersByUserID", ol);
        } 
        else if ("employee".equals(user.getRole())) {
            ol = LogicFacade.getAllOrdersByShipping();
            session.setAttribute("getAllOrdersByShipping", ol);
        }
        return "vieworders";
    }
}
