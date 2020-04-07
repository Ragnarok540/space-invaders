package edu.patrones.modelo;

import edu.patrones.intefaces.IMovimientoCommand;

public class Disparar implements IMovimientoCommand {

	private TecladoCommand teclado;
	
	public Disparar(TecladoCommand teclado) {

		this.teclado = teclado;
	}
	
	@Override
	public void execute() {
		this.teclado.disparar();

	}

}