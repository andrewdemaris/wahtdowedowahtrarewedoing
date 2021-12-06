package LineDraw;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Andrew.Kaye
 */

/**
 *
 * @author Andrew.Kaye
 */
public class KeyDemoListener implements KeyListener
{
private KeyDemoPanel panel;

    public KeyDemoListener(KeyDemoPanel panel)
    {
        this.panel = panel;
    }
    
    @Override
    public void keyTyped(KeyEvent e) 
    {
        
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        
        switch (e.getKeyCode()) 
        {
            case KeyEvent.VK_LEFT -> panel.p1moveLeft();
            case KeyEvent.VK_RIGHT -> panel.p1moveRight();
            case KeyEvent.VK_UP -> panel.p1moveUp();
            case KeyEvent.VK_DOWN -> panel.p1moveDown();
            case KeyEvent.VK_A -> panel.p2moveLeft();
            case KeyEvent.VK_D -> panel.p2moveRight();
            case KeyEvent.VK_W -> panel.p2moveUp();
            case KeyEvent.VK_S -> panel.p2moveDown();
            default -> {
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    
}
