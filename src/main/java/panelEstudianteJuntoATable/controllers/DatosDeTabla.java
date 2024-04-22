package panelEstudianteJuntoATable.controllers;

import java.util.List;


import panelEstudianteJuntoATable.model.Estudiante;


public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"id", "nombre", "apellido1", "apellido2", "dni", "direccion", "email", "telefono", "sexo", "colorPreferido"};
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Estudiante> estudiantes = (List<Estudiante>) ControladorEstudiante.getInstance().findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[estudiantes.size()][10];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < estudiantes.size(); i++) {
			Estudiante e = estudiantes.get(i);
			datos[i][0] = e.getId();
			datos[i][1] = e.getNombre();
			datos[i][2] = e.getApellido1();
			datos[i][3] = e.getApellido2();
			datos[i][4] = e.getDni();
			datos[i][5] = e.getDireccion();
			datos[i][6] = e.getEmail();
			datos[i][7] = e.getTelefono();
			datos[i][8] = e.getSexo();
			datos[i][9] = e.getColorPreferido();
		}
		
		return datos;
	}
	
	
}
