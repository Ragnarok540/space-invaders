package edu.patrones.imagen;

import java.util.HashMap;

import edu.patrones.intefaces.IModeloFlyweight;

public class FabricaFlyweight {

	private HashMap<String, IModeloFlyweight> modelos;
	
	public FabricaFlyweight() {
		modelos = new HashMap<>();
	}
	
	public IModeloFlyweight obtenerModelo(String tipo) {
		if (modelos.get(tipo) != null) {
			return modelos.get(tipo);
		} else {
			IModeloFlyweight modelo;
			switch (tipo) {
			case "bala":
				modelo = new BalaFlyweight();
			break;
			case "calamar":
				modelo = new CalamarFlyweight();
			break;
			case "cangrejo":
				modelo = new CangrejoFlyweight();
			break;
			case "pulpo":
				modelo = new PulpoFlyweight();
			break;
			default:
				return null;
			}
			modelos.put(tipo, modelo);
			return modelo;
		}
	}
	
}
