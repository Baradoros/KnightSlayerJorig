package GameState;

import java.awt.Graphics2D;
import java.util.ArrayList;

import GameState.HelpState.HelpState;
import GameState.MainMenu.ConfirmQuit;
import GameState.MainMenu.MainMenu;
import GameState.PlayState.Play;


/**
 * Manages Game States by switching which update method is called depending on
 * what state the game is currently in.
 * 
 * @author Drew
 *
 */
public class GameStateManager {
   
   public static ArrayList<GameState> gameStates = new ArrayList<GameState>();
   
   private int currentState;
   
   // ENUMERATE GAMESTATES
   public static final int MENUSTATE = 0;
   public static final int PLAYSTATE = 1;
   public static final int HELPSTATE = 2;
   public static final int CONFIRMQUITSTATE = 3;
   
   
   // CONSTRUCTOR
   public GameStateManager() {
      
      currentState = MENUSTATE;
      
      gameStates.add(new MainMenu(this));
      gameStates.add(new Play(this));
      gameStates.add(new HelpState(this));
      gameStates.add(new ConfirmQuit(this));
      
   }

   // GETERS AND SETTERS
   public void setCurrentState(int state) {
      this.currentState = state;
   }
   
   public int getCurrentState() { return currentState; }
   
   public ArrayList<GameState> getGameStates() { return gameStates; }
   
   
   // PASS ON TO GAMESTATES
   public void update() {
      gameStates.get(currentState).update();
   }
   public void draw(Graphics2D g) {
      gameStates.get(currentState).draw(g);

   }
   public void keyPressed(int k) {
      gameStates.get(currentState).keyPressed(k);

   }
   public void keyReleased(int k) {
      gameStates.get(currentState).keyReleased(k);

   }
   
}
