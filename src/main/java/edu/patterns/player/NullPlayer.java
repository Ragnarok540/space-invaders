package edu.patterns.player;

import edu.patterns.interfaces.IPlayerNullObject;

public final class NullPlayer implements IPlayerNullObject {
    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public String getName() {
        return "The player does not exist";
    }

    @Override
    public String getNickName() {
        return "The player does not exist";
    }

    @Override
    public int getMaxScore() {
        return -1;
    }

    @Override
    public void openPlayer(final MementoPlayer mementoPlayer) {

    }

    @Override
    public MementoPlayer savePlayer() {
        return null;
    }

    @Override
    public void setMaxScore(final int maxScore) {

    }
}
