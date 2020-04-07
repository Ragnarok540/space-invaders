package edu.patrones.modelo;

import edu.patrones.intefaces.IMovimientoCommand;

public class MoverDerecha implements IMovimientoCommand {

	private TecladoCommand teclado;
	
	public MoverDerecha(TecladoCommand teclado) {

		this.teclado = teclado;
	}
	
	@Override
	public void execute() {
		this.teclado.moverDerecha();

	}

}
