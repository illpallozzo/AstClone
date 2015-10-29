package asteroids.shapes;

import java.awt.Graphics;

/**
 *
 * @author nels quinlog
 */
public interface Shape {
    public final static double TAO = 2 * Math.PI;
    final ShapePainter sp = new ShapePainter();
    
    //pass the JPanel Graphics and location as [X,Y,Theta]
    public void drawShape(Graphics g, double[] location);
}
