package asteroids.shapes;

import static asteroids.shapes.Shape.sp;
import java.awt.Graphics;

/**
 *
 * @author nels quinlog
 */
public class Missile implements Shape {
    private final static double[][] shape = {{3,2,2},{0,3,3.28}};
    private final static int vertices  = 4;

    public Missile() {
        
    }
    
    @Override
    public void drawShape(Graphics g, double[] location) {
        sp.draw(this.shape, g, location);
    }
}
