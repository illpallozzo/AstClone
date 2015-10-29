package asteroids.shapes;

import java.awt.Graphics;

/**
 *
 * @author nels quinlog
 */
public class Fighter implements Shape {
    private final double[][] shape = {{8,6,1,6,},{0,2.7,Math.PI,3.58}};
    private final int vertices = 4;
    
    public Fighter() {
    }

    @Override
    public void drawShape(Graphics g, double[] location) {
        sp.draw(this.shape, g, location);
    }
}
