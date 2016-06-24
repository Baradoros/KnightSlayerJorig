package World.Levels;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.sun.glass.events.KeyEvent;

import Entities.Creatures.Player;
import GameState.GameStateManager;
import Main.GamePanel;
import Utils.LevelBuilder;
import World.Assets.Assets;
import World.Assets.Tile;

/**
 * Level for testing stuffs.
 * 
 * @author Drew
 *
 */
public class TestLevel extends Level {

   private GameStateManager gsm;
   private ArrayList<Tile> tiles = new ArrayList<Tile>();
   private Player player;

   public TestLevel(GameStateManager gsm) {
      this.gsm = gsm;
      init();
   }

   @Override
   public void init() {
      Assets.init();
      // ADD USED TILES
      // **********************************************************************
      // TODO URGENT LOOK INTO BETTER WAY TO ORGANIZE THESE THAT ALLOWS
      // SEARCHING BY
      // NAME RATHER THAN INDEX.
      // IMPLIMENT BEFORE CREATING ANYTHING OTHER THAN THE TEST LEVEL.
      // AIN'T NOBODY GOT TIME TO REDO ALL THE LEVELS LATER.
      // **********************************************************************
      tiles.add(new Tile(Assets.bossCobblePlain1)); // 0
      tiles.add(new Tile(Assets.bossCobblePlain2)); // 1
      tiles.add(new Tile(Assets.bossCobblePlain3)); // 2
      tiles.add(new Tile(Assets.bossCobbleCrater1)); // 3
      tiles.add(new Tile(Assets.bossCobbleCrater2)); // 4
      tiles.add(new Tile(Assets.bossCobbleCrater3)); // 5
      tiles.add(new Tile(Assets.bossCobbleBlood1)); // 6
      tiles.add(new Tile(Assets.bossCobbleBlood2)); // 7
      tiles.add(new Tile(Assets.bossCobbleBlood3)); // 8
      tiles.add(new Tile(Assets.bossCobbleBlood4)); // 9
      tiles.add(new Tile(Assets.bossCobbleBlood5)); // 10

      tiles.add(new Tile(Assets.lava1)); // 11
      tiles.add(new Tile(Assets.lava2)); // 12
      tiles.add(new Tile(Assets.lava3)); // 13
      tiles.add(new Tile(Assets.lava4)); // 14

      tiles.add(new Tile(Assets.darkSquareStone1)); // 15
      tiles.add(new Tile(Assets.darkSquareStone2)); // 16
      tiles.add(new Tile(Assets.darkSquareStone3)); // 17
      tiles.add(new Tile(Assets.darkSquareStone4)); // 18
      // SET LAVA AND SQUARE STONE TILES SOLID
      for (int i = 11; i < 18; i++)
         tiles.get(i).setSolid(true);

      // INITIALIZE THE PLAYER
      player = new Player(5, 5);
   }

   @Override
   public void update() {
      player.update();
   }

   @Override
   public void draw(Graphics2D g) {
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

      buildLevel(g);
      buildCollision();
      player.draw(g);

   }

   // THE BIG ONE
   private void buildLevel(Graphics2D g) {
      // FLOOR
      for (int i = 0; i < GamePanel.WIDTH / Assets.SCALE; i++) {
         for (int j = 0; j < GamePanel.HEIGHT / Assets.SCALE; j++) {
            tiles.get(0).drawTile(g, i, j);
         }
      }

      // BORDER
      LevelBuilder.drawBox(g, tiles.get(15), 0, 0,
            GamePanel.WIDTH / Assets.SCALE, GamePanel.HEIGHT / Assets.SCALE);

      // CENTER BOX
      LevelBuilder.drawBox(g, tiles.get(15), 10, 7, 5, 5);
      LevelBuilder.drawArea(g, tiles.get(11), 11, 8, 3, 3);
      LevelBuilder.drawBox(g, tiles.get(15), 8, 5, 9, 9);
      LevelBuilder.drawBox(g, tiles.get(11), 9, 6, 7, 7);

   }
   
   // LAYERS COLLISION ONTO THE MAP
   private void buildCollision() {
      // TODO MAKE IT SO
   }

   @Override
   public void keyPressed(int k) {
      if (k == KeyEvent.VK_ESCAPE) {
         gsm.setCurrentState(GameStateManager.MENUSTATE);
      } else {
         player.keyPressed(k);
      }
   }

   @Override
   public void keyReleased(int k) {
      player.keyReleased(k);
   }

   @Override
   public Rectangle[] getBounds() {
      return null;
   }

}
