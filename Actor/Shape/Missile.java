package asteroids.Actor.Shape;

import static asteroids.Actor.Shape.Shape.sp;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author nels quinlog
 */
public class Missile implements Shape {
    private final double[][] shape = {{3,2,2},{0,3,3.28}};
    private final Color color;

    public Missile(Color color) {
        this.color = color;
    }
    
    @Override
    public void drawShape(Graphics g, double[] location) {
        sp.draw(shape, g, location, color);
    }
}
