package asteroids;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Nels Quinlog
 */

public class ControlAdapter implements KeyListener {
    
    public enum Command {
        LEFT (-1),
        CENTER (0),
        RIGHT (1),
        THRUST_ON (2),
        THRUST_OFF (3),
        FIRE1 (4),
        FIRE2 (5);
        private final int command;
        
        Command(int command) {
            this.command = command;
        }
        public int getCommand() { return command; };
    }
    
    private final CommandListener cl;
    
    public ControlAdapter(CommandListener cl) {
        this.cl = cl;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())  {
            case KeyEvent.VK_LEFT: {
                cl.command(Command.LEFT);
            } break;
            case KeyEvent.VK_UP : {
                cl.command(Command.THRUST_ON);
            }break;
            case KeyEvent.VK_RIGHT : {
                cl.command(Command.RIGHT);
            }break;
            case KeyEvent.VK_Z : {
                cl.command(Command.FIRE1);
            }break;
            case KeyEvent.VK_X : {
                cl.command(Command.FIRE2);
            }break;
            default : { }
        }   
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode())  {
            case KeyEvent.VK_LEFT: {
                cl.command(Command.CENTER);
            } break;
            case KeyEvent.VK_UP : {
                cl.command(Command.THRUST_OFF);
            }break;
            case KeyEvent.VK_RIGHT : {
                cl.command(Command.CENTER);
            }break;
            case KeyEvent.VK_Z : {
            }break;
            case KeyEvent.VK_X : {
            }break;
            default : { }
        }   
    }
}
