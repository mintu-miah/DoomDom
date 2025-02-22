//package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player2 {
  private double xp2;
  private double yp2;
  public int facingp2 = 0; // left

  private boolean jumpingP2;
  private boolean hasChosen = false;

  private double velXp2 = 0;
  private double velYp2 = 0;

  public boolean punchP2 = false;
  public boolean kickP2 = false;
  public boolean strafeP2 = false;
  public boolean inActionP2 = false;
  public boolean collidableP2 = false;

  Texture tex = Game.getInstance();

  private Animation playerWalk, playerWalkLeft, playerJump, playerJumpLeft, playerStillLeft, playerStill; // movements
  private Animation playerPunch, playerPunchLeft, playerKick, playerKickLeft; // attacks

  public Player2(double xp2, double yp2, Texture texture) {
    this.xp2 = xp2;
    this.yp2 = yp2;

    if (!hasChosen) {
      if (Game.ChoiceP2 == Game.CHOICEP2.MINHAJP2) {
        System.out.println("Player 2 has chosen Minhaj");
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

      else if (Game.ChoiceP2 == Game.CHOICEP2.STALINEP2) {
        System.out.println("Player 2 has chosen Staline");
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

      else if (Game.ChoiceP2 == Game.CHOICEP2.JERRYP2) {
        System.out.println("Player 2 has chosen Jerry");
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
    xp2 += velXp2;
    yp2 += velYp2;
    if (yp2 <= 340) {
      velYp2++;
      jumpingP2 = true;
    }
    if (xp2 <= 0) {
      xp2 = 0;
    }
    if (xp2 >= 725) {
      xp2 = 725;
    }
    if (yp2 >= 400) {
      yp2 = 400;
      jumpingP2 = false;
    }
    if (yp2 <= 0) {
      yp2 = 0;
    }
    if (velXp2 < 0) {
      facingp2 = 0;
    } else if (velXp2 > 0) {
      facingp2 = 1;
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
    if (jumpingP2 && facingp2 == 1) {
      playerJump.drawAnimation(g, (int) xp2, (int) yp2);
    }

    else if (jumpingP2 && facingp2 == 0) {
      playerJumpLeft.drawAnimation(g, (int) xp2, (int) yp2);
    } else {
      if (!inActionP2 && velXp2 < 0) { // left
        playerWalkLeft.drawAnimation(g, (int) xp2, (int) yp2);
      } else if (!inActionP2 && velXp2 > 0) {
        playerWalk.drawAnimation(g, (int) xp2, (int) yp2);
      } else if (kickP2 && facingp2 == 1) {
        playerKick.drawAnimation(g, (int) xp2, (int) yp2);
      } else if (kickP2 && facingp2 == 0) {
        playerKickLeft.drawAnimation(g, (int) xp2, (int) yp2);
      } else if (punchP2 && facingp2 == 1) {
        playerPunch.drawAnimation(g, (int) xp2, (int) yp2);
      } else if (punchP2 && facingp2 == 0) {
        playerPunchLeft.drawAnimation(g, (int) xp2, (int) yp2);
      } else {
        if (facingp2 == 0) {
          playerStill.drawAnimation(g, (int) xp2, (int) yp2);
        } else if (facingp2 == 1) {
          playerStillLeft.drawAnimation(g, (int) xp2, (int) yp2);
        }
      }
    }
  }

  public double getX2p2() {
    return xp2;
  }

  public double getY2p2() {
    return yp2;
  }

  public boolean isJumpingp2() {
    return jumpingP2;
  }

  public void setXp2(double xp2) {
    this.xp2 = xp2;
  }

  public void setYp2(double yp2) {
    this.yp2 = yp2;
  }

  public void setVelXp2(double velXp2) {
    this.velXp2 = velXp2;
  }

  public void setVelYp2(double velYp2) {
    this.velYp2 = velYp2;
  }

}
