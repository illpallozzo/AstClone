package asteroids;

import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

/**
 * @author Nels Quinlog
 */
public class Space extends JPanel {
    private int height;
    private int width;
    private static String display = "";
    private final ArrayList<Physical> physicales;
    private Physical ballistic; 
    private final Random r = new Random();
    
    public Space(int width, int height) {
        this.height = height;
        this.width  = width;
        physicales = new ArrayList<>();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //various instructions for doodling 
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.YELLOW);
        drawPhysicals(g);
        repaint();
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    private void drawPhysicals (Graphics g) {
        //g.drawString(display, 20, 400);
        collision(physicales);
        for(Physical phys: physicales) {
            phys.update();
        }
        for(Physical phys: physicales) {
            g.setColor(phys.getColor());

            double[] loc = phys.getLoc();
            double[] vect = {r.nextDouble(),r.nextDouble(),(r.nextDouble() -  0.5)/16};
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
                        //from top random width
                        loc[0] = (double) r.nextInt(width);
                        loc[1] = 0.0;
                        vect[0] -= 0.5;
                        vect[1] = (vect[0] * -1)/2.0; //down vector
                    } break;
                    case 3: {
                        //from bottom random width
                        loc[0] = (double) r.nextInt(width);
                        loc[1] = (double) height;
                        vect[0] -= 0.5;
                        vect[1] = (vect[0])/2; //up vector
                    } break;
                    default: {
                    } break;
                } // end switch
                physicales.set(physicales.indexOf(phys), new Rock(5 + r.nextInt(12),loc,vect,(5 + r.nextInt(12)),new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256))));
            } else if(phys.looping()) {
                if(loc[0] <= 0)
                    loc[0] += width;
                if(loc[0] >= width)
                    loc[0] = 0;
                if(loc[1] <= 0)
                    loc[1] += height;
                if(loc[1] >= height)
                    loc[1] = 0;
            }// end outta bounds
            g.drawPolygon(phys.getXs(loc),phys.getYs(loc),phys.getVertices());
        } //end each Physical
        if(this.ballistic != null) { //add any balistic additions
            add(this.ballistic.);
            this.ballistic = null;
        }
    }
    
    public void collision(ArrayList<Physical> physicales) {
        ArrayList<double[]> collMap = new ArrayList();
        for(Physical phys : physicales) {
            double[] loc = phys.getLoc();
            double[] cur = {loc[0],loc[1],phys.getSize(),physicales.indexOf(phys)};
            for(double[] listed: collMap) {
                if(Math.hypot((cur[0]-listed[0]), (cur[1]-listed[1])) < (cur[2]+listed[2])) {
                    physicales.get((int) cur[3]).collide(physicales.get((int) listed[3]));
                    physicales.get((int) listed[3]).collide(physicales.get((int) cur[3]));
                }
            }
            collMap.add(cur);
        }
        sweepDead();
    }
    public void add(Physical phys) { physicales.add(phys); }
    public int remain() { return (physicales.size()); }
    public void sweepDead() {
        physicales.removeIf(p -> (p.hp <= 0));
    }
}
