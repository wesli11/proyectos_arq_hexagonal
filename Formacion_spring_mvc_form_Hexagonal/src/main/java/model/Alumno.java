package model;

public class Alumno {

	private String usuario;
	private String nombre;
	private int edad;
	private String email;
	private String password;
	
	public Alumno(String usuario, String nombre, int edad, String email, String password) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
