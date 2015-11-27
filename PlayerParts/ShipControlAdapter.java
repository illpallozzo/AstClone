package asteroids.PlayerParts;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Nels Quinlog
 */

public class ShipControlAdapter implements KeyListener {
    private static PlayerItem ship;
    
    @Override
    public void keyTyped(KeyEvent e) {    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())  {
            case KeyEvent.VK_LEFT: {
                ship.command(PlayerItem.Maneuver.LEFT);
            } break;
            case KeyEvent.VK_UP : {
                ship.command(PlayerItem.Maneuver.THRUST_ON);
            }break;
            case KeyEvent.VK_RIGHT : {
                ship.command(PlayerItem.Maneuver.RIGHT);
            }break;
            case KeyEvent.VK_Z : {
                ship.command(PlayerItem.Maneuver.FIRE1);
            }break;
            case KeyEvent.VK_X : {
                ship.command(PlayerItem.Maneuver.FIRE2);
            }break;
            default : { }
        }   
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode())  {
            case KeyEvent.VK_LEFT: {
                ship.command(PlayerItem.Maneuver.CENTER);
            } break;
            case KeyEvent.VK_UP : {
                ship.command(PlayerItem.Maneuver.THRUST_OFF);
            }break;
            case KeyEvent.VK_RIGHT : {
                ship.command(PlayerItem.Maneuver.CENTER);
            }break;
            case KeyEvent.VK_Z : {
            }break;
            case KeyEvent.VK_X : {
            }break;
            default : { }
        }   
    }
}
