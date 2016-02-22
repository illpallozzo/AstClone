package asteroids.Actor.Shape;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author nels quinlog
 */
public class Fighter implements Shape {
    private final double[][] shape = {{8,6,1,6},{0,2.7,Math.PI,3.58}};
    private final Color color;

    Fighter(Color color) {
        this.color = color;
    }

    @Override
    public void drawShape(double[] location, Graphics g) {
        sp.draw(shape, g, location, color);
    }
}
