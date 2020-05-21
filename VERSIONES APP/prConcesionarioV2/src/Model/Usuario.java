package Model;

public class Usuario {
	int idUsuario;
	String correo;
    String password;
    String dni;
    String nombre;
    String apellidos;
    String fecNacimiento;
    int movil;
    String direccion;
    int codPostal;
    String ciudad;
    String provincia;
    String tipoRol;
    private byte[] foto;
	
    //getters
        
    public int getIdUsuario() {
    	return idUsuario;
    }
    
    public String getCorreo() {
		return correo;
	}
	public String getPassword() {
		return password;
	}
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getFecNacimiento() {
		return fecNacimiento;
	}
	public int getMovil() {
		return movil;
	}
	public String getDireccion() {
		return direccion;
	}
	public int getCodPostal() {
		return codPostal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public String getTipoRol() {
		return tipoRol;
	}
	public byte[] getFoto() {
		return foto;
	}
	
	
	//setters
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setFecNacimiento(String fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}
	public void setMovil(int movil) {
		this.movil = movil;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
}
