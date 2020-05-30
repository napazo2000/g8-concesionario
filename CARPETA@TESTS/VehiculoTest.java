package Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Model.Vehiculo;

public class VehiculoTest {
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
	public void idVehiculonull() {
		assertEquals(0, v.getIdVehiculo());
	}
	@Test
	public void marcanull() {
		assertEquals(null, v.getMarca());
	}
	@Test
	public void modelonull() {
		assertEquals(null, v.getModelo());
	}
	@Test
	public void estadonull() {
		assertEquals(null, v.getEstado());
	}
	@Test
	public void tipoOfertanull() {
		assertEquals(null, v.getTipoOferta());
	}
	@Test
	public void kilometrosnull() {
		assertEquals(0, v.getKilometros());
	}
	@Test
	public void cilindradanull() {
		assertEquals(null, v.getCilindrada());
	}
	@Test
	public void precionull() {
		//assertEquals(0, v.getPrecio());
		assertEquals(0, v.getPrecio(),0);
	}
	@Test
	public void tipoConbustiblenull() {
		assertEquals(null, v.getTipoCombustible());
	}
	@Test
	public void tipoCambionull() {
		assertEquals(null, v.getTipoCambio());
	}
	@Test
	public void anyoFabricacionnull() {
		assertEquals(0, v.getAnyoFabricacion());
	}
	@Test
	public void precioSinIvanull() {
		//assertEquals(0, v.getPrecioSinIva());
		assertEquals(0, v.getPrecioSinIva(),0);
	}
	@Test
	public void matriculanull() {
		assertEquals(null, v.getMatricula());
	}
	@Test
	public void dispnull() {
		assertEquals(0, v.getDisponibilidad());
	}
	@Test
	public void fotonull() {
		assertEquals(null, v.getFoto());
	}
}
