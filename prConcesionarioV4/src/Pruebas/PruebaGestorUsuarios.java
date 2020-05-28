package Pruebas;

import org.junit.*;
import org.mockito.*;

import Model.*;

public class PruebaGestorUsuarios {

	GestorUsuarios gestorU;
	
	
	@Before
	public void init() {
		gestorU = new GestorUsuarios();
	}
	
	@After
	public void terminate() {
		gestorU = null;
	}
	
	public void AñadirUsuarioDelGestorVacio() {
		System.out.println("añadirUsuarioDelGestorVacio");
		Usuario u = new Usuario();
		u.setCorreo("");
		u.setPassword("");
		u.setDni("");
		u.setNombre("");
		u.setApellidos("");
		u.setFecNacimiento("");
		u.setMovil(0);
		u.setDireccion("");
		u.setCodPostal(0);
		u.setCiudad("");
		u.setProvincia("");
		u.setTipoRol("");
		u.setFoto(null);
		
		gestorU.addUsuario(u);
		
	}
	
	
	
	public void EditarUsuarioDelGestorVacio() {
		Usuario u = new Usuario();
		u.setCorreo("");
		u.setPassword("");
		u.setDni("");
		u.setNombre("");
		u.setApellidos("");
		u.setFecNacimiento("");
		u.setMovil(0);
		u.setDireccion("");
		u.setCodPostal(0);
		u.setCiudad("");
		u.setProvincia("");
		u.setTipoRol("");
		u.setFoto(null);
		
		gestorU.editUsuario(u);;
		
	}
	
	
	
}
