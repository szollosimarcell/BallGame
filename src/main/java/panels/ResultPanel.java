/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import control.Controller;
import custommodel.CustomListModel;
import global.Global;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Marci
 */
public class ResultPanel extends javax.swing.JPanel {

    private Controller controller;
    int xMouse;
    int yMouse;

    private final Image wallpaperImg = new ImageIcon(this.getClass().getResource(Global.MENU_IMAGE)).getImage();
    private final ImageIcon backButtonPressedImage = new ImageIcon(this.getClass().getResource("/kepek/back_button.png"));
    private final ImageIcon backButtonImage = new ImageIcon(this.getClass().getResource("/kepek/back_button_dark.png"));
    private CustomListModel<String> resultModel = new CustomListModel<>();

    /**
     * Creates new form ResultPanel
     */
    public ResultPanel() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lstResults = new javax.swing.JList<>();
        btnBack = new javax.swing.JButton();

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jScrollPane1.setViewportView(lstResults);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/back_button.png"))); // NOI18N
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBackMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnBackMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMousePressed
        btnBack.setIcon(backButtonImage);
    }//GEN-LAST:event_btnBackMousePressed

    private void btnBackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseReleased
        btnBack.setIcon(backButtonPressedImage);
        controller.mainMenuShow();
    }//GEN-LAST:event_btnBackMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int xScreen = evt.getXOnScreen();
        int yScreen = evt.getYOnScreen();

        ((JFrame) SwingUtilities.getWindowAncestor(this)).setLocation(xScreen - xMouse, yScreen - yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstResults;
    // End of variables declaration//GEN-END:variables

    private void setting() {
        this.setVisible(false);
        lstResults.setModel(resultModel);

        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Image cursorImage = new ImageIcon(this.getClass().getResource("/kepek/cursor_image_orange.png")).getImage();
        Point pont = new Point(0, 0);
        Cursor cursor = toolKit.createCustomCursor(cursorImage, pont, "Cursor");

        this.setCursor(cursor);
    }
}
