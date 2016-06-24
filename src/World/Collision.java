package World;

import java.awt.Rectangle;

/**
 * Class containing methods for collision detection.
 * @author Drew
 *
 */
public class Collision {

   /**
    * Checks for intersection between two arrays of rectangles.
    * @param object1
    * @param object2
    * @return
    */
   public boolean checkCollision(Rectangle[] object1, Rectangle[] object2) {
      
      for (int i = 0; i < object1.length; i++) {
         for (int j = 0; j < object2.length; j++) {
            if (object1[i].intersects(object2[j])) {
               return true;
            }
         }
      }
      return false;
   }
   
}
