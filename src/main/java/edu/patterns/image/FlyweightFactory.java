package edu.patterns.image;

import java.util.ArrayList;
import java.util.HashMap;

import edu.patterns.model.Entity;

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
    * @param type The entity.
    * @return The model for the given entity.
    */
    public FlyweightModel getModel(final Entity type) {
        if (models.get(type) != null) {
            return models.get(type);
        } else {
            FlyweightModel model = new FlyweightModel(type.getPaths());
            models.put(type.getName(), model);
            return model;
        }
    }
}
