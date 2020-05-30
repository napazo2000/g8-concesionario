package Tabla;

import Model.GestorUsuarios;
import Model.Usuario;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*En esta clase, lo que vamos a construir es la tabla correspondiente a la Usuarios, la cual está conectada a la base de datos,
con las mismas variables que tiene operación, por tanto, en esta clase, vamos a ir añadiendo cada columna con un orden específico,
que estará en función de lo que se haya configurado previamente. Primero añadiremos cada columna con las varibles, y posteriormente
haremos un bucle que recorrar toda la tabla, y en cada fila le asocie un valor que obtendremos de los getter de la clase Usuario. En 
este caso, al tener que añadir una foto es necesario un try-catch para lanzar la excepción
*/

public class TablaGestorUsuarios{

   GestorUsuarios dao = null;


    @SuppressWarnings("serial")
	public void verUsuarios(JTable tabla, String filtro){
        
    	tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("ID Usuario");
        dt.addColumn("Correo");
        dt.addColumn("Contraseña");
        dt.addColumn("DNI");
        dt.addColumn("Nombre");
        dt.addColumn("Apellidos");
        dt.addColumn("Fecha Nacimiento");
        dt.addColumn("Móvil");
        dt.addColumn("Dirección");
        dt.addColumn("Código Postal");
        dt.addColumn("Ciudad");
        dt.addColumn("Provincia");
       dt.addColumn("Imagen");

        dao = new GestorUsuarios();
        Model.Usuario u = new Model.Usuario();
        ArrayList<Usuario> list = dao.verUsuarios(filtro);

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[13];
                u = list.get(i);
                fila[0] = u.getIdUsuario();
                fila[1] = u.getCorreo();
                fila[2] = u.getPassword();
                fila[3] = u.getDni();
                fila[4] = u.getNombre();
                fila[5] = u.getApellidos();
                fila[6] = u.getFecNacimiento();
                fila[7] = u.getMovil();
                fila[8] = u.getDireccion();
                fila[9] = u.getCodPostal();
                fila[10] = u.getCiudad();
                fila[11] = u.getProvincia();
               
                try{
                    byte[] bi = u.getFoto();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(150, 150, 0));
                    fila[12] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[12] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(100);
        }
    }
}


