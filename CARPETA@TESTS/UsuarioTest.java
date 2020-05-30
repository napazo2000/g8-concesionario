package Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Model.Usuario;

public class UsuarioTest {
	Usuario user;

	@Before
	public void init() {
		user = new Usuario();
	}
	
	@After
	public void terminate() {
		user = null;
	}

	@Test
	public void idUsuarioCero() {
		assertEquals(0, user.getIdUsuario());
	}
	@Test
	public void correonull() {
		assertEquals(null, user.getCorreo());
	}
	@Test
	public void passwornull() {
		assertEquals(null, user.getPassword());
	}
	@Test
	public void dninull() {
		assertEquals(null, user.getDni());
	}
	@Test
	public void nombrenull() {
		assertEquals(null, user.getNombre());
	}
	@Test
	public void apellidosnull() {
		assertEquals(null, user.getApellidos());
	}
	@Test
	public void fecNacimientonull() {
		assertEquals(null, user.getFecNacimiento());
	}
	@Test
	public void movilnull() {
		assertEquals(0, user.getMovil());
	}
	@Test
	public void direccionnull() {
		assertEquals(null, user.getDireccion());
	}
	@Test
	public void codPostalnull() {
		assertEquals(0, user.getCodPostal());
	}
	@Test
	public void ciudadnull() {
		assertEquals(null, user.getCiudad());
	}
	@Test
	public void provincianull() {
		assertEquals(null, user.getProvincia());
	}
	@Test
	public void tipoRolnull() {
		assertEquals(null, user.getTipoRol());
	}
	@Test
	public void fotonull() {
		assertEquals(null, user.getFoto());
	}
	
}
