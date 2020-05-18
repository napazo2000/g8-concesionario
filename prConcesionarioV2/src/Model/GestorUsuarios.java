package Model;

import Conexion.Conectar;

import java.sql.*;
import java.util.ArrayList;


/*Metodo listar*/
public class GestorUsuarios{

	  public ArrayList<Usuario> verUsuarios(String filtro){
	        ArrayList<Usuario> list = new ArrayList<Usuario>();
	        Conectar conec = new Conectar();
	        String sql;
	        if(filtro.equals("default")) {
	        	sql = "SELECT * FROM usuario";
	        }
	        else {
	        	sql = "SELECT * FROM usuario ORDER BY +" + filtro + "";
	        }
	        ResultSet rs = null;
	        PreparedStatement ps = null;
	        try{
	            ps = conec.getConnection().prepareStatement(sql);
	            rs = ps.executeQuery();
	            while(rs.next()){
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
	    public void addUsuario(Usuario u){
	        Conectar conec = new Conectar();
	        String sql = "INSERT INTO usuario (idUsuario, correo, password, dni, nombre, apellidos, fecNac, movil, direccion, codPostal, ciudad, provincia, tipoRol, foto)\n" +
	"VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	        PreparedStatement ps = null;
	        try{
	            ps = conec.getConnection().prepareStatement(sql);
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
	                ps.close();
	                conec.desconectar();
	            }catch(Exception ex){}
	        }
	    }


	/*Metodo Modificar*/
	    public void editUsuario(Usuario u){
	        Conectar conec = new Conectar();
	        String sql = "UPDATE usuario SET correo = ?, password = ?, dni = ?, nombre = ?, apellidos = ?, fecNac = ?, movil = ?, direccion = ?, codPostal = ?, ciudad = ?, provincia = ?, tipoRol = ?, foto = ?\n" +
	"WHERE idUsuario = ?;";
	        PreparedStatement ps = null;
	        try{
	            ps = conec.getConnection().prepareStatement(sql);
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
	                ps.close();
	                conec.desconectar();
	            }catch(Exception ex){}
	        }
	    }

	/*Metodo Eliminar*/
	    public void delUsuario(Usuario u){
	        Conectar conec = new Conectar();
	        String sql = "DELETE FROM usuario WHERE idUsuario = ?;";
	        PreparedStatement ps = null;
	        try{
	            ps = conec.getConnection().prepareStatement(sql);
	            ps.setInt(1, u.getIdUsuario());
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