package edu.patterns.image;

import java.util.ArrayList;
import java.util.HashMap;

public class FlyweightFactory {
    private HashMap<String, FlyweightModel> models;

    public FlyweightFactory() {
        models = new HashMap<>();
    }

    public FlyweightModel getModel(String type) {
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
