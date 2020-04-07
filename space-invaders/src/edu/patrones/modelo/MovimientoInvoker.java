package edu.patrones.modelo;

import java.util.ArrayList;
import java.util.List;
import edu.patrones.intefaces.IMovimientoCommand;

public class MovimientoInvoker {
	
	List<IMovimientoCommand> movimientos = new ArrayList<IMovimientoCommand>();
	
	public void recibirMovimiento(IMovimientoCommand movimiento) {
		this.movimientos.add(movimiento);
	}
	
	public void realizarMovimientos() {
		this.movimientos.forEach(x -> x.execute());
		this.movimientos.clear();

	}

}
