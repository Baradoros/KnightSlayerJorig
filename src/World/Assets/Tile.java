package World.Assets;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Allows tiles to have properties. Do not paint tiles to the screen without
 * using this class.
 * 
 * @author Drew
 *
 */
public class Tile {

   // TODO SOLID IS FOR COLLISION DETECTION LATER
   private boolean solid;
   private int xPos, yPos;
   private BufferedImage sprite;

   public Tile(BufferedImage sprite, int xPos, int yPos) {
      solid = false;
      this.sprite = sprite;
      this.xPos = xPos;
      this.yPos = yPos;

   }

   public int getxPos() {
      return xPos;
   }

   public void setxPos(int xPos) {
      this.xPos = xPos;
   }

   public int getyPos() {
      return yPos;
   }

   public void setyPos(int yPos) {
      this.yPos = yPos;
   }

   public BufferedImage getSprite() {
      return sprite;
   }

   public void setSprite(BufferedImage sprite) {
      this.sprite = sprite;
   }

   // CONVERTS TILE DISTANCE TO PIXELS
   public void drawTile(Graphics2D g) {
      g.drawImage(sprite, xPos * Assets.SCALE, yPos * Assets.SCALE,
            null);
   }

   public void setSolid(boolean solid) {
      this.solid = solid;
   }

   public boolean isSolid() {
      return solid;
   }
}
