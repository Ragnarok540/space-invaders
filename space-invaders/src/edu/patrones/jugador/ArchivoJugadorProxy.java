package edu.patrones.jugador;

import java.util.Collections;
import java.util.List;

import edu.patrones.intefaces.IArchivoJugadorProxy;

public class ArchivoJugadorProxy implements IArchivoJugadorProxy {

	private ArchivoJugador aj;
	
	public ArchivoJugadorProxy() {
		aj = new ArchivoJugador();
	}
	
	@Override
	public List<String[]> getData() {
		List<String[]> data = aj.getData();
		
		Collections.sort(data, (e1, e2) -> {
			return Integer.parseInt(e2[2]) - Integer.parseInt(e1[2]);
		});
		
		return data;
	}
	
	public Object[][] convertir(List<String[]> lista) {
		Object[][] salida = new Object[lista.size()][4];
				
		for (int i = 0; i < lista.size(); i++) {
			salida[i] = new Object[] {i + 1, 
					lista.get(i)[2], 
					lista.get(i)[0], 
					lista.get(i)[1]};
		}
		
		return salida;
	}
	
}
