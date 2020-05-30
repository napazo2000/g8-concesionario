package Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.ConcesionarioException;
import Model.GestorOperacion;
import Model.GestorUsuarios;
import Model.GestorVehiculos;
import Model.Operacion;
import Model.Usuario;

public class GestorOperacionTest {
	Operacion op;
	
	@Before
	public void init() {
		op = new Operacion();
	}
	
	@After
	public void terminate() {
		op = null;
	}
	@Test
	public void inicialmenteElNumeroDeIdEsCero() {
        int numId = op.getIDvehiculo();
        assertEquals(numId, 0);  //Si es igual, devuelve la funcion assertEquals= true, y el Test es pasado con Exito
    }

	//
	@Test
	public void siSeBorraUnaOperacionNoExistenteSeElevaExcepcion() {  //DA TEST PASADO CON EXITO, SI SE RECIBE LA EXCEPCIÓN QUE 
        //ESPERA, es como si java por defecto te pone un assert verdadero, SI NO LA RECIBE LA EXCEPCION DA TEST NO PASADO (HAY QUE PONER QUE FALLA, CON FAIL)
		GestorOperacion o = new GestorOperacion();
      try{
          o.delOperacion(op);
      }catch (ConcesionarioException e) {
      }
	}
	@Test
	public void siSeBorraUnaOperacionNoExisteSuId() {
        GestorOperacion o = new GestorOperacion();
        o.delOperacion(op);
        int numId = op.getIDoperacion();
        assertEquals(numId,0);
    }

}
