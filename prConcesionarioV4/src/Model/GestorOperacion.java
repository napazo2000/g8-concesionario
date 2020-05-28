package Model;

import Conexion.Conectar;

import java.sql.*;
import java.util.ArrayList;


/*Metodo listar*/
public class GestorOperacion{
	//clase para ver operaciones
	  public ArrayList<Operacion> verOperaciones(String filtro){
		  //creamos una lista
	        ArrayList<Operacion> list = new ArrayList<Operacion>();
		  //conectamos a mySql
	        Conectar conec = new Conectar();
	        String sql;
		  //bucle para las opciones del filtro
	        if(filtro.equals("default")) {
	        	sql = "SELECT * FROM operacion";
	        }
		  //opciones dentro del filtro
	        else {
	        	sql = "SELECT * FROM operacion ORDER BY +" + filtro + "";
	        }
	        ResultSet rs = null;
	        PreparedStatement ps = null;
		  
	        try{
			
	            ps = conec.getConnection().prepareStatement(sql);
	            rs = ps.executeQuery();
			//bucle para el listado de las operaciones, que ira recorriendo cada operación
	            while(rs.next()){
			    //parametros de operacion
	                Operacion u = new Operacion();
	                u.setIDoperacion(rs.getInt(1));
	                u.setIdvendedor(rs.getInt(2));
	                u.setIDvehiculo(rs.getInt(3));
	                u.setIDcliente(rs.getInt(4));
	                u.setDate(rs.getString(5));
	                u.setNumdias(rs.getInt(6));
	                u.setImporte(rs.getDouble(7));
	                u.setFinanciacion(rs.getString(8));
	                u.setMeses(rs.getInt(9));
	                u.setFormapago(rs.getString(10));
	                u.setTipooferta(rs.getString(11));
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
	    public void addOperacion(Operacion u){
		    //conectamos a la base de datos
	        Conectar conec = new Conectar();
		    //variable con orden de parametros
	        String sql = "INSERT INTO operacion (IDoperacion, Idvendedor, IDvehiculo, IDcliente, Date, Numdias, Importe, Financiacion, Meses, Formapago)\n" +
	"VALUES (NULL,?,?,?,?,?,?,?,?,?,?);";
	        PreparedStatement ps = null;
	        try{
			//ps conecta a la base de datos y le introduce el orden de parametros
	            ps = conec.getConnection().prepareStatement(sql);
			//obtenemos cada variable ordenada según la variable sql y devolvemos el valor de cada parametro
	            ps.setInt(1, u.getIdvendedor());
	            ps.setInt(2, u.getIDvehiculo());
	            ps.setInt(3, u.getIDcliente());
	            ps.setString(4, u.getDate());
	            ps.setInt(5, u.getNumdias());
	            ps.setDouble(6, u.getImporte());
	            ps.setString(7, u.getFinanciacion());
	            ps.setInt(8, u.getMeses());
	            ps.setString(9, u.getFormapago());
	            ps.setString(10, u.getTipooferta());
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
	    public void editOperacion(Operacion u){
		    //conectamos a la base de datos
	        Conectar conec = new Conectar();
		    //variable con orden de variables
	        String sql = "UPDATE operacion SET Idvendedor = ?, IDvehiculo = ?, IDcliente = ?, Date = ?, Numdias = ?, Importe = ?, Financiacion = ?, Meses = ?, Formapago = ?, Tipooferta = ?\n" +
	"WHERE IDoperacion = ?;";
	        PreparedStatement ps = null;
	        try{
			//ps conecta a la base de datos y le introduce el orden de parametros
	            ps = conec.getConnection().prepareStatement(sql);
			//obtenemos cada variable ordenada según la variable sql y devolvemos el valor de cada parametro
	            ps.setInt(1, u.getIdvendedor());
	            ps.setInt(2, u.getIDvehiculo());
	            ps.setInt(3, u.getIDcliente());
	            ps.setString(4, u.getDate());
	            ps.setInt(5, u.getNumdias());
	            ps.setDouble(6, u.getImporte());
	            ps.setString(7, u.getFinanciacion());
	            ps.setInt(8, u.getMeses());
	            ps.setString(9, u.getFormapago());
	            ps.setString(10, u.getTipooferta());
	            ps.setInt(11, u.getIDoperacion());
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
	    public void delOperacion(Operacion u){
		    //conectamos a la base de datos
	        Conectar conec = new Conectar();
		    //varible donde borraremos una operación desde su id
	        String sql = "DELETE FROM operacion WHERE  IDoperacion = ?;";
	        PreparedStatement ps = null;
	        try{
			//ps conecta a la base de datos y le introduce el orden de parametros
	            ps = conec.getConnection().prepareStatement(sql);
			//conseguimos el id de la operacion
	            ps.setInt(1, u.getIDoperacion());
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
