
//package com.game.src.main;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Texture {
    SpriteSheet ms, ss, js;
    private BufferedImage minhaj_sheet = null;
    private BufferedImage staline_sheet = null;
    private BufferedImage jerry_sheet = null;

    public BufferedImage[] staline = new BufferedImage[16];
    public BufferedImage[] staline_jump = new BufferedImage[14];
    public BufferedImage[] staline_punch = new BufferedImage[16];
    public BufferedImage[] staline_kick = new BufferedImage[14];

    public BufferedImage[] minhaj = new BufferedImage[14];
    public BufferedImage[] minhaj_jump = new BufferedImage[18];
    public BufferedImage[] minhaj_punch = new BufferedImage[18];
    public BufferedImage[] minhaj_kick = new BufferedImage[18];

    public BufferedImage[] jerry = new BufferedImage[14];
    public BufferedImage[] jerry_jump = new BufferedImage[18];
    public BufferedImage[] jerry_punch = new BufferedImage[18];
    public BufferedImage[] jerry_kick = new BufferedImage[18];

    public Texture() {

        BufferedImageLoader loaderStaline = new BufferedImageLoader();
        BufferedImageLoader loaderMinhaj = new BufferedImageLoader();
        BufferedImageLoader loaderJerry = new BufferedImageLoader();

        try {
            minhaj_sheet = loaderMinhaj.loadImage("/res/MINHAJSHEET.png");
            staline_sheet = loaderStaline.loadImage("/res/STALINESHEET.png");
            jerry_sheet = loaderJerry.loadImage("/res/JERRYSHEET.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // THIS PLAYS THE THEME SONG
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    this.getClass().getResource("/music/menu.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }

        catch (Exception ex) {
        }
        //

        ms = new SpriteSheet(minhaj_sheet);
        ss = new SpriteSheet(staline_sheet);
        js = new SpriteSheet(jerry_sheet);

        getTextures();

    }

    public void getTextures() {

        // Minhaj STUFF
        // minhaj looking right
        minhaj[0] = ms.grabImage(1, 1, 100, 150);
        minhaj[1] = ms.grabImage(2, 1, 100, 150);
        minhaj[2] = ms.grabImage(3, 1, 100, 150);
        minhaj[3] = ms.grabImage(4, 1, 100, 150);
        minhaj[4] = ms.grabImage(5, 1, 100, 150);
        minhaj[5] = ms.grabImage(6, 1, 100, 150);

        // minhaj looking left
        minhaj[6] = ms.grabImage(1, 6, 100, 150);
        minhaj[7] = ms.grabImage(2, 6, 100, 150);
        minhaj[8] = ms.grabImage(3, 6, 100, 150);
        minhaj[9] = ms.grabImage(4, 6, 100, 150);
        minhaj[10] = ms.grabImage(5, 6, 100, 150);
        minhaj[11] = ms.grabImage(6, 6, 100, 150);

        // minhaj jump
        minhaj_jump[0] = ms.grabImage(1, 3, 100, 150);
        minhaj_jump[1] = ms.grabImage(2, 3, 100, 150);
        minhaj_jump[2] = ms.grabImage(3, 3, 100, 150);
        minhaj_jump[3] = ms.grabImage(4, 3, 100, 150);
        minhaj_jump[4] = ms.grabImage(5, 3, 100, 150);

        // minhaj jump left
        minhaj_jump[5] = ms.grabImage(1, 8, 100, 150);
        minhaj_jump[6] = ms.grabImage(2, 8, 100, 150);
        minhaj_jump[7] = ms.grabImage(3, 8, 100, 150);
        minhaj_jump[8] = ms.grabImage(4, 8, 100, 150);
        minhaj_jump[9] = ms.grabImage(5, 8, 100, 150);

        // minhaj punch right
        minhaj_punch[0] = ms.grabImage(1, 2, 100, 150);
        minhaj_punch[1] = ms.grabImage(2, 2, 100, 150);
        minhaj_punch[2] = ms.grabImage(3, 2, 100, 150);
        minhaj_punch[3] = ms.grabImage(4, 2, 100, 150);
        minhaj_punch[4] = ms.grabImage(5, 2, 100, 150);

        // minhaj punch left
        minhaj_punch[5] = ms.grabImage(1, 7, 100, 150);
        minhaj_punch[6] = ms.grabImage(2, 7, 100, 150);
        minhaj_punch[7] = ms.grabImage(3, 7, 100, 150);
        minhaj_punch[8] = ms.grabImage(4, 7, 100, 150);
        minhaj_punch[9] = ms.grabImage(5, 7, 100, 150);

        // minhaj kick right
        minhaj_kick[0] = ms.grabImage(1, 4, 100, 150);
        minhaj_kick[1] = ms.grabImage(2, 4, 100, 150);
        minhaj_kick[2] = ms.grabImage(3, 4, 100, 150);
        minhaj_kick[3] = ms.grabImage(4, 4, 100, 150);
        minhaj_kick[4] = ms.grabImage(5, 4, 100, 150);
        minhaj_kick[5] = ms.grabImage(6, 4, 100, 150);

        // minhaj kick left
        minhaj_kick[6] = ms.grabImage(1, 9, 100, 150);
        minhaj_kick[7] = ms.grabImage(2, 9, 100, 150);
        minhaj_kick[8] = ms.grabImage(3, 9, 100, 150);
        minhaj_kick[9] = ms.grabImage(4, 9, 100, 150);
        minhaj_kick[10] = ms.grabImage(5, 9, 100, 150);
        minhaj_kick[11] = ms.grabImage(6, 9, 100, 150);

        // Staline STUFF
        // looking right
        staline[0] = ss.grabImage(1, 1, 100, 150);
        staline[1] = ss.grabImage(2, 1, 100, 150);
        staline[2] = ss.grabImage(3, 1, 100, 150);
        staline[3] = ss.grabImage(4, 1, 100, 150);
        staline[4] = ss.grabImage(5, 1, 100, 150);

        // looking left
        staline[5] = ss.grabImage(1, 6, 100, 150);
        staline[6] = ss.grabImage(2, 6, 100, 150);
        staline[7] = ss.grabImage(3, 6, 100, 150);
        staline[8] = ss.grabImage(4, 6, 100, 150);
        staline[9] = ss.grabImage(5, 6, 100, 150);

        // staline jump
        staline_jump[0] = ss.grabImage(1, 3, 100, 150);
        staline_jump[1] = ss.grabImage(2, 3, 100, 150);
        staline_jump[2] = ss.grabImage(3, 3, 100, 150);
        staline_jump[3] = ss.grabImage(4, 3, 100, 150);
        staline_jump[4] = ss.grabImage(5, 3, 100, 150);
        staline_jump[5] = ss.grabImage(6, 3, 100, 150);
        staline_jump[6] = ss.grabImage(7, 3, 100, 150);

        // staline jump left
        staline_jump[7] = ss.grabImage(1, 8, 100, 150);
        staline_jump[8] = ss.grabImage(2, 8, 100, 150);
        staline_jump[9] = ss.grabImage(3, 8, 100, 150);
        staline_jump[10] = ss.grabImage(4, 8, 100, 150);
        staline_jump[11] = ss.grabImage(5, 8, 100, 150);
        staline_jump[12] = ss.grabImage(6, 8, 100, 150);
        staline_jump[13] = ss.grabImage(7, 8, 100, 150);

        // staline punch right
        staline_punch[0] = ss.grabImage(1, 2, 100, 150);
        staline_punch[1] = ss.grabImage(2, 2, 100, 150);
        staline_punch[2] = ss.grabImage(3, 2, 100, 150);
        staline_punch[3] = ss.grabImage(4, 2, 100, 150);
        staline_punch[4] = ss.grabImage(5, 2, 100, 150);

        // staline punch left
        staline_punch[5] = ss.grabImage(1, 7, 100, 150);
        staline_punch[6] = ss.grabImage(2, 7, 100, 150);
        staline_punch[7] = ss.grabImage(3, 7, 100, 150);
        staline_punch[8] = ss.grabImage(4, 7, 100, 150);
        staline_punch[9] = ss.grabImage(5, 7, 100, 150);

        // staline kick right
        staline_kick[0] = ss.grabImage(1, 4, 100, 150);
        staline_kick[1] = ss.grabImage(2, 4, 100, 150);
        staline_kick[2] = ss.grabImage(3, 4, 100, 150);
        staline_kick[3] = ss.grabImage(4, 4, 100, 150);
        staline_kick[4] = ss.grabImage(5, 4, 100, 150);
        staline_kick[5] = ss.grabImage(6, 4, 100, 150);
        staline_kick[6] = ss.grabImage(7, 4, 100, 150);

        // staline kick left
        staline_kick[7] = ss.grabImage(1, 9, 100, 150);
        staline_kick[8] = ss.grabImage(2, 9, 100, 150);
        staline_kick[9] = ss.grabImage(3, 9, 100, 150);
        staline_kick[10] = ss.grabImage(4, 9, 100, 150);
        staline_kick[11] = ss.grabImage(5, 9, 100, 150);
        staline_kick[12] = ss.grabImage(6, 9, 100, 150);
        staline_kick[13] = ss.grabImage(7, 9, 100, 150);

        // Jerry STUFF
        // looking right
        jerry[0] = js.grabImage(1, 1, 100, 150);
        jerry[1] = js.grabImage(2, 1, 100, 150);
        jerry[2] = js.grabImage(3, 1, 100, 150);
        jerry[3] = js.grabImage(4, 1, 100, 150);
        jerry[4] = js.grabImage(5, 1, 100, 150);

        // looking left
        jerry[5] = js.grabImage(6, 5, 100, 150);
        jerry[6] = js.grabImage(7, 5, 100, 150);
        jerry[7] = js.grabImage(8, 5, 100, 150);
        jerry[8] = js.grabImage(9, 5, 100, 150);
        jerry[9] = js.grabImage(10, 5, 100, 150);

        // jerry jump
        jerry_jump[0] = js.grabImage(1, 3, 100, 150);
        jerry_jump[1] = js.grabImage(2, 3, 100, 150);
        jerry_jump[2] = js.grabImage(3, 3, 100, 150);
        jerry_jump[3] = js.grabImage(4, 3, 100, 150);
        jerry_jump[4] = js.grabImage(5, 3, 100, 150);

        // jerry jump left
        jerry_jump[5] = js.grabImage(6, 8, 100, 150);
        jerry_jump[6] = js.grabImage(7, 8, 100, 150);
        jerry_jump[7] = js.grabImage(8, 8, 100, 150);
        jerry_jump[8] = js.grabImage(9, 8, 100, 150);
        jerry_jump[9] = js.grabImage(10, 8, 100, 150);

        // jerry punch right
        jerry_punch[0] = js.grabImage(1, 2, 100, 150);
        jerry_punch[1] = js.grabImage(2, 2, 100, 150);
        jerry_punch[2] = js.grabImage(3, 2, 100, 150);
        jerry_punch[3] = js.grabImage(4, 2, 100, 150);
        jerry_punch[4] = js.grabImage(5, 2, 100, 150);
        jerry_punch[5] = js.grabImage(6, 2, 100, 150);

        // jerry punch left
        jerry_punch[6] = js.grabImage(1, 7, 100, 150);
        jerry_punch[7] = js.grabImage(2, 7, 100, 150);
        jerry_punch[8] = js.grabImage(3, 7, 100, 150);
        jerry_punch[9] = js.grabImage(4, 7, 100, 150);
        jerry_punch[10] = js.grabImage(5, 7, 100, 150);
        jerry_punch[11] = js.grabImage(6, 7, 100, 150);

        // jerry kick right
        jerry_kick[0] = js.grabImage(1, 4, 100, 150);
        jerry_kick[1] = js.grabImage(2, 4, 100, 150);
        jerry_kick[2] = js.grabImage(3, 4, 100, 150);
        jerry_kick[3] = js.grabImage(4, 4, 100, 150);
        jerry_kick[4] = js.grabImage(5, 4, 100, 150);
        jerry_kick[5] = js.grabImage(6, 4, 100, 150);
        jerry_kick[6] = js.grabImage(7, 4, 100, 150);

        // jerry kick left
        jerry_kick[7] = js.grabImage(1, 9, 100, 150);
        jerry_kick[8] = js.grabImage(2, 9, 100, 150);
        jerry_kick[9] = js.grabImage(3, 9, 100, 150);
        jerry_kick[10] = js.grabImage(4, 9, 100, 150);
        jerry_kick[11] = js.grabImage(5, 9, 100, 150);
        jerry_kick[12] = js.grabImage(6, 9, 100, 150);
        jerry_kick[13] = js.grabImage(7, 9, 100, 150);

    }

}
