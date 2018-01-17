/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import baseclasses.Music;
import baseclasses.Player;
import control.Controller;
import control.MainFrame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import panels.MenuPanel;
import panels.ResultPanel;

/**
 *
 * @author Marci
 */
public class BallGameTest {
    
    private static final String MUSIC_PATH = "/music/mainMusic.mp3";
    private static final String PLAYER_NAME = "Marci";
    
    private Controller controller;
    private MainFrame mainFrame;
    private MenuPanel menuPanel;
    private ResultPanel resultPanel;
    
    private Music music;
    private Player player;
    
    public BallGameTest() {
    }
    
    @Before
    public void setUp() {
        mainFrame = new MainFrame();
        menuPanel = mainFrame.getMenuPanel1();
        resultPanel = mainFrame.getResultPanel1();
        controller = new Controller(menuPanel, resultPanel, mainFrame);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void musicTest() {
        music = new Music();
        music.setPath(MUSIC_PATH);
        assertTrue(music != null);
        assertFalse(music.isAlive());
        music.start();
        assertTrue(music.isAlive());
    }
    
    @Test
    public void playerTest() {
        player = new Player(PLAYER_NAME);
        assertTrue(player != null);
        player.earnPoint();
        assertTrue(player.getPoints() == 1);
        player.cleanPoint();
        assertTrue(player.getPoints() == 0);
    }
    
    @Test
    public void panelTest() {
        controller.showResult();
        assertFalse(menuPanel.isVisible());
        assertTrue(resultPanel.isVisible());
        controller.showMainMenu();
        assertTrue(menuPanel.isVisible());
        assertFalse(resultPanel.isVisible());
    }
}
