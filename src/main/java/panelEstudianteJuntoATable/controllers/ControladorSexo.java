package panelEstudianteJuntoATable.controllers;

import panelEstudianteJuntoATable.model.Sexo;

public class ControladorSexo extends SuperControlador{
	private static ControladorSexo instance = null;
	
	public ControladorSexo() {
		super("tipologiaSexo", Sexo.class);
	}
	
	public static ControladorSexo getInstance() {
		if(instance==null) {
			instance = new ControladorSexo();
		}
		return instance;
	}
}
