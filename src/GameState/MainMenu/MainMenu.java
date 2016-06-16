package GameState.MainMenu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.glass.events.KeyEvent;

import GameState.GameState;
import GameState.GameStateManager;
import Main.GamePanel;

/**
 * Temporary main menu
 * 
 * @author Drew
 *
 */
public class MainMenu extends GameState {

   // FIELDS
   private int titleX, titleY;
   private int startButtonX, startButtonY;
   private int helpButtonX, helpButtonY;
   private int quitButtonX, quitButtonY;
   private int selector1X, selector1Y;
   private int selector2X, selector2Y;

   // IMAGES AND PATHS
   // TODO MOVE THESE TO ASSETS
   private BufferedImage title, background, startButton, helpButton, quitButton,
         selector1, selector2;
   private String selectorImagePath = "Resources/img/Selector.png";
   private String quitButtonImagePath = "Resources/img/Quit.png";
   private String startButtonImagePath = "Resources/img/Start.png";
   private String helpButtonImagePath = "Resources/img/Help.png";
   private String backgroundImagePath = "Resources/img/background.png";
   private String titleImagePath = "Resources/img/title.png";

   // OPTIONS
   private final int START = 0;
   private final int HELP = 1;
   private final int QUIT = 2;
   private final int TOTAL_OPTIONS = 3;
   private int selection;

   private GameStateManager gsm;

   // CONSTRUCTOR
   public MainMenu(GameStateManager gsm) {

      this.gsm = gsm;
      selection = HELP;
      readImages();
      positionImages();
   }

   private void readImages() {

      // READ IMAGE FILES
      // TODO MOVE TO ASSETS
      try {
         background = ImageIO.read(new File(backgroundImagePath));
      } catch (IOException e) {
         e.printStackTrace();
      }

      try {
         title = ImageIO.read(new File(titleImagePath));
      } catch (IOException e) {
         e.printStackTrace();
      }

      try {
         startButton = ImageIO.read(new File(startButtonImagePath));
      } catch (IOException e) {
         e.printStackTrace();
      }

      try {
         helpButton = ImageIO.read(new File(helpButtonImagePath));
      } catch (IOException e) {
         e.printStackTrace();
      }

      try {
         quitButton = ImageIO.read(new File(quitButtonImagePath));
      } catch (IOException e) {
         e.printStackTrace();
      }

      try {
         selector1 = ImageIO.read(new File(selectorImagePath));
      } catch (IOException e) {
         e.printStackTrace();
      }

      try {
         selector2 = ImageIO.read(new File(selectorImagePath));
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

   private void positionImages() {

      // SET IMAGE POSITIONS
      titleX = GamePanel.WIDTH / 2 - (title.getWidth() / 2);
      titleY = GamePanel.HEIGHT / 20;

      startButtonX = GamePanel.WIDTH / 2 - (startButton.getWidth() / 2);
      startButtonY = GamePanel.HEIGHT / 5 + startButton.getHeight();

      helpButtonX = GamePanel.WIDTH / 2 - (helpButton.getWidth() / 2);
      helpButtonY = startButtonY + startButton.getHeight()
            + startButton.getHeight() / 2;

      quitButtonX = GamePanel.WIDTH / 2 - (quitButton.getWidth() / 2);
      quitButtonY = helpButtonY + helpButton.getHeight()
            + helpButton.getHeight() / 2;

      selector1X = startButtonX - selector1.getWidth()
            - (selector1.getWidth() / 2);
      selector2X = startButtonX + startButton.getWidth() + selector2.getWidth()
            - (selector2.getWidth() / 2);

      // SELECTOR POSITIONS
      if (selection == START) {
         selector1Y = startButtonY + (startButton.getHeight() / 2)
               - (selector1.getHeight() / 2);
         selector2Y = startButtonY + (startButton.getHeight() / 2)
               - (selector1.getHeight() / 2);
      } else if (selection == HELP) {
         selector1Y = helpButtonY + (startButton.getHeight() / 2)
               - (selector1.getHeight() / 2);
         selector2Y = helpButtonY + (startButton.getHeight() / 2)
               - (selector1.getHeight() / 2);
      } else if (selection == QUIT) {
         selector1Y = quitButtonY + (startButton.getHeight() / 2)
               - (selector1.getHeight() / 2);
         selector2Y = quitButtonY + (startButton.getHeight() / 2)
               - (selector1.getHeight() / 2);
      }
   }

   @Override
   public void update() {
      positionImages();
   }

   @Override
   public void draw(Graphics2D g) {

      // BACKGROUND
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

      // BACKGROUND
      g.drawImage(background, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);

      // TITLE
      g.drawImage(title, titleX, titleY, null);

      // START BUTTON
      g.drawImage(startButton, startButtonX, startButtonY, null);

      // HELP BUTTON
      g.drawImage(helpButton, helpButtonX, helpButtonY, null);

      // QUIT BUTTON
      g.drawImage(quitButton, quitButtonX, quitButtonY, null);

      // SELECTOR
      g.drawImage(selector1, selector1X, selector1Y, null);
      g.drawImage(selector2, selector2X, selector2Y, null);

   }

   private void select() {
      if (selection == QUIT) {
         gsm.setCurrentState(GameStateManager.CONFIRMQUITSTATE);
      } else if (selection == START) {
         gsm.setCurrentState(GameStateManager.PLAYSTATE);
      }
   }

   private void incrementSelection() {
      selection--;
      if (selection > TOTAL_OPTIONS - 1) {
         selection = START;
      }
      if (selection < 0) {
         selection = QUIT;
      }
   }

   private void decrementSelection() {
      selection++;
      if (selection > TOTAL_OPTIONS - 1) {
         selection = START;
      }
      if (selection < 0) {
         selection = QUIT;
      }
   }

   @Override
   public void keyPressed(int k) {
      if (k == KeyEvent.VK_W || k == KeyEvent.VK_UP) {
         incrementSelection();
      } else if (k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN) {
         decrementSelection();
      } else if (k == KeyEvent.VK_ENTER) {
         select();
      }
   }

   @Override
   public void keyReleased(int k) {
      // TODO Auto-generated method stub

   }

}
