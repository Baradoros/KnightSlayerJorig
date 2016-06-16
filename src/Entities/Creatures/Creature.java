package Entities.Creatures;

import Entities.Entity;

/**
 * Template for Creatures.
 * @author Drew
 *
 */
public abstract class Creature extends Entity {
   
   protected int health;
   public static final int DEFAULT_HEALTH = 10;

   public Creature(float xPos, float yPos) {
      super(xPos, yPos);
      health = DEFAULT_HEALTH;
   }

}
