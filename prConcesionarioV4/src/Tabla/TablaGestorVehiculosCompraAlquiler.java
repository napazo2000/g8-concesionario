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

import Model.GestorVehiculos;

/*En esta clase, lo que vamos a construir es la tabla correspondiente a la gestor vehiculo, la cual está conectada a la base de datos,
con las mismas variables que tiene gestor vehiculo, por tanto, en esta clase, vamos a ir añadiendo cada columna con un orden específico,
que estará en función de lo que se haya configurado previamente. Primero añadiremos cada columna con las varibles, y posteriormente
haremos un bucle que recorrar toda la tabla, y en cada fila le asocie un valor que obtendremos de los getter de la clase gestor vehiculo
*/

public class TablaGestorVehiculosCompraAlquiler{

	   GestorVehiculos dao = null;


	    @SuppressWarnings("serial")
		public void verVehiculos(JTable tabla, String filtro, String tipoOferta){
	        
	    	tabla.setDefaultRenderer(Object.class, new Render());
	        DefaultTableModel dt = new DefaultTableModel(){
	            @Override
	            public boolean isCellEditable(int row, int column){
	                return false;
	            }
	        };
	        dt.addColumn("ID Vehiculo");
	        dt.addColumn("Marca");
	        dt.addColumn("Modelo");
	        dt.addColumn("Estado");
	        dt.addColumn("Precio");
	        dt.addColumn("Kilometros");
	        dt.addColumn("Cilindrada");
	        dt.addColumn("Combustible");
	        dt.addColumn("Cambio");
	        dt.addColumn("Año");
	        dt.addColumn("Matricula");
	        dt.addColumn("Foto");

	        dao = new GestorVehiculos();
	        Model.Vehiculo v = new Model.Vehiculo();
	        ArrayList<Model.Vehiculo> list = dao.verVehiculos(filtro, tipoOferta, "Empleado");

	        if(list.size() > 0){
	            for(int i=0; i<list.size(); i++){
	                Object fila[] = new Object[12];
	                v = list.get(i);
	                fila[0] = v.getIdVehiculo();
	                fila[1] = v.getMarca();
	                fila[2] = v.getModelo();
	                fila[3] = v.getEstado();
	                fila[4] = v.getPrecio();
	                fila[5] = v.getKilometros();
	                fila[6] = v.getCilindrada();
	                fila[7] = v.getTipoCombustible();
	                fila[8] = v.getTipoCambio();
	                fila[9] = v.getAnyoFabricacion();
	                fila[10] = v.getMatricula();
	                
	                try{
	                    byte[] bi = v.getFoto();
	                    BufferedImage image = null;
	                    InputStream in = new ByteArrayInputStream(bi);
	                    image = ImageIO.read(in);
	                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(150, 150, 0));
	                    fila[11] = new JLabel(imgi);

	                }catch(Exception ex){
	                    fila[11] = new JLabel("No imagen");
	                }
	                dt.addRow(fila);
	            }
	            tabla.setModel(dt);
	            tabla.setRowHeight(100);
	        }
	    }
	}

