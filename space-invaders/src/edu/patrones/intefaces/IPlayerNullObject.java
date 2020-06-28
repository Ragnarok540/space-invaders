package edu.patrones.intefaces;

import edu.patrones.jugador.MementoPlayer;

public interface IPlayerNullObject {

	public boolean isNull();

	public String getName();

	public String getNickName();

	public int getMaxScore();

	public void openPlayer(MementoPlayer mementoPlayer);

	public MementoPlayer savePlayer();

	public void setMaxScore(int maxScore);

}
