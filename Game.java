
//package com.game.src.main;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
  // game windows and 'engine'
  public static final int WIDTH = 790;
  public static final int HEIGHT = 590;
  public static final int SCALE = 1;
  public final String TITLE = "DOOMDOM";
  private boolean running = false;
  private Thread thread;

  // images
  private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
  private BufferedImage menuIMG = null;
  private BufferedImage optionsIMG = null;
  private BufferedImage charSelIMG = null;
  public BufferedImage player1 = null; // test
  public BufferedImage player2 = null; // test
  public BufferedImage gameBG = null;
  private Menu menu;
  private Options options;
  private CharSel1 charSel1;

  // states
  public static enum STATE {
    MENU, OPTIONS, CHARSEL1, CHARSEL2, CHOOSE, GAME
  };

  // CHARACTER CHOICE
  public static enum CHOICEP1 {
    NOTHING, MINHAJP1, STALINEP1, JERRYP1
  };

  public static enum CHOICEP2 {
    NOTHING2, MINHAJP2, STALINEP2, JERRYP2
  };

  // current state and choice
  public static CHOICEP1 ChoiceP1 = CHOICEP1.NOTHING;
  public static CHOICEP2 ChoiceP2 = CHOICEP2.NOTHING2;
  public static STATE State = STATE.MENU;
  public static STATE settings = STATE.OPTIONS;

  private Player p;
  private Player2 p2;
  static Texture tex;

  public void init() {

    BufferedImageLoader loaderMenu = new BufferedImageLoader();
    BufferedImageLoader loaderChar = new BufferedImageLoader();
    BufferedImageLoader loaderGBG = new BufferedImageLoader();
    BufferedImageLoader loaderOptions = new BufferedImageLoader();

    tex = new Texture();
    try {
      menuIMG = loaderMenu.loadImage("/res/BGM.jpg");
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      optionsIMG = loaderOptions.loadImage("/res/Settings.jpg");
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      gameBG = loaderGBG.loadImage("/res/GAME_BG3.JPG");
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      charSelIMG = loaderChar.loadImage("/res/Character_BG.jpg");
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.addMouseListener(new MouseInput());
    addKeyListener(new KeyInput(this));
    menu = new Menu();
    options = new Options();
    charSel1 = new CharSel1();

  }

  private synchronized void start() {
    if (running)
      return;
    running = true;
    thread = new Thread(this);
    thread.start();
  }

  private synchronized void stop() {
    if (!running)
      return;
    running = false;
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.exit(1);
  }

  public void run() {
    init();

    long lastTime = System.nanoTime();
    final double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    int updates = 0;
    int frames = 0;
    long timer = System.currentTimeMillis();

    while (running) {
      long now = System.nanoTime();
      delta += (now - lastTime) / ns;
      lastTime = now;
      if (delta >= 1) {
        tick();
        updates++;
        delta--;
      }
      render();
      frames++;

      if (System.currentTimeMillis() - timer > 1000) {
        timer += 1000;
        System.out.println(updates + " Ticks, FPS " + frames);
        updates = 0;
        frames = 0;
      }
    }
    stop();
  }

  private void tick() {
    if (State == STATE.GAME) {
      p.tick();
      p2.tick();
    }
    if (State == STATE.GAME) {
      p.init();
      p2.init();
    }
    if (State == STATE.CHOOSE) {
      p = new Player(100.0, 175.0);
      p2 = new Player2(1000.0 - 100.0, 175.0, tex);
      State = STATE.GAME;
    }
  }

  private void render() {
    BufferStrategy bs = this.getBufferStrategy();
    if (bs == null) {
      createBufferStrategy(3);
      return;
    }

    Graphics g = bs.getDrawGraphics();

    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    if (State == STATE.GAME) {

      g.clearRect(0, 0, 800, 600);

      g.drawImage(gameBG, 0, 0, null);
      p.render(g);
      p2.render(g);

    } else if (State == STATE.MENU) {
      g.clearRect(0, 0, 800, 600);
      g.drawImage(menuIMG, 0, 0, null);
      menu.render(g);

    } else if (State == STATE.GAME) {
      g.clearRect(0, 0, 800, 600);
      g.drawImage(optionsIMG, 0, 0, null);
      options.render(g);

    } else if (State == STATE.CHARSEL1 || State == STATE.CHARSEL2) {
      g.clearRect(0, 0, 800, 600);
      g.drawImage(charSelIMG, 0, 0, null);
      charSel1.render(g);
    }else if (State == STATE.OPTIONS) {
      g.clearRect(0, 0, 800, 600);
      g.drawImage(optionsIMG, 0, 0, null);
      options.render(g);

    }
    g.dispose();
    bs.show();

  }

  // player 1 keyinput
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_D) {
      p.setVelX(5);
    } else if (key == KeyEvent.VK_A) {
      p.setVelX(-5);
    } else if (key == KeyEvent.VK_S) {
      p.setVelY(1);
    } else if (key == KeyEvent.VK_W && !p.isJumping()) {
      p.setVelY(-17);
      try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
            this.getClass().getResource("/music/jump.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
      }

      catch (Exception ex) {
      }

    } else if (key == KeyEvent.VK_J) {
      p.punch = true;
      p.inAction = true;
      p.collidable = true;

      // punch audio file
      try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
            this.getClass().getResource("/music/punch.au"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
      }

      catch (Exception ex) {
      }

      if (p.facing == 1 && p.getX() != 0) {
        p.setVelX(0);
      } else if (p.facing == 0 && p.getX() != 0) {
        p.setVelX(0);
      }
    } else if (key == KeyEvent.VK_K) {
      p.kick = true;
      p.inAction = true;
      p.collidable = true;

      // kick audio file

      try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
            this.getClass().getResource("/music/kick.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
      } catch (Exception ex) {
      }
      p.setVelX(0);
    }
    try {
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
          this.getClass().getResource("/music/select.wav"));
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    }

    catch (Exception ex) {
    }

    //
    p.setVelX(0);
    if (key == KeyEvent.VK_S && key == KeyEvent.VK_D) {
      p.setX(p.getX() + 140);
      p.strafe = true;
      p.inAction = true;
    } else if (key == KeyEvent.VK_S && key == KeyEvent.VK_A) {
      p.setX(p.getX() - 140);
      p.strafe = true;
      p.inAction = true;

    }

    if (key == KeyEvent.VK_RIGHT) {
      p2.setVelXp2(5);
    } else if (key == KeyEvent.VK_LEFT) {
      p2.setVelXp2(-5);
    } else if (key == KeyEvent.VK_DOWN) {
      p2.setVelYp2(1);
    } else if (key == KeyEvent.VK_UP && !p2.isJumpingp2()) {
      p2.setVelYp2(-17);

      // jump audio file
      try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
            this.getClass().getResource("/music/jump.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
      } catch (Exception ex) {
      }

      // P2 punch keyinput
    } else if (key == KeyEvent.VK_NUMPAD1) {
      p2.punchP2 = true;
      p2.inActionP2 = true;
      p2.collidableP2 = true;

      try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
            this.getClass().getResource("/music/punch2.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
      } catch (Exception ex) {
      }

      // P2 kick keyinput
      p2.setVelXp2(0);
    } else if (key == KeyEvent.VK_NUMPAD2) {
      p2.kickP2 = true;
      p2.inActionP2 = true;
      p2.collidableP2 = true;
      try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
            this.getClass().getResource("/music/kick2.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
      } catch (Exception ex) {
      }

      p2.setVelXp2(0);
    }
    try {
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
          this.getClass().getResource("/music/special2.wav"));
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    }

    catch (Exception ex) {
    }
    p2.setVelXp2(0);
    if (key == KeyEvent.VK_DOWN && key == KeyEvent.VK_LEFT) {
      p2.strafeP2 = true;
      p2.inActionP2 = true;
    } else if (key == KeyEvent.VK_DOWN && key == KeyEvent.VK_RIGHT) {
      p2.strafeP2 = true;
      p2.inActionP2 = true;
    }
  }

  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_D) {
      p.setVelX(0);
    } else if (key == KeyEvent.VK_A) {
      p.setVelX(0);
    } else if (key == KeyEvent.VK_S) {
      // p.setVelY(0);
    } else if (key == KeyEvent.VK_W) {
      // p.setVelY(0);
    } else if (key == KeyEvent.VK_J) {
      p.punch = false;
      p.inAction = false;
      p.collidable = false;
    } else if (key == KeyEvent.VK_K) {
      p.kick = false;
      p.inAction = false;
      p.collidable = false;
      p.setVelX(0);
    }

    if (key == KeyEvent.VK_S && key == KeyEvent.VK_D) {
      p.setX(p.getX() + 140);
      p.strafe = false;
      p.inAction = false;
    } else if (key == KeyEvent.VK_S && key == KeyEvent.VK_A) {
      p.setX(p.getX() - 140);
      p.strafe = false;
      p.inAction = false;
      p.collidable = false;
    }

    if (key == KeyEvent.VK_RIGHT) {
      p2.setVelXp2(0);
    } else if (key == KeyEvent.VK_LEFT) {
      p2.setVelXp2(0);
    } else if (key == KeyEvent.VK_DOWN) {
      // p2.setVelYp2(0);
    } else if (key == KeyEvent.VK_UP) {
      // p2.setVelYp2(0);
    } else if (key == KeyEvent.VK_NUMPAD1) {
      p2.punchP2 = false;
      p2.inActionP2 = false;
      p2.collidableP2 = false;
      p2.setVelXp2(0);
    } else if (key == KeyEvent.VK_NUMPAD2) {
      p2.kickP2 = false;
      p2.inActionP2 = false;
      p2.collidableP2 = true;
      p2.setVelXp2(0);
    }

    if (key == KeyEvent.VK_DOWN && key == KeyEvent.VK_LEFT) {
      p2.strafeP2 = false;
      p2.inActionP2 = false;
    } else if (key == KeyEvent.VK_DOWN && key == KeyEvent.VK_RIGHT) {
      p2.strafeP2 = false;
      p2.inActionP2 = false;
      p2.collidableP2 = false;

    }

  }

  public static Texture getInstance() {
    return tex;
  }

  public static void main(String[] args) {
    Game game = new Game();

    game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
    game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
    game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

    JFrame frame = new JFrame(game.TITLE);
    frame.add(game);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    game.start();
  }
  /*
   * public BufferedImage getTestChar(){
   * return player1;
   * }
   */

}
