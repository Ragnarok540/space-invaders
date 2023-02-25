package edu.patterns.player;

public class MementoPlayer {

	private String nickName;
	private String name;
	private String maxScore;

	public MementoPlayer(String nickName, String name, String maxScore) {
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
