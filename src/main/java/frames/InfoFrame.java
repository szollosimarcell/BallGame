/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import control.Controller;
import global.Global;

/**
 *
 * @author Marci
 */
public class InfoFrame extends javax.swing.JFrame {
    
    private final int width = Global.INFO_FRAME_WIDTH;
    private final int height = Global.INFO_FRAME_HEIGHT;
    private final String title = Global.INFO_FRAME_TITLE;
    Controller controller;

    /**
     * Creates new form InfoFrame
     */
    public InfoFrame(Controller controller) {
        initComponents();
        setting(controller);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoPanel1 = new panels.InfoPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().add(infoPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setting(Controller controller) {
        this.setSize(width, height);
        this.setTitle(title);
        this.setLocationRelativeTo(this);
        
        this.setVisible(true);
        this.controller = controller;
        controller.setInfoPanel(infoPanel1);
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private panels.InfoPanel infoPanel1;
    // End of variables declaration//GEN-END:variables
}