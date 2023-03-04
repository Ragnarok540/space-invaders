package edu.patterns.player;

import edu.patterns.interfaces.IPlayerNullObject;

public final class Player implements IPlayerNullObject {
    private String nickName;
    private String name;
    private int maxScore;

    public Player(final String nickName, final String name) {
        super();
        this.nickName = nickName;
        this.name = name;
        this.maxScore = 0;
    }

    public Player() {

    }

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxScore() {
        return maxScore;
    }

    @Override
    public void setMaxScore(final int maxScore) {
        if (maxScore > this.maxScore) {
            this.maxScore = maxScore;
        }
    }

    @Override
    public MementoPlayer savePlayer() {
        return new MementoPlayer(nickName, name, maxScore + "");
    }

    @Override
    public void openPlayer(final MementoPlayer mementoPlayer) {
        this.nickName = mementoPlayer.getNickName();
        this.name = mementoPlayer.getName();
        this.maxScore = Integer.parseInt(mementoPlayer.getMaxScore());
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
