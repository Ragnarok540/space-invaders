package edu.patrones.modelo;

import edu.patrones.intefaces.IMovimientoCommand;

public class Pausar implements IMovimientoCommand {

	private TecladoCommand teclado;
	
	public Pausar(TecladoCommand teclado) {

		this.teclado = teclado;
	}
	
	@Override
	public void execute() {
		this.teclado.pausar();

	}

}
