package asteroids.PlayerParts;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Nels Quinlog
 */

public class ShipControlAdapter implements KeyListener {
    private static Item ship;
    
    @Override
    public void keyTyped(KeyEvent e) {    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())  {
            case KeyEvent.VK_LEFT: {
                ship.command(Item.Command.LEFT);
            } break;
            case KeyEvent.VK_UP : {
                ship.command(Item.Command.THRUST_ON);
            }break;
            case KeyEvent.VK_RIGHT : {
                ship.command(Item.Command.RIGHT);
            }break;
            case KeyEvent.VK_Z : {
                ship.command(Item.Command.FIRE1);
            }break;
            case KeyEvent.VK_X : {
                ship.command(Item.Command.FIRE2);
            }break;
            default : { }
        }   
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode())  {
            case KeyEvent.VK_LEFT: {
                ship.command(Item.Command.CENTER);
            } break;
            case KeyEvent.VK_UP : {
                ship.command(Item.Command.THRUST_OFF);
            }break;
            case KeyEvent.VK_RIGHT : {
                ship.command(Item.Command.CENTER);
            }break;
            case KeyEvent.VK_Z : {
            }break;
            case KeyEvent.VK_X : {
            }break;
            default : { }
        }   
    }
}
