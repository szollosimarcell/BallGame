/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import control.Controller;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Marci
 */
public class Paddle {

    private final PaddleImagePair imagePair;
    private final Controller controller;

    private Image img;
    private int x;
    
    private static int y;
    private static int width;
    private static int height;

    public Paddle(PaddleImagePair imgPair, int x, Controller controller) {
        this.imagePair = imgPair;
        this.x = x;
        this.controller = controller;
        setting();
    }

    private void setting() {
        img = imagePair.getBlueImage();
    }

    public void draw(Graphics g) {
        g.drawImage(img, x - width / 2, y - height / 2, width, height, null);
    }
    
    public void imageChange() {
        img = imagePair.getRedImage();
    }

    public static void setY(int y) {
        Paddle.y = y;
    }

    public static void setWidth(int width) {
        Paddle.width = width;
    }

    public static void setHeight(int height) {
        Paddle.height = height;
    }

    public void setX(int x) {
        this.x = x;
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

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
