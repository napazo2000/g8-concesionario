package Tabla;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.GestorUsuarios;
import Model.Usuario;
/*En esta clase, lo que vamos a construir es la tabla correspondiente a la Gestor Usuario, la cual está conectada a la base de datos,
con las mismas variables que tiene operación, por tanto, en esta clase, vamos a ir añadiendo cada columna con un orden específico,
que estará en función de lo que se haya configurado previamente. Primero añadiremos cada columna con las varibles, y posteriormente
haremos un bucle que recorrar toda la tabla, y en cada fila le asocie un valor que obtendremos de los getter de la clase Gestor usuario
*/

public class TablaGestorUsuariosCompraAlquiler{

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
	        dt.addColumn("DNI");
	        dt.addColumn("Nombre");
	        dt.addColumn("Apellidos");
	        dt.addColumn("Fecha Nacimiento");
	        dt.addColumn("Móvil");
	        dt.addColumn("Imagen");

	        dao = new GestorUsuarios();
	        Model.Usuario u = new Model.Usuario();
	        ArrayList<Usuario> list = dao.verUsuarios(filtro);

	        if(list.size() > 0){
	            for(int i=0; i<list.size(); i++){
	                Object fila[] = new Object[8];
	                u = list.get(i);
	                fila[0] = u.getIdUsuario();
	                fila[1] = u.getCorreo();
	                fila[2] = u.getDni();
	                fila[3] = u.getNombre();
	                fila[4] = u.getApellidos();
	                fila[5] = u.getFecNacimiento();
	                fila[6] = u.getMovil();
	               
	                try{
	                    byte[] bi = u.getFoto();
	                    BufferedImage image = null;
	                    InputStream in = new ByteArrayInputStream(bi);
	                    image = ImageIO.read(in);
	                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(150, 150, 0));
	                    fila[7] = new JLabel(imgi);

	                }catch(Exception ex){
	                    fila[7] = new JLabel("No imagen");
	                }
	                dt.addRow(fila);
	            }
	            tabla.setModel(dt);
	            tabla.setRowHeight(100);
	        }
	    }
	}
