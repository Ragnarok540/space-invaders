package edu.patrones.jugador;

import java.util.Collections;
import java.util.List;

public class ArchivoJugadorProxy {

	private ArchivoJugador aj;
	
	public ArchivoJugadorProxy() {
		aj = new ArchivoJugador();
	}
	
	public Object[][] datosOrdenados() {
		List<String[]> data = aj.getData();
		
		Collections.sort(data, (e1, e2) -> {
			return Integer.parseInt(e2[2]) - Integer.parseInt(e1[2]);
		});
		
		Object[][] salida = new Object[data.size()][4];
		
		for (int i = 0; i < data.size(); i++) {
			salida[i] = new Object[] {i + 1, 
					                  data.get(i)[2], 
					                  data.get(i)[0], 
					                  data.get(i)[1]};
		}
		
		return salida;
	}
	
}
