package edu.patrones.imagen;

import java.util.ArrayList;
import java.util.HashMap;

public class FlyweightFactory {

	private HashMap<String, FlyweightModel> models;

	public FlyweightFactory() {
		models = new HashMap<>();
	}

	public FlyweightModel obtenerModelo(String type) {

		if (models.get(type) != null) {

			return models.get(type);

		} else {

			ArrayList<String> paths = new ArrayList<>();

			switch (type) {
			case "nave":
				paths.add("res/nave.png");
				break;
			case "bala":
				paths.add("res/missile.png");
				paths.add("res/laser.png");
				break;
			case "calamar":
				paths.add("res/cal0.png");
				paths.add("res/cal1.png");
				break;
			case "cangrejo":
				paths.add("res/can0.png");
				paths.add("res/can1.png");
				break;
			case "pulpo":
				paths.add("res/pul0.png");
				paths.add("res/pul1.png");
				break;
			default:
				return null;
			}

			FlyweightModel model = new FlyweightModel(paths);
			models.put(type, model);
			return model;
		}
	}

}
