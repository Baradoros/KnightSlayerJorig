package GameState.PlayState;

import java.awt.Graphics2D;

import GameState.GameState;
import GameState.GameStateManager;
import World.World;

/**
 * Main gameplay state. Creates the world.
 * @author Drew
 *
 */
public class Play extends GameState {
   
   // FIELDS
   private World world;
   
   @SuppressWarnings("unused")
   private GameStateManager gsm;
   
   // CONSTRUCTOR
   public Play(GameStateManager gsm) {
      this.gsm = gsm;
      
      world = new World(gsm);
      
      world.init();
      world.setLevel(0);
   }

   // PASS ON TO WORLD
   @Override
   public void update() {
      world.update();
   }

   @Override
   public void draw(Graphics2D g) {
      world.draw(g);
      
   }

   @Override
   public void keyPressed(int k) {
      world.keyPressed(k);
      
   }

   @Override
   public void keyReleased(int k) {
      world.keyReleased(k);      
   }

}
