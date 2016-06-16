package GameState;

import java.awt.Graphics2D;

/**
 * Specifies methods all GameStates are required to have. All GameStates must
 * extend this class. 
 * 
 * @author Drew
 *
 */
public abstract class GameState {

   public abstract void update();
   public abstract void draw(Graphics2D g);
   public abstract void keyPressed(int k);
   public abstract void keyReleased(int k);
   
}
