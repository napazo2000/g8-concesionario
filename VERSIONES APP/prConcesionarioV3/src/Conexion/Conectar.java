package Conexion;

import java.sql.*;

public class Conectar{

    static String bd = "concesionario";
    static String login = "root";
    static String password = "admin";
    static String url = "jdbc:mysql://localhost/"+bd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    Connection connection = null;

    public Conectar(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url,login,password);
        if (connection!=null){
            System.out.println("Conexion a base de datos "+bd+" OK\n");
        }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void desconectar(){
        try{
            System.out.println("Cerrando conexion");
            connection.close();
        }catch(Exception ex){}
    }


}
