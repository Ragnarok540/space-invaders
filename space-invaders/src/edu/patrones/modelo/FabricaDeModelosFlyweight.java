package edu.patrones.modelo;

import java.util.HashMap;

import edu.patrones.intefaces.IModeloFlyweight;

public class FabricaDeModelosFlyweight {

	private HashMap<String, IModeloFlyweight> modelos;
	
	public FabricaDeModelosFlyweight() {
		modelos = new HashMap<>();
	}
	
	public IModeloFlyweight obtenerModelo(String tipo) {
		if (modelos.get(tipo) != null) {
			return modelos.get(tipo);
		} else {
			IModeloFlyweight modelo;
			switch (tipo) {
			case "bala":
				modelo = new ModeloFlyweightBala();
			break;
			case "calamar":
				modelo = new ModeloFlyweightCalamar();
			break;
			case "cangrejo":
				modelo = new ModeloFlyweightCangrejo();
			break;
			case "pulpo":
				modelo = new ModeloFlyweightPulpo();
			break;
			default:
				return null;
			}
			modelos.put(tipo, modelo);
			return modelo;
		}
	}
	
}
