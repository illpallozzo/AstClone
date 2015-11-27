package asteroids.shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author nels quinlog
 */
public interface Shape {
    public static final double TAO = 2 * Math.PI;
    public static final ShapePainter sp = new ShapePainter();
    
    //pass the JPanel Graphics and location as [X,Y, directionTheta]
    public void drawShape(Graphics g, double[] location, Color color);
}
