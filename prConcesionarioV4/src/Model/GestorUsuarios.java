package Model;

import Conexion.Conectar;

import java.sql.*;
import java.util.ArrayList;


/*Metodo listar*/
public class GestorUsuarios{
	//clase para ver usuarios
	  public ArrayList<Usuario> verUsuarios(String filtro){
		  //creamos una lista
	        ArrayList<Usuario> list = new ArrayList<Usuario>();
		  		  //conectamos a mySql
	        Conectar conec = new Conectar();
	        String sql;
		  //bucle para las opciones del filtro
	        if(filtro.equals("default")) {
	        	sql = "SELECT * FROM usuario WHERE tipoRol = 'Cliente'";
	        }
		  //opciones dentro del filtro
	        else {
	        	sql = "SELECT * FROM usuario WHERE tipoRol = 'Cliente' ORDER BY +" + filtro + "";
	        }
	        ResultSet rs = null;
	        PreparedStatement ps = null;
	        try{
	            ps = conec.getConnection().prepareStatement(sql);
	            rs = ps.executeQuery();
			//bucle para el listado de las operaciones, que ira recorriendo cada operación
	            while(rs.next()){
			     //parametros de operacion
	                Usuario u = new Usuario();
	                u.setIdUsuario(rs.getInt(1));
	                u.setCorreo(rs.getString(2));
	                u.setPassword(rs.getString(3));
	                u.setDni(rs.getString(4));
	                u.setNombre(rs.getString(5));
	                u.setApellidos(rs.getString(6));
	                u.setFecNacimiento(rs.getString(7));
	                u.setMovil(rs.getInt(8));
	                u.setDireccion(rs.getString(9));
	                u.setCodPostal(rs.getInt(10));
	                u.setCiudad(rs.getString(11));
	                u.setProvincia(rs.getString(12));
	                u.setTipoRol(rs.getString(13));
	                u.setFoto(rs.getBytes(14));
	                list.add(u);
	            }
			//captura de excepciones
	        }catch(SQLException ex){
	            System.out.println(ex.getMessage());
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }finally{
	            try{
			    //cerramos las variables abiertas para el recorrido de los bucles
	                ps.close();
	                rs.close();
			     //nos desconectamos de la base de datos
	                conec.desconectar();
	            }catch(Exception ex){}
	        }
		  //nos devuelve la lista con los parametros
	        return list;
	    }


	/*Metodo agregar*/
	    public void addUsuario(Usuario u){
		    //conectamos a la base de datos
	        Conectar conec = new Conectar();
		    //variable con orden de parametros
	        String sql = "INSERT INTO usuario (idUsuario, correo, password, dni, nombre, apellidos, fecNac, movil, direccion, codPostal, ciudad, provincia, tipoRol, foto)\n" +
	"VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	        PreparedStatement ps = null;
	        try{
			//ps conecta a la base de datos y le introduce el orden de parametros
	            ps = conec.getConnection().prepareStatement(sql);
			//obtenemos cada variable ordenada según la variable sql y devolvemos el valor de cada parametro
	            ps.setString(1, u.getCorreo());
	            ps.setString(2, u.getPassword());
	            ps.setString(3, u.getDni());
	            ps.setString(4, u.getNombre());
	            ps.setString(5, u.getApellidos());
	            ps.setString(6, u.getFecNacimiento());
	            ps.setInt(7, u.getMovil());
	            ps.setString(8, u.getDireccion());
	            ps.setInt(9, u.getCodPostal());
	            ps.setString(10, u.getCiudad());
	            ps.setString(11, u.getProvincia());
	            ps.setString(12, u.getTipoRol());
	            ps.setBytes(13, u.getFoto());
	            ps.executeUpdate();
	        }catch(SQLException ex){
	            System.out.println("A "+ex.getMessage());
	        }catch(Exception ex){
	            System.out.println("B "+ex.getMessage());
	        }finally{
	            try{
			     //cerramos variables y desconectamos de la base de datos
	                ps.close();
	                conec.desconectar();
	            }catch(Exception ex){}
	        }
	    }


	/*Metodo Modificar*/
	    public void editUsuario(Usuario u){
		      //conectamos a la base de datos
	        Conectar conec = new Conectar();
		    //variable con orden de variables
	        String sql = "UPDATE usuario SET correo = ?, password = ?, dni = ?, nombre = ?, apellidos = ?, fecNac = ?, movil = ?, direccion = ?, codPostal = ?, ciudad = ?, provincia = ?, tipoRol = ?, foto = ?\n" +
	"WHERE idUsuario = ?;";
	        PreparedStatement ps = null;
	        try{
			//ps conecta a la base de datos y le introduce el orden de parametros
	            ps = conec.getConnection().prepareStatement(sql);
			//obtenemos cada variable ordenada según la variable sql y devolvemos el valor de cada parametro
	            ps.setString(1, u.getCorreo());
	            ps.setString(2, u.getPassword());
	            ps.setString(3, u.getDni());
	            ps.setString(4, u.getNombre());
	            ps.setString(5, u.getApellidos());
	            ps.setString(6, u.getFecNacimiento());
	            ps.setInt(7, u.getMovil());
	            ps.setString(8, u.getDireccion());
	            ps.setInt(9, u.getCodPostal());
	            ps.setString(10, u.getCiudad());
	            ps.setString(11, u.getProvincia());
	            ps.setString(12, u.getTipoRol());
	            ps.setBytes(13, u.getFoto());
	            ps.setInt(14, u.getIdUsuario());
	            ps.executeUpdate();
	        }catch(SQLException ex){
	            System.out.println(ex.getMessage());
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }finally{
	            try{
			     //cerramos variables y desconectamos de la base de datos
	                ps.close();
	                conec.desconectar();
	            }catch(Exception ex){}
	        }
	    }

	/*Metodo Eliminar*/
	    public void delUsuario(Usuario u){
		      //conectamos a la base de datos
	        Conectar conec = new Conectar();
		    //varible donde borraremos una operación desde su id
	        String sql = "DELETE FROM usuario WHERE idUsuario = ?;";
	        PreparedStatement ps = null;
	        try{
			//ps conecta a la base de datos y le introduce el orden de parametros
	            ps = conec.getConnection().prepareStatement(sql);
			//conseguimos el id de la operacion
	            ps.setInt(1, u.getIdUsuario());
			//actualizamos el estado de la operacion, que será eliminarlo
	            ps.executeUpdate();
	        }catch(SQLException ex){
	            System.out.println(ex.getMessage());
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }finally{
	            try{
			    //cerramos variable y desconectamos de la base de datos
	                ps.close();
	                conec.desconectar();
	            }catch(Exception ex){}
	        }
	    }


}
