package asteroids;
  
import asteroids.PlayerParts.ShipControl;

import javax.swing.JPanel;

/**
 *
 * @author Nels Quinlog
 * UI interface for Asteroids game
 */

public class AsteroidUI extends JPanel {
    
    public AsteroidUI(ShipControl sc) {
        this.addKeyListener(sc);     
    }
}
