//package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player {
  private double x;
  private double y;

  private boolean hasChosen = false;

  private boolean jumping;

  private double velX = 0;
  private double velY = 0;

  public int facing = 1;// right
  public boolean punch = false;
  public boolean kick = false;
  public boolean strafe = false;
  public boolean inAction = false;
  public boolean collidable = false;

  Texture tex = Game.getInstance();

  private Animation playerWalk, playerWalkLeft, playerJump, playerJumpLeft, playerStillLeft, playerStill; // movements
  private Animation playerPunch, playerPunchLeft, playerKick, playerKickLeft; // attacks

  public Player(double x, double y) {
    this.x = x;
    this.y = y;
    if (!hasChosen) {
      if (Game.ChoiceP1 == Game.CHOICEP1.MINHAJP1) {
        System.out.println("Player 1 has chosen Minhaj");
        playerWalk = new Animation(
            5, tex.minhaj[0], tex.minhaj[1], tex.minhaj[2], tex.minhaj[3], tex.minhaj[4], tex.minhaj[5]);
        playerWalkLeft = new Animation(
            5, tex.minhaj[6], tex.minhaj[7], tex.minhaj[8], tex.minhaj[9], tex.minhaj[10], tex.minhaj[11]);
        playerJump = new Animation(
            15, tex.minhaj_jump[0], tex.minhaj_jump[1], tex.minhaj_jump[2], tex.minhaj_jump[2], tex.minhaj_jump[2],
            tex.minhaj_jump[3], tex.minhaj_jump[4]);
        playerJumpLeft = new Animation(
            15, tex.minhaj_jump[5], tex.minhaj_jump[6], tex.minhaj_jump[7], tex.minhaj_jump[7], tex.minhaj_jump[7],
            tex.minhaj_jump[8], tex.minhaj_jump[9]);
        playerStillLeft = new Animation(1, tex.minhaj[0]);
        playerStill = new Animation(1, tex.minhaj[6]);

        playerPunch = new Animation(
            3, tex.minhaj_punch[0], tex.minhaj_punch[1], tex.minhaj_punch[2], tex.minhaj_punch[3], tex.minhaj_punch[4]);
        playerPunchLeft = new Animation(
            3, tex.minhaj_punch[5], tex.minhaj_punch[6], tex.minhaj_punch[7], tex.minhaj_punch[8], tex.minhaj_punch[9]);
        playerKick = new Animation(
            3, tex.minhaj_kick[0], tex.minhaj_kick[1], tex.minhaj_kick[2], tex.minhaj_kick[3], tex.minhaj_kick[4],
            tex.minhaj_kick[5]);
        playerKickLeft = new Animation(
            3, tex.minhaj_kick[6], tex.minhaj_kick[7], tex.minhaj_kick[8], tex.minhaj_kick[9], tex.minhaj_kick[10],
            tex.minhaj_kick[11]);
      }

      else if (Game.ChoiceP1 == Game.CHOICEP1.STALINEP1) {
        System.out.println("Player 1 has chosen Staline");
        playerWalk = new Animation(
            5, tex.staline[0], tex.staline[1], tex.staline[2], tex.staline[3], tex.staline[4]);
        playerWalkLeft = new Animation(
            5, tex.staline[5],
            tex.staline[6], tex.staline[7], tex.staline[8], tex.staline[9]);
        playerJump = new Animation(
            15, tex.staline_jump[0], tex.staline_jump[1], tex.staline_jump[2], tex.staline_jump[3], tex.staline_jump[4],
            tex.staline_jump[4],
            tex.staline_jump[4], tex.staline_jump[5], tex.staline_jump[6]);
        playerJumpLeft = new Animation(
            15, tex.staline_jump[7], tex.staline_jump[8], tex.staline_jump[9], tex.staline_jump[10],
            tex.staline_jump[11], tex.staline_jump[11],
            tex.staline_jump[11], tex.staline_jump[12], tex.staline_jump[13]);

        playerStillLeft = new Animation(1, tex.staline[0]);
        playerStill = new Animation(1, tex.staline[8]);

        playerPunch = new Animation(
            3, tex.staline_punch[0], tex.staline_punch[1], tex.staline_punch[2], tex.staline_punch[3],
            tex.staline_punch[4]);
        playerPunchLeft = new Animation(
            3, tex.staline_punch[5], tex.staline_punch[6], tex.staline_punch[7], tex.staline_punch[8],
            tex.staline_punch[9]);
        playerKick = new Animation(
            3, tex.staline_kick[0], tex.staline_kick[1], tex.staline_kick[2], tex.staline_kick[3], tex.staline_kick[4],
            tex.staline_kick[5], tex.staline_kick[6]);
        playerKickLeft = new Animation(
            3, tex.staline_kick[7], tex.staline_kick[8], tex.staline_kick[9], tex.staline_kick[10],
            tex.staline_kick[11],
            tex.staline_kick[12], tex.staline_kick[13]);
      }

      else if (Game.ChoiceP1 == Game.CHOICEP1.JERRYP1) {
        System.out.println("Player 1 has chosen Jerry");
        playerWalk = new Animation(5, tex.jerry[0], tex.jerry[1], tex.jerry[2], tex.jerry[3], tex.jerry[4]);
        playerWalkLeft = new Animation(5, tex.jerry[5], tex.jerry[6], tex.jerry[7], tex.jerry[8], tex.jerry[9]);
        playerJump = new Animation(
            15, tex.jerry_jump[0], tex.jerry_jump[1], tex.jerry_jump[2], tex.jerry_jump[2], tex.jerry_jump[2],
            tex.jerry_jump[3], tex.jerry_jump[4]);
        playerJumpLeft = new Animation(
            15, tex.jerry_jump[5], tex.jerry_jump[6], tex.jerry_jump[7], tex.jerry_jump[7], tex.jerry_jump[7],
            tex.jerry_jump[8], tex.jerry_jump[9]);

        playerStillLeft = new Animation(1, tex.jerry[0]);
        playerStill = new Animation(1, tex.jerry[8]);

        playerPunch = new Animation(
            3, tex.jerry_punch[0], tex.jerry_punch[1], tex.jerry_punch[2], tex.jerry_punch[3], tex.jerry_punch[4]);
        playerPunchLeft = new Animation(
            3, tex.jerry_punch[5], tex.jerry_punch[6], tex.jerry_punch[7], tex.jerry_punch[8], tex.jerry_punch[9]);
        playerKick = new Animation(
            3, tex.jerry_kick[0], tex.jerry_kick[1], tex.jerry_kick[2], tex.jerry_kick[3], tex.jerry_kick[4],
            tex.jerry_kick[5], tex.jerry_kick[6]);
        playerKickLeft = new Animation(
            3, tex.jerry_kick[7], tex.jerry_kick[8], tex.jerry_kick[9], tex.jerry_kick[10], tex.jerry_kick[11],
            tex.jerry_kick[12], tex.jerry_kick[13]);
      }
      hasChosen = true;
    }

  }

  public void init() {

  }

  public void tick() {
    x += velX;
    y += velY;
    if (y <= 340) {
      velY++;
      jumping = true;
    }
    if (x <= 0) {
      x = 0;
    }
    if (x >= 725) {
      x = 725;
    }
    if (y >= 400) {
      y = 400;
      jumping = false;
    }
    if (y <= 0) {
      y = 0;
    }

    if (velX < 0) {
      facing = 0;
    } else if (velX > 0) {
      facing = 1;
    }

    playerWalk.runAnimation();
    playerWalkLeft.runAnimation();
    playerJump.runAnimation();
    playerJumpLeft.runAnimation();
    playerStill.runAnimation();
    playerStillLeft.runAnimation();
    playerPunch.runAnimation();
    playerPunchLeft.runAnimation();
    playerKick.runAnimation();
    playerKickLeft.runAnimation();
  }

  public void render(Graphics g) {

    if (jumping && facing == 1) {
      playerJump.drawAnimation(g, (int) x, (int) y);
    }

    else if (jumping && facing == 0) {
      playerJumpLeft.drawAnimation(g, (int) x, (int) y);
    } else {
      if (!inAction && velX < 0) { // left
        playerWalkLeft.drawAnimation(g, (int) x, (int) y);
      } else if (!inAction && velX > 0) {
        playerWalk.drawAnimation(g, (int) x, (int) y);
      } else if (kick && facing == 1) {
        playerKick.drawAnimation(g, (int) x, (int) y);
      } else if (kick && facing == 0) {
        playerKickLeft.drawAnimation(g, (int) x, (int) y);
      } else if (punch && facing == 1) {
        playerPunch.drawAnimation(g, (int) x, (int) y);
      } else if (punch && facing == 0) {
        playerPunchLeft.drawAnimation(g, (int) x, (int) y);
      } else {
        if (facing == 0) {
          playerStill.drawAnimation(g, (int) x, (int) y);
        } else if (facing == 1) {
          playerStillLeft.drawAnimation(g, (int) x, (int) y);
        }
      }
    }
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public boolean isJumping() {
    return jumping;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public void setVelX(double velX) {
    this.velX = velX;
  }

  public void setVelY(double velY) {
    this.velY = velY;
  }

  public static boolean intersects(Object player2) {
    return false;
  }

}
