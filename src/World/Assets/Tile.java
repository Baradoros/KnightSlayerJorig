package World.Assets;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Allows tiles to have properties. Do not paint tiles to the screen without
 * using this class.
 * @author Drew
 *
 */
public class Tile {

   // TODO SOLID IS FOR COLLISION DETECTION LATER
   private boolean solid;
   private BufferedImage sprite;
   
   
   public Tile(BufferedImage sprite) {
      solid = false;
      this.sprite = sprite;
      
   }
   
   // CONVERTS TILE DISTANCE TO PIXELS
   public void drawTile(Graphics2D g, int xTilePos, int yTilePos) {
      g.drawImage(sprite, xTilePos * Assets.SCALE, yTilePos * Assets.SCALE, null);
   }
   
   public void setSolid(boolean solid) {
      this.solid = solid;
   }
   
   public boolean isSolid() {
      return solid;
   }
}
