package edu.patterns.interfaces;

import edu.patterns.player.MementoPlayer;

public interface IPlayerNullObject {
    boolean isNull();
    String getName();
    String getNickName();
    int getMaxScore();
    void openPlayer(MementoPlayer mementoPlayer);
    MementoPlayer savePlayer();
    void setMaxScore(int maxScore);
}
