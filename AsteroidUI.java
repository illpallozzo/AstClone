package asteroids;
  
import asteroids.Physical.Ship;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Nels Quinlog
 * UI interface for Asteroids game
 */
public class AsteroidUI extends JPanel {
    
    public AsteroidUI(Ship ship, Space space) {
        this.add(space);
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP: {
                        ship.maneuver(Ship.Maneuver.THRUST_ON);
                    }break;
                    case KeyEvent.VK_LEFT: {
                        ship.maneuver(Ship.Maneuver.LEFT);
                    }break;
                    case KeyEvent.VK_RIGHT: {
                        ship.maneuver(Ship.Maneuver.RIGHT);
                    }break;
                    case KeyEvent.VK_SPACE: {
                        
                    }break;
                    case KeyEvent.VK_X: {
                        space.add(ship.getWeapon());
                    }break;
                    case KeyEvent.VK_Z: {
                        
                    }
                    default:{ }break;
                }
                ship.update();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP: {
                        ship.maneuver(Ship.Maneuver.THRUST_OFF);
                    }break;
                    case KeyEvent.VK_LEFT: {
                        ship.maneuver(Ship.Maneuver.CENTER);
                    }break;
                    case KeyEvent.VK_RIGHT: {
                        ship.maneuver(Ship.Maneuver.CENTER);
                    }break;
                    case KeyEvent.VK_SPACE: {
                        
                    }break;
                    case KeyEvent.VK_X: {
                        
                    }break;
                    case KeyEvent.VK_Z: {
                        
                    }
                    default:{}break;
                }
            }
        });
    }
}
