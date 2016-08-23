package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import GameState.GameStateManager;

/**
 * Creates a JPanel on which to draw things. No game logic is done here.
 * 
 * @author Drew
 *
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {

   // DIMENSIONS
   public static final int WIDTH = 800;
   public static final int HEIGHT = 640;

   // GAME THREAD
   private static Thread thread;
   private boolean running;
   private static final int FPS = 60;
   private long targetTime = 1000 / FPS;
   private long totalTime = 0;
   private int frameCount = 0;
   private double averageFPS;

   // CANVAS AND PAINTBRUSH
   private BufferedImage image;
   private Graphics2D g;

   // GAME STATE MANAGER
   public static GameStateManager gsm = new GameStateManager();
   
   // CONSTRUCTOR
   public GamePanel() {
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
      setFocusable(true);
      requestFocus();
   }

   // STARTS THREAD WHEN JPANEL IS FINISHED LOADING
   // TODO RESEARCH WHETHER OR NOT USING ADDNOTIFY IS A GOOD IDEA
   public void addNotify() {
      super.addNotify();
      if (thread == null) {
         addKeyListener(this);
         startThread();
      }
   }

   // INITIALIZER
   private void init() {
      image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
      g = (Graphics2D) image.getGraphics();
      running = true;
   }
   
   public synchronized void startThread() {
      thread = new Thread(this);
      thread.start();
   }

   public void run() {
      init();

      long start;
      long elapsed;
      long wait;

      // GAME LOOP
      while (running) {

         start = System.nanoTime();

         update();
         draw();
         drawToScreen();

         elapsed = System.nanoTime() - start;
         wait = targetTime - elapsed / 1000000;

         try {
            if (wait > 0) {
               Thread.sleep(wait);
            }
         } catch (Exception e) {
            e.printStackTrace();
         }

         // FPS COUNTER
         totalTime += System.nanoTime() - start;
         frameCount++;
         if (frameCount == FPS) {
            averageFPS = 1000.0 / ((totalTime / frameCount) / 1000000);
            frameCount = 0;
            totalTime = 0;
         }
      }
   }

   private void update() {
      gsm.update();
   }

   private void draw() {
      gsm.draw(g);
      
      // DRAW FPS COUNTER OVER EVERYTHING
      g.setColor(Color.GREEN);
      Font font = new Font("Helvetica", Font.PLAIN, 14);
      g.setFont(font);
      g.drawString("FPS: " + (int) Math.floor(averageFPS), 10, 20);
      
   }

   private void drawToScreen() {
      Graphics g2 = this.getGraphics();
      g2.drawImage(image, 0, 0, null);
      g2.dispose();

   }

   public void keyTyped(KeyEvent key) {
      // who actually uses this method and why is it required
   }

   // BEGIN THE KEYCODE RELAY
   public void keyPressed(KeyEvent key) {
      gsm.keyPressed(key.getKeyCode());
   }

   public void keyReleased(KeyEvent key) {
      gsm.keyReleased(key.getKeyCode());

   }

}
