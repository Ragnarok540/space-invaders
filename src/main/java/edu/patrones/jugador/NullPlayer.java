package edu.patrones.jugador;

import edu.patrones.intefaces.*;

public class NullPlayer implements IPlayerNullObject {

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public String getName() {
		return "El jugador no existe";
	}

	@Override
	public String getNickName() {
		return "El jugador no existe";
	}

	@Override
	public int getMaxScore() {
		return -1;
	}

	@Override
	public void openPlayer(MementoPlayer mementoPlayer) {
		// TODO Auto-generated method stub
	}

	@Override
	public MementoPlayer savePlayer() {
		return null;
	}

	@Override
	public void setMaxScore(int maxScore) {
		// TODO Auto-generated method stub
	}

}
