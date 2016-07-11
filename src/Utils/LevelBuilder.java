package Utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import World.Assets.Tile;

/**
 * Helpers for level creation because ain't nobody got time to write 8 billion
 * drawImage statements.
 * 
 * @author Drew
 *
 */
public class LevelBuilder {

   // TODO UPDATED ON 7/11/2016. NOT UNIT TESTED YET. CHECK FUNCTIONALITY.
   /**
    * Fills a given area with a tile.
    * 
    * @param g
    * @param tile
    * @param startRow
    * @param startColumn
    * @param width
    * @param height
    */
   public static void addArea(ArrayList<Tile> tiles, BufferedImage sprite,
         int startRow, int startColumn, int width, int height, boolean solid) {

      for (int i = 0; i < width; i++) {
         for (int j = 0; j < height; j++) {
            tiles.add(new Tile(sprite, i + startRow, j + startColumn, solid));
         }
      }
   }

   /**
    * Draws the given tile at every other space.
    * 
    * @param g
    * @param tile
    * @param mod
    * @param row
    * @param width
    */
   public static void addEveryOtherX(ArrayList<Tile> tiles,
         BufferedImage sprite, int mod, int row, int width, boolean solid) {
      // TODO ADD VERTICAL FUNCTIONALITY
      for (int i = 0; i < width; i++) {
         if (i % mod == 0) {
            tiles.add(new Tile(sprite, i + row, row, solid));
         }
      }
   }

   /**
    * Draws a hollow box of the given tile
    * 
    * @param g
    * @param tile
    * @param x
    * @param y
    * @param width
    * @param height
    */
   public static void addBox(ArrayList<Tile> tiles, BufferedImage sprite, int x,
         int y, int width, int height, boolean solid) {

      addArea(tiles, sprite, x, y + 1, 1, height - 2, solid);
      addArea(tiles, sprite, x + width - 1, y + 1, 1, height - 2, solid);
      addArea(tiles, sprite, x, y, width, 1, solid);
      addArea(tiles, sprite, x, y + height - 1, width, 1, solid);

   }

   public static void addCircle(Graphics2D g, Tile tile, int centerX,
         int centerY, int radius) {

      // TODO MAKE IT SO
      // SEE https://en.wikipedia.org/wiki/Midpoint_circle_algorithm
      // COME BACK WHEN YOU LEARN SOME TRIG, CASUAL

   }

}
