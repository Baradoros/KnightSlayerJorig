package Utils;

import java.awt.Graphics2D;

import World.Assets.Tile;

/**
 * Helpers for level creation because ain't nobody got time to write 8 billion
 * drawImage statements.
 * 
 * @author Drew
 *
 */
public class LevelBuilder {

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
   public static void drawArea(Graphics2D g, Tile tile, int startRow,
         int startColumn, int width, int height) {

      for (int i = 0; i < width; i++) {
         for (int j = 0; j < height; j++) {
            tile.drawTile(g, i + startRow, j + startColumn);
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
   public static void drawEveryOtherX(Graphics2D g, Tile tile, int mod, int row,
         int width) {
      // TODO ADD VERTICAL FUNCTIONALITY
      for (int i = 0; i < width; i++) {
         if (i % mod == 0) {
            tile.drawTile(g, i + row, row);
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
   public static void drawBox(Graphics2D g, Tile tile, int x, int y, int width,
         int height) {

      drawArea(g, tile, x, y + 1, 1, height - 2);
      drawArea(g, tile, x + width - 1, y + 1, 1, height - 2);
      drawArea(g, tile, x, y, width, 1);
      drawArea(g, tile, x, y + height - 1, width, 1);

   }

   public static void drawCircle(Graphics2D g, Tile tile, int centerX,
         int centerY, int radius) {

      // TODO MAKE IT SO
      // SEE https://en.wikipedia.org/wiki/Midpoint_circle_algorithm
      // COME BACK WHEN YOU LEARN SOME TRIG
      
   }

}
