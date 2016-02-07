package asteroids;
  
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Nels Quinlog
 * UI interface for Asteroids game
 */

public class AsteroidUI extends JPanel {
    
    public AsteroidUI(KeyListener cl) {
        this.addKeyListener(cl);     
    }
}
