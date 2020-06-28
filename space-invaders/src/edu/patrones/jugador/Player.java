package edu.patrones.jugador;

import edu.patrones.intefaces.IPlayerNullObject;

public class Player implements IPlayerNullObject {

	private String nickName;
	private String name;
	private int maxScore;

	public Player(String nickName, String name) {
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
	public void setMaxScore(int maxScore) {
		if (maxScore > this.maxScore) {
			this.maxScore = maxScore;
		}
	}

	@Override
	public MementoPlayer savePlayer() {
		return new MementoPlayer(nickName, name, maxScore + "");
	}

	@Override
	public void openPlayer(MementoPlayer mementoPlayer) {
		this.nickName = mementoPlayer.getNickName();
		this.name = mementoPlayer.getName();
		this.maxScore = Integer.parseInt(mementoPlayer.getMaxScore());
	}

	@Override
	public boolean isNull() {
		return false;
	}

}
