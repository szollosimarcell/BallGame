/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

import java.awt.Image;

/**
 *
 * @author Marci
 */
public class BallImagePair {
    
    private final Image blueImage;
    private final Image redImage;

    public BallImagePair(Image blueImage, Image redImage) {
        this.blueImage = blueImage;
        this.redImage = redImage;
    }

    public Image getBlueImage() {
        return blueImage;
    }

    public Image getRedImage() {
        return redImage;
    }
}
