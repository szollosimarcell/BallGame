/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import control.Controller;
import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marci
 */
public class Ball extends Thread {

    private final Controller controller;
    private BallImagePair imagePair;
    private Image img;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private long time;

    private static int width;
    private static int height;
    private static int panelWidth;
    private static int panelHeight;
    private static int speedLimit;

    private boolean aktiv = true;
    private boolean falling = false;

    /**
     * The contructor of the Ball object with one image.
     *
     * @param img  the image of the ball
     * @param x  x coordinate of the ball image
     * @param y  y coordinate of the ball image
     * @param dx  horizontal movement speed of the ball
     * @param dy  vertical movement speed of the ball
     * @param time  sleeping time of tha ball
     * @param controller
     */
    public Ball(Image img, int x, int y, int dx, int dy, long time, Controller controller) {
        this.controller = controller;
        this.img = img;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.time = time;
    }

    /**
     * The contructor of the Ball object with a pair of two images.
     *
     * @param imagePair  the pair of the two images of the ball
     * @param x  x coordinate of the ball image
     * @param y  y coordinate of the ball image
     * @param dx  horizontal movement speed of the ball
     * @param dy  vertical movement speed of the ball
     * @param time  sleeping time of tha ball
     * @param controller
     */
    public Ball(BallImagePair imagePair, int x, int y, int dx, int dy, long time, Controller controller) {
        this.imagePair = imagePair;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.time = time;
        this.controller = controller;
        setting();
    }

    private void setting() {
        img = imagePair.getBlueImage();
    }

    public void draw(Graphics g) {
        g.drawImage(img, x - width / 2, y - height / 2, width, height, null);
    }

    public void speeding() {
        if (time >= speedLimit) {
            time--;
        }
    }

    public void imageChange() {
        img = imagePair.getRedImage();
    }

    @Override
    public void run() {
        while (aktiv) {
            move();
            collide();
            fall();
            respawn();
            rest();
            update();
        }
    }

    /**
     * This method is the balls movement description.
     * When the ball hits the wall it changes its direction
     */
    private void move() {
        x += dx;
        y += dy;

        if (y <= height / 2) {
            dy = -dy;
        }

        if (x <= width / 2 || panelWidth - width / 2 <= x) {
            dx = -dx;
        }
    }

    /**
     * This method changes the balls direction vertically if
     * it collided with the paddle and if it is not in
     * the falling state.
     */
    private void collide() {
        if (controller.collisionCheck(x, y) && falling == false) {
            dy = -dy;
        }
    }

    /**
     * This method decides whether the ball is falling or not
     */
    private void fall() {
        if (controller.ballFell(y)) {
            falling = true;
        }
    }

    /**
     * The ball gets a new position when it has fallen.
     */
    private void respawn() {
        if (panelHeight < y + height / 2) {
            y = height / 2;
            x = panelWidth / 4;
            falling = false;
            controller.mistakeOccurred();
        }
    }
    
    /**
     * The thread's sleeping time
     */
    private void rest() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void update() {
        controller.update();
    }

    public static void setWidth(int width) {
        Ball.width = width;
    }

    public static void setHeight(int height) {
        Ball.height = height;
    }

    public static void setPanelWidth(int panelWidth) {
        Ball.panelWidth = panelWidth;
    }

    public static void setPanelHeight(int panelHeight) {
        Ball.panelHeight = panelHeight;
    }

    public static void setSpeedLimit(int speedLimit) {
        Ball.speedLimit = speedLimit;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public Image getImg() {
        return img;
    }

    public Controller getController() {
        return controller;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public long getTime() {
        return time;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public static int getPanelWidth() {
        return panelWidth;
    }

    public static int getPanelHeight() {
        return panelHeight;
    }

}
