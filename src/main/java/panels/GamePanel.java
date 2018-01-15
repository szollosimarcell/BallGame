/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import control.Controller;
import global.Global;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Marci
 */
public class GamePanel extends javax.swing.JPanel {

    Controller controller;
    Image wallpaperImg = new ImageIcon(this.getClass().getResource(Global.GAME_IMAGE_BLUE)).getImage();

    /**
     * Creates new form GamePanel
     */
    public GamePanel() {
        initComponents();
        setting();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int pointX = 0, pointY = 0,
                width = this.getWidth(),
                height = this.getHeight();
        g.drawImage(wallpaperImg, pointX, pointY, width, height, null);
        if (controller != null) {
            controller.draw(g);
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        controller.movePaddle(evt.getX());
    }//GEN-LAST:event_formMouseMoved

    private void setting() {
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        BufferedImage blankImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
        Point pont = new Point(0, 0);
        Cursor blankCursor = toolKit.createCustomCursor(blankImage, pont, "blankCursor");

        this.setCursor(blankCursor);
    }

    public void imageChange() {
        wallpaperImg = new ImageIcon(this.getClass().getResource(Global.GAME_IMAGE_RED)).getImage();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
