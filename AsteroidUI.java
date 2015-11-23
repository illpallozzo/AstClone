package asteroids;
  
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;


/**
 *
 * @author Nels Quinlog
 * UI interface for Asteroids game
 */

public class AsteroidUI extends JPanel {
    private ArrayList<AsteroidsListener> AListers;
    
    public AsteroidUI(JPanel space) {
        this.add(space);
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
    }
    
    
}
