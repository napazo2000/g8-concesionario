package Model;

import Conexion.Conectar;

import java.sql.*;
import java.util.ArrayList;


/*Metodo listar*/
public class GestorVehiculos{

	//Metodo para visualizar los vehiculos de la clase vehiculo
	  public ArrayList<Vehiculo> verVehiculos(String filtro, String tipoOferta, String tipoRol){
		  	//Creamos una lista con los datos de la clase vehiculo
	        ArrayList<Vehiculo> list = new ArrayList<Vehiculo>();
	        //Conectamos a la base de datos
	        Conectar conec = new Conectar();
	        String sql;
	        //Si(el tipo de rol es un empleado) entraremos dentro del bucle
		   if(tipoRol.equals("Empleado")) {
			   if(tipoOferta.equals("all")) {
				   //Uso del filtro para ordenar
		    	if(filtro.equals("default")) {
		        	sql = "SELECT * FROM vehiculo WHERE dispo = '1'";
		        }
		        else {
		        	sql = "SELECT * FROM vehiculo WHERE dispo = '1' ORDER BY " + filtro + "";
		        }
		    } else {
		    	if(filtro.equals("default")) {
		    		System.out.println("entra aqui");
		        	sql = "SELECT * FROM vehiculo WHERE tipoOferta = '" + tipoOferta + "' AND dispo = '1'";
		        }
		        else {
		        	sql = "SELECT * FROM vehiculo WHERE tipoOferta = '" + tipoOferta + "' AND dispo = '1' ORDER BY " + filtro + "";
			        }
		        }
		   } else {
			   if(tipoOferta.equals("all")) {
		    	if(filtro.equals("default")) {
		        	sql = "SELECT * FROM vehiculo";
		        }
		        else {
		        	sql = "SELECT * FROM vehiculo ORDER BY " + filtro + "";
		        }
		    } else {
		    	if(filtro.equals("default")) {
		    		System.out.println("entra aqui");
		        	sql = "SELECT * FROM vehiculo WHERE tipoOferta = '" + tipoOferta + "'";
		        }
		        else {
		        	sql = "SELECT * FROM vehiculo WHERE tipoOferta = '" + tipoOferta + "' ORDER BY " + filtro + "";
			        }
		        }
		   }
	        ResultSet rs = null;
	        PreparedStatement ps = null;
	        try{
	            ps = conec.getConnection().prepareStatement(sql);	            
	            rs = ps.executeQuery();
	            while(rs.next()){
	            	//inicializamos todos los getter de la clase vehiculo
	                Vehiculo v = new Vehiculo();
	                v.setIdVehiculo(rs.getInt(1));
	                v.setMarca(rs.getString(2));
	                v.setModelo(rs.getString(3));
	                v.setEstado(rs.getString(4));
	                v.setTipoOferta(rs.getString(5));
	                v.setKilometros(rs.getInt(6));
	                v.setCilindrada(rs.getString(7));
	                v.setPrecio(rs.getDouble(8));
	                v.setTipoCombustible(rs.getString(9));
	                v.setTipoCambio(rs.getString(10));
	                v.setAnyoFabricacion(rs.getInt(11));
	                v.setPrecioSinIva(rs.getDouble(12));
	                v.setMatricula(rs.getString(13));
	                v.setDisponibilidad(rs.getInt(14));
	                v.setFoto(rs.getBytes(15));
	                //los añadimos a la lista
	                list.add(v);
	            }
	            //capturamos la excepciones
	        }catch(SQLException ex){
	            System.out.println(ex.getMessage());
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }finally{
	            try{
	            	//cerramos todas las conexiones
	                ps.close();
	                rs.close();
	                conec.desconectar();
	            }catch(Exception ex){}
	        }
	        //devolvemos la lista
	        return list;
	    }


