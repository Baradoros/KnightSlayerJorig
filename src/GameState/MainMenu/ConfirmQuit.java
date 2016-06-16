package GameState.MainMenu;

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
 * Confirmation dialog for quitting.
 * @author Drew
 *
 */
public class ConfirmQuit extends GameState {

   // LOCATIONS OF IMAGES
   private int titleX, titleY;
   private int windowX, windowY;
   private int yesX, yesY;
   private int noX, noY;
   private int selector1X, selector1Y, selector2X, selector2Y;

   // OPTIONS
   private final int YES = 0;
   private final int NO = 1;
   private final int TOTAL_OPTIONS = 2;
   private int selection;

   // IMAGES AND PATHS
   private BufferedImage window, yes, no, selector1, selector2, background,
         title;
   // THIS SECTION PLEASES ME 
   // TODO MOVE TO ASSETS
   private String backgroundImagePath = "Resources/img/Background.png";
   private String selectorImagePath = "Resources/img/Selector.png";
   private String windowImagePath = "Resources/img/Confirm.png";
   private String titleImagePath = "Resources/img/title.png";
   private String yesImagePath = "Resources/img/Yes.png";
   private String noImagePath = "Resources/img/No.png";

   private GameStateManager gsm;

   // CONSTRUCTOR
   public ConfirmQuit(GameStateManager gsm) {

      this.gsm = gsm;
      selection = 0;

      readImages();
      positionImages();

   }

   // TODO MOVE TO ASSETS
   private void readImages() {

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
         window = ImageIO.read(new File(windowImagePath));

      } catch (IOException e) {
         e.printStackTrace();
      }

      try {
         yes = ImageIO.read(new File(yesImagePath));
      } catch (IOException e) {
         e.printStackTrace();
      }

      try {
         no = ImageIO.read(new File(noImagePath));
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

      windowX = GamePanel.WIDTH / 2 - (window.getWidth() / 2);
      windowY = GamePanel.HEIGHT / 2 - (window.getHeight() / 2);

      yesX = windowX + (window.getWidth() / 2) - (yes.getWidth() / 2);
      yesY = windowY + window.getHeight() / 3;

      noX = windowX + (window.getWidth() / 2) - (no.getWidth() / 2);
      noY = yesY + yes.getHeight() + yes.getHeight() / 5;

      selector1X = yesX - selector1.getWidth() - (selector1.getWidth() / 2);
      selector2X = yesX + yes.getWidth() + (selector2.getWidth() / 2);

      if (selection == YES) {
         selector1Y = yesY + (selector1.getHeight() / 4);
         selector2Y = yesY + (selector2.getHeight() / 4);

      } else if (selection == NO) {
         selector1Y = noY + (selector1.getHeight() / 4);
         selector2Y = noY + (selector2.getHeight() / 4);

      }

   }

   private void incrementSelection() {
      selection--;
      if (selection > TOTAL_OPTIONS - 1) {
         selection = YES;
      }
      if (selection < 0) {
         selection = NO;
      }
   }

   private void decrementSelection() {
      selection++;
      if (selection > TOTAL_OPTIONS - 1) {
         selection = YES;
      }
      if (selection < 0) {
         selection = NO;
      }
   }

   private void select() {
      if (selection == YES) {
         System.exit(1);
      } else {
         gsm.setCurrentState(GameStateManager.MENUSTATE);
      }
   }

   @Override
   public void update() {
      positionImages();
   }

   @Override
   public void draw(Graphics2D g) {
      // BACKGROUND
      g.drawImage(background, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);

      // TITLE
      g.drawImage(title, titleX, titleY, null);

      // WINDOW
      g.drawImage(window, windowX, windowY, null);

      // YES
      g.drawImage(yes, yesX, yesY, null);

      // NO
      g.drawImage(no, noX, noY, null);

      // SELECTORS
      g.drawImage(selector1, selector1X, selector1Y, null);
      g.drawImage(selector2, selector2X, selector2Y, null);

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
