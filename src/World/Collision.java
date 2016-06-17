package World;

import java.awt.Rectangle;

public class Collision {

   public boolean checkCollision(Rectangle[] object1, Rectangle[] object2) {
      for (int i = 0; i < object1.length; i++) {
         for (int j = 0; j < object2.length; j++) {
            if (object1[i].intersects(object2[j])) {
               return true;
            } else return false;
         }
      }
      return false;
   }
}