	/*Metodo agregar*/
	    public void addVehiculo(Vehiculo v){
	    	//conectamos a la base de datos
	        Conectar conec = new Conectar();
	        //creamos variable para configurar el orden de entrada de los datos
	        String sql = "INSERT INTO vehiculo (idVehiculo, marca, modelo, estado, tipoOferta, kilometros, cilindrada, precio, tipoCombustible, tipoCambio, anyoFabricacion, precioSinIva, matricula,dispo, foto)\n" +
	"VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	        PreparedStatement ps = null;
	        try{
	        	//conectamos y usamos los getters para obtener los valores
	            ps = conec.getConnection().prepareStatement(sql);
	            ps.setString(1, v.getMarca());
	            ps.setString(2, v.getModelo());
	            ps.setString(3, v.getEstado());
	            ps.setString(4, v.getTipoOferta());
	            ps.setInt(5, v.getKilometros());
	            ps.setString(6, v.getCilindrada());
	            ps.setDouble(7, v.getPrecio());
	            ps.setString(8, v.getTipoCombustible());
	            ps.setString(9, v.getTipoCambio());
	            ps.setInt(10, v.getAnyoFabricacion());
	            ps.setDouble(11, v.getPrecioSinIva());
	            ps.setString(12, v.getMatricula());
	            ps.setInt(13, v.getDisponibilidad());
	            ps.setBytes(14, v.getFoto());
	            ps.executeUpdate();
	        }catch(SQLException ex){
	            System.out.println("A "+ex.getMessage());
	        }catch(Exception ex){
	            System.out.println("B "+ex.getMessage());
	        }finally{
	            try{
	                ps.close();
	                conec.desconectar();
	            }catch(Exception ex){}
	        }
	    }


	/*Metodo Modificar*/
	    public void editVehiculo(Vehiculo v){
	    	//conectamos a la base de datos
	        Conectar conec = new Conectar();
	        //variables para predefinir el orden de las variables
	        String sql = "UPDATE vehiculo SET marca = ?, modelo = ?, estado = ?, tipoOferta = ?, kilometros = ?, cilindrada = ?, precio = ?, tipoCombustible = ?, tipoCambio = ?, anyoFabricacion = ?, precioSinIva = ?, matricula = ?, dispo = ?, foto = ?\n" +
	"WHERE idVehiculo = ?;";
	        PreparedStatement ps = null;
	        try{
	        	ps = conec.getConnection().prepareStatement(sql);
	            ps.setString(1, v.getMarca());
	            ps.setString(2, v.getModelo());
	            ps.setString(3, v.getEstado());
	            ps.setString(4, v.getTipoOferta());
	            ps.setInt(5, v.getKilometros());
	            ps.setString(6, v.getCilindrada());
	            ps.setDouble(7, v.getPrecio());
	            ps.setString(8, v.getTipoCombustible());
	            ps.setString(9, v.getTipoCambio());
	            ps.setInt(10, v.getAnyoFabricacion());
	            ps.setDouble(11, v.getPrecioSinIva());
	            ps.setString(12, v.getMatricula());
	            ps.setInt(13, v.getDisponibilidad());
	            ps.setBytes(14, v.getFoto());
	            ps.setInt(15, v.getIdVehiculo());
	            ps.executeUpdate();
	        }catch(SQLException ex){
	            System.out.println(ex.getMessage());
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }finally{
	            try{
	                ps.close();
	                conec.desconectar();
	            }catch(Exception ex){}
	        }
	    }

	/*Metodo Eliminar*/
	    public void delVehiculo(Vehiculo v){
	    	//Conectamos
	        Conectar conec = new Conectar();
	        // predefinimos el mensaje para borrar segun id
	        String sql = "DELETE FROM vehiculo WHERE idVehiculo = ?;";
	        PreparedStatement ps = null;
	        try{
	        	//preparamos la paremetrizacion de la variable sqp
	            ps = conec.getConnection().prepareStatement(sql);
	            //a traves de la id del vehiculo se borraran todos los datos
	            ps.setInt(1, v.getIdVehiculo());
	            ps.executeUpdate();
	        }catch(SQLException ex){
	            System.out.println(ex.getMessage());
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }finally{
	            try{
	                ps.close();
	                conec.desconectar();
	            }catch(Exception ex){}
	        }
	    }


}
