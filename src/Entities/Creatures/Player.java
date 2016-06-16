package Entities.Creatures;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Main.GamePanel;

/**
 * The player. Don't write game mechanics in here.
 * 
 * @author Drew
 *
 */
public class Player extends Creature {

   private int playerXSpeed;
   private int playerYSpeed;
   private int playerSize = 32;
   private int speed;

   public Player(float xPos, float yPos) {
      super(xPos, yPos);
      speed = 4;
   }

   /**
    * Prevents player from leaving the screen
    */
   private void checkScreenBoundsCollision() {
      if (xPos < 0)
         xPos = 0;
      if (xPos > GamePanel.WIDTH - playerSize)
         xPos = GamePanel.WIDTH - playerSize;
      if (yPos < 0)
         yPos = 0;
      if (yPos > GamePanel.HEIGHT - playerSize)
         yPos = GamePanel.HEIGHT - playerSize;
   }

   @Override
   public void update() {
      xPos += playerXSpeed;
      yPos += playerYSpeed;
      checkScreenBoundsCollision();
   }

   @Override
   public void draw(Graphics2D g) {
      g.setColor(Color.BLACK);
      g.setStroke(new BasicStroke(1));
      g.fillOval((int) xPos, (int) yPos, playerSize, playerSize);
      g.setStroke(new BasicStroke(5));
      g.setColor(Color.GRAY);
      g.drawOval((int) xPos, (int) yPos, playerSize, playerSize);
   }

   public void keyPressed(int k) {
      switch (k) {
      case KeyEvent.VK_W:
         playerYSpeed = -speed;
         break;

      case KeyEvent.VK_S:
         playerYSpeed = speed;
         break;

      case KeyEvent.VK_D:
         playerXSpeed = speed;
         break;

      case KeyEvent.VK_A:
         playerXSpeed = -speed;
         break;

      case KeyEvent.VK_UP:
         playerYSpeed = -speed;
         break;

      case KeyEvent.VK_DOWN:
         playerYSpeed = speed;
         break;

      case KeyEvent.VK_RIGHT:
         playerXSpeed = speed;
         break;

      case KeyEvent.VK_LEFT:
         playerXSpeed = -speed;
         break;

      default:
         break;
      }

   }

   public void keyReleased(int k) {
      switch (k) {
      case KeyEvent.VK_W:
         playerYSpeed = 0;
         break;

      case KeyEvent.VK_S:
         playerYSpeed = 0;
         break;

      case KeyEvent.VK_D:
         playerXSpeed = 0;
         break;

      case KeyEvent.VK_A:
         playerXSpeed = 0;

      case KeyEvent.VK_UP:
         playerYSpeed = 0;
         break;

      case KeyEvent.VK_DOWN:
         playerYSpeed = 0;
         break;

      case KeyEvent.VK_RIGHT:
         playerXSpeed = 0;
         break;

      case KeyEvent.VK_LEFT:
         playerXSpeed = 0;
         break;

      default:
         break;
      }

   }

   @Override
   public Rectangle getBounds() {
      return new Rectangle();
   }
}
