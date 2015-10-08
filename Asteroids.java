package asteroids;

import java.awt.Color;
import java.util.*;
import javax.swing.JFrame;

/**
 * @author Nels Quinlog
 * this whole project is more an exercise in math for the graphics than 
 * a serious project for for any purpose. I still want to build it 
 * correctly and have fun.
 * Possibly even make it 3D
 */
public class Asteroids {
    
    private final String[] HUDnames = {"health","attack","score"};
    private static final Random r = new Random();
    private static final ArrayList<Physical> physicales = new ArrayList();
    private static final double[] shipVect = {0.0,0.0,0.0};
    private static final double[] shipLoc = {300.0,300.0,0};
    protected static final Ship ship = new Ship(shipLoc,shipVect);
    private static final int height = 500;
    private static final int width  = 680;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                populateSpace(7);
                buildTheInteface();
            }
        });  
    }
    
    private static void buildTheInteface() {
        JFrame frame = new JFrame("Asteroids");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Space space = new Space(width,height);
        AsteroidUI ui = new AsteroidUI(ship,space);
        ui.setFocusable(true);
        frame.add(ui);
        frame.pack();
        frame.setVisible(true);
    }
    
    private static void populateSpace(int rocks) {
        physicales.add(ship);
        for(int i = 0; i<rocks;++i) {
            double[] loc = {(double)  r.nextInt(width),(double) r.nextInt(height),r.nextDouble()};
            double[] vect = {(r.nextDouble() - 0.5), (r.nextDouble() - 0.5),(r.nextDouble() -  0.5)/16};
            physicales.add(new Rock(5 + r.nextInt(10),loc,vect, 5 + r.nextInt(10),new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256))));
        }       
    }    
}
