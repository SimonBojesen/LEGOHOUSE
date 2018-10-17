/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import Exceptions.WritingToSQLException;
import FunctionLayer.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Simon
 */
public class OrderMapper {
    
    public static void createOrder( Order order, int userid ) throws WritingToSQLException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `order` ( length, width, height, shipped, fk_userid ) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, order.getLength());
            ps.setInt(2, order.getWidth());
            ps.setInt(3, order.getHeight());
            ps.setBoolean(4, false);
            ps.setInt(5, userid);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            order.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new WritingToSQLException( ex.getMessage() );
        }
    }
    
    public static ArrayList<Order> getOrdersByUserID( int userid ) throws WritingToSQLException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM `order` "
                    + "WHERE fk_userid=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, userid );
            ResultSet rs = ps.executeQuery();
            ArrayList<Order> orders = new ArrayList<>();
            while ( rs.next() ) {
                Order order = new Order( rs.getInt("id"), rs.getInt("length"), rs.getInt("width"), rs.getInt("height"), rs.getBoolean("shipped") );
                orders.add( order );
            }
            return orders;
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new WritingToSQLException( ex.getMessage() );
        }
    }
    
    public static ArrayList<Order> getAllOrdersByShipping() throws WritingToSQLException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM `order` "
                       + "WHERE shipped=false";
            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            ArrayList<Order> orders = new ArrayList<>();
            while ( rs.next() ) {
                Order order = new Order( rs.getInt("id"), rs.getInt("length"), rs.getInt("width"), rs.getInt("height"), rs.getBoolean("shipped") );
                orders.add( order );
            }
            return orders;
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new WritingToSQLException( ex.getMessage() );
        }
    }
    
    public static void setShippingByOrderID(int orderid) throws WritingToSQLException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE `order` "
                       + "SET shipping = true "
                       + "WHERE id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderid);
            ps.executeUpdate(SQL);
            
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new WritingToSQLException( ex.getMessage() );
        }
    }
    public static Order getOrderByOrderID( int orderid ) throws WritingToSQLException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM `order` "
                       + "WHERE id=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, orderid );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                Order order = new Order( rs.getInt("id"), rs.getInt("length"), rs.getInt("width"), rs.getInt("height"), rs.getBoolean("shipped") );
                return order;
            } else {
                throw new WritingToSQLException( "Could not find order" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new WritingToSQLException( ex.getMessage() );
        }
    }
    
}
