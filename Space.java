package asteroids;

import asteroids.Actor.Actor;
import asteroids.Actor.Physical.Collision;
import static asteroids.Actor.Physical.CollisionListener.DIMENSIONS;
import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

/**
 * @author Nels Quinlog
 */
public class Space extends JPanel {
    private int height;
    private int width;
    private final Random r = new Random();
    private ArrayList<Actor> actors = new ArrayList<>();
    private double[] fieldFlow = new double[DIMENSIONS];
    private double fieldFriction = 0;
    

    Space(int width, int height) {
        this.height = height;
        this.width  = width;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //various instructions for doodling 
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.YELLOW);
        drawShapes(g);
        repaint();
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    private void drawShapes (Graphics g) {
 
        Collision.collisionCheck();
        
        for(Actor phys: actors) {
            phys.paintSelf(g);
        }
    }
    
    public void sweepDead() {
        actors.removeIf(p -> (p.getHP() <= 0));
    }
    
    public void addActor(Actor cl) {
        actors.add(cl);
    }
    
    @Override
    public Graphics getGraphics() {
        return super.getGraphics();
    }
}
