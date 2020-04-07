package edu.patrones.modelo;

import edu.patrones.intefaces.IMovimientoCommand;

public class MoverIzquierda implements IMovimientoCommand {

	private TecladoCommand teclado;
	
	public MoverIzquierda(TecladoCommand teclado) {

		this.teclado = teclado;
	}
	
	@Override
	public void execute() {
		this.teclado.moverIzquierda();

	}

}
