package edu.patterns.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class FlyweightModel {
    
    private BufferedImage[] sprites;

    public FlyweightModel(ArrayList<String> paths) {
        sprites = new BufferedImage[paths.size()];

        int counter = 0;
        for (String path: paths) {
            try {
                sprites[counter++] = ImageIO.read(new File(path));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public BufferedImage[] getSprites() {
        return sprites;
    }

}
