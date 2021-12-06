
package LineDraw;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andrew.Kaye
 */
public class Main 
{
    
    
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Line Draw");
        KeyDemoPanel panel = new KeyDemoPanel();
        panel.setFocusable(true);
        panel.addKeyListener(new KeyDemoListener(panel));
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        float x = getX();
        float y = getY();

        float screenW = frame.getWidth();
        float screenH = frame.getHeight();

        if (x > screenW)
    x = 0;
else if (x < 0)
    x = screenW;

if (y > screenH)
    y = 0;
else if (y < 0)
    y = screenH;
        
panel.setPosition(x,y);
    }
}
    
    
    
