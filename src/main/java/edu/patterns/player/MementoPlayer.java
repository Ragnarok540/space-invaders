package edu.patterns.player;

public final class MementoPlayer {
    /**
    * Nickname of the player.
    * @see edu.patterns.player.Player
    */
    private String nickName;
    /**
    * Name of the player.
    * @see edu.patterns.player.Player
    */
    private String name;
    /**
    * Maximum recorded score of the player.
    * @see edu.patterns.player.Player
    */
    private String maxScore;

    /**
    * Constructor for the Memento Player, used to save the information
    * of the players.
    * @param nickName Nickname of the player.
    * @param name Name of the player.
    * @param maxScore Maximum recorded score of the player.
    * @see edu.patterns.player.Player
    */
    public MementoPlayer(final String nickName,
                         final String name,
                         final String maxScore) {
        this.nickName = nickName;
        this.name = name;
        this.maxScore = maxScore;
    }

    /**
    * Nickname of the player.
    * @return The nickname.
    * @see edu.patterns.player.Player
    */
    public String getNickName() {
        return nickName;
    }

    /**
    * Name of the player.
    * @return The name.
    * @see edu.patterns.player.Player
    */
    public String getName() {
        return name;
    }

    /**
    * Maximum recorded score of the player.
    * @return The score.
    * @see edu.patterns.player.Player
    */
    public String getMaxScore() {
        return maxScore;
    }
}
