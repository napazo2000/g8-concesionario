package Model;

import Conexion.Conectar;

import java.sql.*;
import java.util.ArrayList;


/*Metodo listar*/
public class GestorOperacion{

	  public ArrayList<Operacion> verOperaciones(String filtro){
	        ArrayList<Operacion> list = new ArrayList<Operacion>();
	        Conectar conec = new Conectar();
	        String sql;
	        if(filtro.equals("default")) {
	        	sql = "SELECT * FROM operacion";
	        }
	        else {
	        	sql = "SELECT * FROM operacion ORDER BY +" + filtro + "";
	        }
	        ResultSet rs = null;
	        PreparedStatement ps = null;
	        try{
	            ps = conec.getConnection().prepareStatement(sql);
	            rs = ps.executeQuery();
	            while(rs.next()){
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
	        }catch(SQLException ex){
	            System.out.println(ex.getMessage());
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }finally{
	            try{
	                ps.close();
	                rs.close();
	                conec.desconectar();
	            }catch(Exception ex){}
	        }
	        return list;
	    }
	  

	/*Metodo agregar*/
	    public void addOperacion(Operacion u){
	        Conectar conec = new Conectar();
	        String sql = "INSERT INTO operacion (IDoperacion, Idvendedor, IDvehiculo, IDcliente, Date, Numdias, Importe, Financiacion, Meses, Formapago)\n" +
	"VALUES (NULL,?,?,?,?,?,?,?,?,?,?);";
	        PreparedStatement ps = null;
	        try{
	            ps = conec.getConnection().prepareStatement(sql);
	            ps.setInt(1, u.getIDoperacion());
	            ps.setInt(2, u.getIdvendedor());
	            ps.setInt(3, u.getIDvehiculo());
	            ps.setInt(4, u.getIDcliente());
	            ps.setString(5, u.getDate());
	            ps.setInt(6, u.getNumdias());
	            ps.setDouble(7, u.getImporte());
	            ps.setString(8, u.getFinanciacion());
	            ps.setInt(9, u.getMeses());
	            ps.setString(10, u.getFormapago());
	            ps.setString(11, u.getTipooferta());
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
	    public void editOperacion(Operacion u){
	        Conectar conec = new Conectar();
	        String sql = "UPDATE operacion SET Idvendedor = ?, IDvehiculo = ?, IDcliente = ?, Date = ?, Numdias = ?, Importe = ?, Financiacion = ?, Meses = ?, Formapago = ?\n" +
	"WHERE IDoperacion = ?;";
	        PreparedStatement ps = null;
	        try{
	            ps = conec.getConnection().prepareStatement(sql);
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
	                ps.close();
	                conec.desconectar();
	            }catch(Exception ex){}
	        }
	    }

	/*Metodo Eliminar*/
	    public void delOperacion(Operacion u){
	        Conectar conec = new Conectar();
	        String sql = "DELETE FROM usuario WHERE  IDoperacion = ?;";
	        PreparedStatement ps = null;
	        try{
	            ps = conec.getConnection().prepareStatement(sql);
	            ps.setInt(1, u.getIDoperacion());
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
