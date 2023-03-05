package edu.patterns.image;

import java.util.ArrayList;
import java.util.HashMap;

public final class FlyweightFactory {
    /**
    * Contains the models for each entity that is represented in the game.
    */
    private HashMap<String, FlyweightModel> models;

    /**
    * Constructor for the Flyweight Factory, it initializes the models
    * HashMap.
    */
    public FlyweightFactory() {
        models = new HashMap<>();
    }

    /**
    * This method obtains the model for a given entity, and only creates the
    * model the first time is called, otherwise it uses a model that is
    * already loaded.
    * @param type The name of the entity.
    * @return The model for the given entity.
    */
    public FlyweightModel getModel(final String type) {
        if (models.get(type) != null) {
            return models.get(type);
        } else {
            ArrayList<String> paths = new ArrayList<>();

            switch (type) {
                case "playerShip":
                    paths.add("res/sprites/ship.png");
                    break;
                case "bullet":
                    paths.add("res/sprites/missile.png");
                    paths.add("res/sprites/laser.png");
                    break;
                case "squid":
                    paths.add("res/sprites/squid_0.png");
                    paths.add("res/sprites/squid_1.png");
                    break;
                case "crab":
                    paths.add("res/sprites/crab_0.png");
                    paths.add("res/sprites/crab_1.png");
                    break;
                case "octopus":
                    paths.add("res/sprites/octopus_0.png");
                    paths.add("res/sprites/octopus_1.png");
                    break;
                default:
                    return null;
            }

            FlyweightModel model = new FlyweightModel(paths);
            models.put(type, model);
            return model;
        }
    }
}
