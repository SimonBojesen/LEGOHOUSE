/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Simon
 */
public class Order {
    //This constructor is for get methods.
    public Order(int id, int length, int width, int height, boolean isSent) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.isSent = isSent;
    }
    //This constructor is for create methods.
    public Order(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    private int id, length, width, height;
    private boolean isSent;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isIsSent() {
        return isSent;
    }

    public void setIsSent(boolean isSent) {
        this.isSent = isSent;
    }
}
