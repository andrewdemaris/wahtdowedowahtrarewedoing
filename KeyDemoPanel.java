package LineDraw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

/**
 *
 * @author Andrew.Kaye
 */
public class KeyDemoPanel extends JPanel 
{
      //private Rectangle target = new Rectangle(420,40,60, 30); 
      private Rectangle mover = new Rectangle(200,450, 15,15);
      private Rectangle mover2 = new Rectangle(420,20, 15,15);
      //private Rectangle platform = new Rectangle(400,10, 60,30);
      
      //private Color targetColor = Color.BLUE;
      private Color platformColor = Color.RED;
      private Color moverColor = Color.ORANGE;
      private Color mover2Color = Color.GRAY;
      @Override
      public void paint(Graphics g)
      {
        //g.setColor(targetColor);
        //g.fillRect(target.x, target.y, target.width, target.height);
        g.setColor(moverColor);
        g.fillRect(mover.x, mover.y, mover.width, mover.height);
        g.setColor(mover2Color);
        g.fillRect(mover2.x, mover2.y, mover2.width, mover2.height);
        //g.setColor(platformColor);
        //g.fillRect(platform.x, platform.y, platform.width, platform.height);
      }
      
      public void p1moveLeft()
      {
          mover.x -= 5;
          this.repaint();
          checkIntersection();
      }
      
      public void p1moveRight()
      {
          mover.x += 5;
          this.repaint();
          checkIntersection();
      }
      
      public void p1moveUp()
      {
          mover.y -= 5;
          this.repaint();
          checkIntersection();
      }
      
       public void p1moveDown()
      {
          mover.y += 5;
          this.repaint();
          checkIntersection();
      }
       
        public void p2moveLeft()
      {
          mover2.x -= 5;
          this.repaint();
          checkIntersection();
      }
       
       public void p2moveRight()
      {
          mover2.x += 5;
          this.repaint();
          checkIntersection();
      }
      
        public void p2moveDown()
      {
          mover2.y += 5;
          this.repaint();
          checkIntersection();
      }
        public void p2moveUp()
      {
          mover2.y -= 5;
          this.repaint();
          checkIntersection();
      }
       
      private void checkIntersection()
      {
          
          if(mover2.intersects(mover))
          {
              mover2Color = Color.GREEN;
          }/*
          if(target.intersects(mover))
          {
              targetColor = Color.BLACK;
          }
          if(platform.intersects(mover))
          {
              platformColor = Color.BLUE;
          }*/
          else
          {
              //targetColor = Color.BLUE;
              //platformColor = Color.RED;
              moverColor = Color.ORANGE;
              mover2Color = Color.GRAY;
          }
      }

    public void setPosition(float x, float y) 
    {
        x = mover.x;
        y = mover.y;
    }

}
