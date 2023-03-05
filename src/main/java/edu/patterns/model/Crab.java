package edu.patterns.model;

import java.util.ArrayList;

public final class Crab extends Enemy {
    private static final int SCORE = 20;

    public Crab() {
        super();
        super.score = SCORE;
        super.name = "crab";
        ArrayList<String> pathsArray = new ArrayList<>();
        pathsArray.add("res/sprites/crab_0.png");
        pathsArray.add("res/sprites/crab_1.png");
        super.paths = pathsArray;
    }
}
