package Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Model.Operacion;

public class OperacionTest {
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
	public void tipoOfertanull() {
		assertEquals(null, op.getTipooferta());
	}
	
	@Test
	public void formaPagonull() {
		assertEquals(null, op.getFormapago());
	}
	@Test
	public void mesesnull() {
		assertEquals(0, op.getMeses());
	}
	@Test
	public void financiacionnull() {
		assertEquals(null, op.getFinanciacion());
	}
	@Test
	public void importenull() {
		//assertEquals(0.0, op.getImporte());
		assertEquals(0.0,op.getImporte(),0);
	}
	@Test
	public void numDiasnull() {
		assertEquals(0, op.getNumdias());
	}
	@Test
	public void datenull() {
		assertEquals(null, op.getDate());
	}
	@Test
	public void idVehiculonull() {
		assertEquals(0, op.getIDvehiculo());
	}
	@Test
	public void idClientenull() {
		assertEquals(0, op.getIDcliente());
	}
	@Test
	public void idVendedornull() {
		assertEquals(0, op.getIdvendedor());
	}
	@Test
	public void idOperacionnull() {
		assertEquals(0, op.getIDoperacion());
	}
	
	
	

	
	

}
