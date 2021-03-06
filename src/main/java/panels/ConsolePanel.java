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
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Marci
 */
public class ConsolePanel extends javax.swing.JPanel {

    private BufferedImage wallpaperImg;
    private Controller controller;

    /**
     * Creates new form ConsolePanel
     */
    public ConsolePanel() {
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
    }

    public void setController(Controller vezerlo) {
        this.controller = vezerlo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTimeString = new javax.swing.JLabel();
        lblPointString = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblPoint = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setForeground(new java.awt.Color(255, 255, 255));

        lblTimeString.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTimeString.setForeground(new java.awt.Color(204, 204, 204));
        lblTimeString.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimeString.setText("Idő:");

        lblPointString.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPointString.setForeground(new java.awt.Color(204, 204, 204));
        lblPointString.setText("Pontszám:");

        lblTime.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(0, 102, 102));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("0");

        lblPoint.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPoint.setForeground(new java.awt.Color(0, 102, 102));
        lblPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPoint.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblPointString, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 716, Short.MAX_VALUE)
                .addComponent(lblTimeString, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPointString, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addComponent(lblTimeString, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
            .addComponent(lblPoint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblPoint;
    private javax.swing.JLabel lblPointString;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTimeString;
    // End of variables declaration//GEN-END:variables

    private void setting() {
        try {
            wallpaperImg = ImageIO.read(this.getClass().getResourceAsStream(Global.CONSOLE_PANEL_IMAGE));
        } catch (IOException ex) {
            Logger.getLogger(ConsolePanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Image cursorImage = new ImageIcon(this.getClass().getResource("/kepek/cursor_image_red.png")).getImage();
        Point pont = new Point(0, 0);
        Cursor cursor = toolKit.createCustomCursor(cursorImage, pont, "Cursor");

        this.setCursor(cursor);
    }

    public void timeWrite(long time) {
        lblTime.setText(time + "");
    }

    public void pointWrite(long point) {
        lblPoint.setText(point + "");
    }

    public void languageSetting(ResourceBundle bundle) {
        lblPointString.setText(bundle.getString("lblPoint.text"));
        lblTimeString.setText(bundle.getString("lblTime.text"));
    }
}
