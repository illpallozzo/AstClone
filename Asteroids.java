package asteroids;

import asteroids.Actor.Actor;
import asteroids.Actor.Physical.Collision;
import asteroids.Actor.Physical.Physical;
import asteroids.Actor.Player;
import asteroids.Actor.Shape.ShapeFactory;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Nels Quinlog
 * this whole project is more an exercise in math for the graphics than 
 * a serious project for any purpose. I still want to build it  correctly and have fun.
 * Possibly even make it 3D later as a practice in reusable code.
 * 
 *   After creating this quickly and simply in early 2015 and complicating it in late 2015
 *     my goal now in 2016 will be to clean up the code for simplicity and functionality.
 *   This may seem like it is taking quite a while to complete. It is composed in my free time,
 *     and not the only project on which I am working.
 *   
 */
public class Asteroids {
    
    private static final int height = 500;
    private static final int width  = 680;
    private static final Random r = new Random();
    private static final double[] shipVec = {0.0,0.0,0.0};
    private static final double[] shipLoc = {300.0,300.0,0};
    private static final Collision collision = new Collision();
    private static final FieldMap space = new Space(width,height);
    private static final Collision collisionCalc = new Collision();
    protected static final Actor ship = new Player(ShapeFactory.getShape(ShapeFactory.Type.FIGHTER, Color.yellow), new Physical(collision,shipLoc,shipVec,2), space, 1200);    
    private static final KeyListener controller = new ControlAdapter((CommandListener) ship);
    private static final AsteroidUI ui = new AsteroidUI(controller);

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                populateSpace(5);
                buildTheInteface();
                
                
            }
        });  
    }
    
    private static void buildTheInteface() {
        JFrame frame = new JFrame("Asteroids");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.add((JPanel) space);
        ui.setFocusable(true);
        frame.add(ui);
        frame.pack();
        frame.setVisible(true);
    }
    
    private static void populateSpace(int rocks) {
        space.addActor(ship);
        for(int i = 0; i<rocks;++i) {
            
            /*double[] loc = {(double)  r.nextInt(width),(double) r.nextInt(height),r.nextDouble()};
            double[] vect = {(r.nextDouble() - 0.5), (r.nextDouble() - 0.5),(r.nextDouble() -  0.5)/16};
            space.add(new Rock(5 + r.nextInt(10),loc,vect, 5 + r.nextInt(10),new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256))));*/
        }       
    }    
}
