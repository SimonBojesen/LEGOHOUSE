package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import Exceptions.InputException;
import Exceptions.WritingToSQLException;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws WritingToSQLException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws WritingToSQLException {
        User user = new User( email, password, "customer" );
        UserMapper.createUser( user );
        return user;
    }
    
    public static Order createOrder( int length, int width, int height, int userid ) throws WritingToSQLException, InputException {
        Order order = new Order( length, width, height );
        OrderMapper.createOrder( order, userid );
        return order;
    }
    
    public static void updateIsSent( int orderid ) throws WritingToSQLException {
        OrderMapper.setShippingByOrderID( orderid );
    }
    
    public static ArrayList<Order> getOrdersByUserID( int userid ) throws WritingToSQLException {
        return OrderMapper.getOrdersByUserID( userid );
    }
    
    public static ArrayList<Order> getAllOrdersByShipping() throws WritingToSQLException {
        return OrderMapper.getAllOrdersByShipping();
    }
        
    public static Order getOrderByOrderID( int orderid ) throws WritingToSQLException {
        return OrderMapper.getOrderByOrderID( orderid );
    }
    
    public static Bricks calculateBricks( User user, int id ) throws WritingToSQLException {
        Order order = OrderMapper.getOrderByOrderID(id);
        HouseCalculator hc = new HouseCalculator();
        return hc.makeHouse( order.getLength(), order.getWidth(), order.getHeight() );
    }
}
