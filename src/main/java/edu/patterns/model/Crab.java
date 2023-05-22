package edu.patterns.model;

import java.util.ArrayList;

public final class Crab extends Enemy {
    /**
    * Points earned for killing this enemy.
    */
    private static final int SCORE = 20;

    /**
    * Constructor for the Crab enemy.
    */
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
