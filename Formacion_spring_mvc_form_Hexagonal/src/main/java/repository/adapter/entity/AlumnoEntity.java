package repository.adapter.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the alumnos database table.
 * 
 */
@Entity
@Table(name="alumnos")
@NamedQuery(name="AlumnoEntity.findAll", query="SELECT a FROM AlumnoEntity a")
public class AlumnoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String usuario;

	private int edad;

	private String email;

	private String nombre;

	private String password;

	//bi-directional many-to-many association to CursoEntity
	@ManyToMany(mappedBy="alumnos")
	private List<CursoEntity> cursos;

	public AlumnoEntity() {
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CursoEntity> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<CursoEntity> cursos) {
		this.cursos = cursos;
	}

}