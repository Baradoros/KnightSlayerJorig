package World.Levels;

import java.awt.Graphics2D;

import World.Collidable;

/**
 * Template for all levels and areas.
 * @author Drew
 *
 */
public abstract class Level implements Collidable {
   
   public abstract void init();
   public abstract void update();
   public abstract void draw(Graphics2D g);
   public abstract void keyPressed(int k);
   public abstract void keyReleased(int k);
}
