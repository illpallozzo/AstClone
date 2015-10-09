/*
 * this is an excellent splash screen created by Nels Quinlog
 */
package asteroids;

import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

/**
 *
 * @author Nels "illpallozzo" Quinlog
 */
public class Splash extends JPanel {
    
    private int height;
    private int width;
    private final Random r = new Random();
    private static final ArrayList<Physical> physicals = new ArrayList();
            
    protected Splash(int width, int height)
    {
        this.height = height;
        this.width  = width;
        for(int i = 0; i<8;++i)
        {
            double[] loc = {(double)  r.nextInt(width),(double) r.nextInt(height)};
            double[] vect = {(r.nextDouble() - 0.5), (r.nextDouble() - 0.5)};
            physicals.add(new Rock(2 + r.nextInt(15),loc,vect,20,new Color(235,123,56)));
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g)    
    {
        //grab the graphic component
        super.paintComponent(g);
        //various instructions for doodling 
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.width, this.height);
        g.setColor(Color.YELLOW);
        
        int[][] xArray = {{10, 100, 150}, {160, 135, 200}, {330, 210, 200}};
        int[][] yArray = {{200, 100, 100}, {100, 120, 200}, {100, 200, 175}};
        int z = 3;
        
        for(int polys = 0; polys < z;++polys)
        {
            g.drawPolygon(xArray[polys], yArray[polys], z);
        }
                
        //name the program in the splash
        g.drawString("Another Asteroids Clone", 40, 40);
        //separate the Strings by a color
        g.setColor(Color.WHITE);
        g.drawString("Created by: Nels Quinlog", 40, 240);
        drawPhysicals(g);
        //repaint();
    }
    
    //make sure it does not kill the the display
    @Override
    public Dimension getPreferredSize() 
    {
        return new Dimension(width, height);
    }

    private void drawPhysicals (Graphics g) {
        for(Physical phys: physicals) {
            g.setColor(phys.getColor());
            phys.update();

            double[] loc = phys.getLoc();
            double[] vect = {r.nextDouble(),r.nextDouble()};
            if(!(phys.looping()) && (loc[0] > width ||  loc[0] < 0 || loc[1] > height || loc[1] < 0)) {
                switch (r.nextInt(4)) {
                    case 0: {
                        //from right random height
                        loc[0] = (double) width;
                        loc[1] = (double) r.nextInt(height);
                        vect[0] = (vect[0] * -1)/2.0; //left vector
                        vect[1] -= 0.5;
                    } break;
                    case 1: {
                        //from left random height
                        loc[0] = 0.0;
                        loc[1] = (double) r.nextInt(height);
                        vect[0] = (vect[0])/2.0; //right vector
                        vect[1] -= 0.5;
                    } break;
                    case 2: {
                        loc[0] = (double) r.nextInt(width);
                        loc[1] = 0.1;
                        vect[0] -= 0.5;
                        vect[1] = (vect[0] * -1)/2.0; //down vector
                    } break;
                    case 3: {
                        loc[0] = (double) r.nextInt(width);
                        loc[1] = (double) height;
                        vect[0] -= 0.5;
                        vect[1] = (vect[0])/2; //up vector
                    } break;
                    default: {
                    physicals.remove(phys);
                    } break;
                } // end switch
                physicals.set(physicals.indexOf(phys), new Rock(2+ r.nextInt(15),loc,vect,(5 + r.nextInt(12)),new Color(246,167,92)));
                
            } // end outta bounds
            g.drawPolygon(phys.getXs(loc),phys.getYs(loc),phys.getVertices());
        } //end each rock
    } //end draw rocks    
} //end class