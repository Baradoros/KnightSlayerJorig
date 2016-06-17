package World;

import java.awt.Rectangle;

/**
 * Implemented by anything that needs collision detection.<br>
 * Returns an array of Rectangles to check collision against.<br>
 * Each bounding box must be set manually in the method declaration.<br>
 * @author Drew
 *
 */
public interface Collidable {

   public Rectangle[] getBounds();
}
