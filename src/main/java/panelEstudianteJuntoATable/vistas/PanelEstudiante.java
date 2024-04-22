package panelEstudianteJuntoATable.vistas;

import javax.swing.JPanel;

import panelEstudianteJuntoATable.Principal;
import panelEstudianteJuntoATable.controllers.ControladorEstudiante;
import panelEstudianteJuntoATable.model.Estudiante;
import panelEstudianteJuntoATable.model.Sexo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;

public class PanelEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelDatosPersonales panelDatos = new PanelDatosPersonales();

	/**
	 * Create the panel.
	 */
	public PanelEstudiante() {
		setLayout(new BorderLayout(0, 0));
		this.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setTitulo("Gestión de estudiante");
		
		this.panelDatos.getJtfId().setEditable(false);
		
		
		this.panelDatos.setRunnableGuardar(
				new Runnable() {
					
					public void run() {
						try {
							guardar();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				);
		
		
		
	}
	
	public void mostrarEntidad(Estudiante e) {
		if (e != null) {
			this.panelDatos.setId(e.getId());
			this.panelDatos.setNombre(e.getNombre());
			this.panelDatos.setApellido1(e.getApellido1());
			this.panelDatos.setApellido2(e.getApellido2());
			for (int i = 0; i < this.panelDatos.getJcbSexo().getItemCount(); i++) {
				if (this.panelDatos.getJcbSexo().getItemAt(i).getId() == e.getSexo().getId()) {
					this.panelDatos.getJcbSexo().setSelectedIndex(i);
				}
			}
			this.panelDatos.setDireccion(e.getDireccion());
			this.panelDatos.setDNI(e.getDni());
			this.panelDatos.setTelefono(e.getTelefono());
			this.panelDatos.setEmail(e.getEmail());
			this.panelDatos.setImagen(e.getImagen());
			this.panelDatos.setColor(e.getColorPreferido());
			if ( e.getColorPreferido() != null && e.getColorPreferido().length() == 7 ) {
				this.panelDatos.setColorPanel(Color.decode(e.getColorPreferido()));
			}
			else {
				this.panelDatos.setColorPanel(Color.WHITE);
			}
		
		}
		
	}
	
	
	
	public void guardar() throws SQLException {
		Estudiante m = new Estudiante();
		
		m.setId(Integer.parseInt(this.panelDatos.getJtfId().getText()));
		m.setNombre(this.panelDatos.getJtfNombre().getText());
		m.setApellido1(this.panelDatos.getJtfApellido1().getText());
		m.setApellido2(this.panelDatos.getJtfApellido2().getText());
		m.setDni(this.panelDatos.getJtfDNI().getText());
		m.setSexo(((Sexo)this.panelDatos.getJcbSexo().getSelectedItem()));
		m.setDireccion(this.panelDatos.getJtfDireccion().getText());
		m.setEmail(this.panelDatos.getJtfEmail().getText());
		m.setTelefono(this.panelDatos.getJtfTelefono().getText());
		m.setImagen(this.panelDatos.getImagen());
		m.setColorPreferido(this.panelDatos.getColor());
		
		ControladorEstudiante.getInstance().actualizacion(m);
		
	}
	
}
