package panelEstudianteJuntoATable.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipologiaSexo")
public class Sexo extends Entidad{
	@Id
	private int id;
	private String descripcion;
	
	@OneToMany(mappedBy="sexo")
	private List<Estudiante> estudiantes;
	
	
	
	public Sexo() {
		super();
	}
	
	public Sexo(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	
//	GETTERS Y SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	@Override
	public String toString() {
		return descripcion;
	}
	
	
	
	
}
