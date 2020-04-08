package edu.patrones.intefaces;

public interface IMovimientoCommand {
	
	public void execute(boolean pressed);
	
	public boolean isDown();

}
