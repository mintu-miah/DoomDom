//package com.game.src.main;

import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MouseInput implements MouseListener {

      public void mouseReleased(MouseEvent e) {
      }

      public void mouseClicked(MouseEvent e) {
      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }

      public void mousePressed(MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();
            if (Game.State == Game.STATE.MENU) {
                  if (mx >= 355 && mx <= 466) {
                        if (my >= 320 && my <= 359) {
                              // play button
                              Game.State = Game.STATE.CHARSEL1;
                              // System.out.println("play clicked");

                              try {
                                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                                this.getClass().getResource("/music/select.wav"));
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(audioInputStream);
                                    clip.start();
                              } catch (Exception ex) {
                              }
                        }
                  }
                  if (mx >= 345 && mx <= 490) {
                        if (my >= 372 && my <= 411) {
                              Game.State = Game.STATE.OPTIONS;
                              if (my >= 535 && my <= 577) {
                                    if (mx >= 22 && mx <= 89) {
                                    } // options
                              }
                        }
                  }
                  if (mx >= 355 && mx <= 476) {
                        if (my >= 420 && my <= 459) {
                              System.exit(1);
                              // exit
                        }
                  }
            }

            // FIRST PLAYER SELECT
            else if (Game.State == Game.STATE.CHARSEL1) {
                  if (my >= 535 && my <= 577) {
                        if (mx >= 22 && mx <= 89) {
                              // back button
                              Game.State = Game.STATE.MENU;
                              try {
                                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                                this.getClass().getResource("/music/select.wav"));
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(audioInputStream);
                                    clip.start();
                              } catch (Exception ex) {
                              }

                        }
                  }
                  if (my >= 175 && my <= 421) {
                        if (mx >= 110 && mx <= 245) {
                              // back button
                              Game.State = Game.STATE.CHARSEL2;
                              Game.ChoiceP1 = Game.CHOICEP1.MINHAJP1;
                              // choiceP1 = 0;
                              try {
                                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                                this.getClass().getResource("/music/select.wav"));
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(audioInputStream);
                                    clip.start();
                              } catch (Exception ex) {
                              }

                        }
                  }
                  if (my >= 200 && my <= 446) {
                        if (mx >= 250 && mx <= 375) {
                              // back button
                              Game.State = Game.STATE.CHARSEL2;
                              Game.ChoiceP1 = Game.CHOICEP1.STALINEP1;
                              try {
                                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                                this.getClass().getResource("/music/select.wav"));
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(audioInputStream);
                                    clip.start();
                              } catch (Exception ex) {
                              }
                              // choiceP1 = 1;

                        }
                  }
                  if (my >= 400 && my <= 535) {
                        if (mx >= 410 && mx <= 556) {
                              // back button
                              Game.State = Game.STATE.CHARSEL2;
                              Game.ChoiceP1 = Game.CHOICEP1.JERRYP1;
                              try {
                                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                                this.getClass().getResource("/music/select.wav"));
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(audioInputStream);
                                    clip.start();
                              } catch (Exception ex) {
                              }
                              // choiceP1 = 1;

                        }
                  }
            }

            // SECOND PLAYER SELECT
            else if (Game.State == Game.STATE.CHARSEL2) {
                  if (my >= 535 && my <= 577) {
                        if (mx >= 22 && mx <= 89) {
                              // back button
                              Game.State = Game.STATE.MENU;

                              try {
                                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                                this.getClass().getResource("/music/select.wav"));
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(audioInputStream);
                                    clip.start();
                              } catch (Exception ex) {
                              } // plays select sound

                        }
                  }
                  if (my >= 175 && my <= 421) {
                        if (mx >= 110 && mx <= 245) {
                              Game.State = Game.STATE.CHOOSE;
                              Game.ChoiceP2 = Game.CHOICEP2.MINHAJP2;
                              // choiceP2 = 0
                              try {
                                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                                this.getClass().getResource("/music/select.wav"));
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(audioInputStream);
                                    clip.start();
                              } catch (Exception ex) {
                              } // plays select sound

                        }
                  }
                  if (my >= 200 && my <= 446) {
                        if (mx >= 250 && mx <= 375) {
                              Game.State = Game.STATE.CHOOSE;
                              Game.ChoiceP2 = Game.CHOICEP2.STALINEP2;
                              // choiceP2 = 1;

                              try {
                                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                                this.getClass().getResource("/music/select.wav"));
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(audioInputStream);
                                    clip.start();
                              } catch (Exception ex) {
                              } // plays select sound

                        }
                  }
                  if (my >= 400 && my <= 535) {
                        if (mx >= 410 && mx <= 556) {
                              Game.State = Game.STATE.CHOOSE;
                              Game.ChoiceP2 = Game.CHOICEP2.JERRYP2;
                              // choiceP2 = 1;

                              try {
                                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                                this.getClass().getResource("/music/select.wav"));
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(audioInputStream);
                                    clip.start();
                              } catch (Exception ex) {
                              } // plays select sound

                        }
                  }

            }

      }

      /*
       * public int getChoiceP1() {
       * return choiceP1;
       * }
       * public int getChoiceP2() {
       * return choiceP2;
       * }
       */

}