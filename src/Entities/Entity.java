package Entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import World.Assets.Assets;

/**
 * Template for Entities.
 * 
 * @author Drew
 *
 */
public abstract class Entity {

   protected float xPos, yPos;

   public Entity(float xPos, float yPos) {
      this.xPos = xPos * Assets.SCALE;
      this.yPos = yPos * Assets.SCALE;
   }

   public float getxPos() {
      return xPos;
   }

   public void setxPos(float xPos) {
      this.xPos = xPos;
   }

   public float getyPos() {
      return yPos;
   }

   public void setyPos(float yPos) {
      this.yPos = yPos;
   }
   
   public abstract Rectangle getBounds();

   public abstract void update();

   public abstract void draw(Graphics2D g);
   
}
