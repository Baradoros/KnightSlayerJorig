package World;

import java.awt.Graphics2D;
import java.util.ArrayList;

import GameState.GameState;
import GameState.GameStateManager;
import World.Levels.Level;
import World.Levels.TestLevel;

/**
 * Loads levels and manages the game. Extends GameState but does not function
 * as a state.
 * @author Drew
 *
 */
public class World extends GameState {

   private GameStateManager gsm;

   private ArrayList<Level> levels = new ArrayList<Level>();
   private int currentLevel = 0;
   private boolean initialized = false;

   // PASS GSM TO WORLD
   public World(GameStateManager gsm) {
      this.gsm = gsm;
   }

   // INITIALIZE WORLD
   public void init() {
      initialized = false;

      importLevels();

      initialized = true;
   }

   // CHECK IF EVERYTHING IS LOADED
   public boolean isInitialized() {
      if (initialized) {
         return true;
      } else {
         return false;
      }
   }

   private void importLevels() {
      levels.add(new TestLevel(gsm));
   }

   public void setLevel(int level) {
      currentLevel = level;
   }

   public Level getCurrentLevel() {
      return levels.get(currentLevel);
   }

   // PASS COMMANDS DOWN TO LEVEL
   @Override
   public void update() {
      levels.get(currentLevel).update();
   }

   @Override
   public void draw(Graphics2D g) {
      levels.get(currentLevel).draw(g);
   }

   @Override
   public void keyPressed(int k) {
      levels.get(currentLevel).keyPressed(k);
   }

   @Override
   public void keyReleased(int k) {
      levels.get(currentLevel).keyReleased(k);
   }

}
