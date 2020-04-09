package edu.patrones.vista;

public final class Const {

	private Const() {

	}
	
	public static final String T_INSTRUCC = "Instrucciones";
	public static final String INSTRUCC = "- Mueva la Nave usando las flechas izq. y der." +
	                                      "\n- Dispare usando la barra espaciadora" +
			                              "\n- Acabe con la invasion alienigena";
	public static final String E_NICK = "El Nick ya esta registrado, debe digitar otro.";
	public static final String E_NUEVO_JUG = "- El Nombre puede tener letras" +
                                             " y espacios, y maximo 25 caracteres." +
                                             "\n- El Nickname puede tener letras y numeros," +
                                             " y maximo 6 caracteres." +
                                             "\n- No se permiten caracteres especiales ni tildes.";
	public static final String T_ACERCA = "Acerca de...";
	public static final String ACERCA = "(C) 2020\nYuli Garces\nCarolina Camacho\nEdgar Nova";
	public static final String T_PUNT = "Mejores Puntajes";
	public static final String[] COL_NAMES = {"Posicion", "Puntaje", "Nickname", "Nombre"};
	public static final String ESTADO_INI = "Cree o seleccione un jugador para empezar...";
	public static final String JUEGO = "Juego";
	public static final String T_NUEVO = "Nuevo Jugador";
	public static final String T_SELECC = "Seleccionar Jugador";
	public static final String T_INGR = "Ingreso Rapido";
	public static final String T_INIC = "Iniciar Juego";
	public static final String AYUDA = "Ayuda";
	public static final String CREAR = "Crear Jugador";
	public static final String CANCELAR = "Cancelar";
	public static final String M_NOMBRE = "Nombre del nuevo jugador:";
	public static final String M_NICK = "Nickname del nuevo jugador:";
	public static final String NAME_REGEX = "[a-zA-Z\\s]+";
	public static final String NICK_REGEX = "[a-zA-Z0-9]+";
	public static final String INTENTAR = "Intentar de Nuevo";
	
}
