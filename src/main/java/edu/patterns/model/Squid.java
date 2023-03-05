package edu.patterns.model;

import java.util.ArrayList;

public final class Squid extends Enemy {
    private static final int SCORE = 30;

    public Squid() {
        super();
        super.score = SCORE;
        super.name = "squid";
        ArrayList<String> pathsArray = new ArrayList<>();
        pathsArray.add("res/sprites/squid_0.png");
        pathsArray.add("res/sprites/squid_1.png");
        super.paths = pathsArray;
    }
}
