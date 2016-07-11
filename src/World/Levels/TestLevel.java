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
   private ArrayList<Tile> tiles;
   private Player player;

   public TestLevel(GameStateManager gsm) {
      this.gsm = gsm;
      init();
   }

   @Override
   public void init() {
      Assets.initBossAssets();
      tiles = new ArrayList<Tile>();
      buildLevel();
      buildCollision();

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

      drawLevel(g);
      player.draw(g);

   }

   // THE BIG ONE
   private void buildLevel() {
      // ADD OUTER BOX
      LevelBuilder.addBox(tiles, Assets.darkSquareStone1, 0, 0,
            GamePanel.WIDTH / Assets.SCALE, GamePanel.HEIGHT / Assets.SCALE,
            true);

      // ADD INNER LAVA POOL AND BOX
      LevelBuilder.addArea(tiles, Assets.lava1, 10, 8, 5, 5, false);
      LevelBuilder.addBox(tiles, Assets.darkSquareStone1, 9, 7, 7, 7, true);

   }

   private void drawLevel(Graphics2D g) {
      for (int i = 0; i < tiles.size(); i++) {
         tiles.get(i).drawTile(g);
      }
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
