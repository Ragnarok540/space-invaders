package edu.patterns.image;

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
    * @param entity The entity.
    * @return The model for the given entity.
    */
    public FlyweightModel getModel(final Entity entity) {
        if (models.get(entity) != null) {
            return models.get(entity);
        } else {
            FlyweightModel model = new FlyweightModel(entity.getPaths());
            models.put(entity.getName(), model);
            return model;
        }
    }
}
