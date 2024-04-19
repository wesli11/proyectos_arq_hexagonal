package model;

import java.util.Date;
import java.util.List;

public class Curso {

	private int idCurso;
	private String nombre;
	private int duracion;
	private Date fechaInicio;
	private List<Alumno> alumnos;
	
	public Curso(int idCurso, String nombre, int duracion, Date fechaInicio, List<Alumno>alumnos) {
		super();
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
		this.alumnos=alumnos;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
	
}
