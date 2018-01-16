/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Marci
 */
public class Music extends Thread {

    private String path;
    private InputStream ins;
    private Player player;

    public void setPath(String path) {
        try {
            this.path = path;
            ins = this.getClass().getResourceAsStream(path);
            player = new Player(ins);
        } catch (JavaLayerException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            player.play();
        } catch (JavaLayerException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void leall() {
        player.close();
    }

    public String getPath() {
        return path;
    }

    public InputStream getIns() {
        return ins;
    }

    public Player getPlayer() {
        return player;
    }
}
