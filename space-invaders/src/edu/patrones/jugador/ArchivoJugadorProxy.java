package edu.patrones.jugador;

import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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
	
	public SortedSet<String> nickNames(List<String[]> lista) {
		Supplier<TreeSet<String>> stringSet = () -> new TreeSet<String>();
		return lista.stream()
				.map(x -> x[0])
				.collect(Collectors.toCollection(stringSet));
	}
	
}
