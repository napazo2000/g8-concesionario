package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.ConcesionarioException;
import Model.GestorVehiculos;
import Model.Vehiculo;

public class GestorVehiculosTest {
	Vehiculo v;
	
	@Before
	public void init() {
		v = new Vehiculo();
	}
	
	@After
	public void terminate() {
		v = null;
	}
	@Test
	public void inicialmenteElNumeroDeIdEsCero() {
        int numId = v.getIdVehiculo();
        assertEquals(numId, 0);  //Si es igual, devuelve la funcion assertEquals= true, y el Test es pasado con Exito
    }

	//
	@Test
	public void siSeBorraUnVehiculoNoExistenteSeElevaExcepcion() {  //DA TEST PASADO CON EXITO, SI SE RECIBE LA EXCEPCIÓN QUE 
        //ESPERA, es como si java por defecto te pone un assert verdadero, SI NO LA RECIBE LA EXCEPCION DA TEST NO PASADO (HAY QUE PONER QUE FALLA, CON FAIL)
      GestorVehiculos gv = new GestorVehiculos();
      try{
          gv.delVehiculo(v);
      }catch (ConcesionarioException e) {
      }
	}
	@Test
	public void siSeBorraUnVehiculoNoExisteSuId() {
        GestorVehiculos gv = new GestorVehiculos();
        gv.delVehiculo(v);
        int numId = v.getIdVehiculo();
        assertEquals(numId,0);
    }


}
