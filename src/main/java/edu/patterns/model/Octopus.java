package edu.patterns.model;

import java.util.ArrayList;

public final class Octopus extends Enemy {
    /**
    * Points earned for killing this enemy.
    */
    private static final int SCORE = 10;

    /**
    * Constructor for the Octopus enemy.
    */
    public Octopus() {
        super();
        super.score = SCORE;
        super.name = "octopus";
        ArrayList<String> pathsArray = new ArrayList<>();
        pathsArray.add("res/sprites/octopus_0.png");
        pathsArray.add("res/sprites/octopus_1.png");
        super.paths = pathsArray;
    }
}
