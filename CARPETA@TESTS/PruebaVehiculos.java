package Pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Model.Usuario;
import Model.Vehiculo;

public class PruebaVehiculos {

	
	@Test
	public void testGetMarca() {
		System.out.println("getMarca");
		Vehiculo instance = new Vehiculo();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setMarca("");//Con esto asignamos un valor vacio
		String result = instance.getMarca();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	
	@Test
	public void testGetModelo() {
		System.out.println("getModelo");
		Vehiculo instance = new Vehiculo();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setModelo("");//Con esto asignamos un valor vacio
		String result = instance.getModelo();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	
	
	@Test
	public void testGetEstado() {
		System.out.println("getEstado");
		Vehiculo instance = new Vehiculo();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setEstado("");//Con esto asignamos un valor vacio
		String result = instance.getEstado();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	
	@Test
	public void testGetTipoOferta() {
		System.out.println("getTipoOferta");
		Vehiculo instance = new Vehiculo();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setTipoOferta("");//Con esto asignamos un valor vacio
		String result = instance.getTipoOferta();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	@Test
	public void testGetKilometros() {
		System.out.println("getKilometros");
		int km = 0;
		Vehiculo instance = new Vehiculo();
		instance.setKilometros(km);
		
	}
	
	
	@Test
	public void testGetCilindrada() {
		System.out.println("getCilindrada");
		Vehiculo instance = new Vehiculo();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setCilindrada("");//Con esto asignamos un valor vacio
		String result = instance.getCilindrada();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	@Test
	public void testGetPrecio() {
		System.out.println("getPrecio");
		Double prex = 0.0;
		Vehiculo instance = new Vehiculo();
		instance.setPrecio(prex);
		
	}
	
	@Test
	public void testGetTipoCombustible() {
		System.out.println("getTipoCombustible");
		Vehiculo instance = new Vehiculo();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setTipoCombustible("");//Con esto asignamos un valor vacio
		String result = instance.getTipoCombustible();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	
	@Test
	public void testGetTipoCambio() {
		System.out.println("getTipoCambio");
		Vehiculo instance = new Vehiculo();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setTipoCambio("");//Con esto asignamos un valor vacio
		String result = instance.getTipoCambio();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	
	@Test
	public void testGetAnyoFabricacion() {
		System.out.println("getAnyoFabricacion");
		int año = 0;
		Vehiculo instance = new Vehiculo();
		instance.setAnyoFabricacion(año);
		
	}
	
	@Test
	public void testGetPrecioSinIva() {
		System.out.println("getPrecioSinIva");
		double precio = 0.0;
		Vehiculo instance = new Vehiculo();
		instance.setPrecioSinIva(precio);
		
	}
	
	@Test
	public void testGetMatricula() {
		System.out.println("getMatricula");
		Vehiculo instance = new Vehiculo();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setMatricula("");//Con esto asignamos un valor vacio
		String result = instance.getMatricula();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	@Test
	public void testGetUnidades() {
		System.out.println("getUnidades");
		int unid = 0;
		Vehiculo instance = new Vehiculo();
		instance.setUnidades(unid);
		
	}
	
//	@Test
//	public void testGetFoto() {
//		System.out.println("getFoto");
//		for (int b = Byte.MIN_VALUE; b <= Byte.MAX_VALUE; b++) {
//			byte r = myMethod((byte) b);
//			System.out.printf("%d = %dn", b, r);
//			}
//		
//	}
//	
	
	
	
	
	
	
	
}
