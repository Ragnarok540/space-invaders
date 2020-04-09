package edu.patrones.jugador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArchivoJugador {

    private static final String NOMBRE_ARCHIVO_CSV = "res/database.csv";
    private static final String DELIMITADOR = ",";
    private List<String[]> data;

    public ArchivoJugador() {
    	cargarArchivo();
    }
    
	public void guardar(JugadorMemento jugador) {
    	for (String[] registro: data) {
    		if (registro[0] == jugador.getNickname()) {
    			registro[2] = jugador.getPuntuacionMaxima();
    			return;		
    		}
    	}
		this.data.add(new String[] {jugador.getNickname(), 
				                    jugador.getNombre(), 
				                    jugador.getPuntuacionMaxima()});
    }

    public JugadorMemento abrir(String nickname) {
    	for (String[] registro: data) {
    		if (registro[0].equals(nickname)) {
    			return new JugadorMemento(registro[0], 
    					                  registro[1], 
    					                  registro[2]);
    		}
    	}
    	return null;
    }
    
    public void escribirArchivo() throws IOException {
        File archivoCSV = new File(NOMBRE_ARCHIVO_CSV);
        try (PrintWriter pw = new PrintWriter(archivoCSV)) {
            data.stream()
              .map(this::convertirEnCSV)
              .forEach(pw::println);
        }
    }
    
	public List<String[]> getData() {
		return data;
	}
    
	public boolean jugadorExiste(String nickname) {
    	for (String[] registro: data) {
    		if (registro[0].equals(nickname)) {
    			return true;
    		}
    	}
		return false;
	}
	
    private void cargarArchivo() {
    	try {
			data = leerArchivo();
		} catch (FileNotFoundException e) {
			data = new ArrayList<>();
			try {
				escribirArchivo();
				data = leerArchivo();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
    private String convertirEnCSV(String[] data) {
        return Stream.of(data)
                 .collect(Collectors.joining(","));
    }

    private List<String[]> leerArchivo() throws FileNotFoundException, IOException {
    	List<String[]> registros = new ArrayList<>();
    	try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO_CSV))) {
    	    String linea;
    	    while ((linea = br.readLine()) != null) {
    	        String[] valores = linea.split(DELIMITADOR);
    	        registros.add(valores);
    	    }
    	}
    	return registros;
    }

}
