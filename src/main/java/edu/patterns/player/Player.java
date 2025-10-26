package edu.patterns.player;

import edu.patterns.interfaces.IPlayerNullObject;

public final class Player implements IPlayerNullObject {
    /**
    * Nickname of the player.
    */
    private String nickName;
    /**
    * Name of the player.
    */
    private String name;
    /**
    * Maximum recorded score of the player.
    */
    private int maxScore;

    /**
    * Constructor for the Player, used to manage the the players.
    * @param nickName Nickname of the player.
    * @param name Name of the player.
    */
    public Player(final String nickName, final String name) {
        super();
        this.nickName = nickName;
        this.name = name;
        this.maxScore = 0;
    }

    /**
    * Constructor for the Player, used to manage the the players.
    */
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
