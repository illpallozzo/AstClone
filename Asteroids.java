package asteroids;

import asteroids.Actor.Actor;
import asteroids.Actor.Physical.Collision;
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
    private static double[] shipVec = {0.0,0.0,0.0};
    private static double[] shipLoc = {height/2,width/2,0};
    private static final Collision collision = new Collision();
    private static final Space space = new Space(width,height);
    private static Actor ship = new Player(ShapeFactory.getShape(ShapeFactory.Type.FIGHTER, Color.yellow), collision.getListener(shipLoc, shipVec, 2), 1200);    
    private static final KeyListener controller = new ControlAdapter((CommandListener) ship);

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                space.addKeyListener(controller);
                populateSpace(5);
                buildTheInteface(); 
            }
        });  
    }
    
    private static void buildTheInteface() {
        JFrame frame = new JFrame("Asteroids");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        space.setFocusable(true);
        frame.add(space);
        frame.pack();
        frame.setVisible(true);
    }
    
    private static void populateSpace(int rocks) {
        space.addActor(ship);
        for(int i = 0; i<rocks;++i) {
            
            double[] loc = {(double)  r.nextInt(width),(double) r.nextInt(height),r.nextDouble()};
            double[] vect = {(r.nextDouble() - 0.5), (r.nextDouble() - 0.5),(r.nextDouble() -  0.5)/16};
            space.addActor(new Actor(ShapeFactory.getShape(ShapeFactory.Type.ROCK, new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256))), collision.getListener(loc,vect,12),20000));
        }       
    }    
}
