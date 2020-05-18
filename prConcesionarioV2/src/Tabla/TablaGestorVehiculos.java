package Tabla;

import Model.GestorVehiculos;
import Model.Vehiculo;
import Model.GestorVehiculos;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class TablaGestorVehiculos{

   GestorVehiculos dao = null;


    public void verVehiculos(JTable tabla, String filtro){
        
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
        dt.addColumn("Tipo de Oferta");
        dt.addColumn("Precio");
        dt.addColumn("Kilometros");
        dt.addColumn("Cilindrada");
        dt.addColumn("Combustible");
        dt.addColumn("Cambio");
        dt.addColumn("Año");
        dt.addColumn("Sin Iva");
        dt.addColumn("Matricula");
        dt.addColumn("Unidades");
        dt.addColumn("Foto");

        dao = new GestorVehiculos();
        Model.Vehiculo v = new Model.Vehiculo();
        ArrayList<Model.Vehiculo> list = dao.verVehiculos(filtro, "all");

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[15];
                v = list.get(i);
                fila[0] = v.getIdVehiculo();
                fila[1] = v.getMarca();
                fila[2] = v.getModelo();
                fila[3] = v.getEstado();
                fila[4] = v.getTipoOferta();
                fila[5] = v.getPrecio();
                fila[6] = v.getKilometros();
                fila[7] = v.getCilindrada();
                fila[8] = v.getTipoCombustible();
                fila[9] = v.getTipoCambio();
                fila[10] = v.getAnyoFabricacion();
                fila[11] = v.getPrecioSinIva();
                fila[12] = v.getMatricula();
                fila[13] = v.getUnidades();
                
                try{
                    byte[] bi = v.getFoto();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(150, 150, 0));
                    fila[14] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[14] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(100);
        }
    }
}


