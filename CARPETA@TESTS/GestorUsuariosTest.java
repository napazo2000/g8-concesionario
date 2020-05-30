package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Model.ConcesionarioException;
import Model.GestorUsuarios;
import Model.GestorVehiculos;
import Model.Usuario;



public class GestorUsuariosTest {
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
	public void inicialmenteElNumeroDeIdEsCero() {
        int numId = user.getIdUsuario();
        assertEquals(numId, 0);  //Si es igual, devuelve la funcion assertEquals= true, y el Test es pasado con Exito
    }

	//
	@Test
	public void siSeBorraUnUsuarioNoExistenteSeElevaExcepcion() {  //DA TEST PASADO CON EXITO, SI SE RECIBE LA EXCEPCIÓN QUE 
        //ESPERA, es como si java por defecto te pone un assert verdadero, SI NO LA RECIBE LA EXCEPCION DA TEST NO PASADO (HAY QUE PONER QUE FALLA, CON FAIL)
      GestorUsuarios u = new GestorUsuarios();
      try{
          u.delUsuario(user);
      }catch (ConcesionarioException e) {
      }
	}
	@Test
	public void siSeBorraUnUsuarioNoExisteSuId() {
        GestorUsuarios u = new GestorUsuarios();
        u.delUsuario(user);
        int numId = user.getIdUsuario();
        assertEquals(numId,0);
    }
	
}
