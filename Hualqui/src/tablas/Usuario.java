package tablas;
// Generated Nov 23, 2019 1:39:02 PM by Hibernate Tools 5.4.7.Final

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

	private int idusuario;
	private String nombre;
	private String nombreusu;
	private String email;
	private Integer edad;

	public Usuario() {
	}

	public Usuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public Usuario(int idusuario, String nombre, String nombreusu, String email, Integer edad) {
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.nombreusu = nombreusu;
		this.email = email;
		this.edad = edad;
	}

	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreusu() {
		return this.nombreusu;
	}

	public void setNombreusu(String nombreusu) {
		this.nombreusu = nombreusu;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
