package World.Assets;

import java.awt.image.BufferedImage;

/**
 * Spritesheet stuffs.
 * @author Drew
 *
 */
public class SpriteSheet {

   private BufferedImage sheet;

   public SpriteSheet(BufferedImage sheet) {
      this.sheet = sheet;
   }
   
   public BufferedImage crop(int x, int y) {
      return sheet.getSubimage(x * Assets.SCALE, y * Assets.SCALE, Assets.WIDTH, Assets.HEIGHT);
   }

   public BufferedImage getSpriteSheet() {
      return sheet;
   }

}
