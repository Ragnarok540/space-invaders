package edu.patterns.player;

public final class MementoPlayer {
    private String nickName;
    private String name;
    private String maxScore;

    public MementoPlayer(final String nickName, final String name, final String maxScore) {
        this.nickName = nickName;
        this.name = name;
        this.maxScore = maxScore;
    }

    public String getNickName() {
        return nickName;
    }

    public String getName() {
        return name;
    }

    public String getMaxScore() {
        return maxScore;
    }
}
