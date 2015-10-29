package asteroids.shapes;

import java.awt.Graphics;
import java.util.Random;

/*/
 * @author nels quinlog
 */
public class Rock implements Shape {
    Random rand = new Random();
    private int vertices;
    private double[][] shape;
    
    public Rock() {
        int minimum = 8;
        int maximum = 16;
        int size = minimum + rand.nextInt(maximum);
        vertices = minimum + rand.nextInt(size);
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
        this.vertices = shape[0].length;
    }

    @Override
    public void drawShape(Graphics g, double[] location) {
        sp.draw(this.shape, g, location);
    }
}
