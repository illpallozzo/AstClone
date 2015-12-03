package asteroids.Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/*
 * @author nels quinlog
*/

public class Rock implements Shape {
    Random rand = new Random();
    private double[][] shape;
    private Color color;
    
    public Rock(Color color) {
        this.color = color;
        int minimum = 8;
        int maximum = 16;
        int size = minimum + rand.nextInt(maximum);
        int vertices = minimum + rand.nextInt(size);
        double point = 0;
        this.shape = new double[2][vertices];
        
        for(int j=0;j<shape[0].length;++j) {
            int extend = rand.nextInt(minimum) - minimum;
            shape[0][j] = size + extend;
        }
        
        for(int i=0;i<shape[1].length;++i) {
            shape[1][i] = point;
            point += TAO / vertices;
        }
    }

    @Override
    public void drawShape(Graphics g, double[] location) {
        sp.draw(shape, g, location, this.color);
    }
    
    protected double[] collide(double[] location, double origin, double effect) {
        double sectorLeft = origin + (TAO / shape[0].length);
        double sectorRight = origin - (TAO / shape[0].length);
        double[] newLoc = location.clone();
        
        for(int i = 0;i<shape[0].length;++i) {
            double point = shape[1][i] + location[2];
            
            if(point < sectorLeft && point >= sectorRight) {
                shape[0][i] -= effect;
                if(shape[0][i] <= 0) {
                    newLoc[0] = 0;
                    newLoc[1] = 0;
                }
            }
        }
        return newLoc;
    }
}
