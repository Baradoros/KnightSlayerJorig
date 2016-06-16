package Main;

import javax.swing.JFrame;

/**
 * This is the driver class for Knight Slayer Jorig.
 * 
 * @author Drew Funderburk
 */
@SuppressWarnings("serial")
public class Game extends JFrame {
   
   public Game() {
      // CREATE NEW WINDOW
      setTitle("Knight Slayer Jorig");
      setContentPane(new GamePanel());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      pack();
      setVisible(true);
   }

   public static void main(String[] args) {
      // INIT GAME
      new Game();

   }

}
