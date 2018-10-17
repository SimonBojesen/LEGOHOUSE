package FunctionLayer;
/**
 *
 * @author Simon
 */
public class Bricks {
       
    private int four;
    private int two;
    private int one;
    
    public Bricks() {
        this.four = 0;
        this.two = 0;
        this.one = 0;
    }

    public int getFour() {
        return four;
    }

    public int getTwo() {
        return two;
    }

    public int getOne() {
        return one;
    }
    
    public void addBricklayers(int four, int two, int one) {
        this.four += four;
        this.two += two;
        this.one += one;       
    }
   
}

