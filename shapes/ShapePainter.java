package asteroids.shapes;

import java.awt.Graphics;

/**
 *
 * @author nels quinlog
 */
public class ShapePainter {
    private double[][] shape;
    
    public Graphics draw(double[][] shape, Graphics g, double[] location) {
        g.drawPolygon(getXs(location,shape),getYs(location,shape),shape[0].length);
        return g;
    }
    
    public int[] getXs(double[] location, double[][] shape) {
        int[] retX = new int[shape[0].length];
        for(int i=0;i< shape[0].length;++i) {
            retX[i] = (int)(location[0] + (this.shape[0][i] * Math.cos(this.shape[1][i] + location[2])));
        }
        return retX;
    }   
    public int[] getYs(double[] location, double[][] shape) {
        int[] retY = new int[shape[0].length];
        for(int i=0;i< shape[0].length;++i) {
            retY[i] = (int)(location[1] + (this.shape[0][i] * Math.sin(this.shape[1][i] + location[2])));
        }
        return retY;
    }
}
