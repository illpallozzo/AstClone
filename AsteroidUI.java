package asteroids;
  
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Nels Quinlog
 * UI interface for Asteroids game
 */

public class AsteroidUI extends JPanel {
    public enum type{PRESS, RELEASE, TYPED;}
    
    private ArrayList<UIListener> pressListeners;
    private ArrayList<UIListener> releaseListeners;
    private ArrayList<UIListener> typedListeners;
    
    public AsteroidUI() {
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) { 
                for(UIListener uil: typedListeners) {
                    uil.update(e.getKeyChar());
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                for(UIListener uil: pressListeners) {
                    uil.update(e.getKeyCode());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                for(UIListener uil: releaseListeners) {
                    uil.update(e.getKeyCode());
                }
            }
        });
    }    
    
    public void registerListener(UIListener uil, type type) {
        switch (type) {
            case PRESS: {
                pressListeners.add(uil);
            }
                break;
            case RELEASE: {
                releaseListeners.add(uil);
            }
                break;
            case TYPED: {
                typedListeners.add(uil);
            }
                break;
            default: {  }
        }
    }
}
