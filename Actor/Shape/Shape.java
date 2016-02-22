package asteroids.Actor.Shape;

import java.awt.Graphics;


/**
 *
 * @author nels quinlog
 */
public interface Shape {
    public static final double TAO = 2 * Math.PI;
    public static final ShapePainter sp = new ShapePainter();
    
    //pass the JPanel Graphics and location as [X,Y, directionTheta]
    public void drawShape(double[] location, Graphics g);
}
