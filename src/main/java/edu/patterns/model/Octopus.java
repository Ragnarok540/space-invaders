package edu.patterns.model;

import java.util.ArrayList;

public final class Octopus extends Enemy {
    private static final int SCORE = 10;

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
