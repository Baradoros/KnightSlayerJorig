package World.Assets;

import java.awt.image.BufferedImage;

import Utils.ImageLoader;

/**
 * All assets of any kind go in static references here. Assets.init(); must be
 * called before Assets can be used.
 * 
 * @author Drew
 *
 */
public class Assets {

   public static final int WIDTH = 32;
   public static final int HEIGHT = 32;
   public static final int SCALE = 32;
   public static SpriteSheet spriteSheet;
   public static BufferedImage bossCobblePlain1, bossCobblePlain2,
         bossCobblePlain3, bossCobbleCrater1, bossCobbleCrater2,
         bossCobbleCrater3, bossCobbleBlood1, bossCobbleBlood2,
         bossCobbleBlood3, bossCobbleBlood4, bossCobbleBlood5;

   public static BufferedImage lava1, lava2, lava3, lava4;

   public static BufferedImage darkSquareStone1, darkSquareStone2,
         darkSquareStone3, darkSquareStone4;

   // TODO MAKE SEPARATE INITS FOR EACH GAMESTATE
   public static void initBossAssets() {
      spriteSheet = new SpriteSheet(ImageLoader.loadImage(
            "/img/SpriteSheets/DungeonCrawl_ProjectUtumnoTileset.png"));

      // BOSS COBBLE
      bossCobblePlain1 = spriteSheet.crop(41, 12);
      bossCobblePlain2 = spriteSheet.crop(45, 12);
      bossCobblePlain3 = spriteSheet.crop(46, 12);
      bossCobbleCrater1 = spriteSheet.crop(48, 12);
      bossCobbleCrater2 = spriteSheet.crop(49, 12);
      bossCobbleCrater3 = spriteSheet.crop(50, 12);
      bossCobbleBlood1 = spriteSheet.crop(42, 12);
      bossCobbleBlood2 = spriteSheet.crop(43, 12);
      bossCobbleBlood3 = spriteSheet.crop(44, 12);
      bossCobbleBlood4 = spriteSheet.crop(51, 12);
      bossCobbleBlood5 = spriteSheet.crop(52, 12);

      // LAVA
      lava1 = spriteSheet.crop(49, 13);
      lava2 = spriteSheet.crop(50, 13);
      lava3 = spriteSheet.crop(51, 13);
      lava4 = spriteSheet.crop(52, 13);

      // DARK SQUARE BLOCKS
      darkSquareStone1 = spriteSheet.crop(35, 17);
      darkSquareStone2 = spriteSheet.crop(36, 17);
      darkSquareStone3 = spriteSheet.crop(37, 17);
      darkSquareStone4 = spriteSheet.crop(38, 17);

   }
}
