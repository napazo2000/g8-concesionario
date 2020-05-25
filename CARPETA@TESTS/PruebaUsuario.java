package Pruebas;
import Model.Usuario;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class PruebaUsuario {

	
	
	
	
	
	
	@Test
	public void testGetNombres() {
		System.out.println("getNombre");
		Usuario instance = new Usuario();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setNombre("");//Con esto asignamos un valor vacio
		String result = instance.getNombre();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	
	
	@Test
	public void testGetApellidos() {
		System.out.println("getApellidos");
		Usuario instance = new Usuario();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setApellidos("");//Con esto asignamos un valor vacio
		String result = instance.getApellidos();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	@Test
	public void testGetIdUsuario() {
		System.out.println("getIdUsuario");
		int id = 0;
		Usuario instance = new Usuario();
		
		instance.setIdUsuario(id);//Con esto asignamos un valor vacio
		
		
	}
	
	
	@Test
	public void testGetPassword() {
		System.out.println("getPassword");
		Usuario instance = new Usuario();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setPassword("");;//Con esto asignamos un valor vacio
		String result = instance.getPassword();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	
	@Test
	public void testGetFecNacimiento() {
		System.out.println("getFecNacimiento");
		Usuario instance = new Usuario();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setFecNacimiento("");;//Con esto asignamos un valor vacio
		String result = instance.getFecNacimiento();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	
	@Test
	public void testGetMovil() {
		System.out.println("getMovil");
		Usuario instance = new Usuario();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setNombre("");//Con esto asignamos un valor vacio
		String result = instance.getNombre();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	
	@Test
	public void testGetDireccion() {
		System.out.println("getDireccion");
		Usuario instance = new Usuario();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setDireccion("");;//Con esto asignamos un valor vacio
		String result = instance.getDireccion();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	@Test
	public void testGetCodPostal() {
		System.out.println("getCodPostal");
		int cod = 0;
		Usuario instance = new Usuario();
		instance.setCodPostal(cod);
		
	}
	
	@Test
	public void testGetCiudad() {
		System.out.println("getCiudad");
		Usuario instance = new Usuario();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setCiudad("");;//Con esto asignamos un valor vacio
		String result = instance.getCiudad();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	@Test
	public void testGetProvincia() {
		System.out.println("getProvincia");
		Usuario instance = new Usuario();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setProvincia("");;//Con esto asignamos un valor vacio
		String result = instance.getProvincia();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	
	@Test
	public void testGetTipoRol() {
		System.out.println("getTipoRol");
		Usuario instance = new Usuario();
		String expResult = ""; //Esta variable tiene un valor vacio
		instance.setTipoRol("");;//Con esto asignamos un valor vacio
		String result = instance.getTipoRol();//recupera lo que tenga nombre
		
		assertEquals(expResult, result);//aqui compara si vacio es igual a vacio
		
		
	}
	
	
	
	
	
	
}
