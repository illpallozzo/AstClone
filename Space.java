package asteroids;

import asteroids.Actor.Actor;
import asteroids.Actor.Physical.CollisionListener;
import static asteroids.Actor.Physical.CollisionListener.DIMENSIONS;
import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

/**
 * @author Nels Quinlog
 */
public class Space extends JPanel implements FieldMap {
    private int height;
    private int width;
    private final Random r = new Random();
    private final ArrayList<Actor> colliders;
    private double[] fieldFlow = new double[DIMENSIONS];
    private double fieldFriction = 0;
    
    public Space(int width, int height) {
        this.height = height;
        this.width  = width;
        colliders = new ArrayList<>();
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
 
        for(CollisionListener phys: colliders) {
            phys.update(fieldFlow,fieldFriction);
        }
        for(Actor phys: colliders) {
            phys.paintSelf(g);
        }
    }
    
    public void sweepDead() {
        colliders.removeIf(p -> (p.getHP() <= 0));
    }
    @Override
    public void addActor(Actor cl) {
        colliders.add(cl);
    }
}
