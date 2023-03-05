package edu.patterns.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public final class FlyweightModel {
    /**
    * Array of images used to represent an entity.
    * @see edu.patterns.model.Entity
    */
    private BufferedImage[] sprites;

    /**
    * Constructor for the Flyweight Model, used to manage the sprites that
    * represent the entities in the game. Each Entity object that is
    * visually represented has a corresponding FlyweightModel object.
    * @param paths The locations of the images to be used as sprites.
    * @see edu.patterns.model.Entity
    */
    public FlyweightModel(final ArrayList<String> paths) {
        sprites = new BufferedImage[paths.size()];

        int counter = 0;
        for (String path: paths) {
            try {
                sprites[counter++] = ImageIO.read(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
    * Array of images used to represent an entity.
    * @return The array of images.
    * @see edu.patterns.model.Entity
    */
    public BufferedImage[] getSprites() {
        return sprites;
    }
}
