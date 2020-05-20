package Tabla;

import Model.GestorOperacion;
import Model.Operacion;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class TablaGestorOperacion{

   GestorOperacion dao = null;


    public void verOperaciones(JTable tabla, String filtro){
        
    	tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("ID Operacion");
        dt.addColumn("ID Vendedor");
        dt.addColumn("ID Vehiculo");
        dt.addColumn("ID Cliente");
        dt.addColumn("Date");
        dt.addColumn("Numero Dias");
        dt.addColumn("Importe");
        dt.addColumn("Financiacion");
        dt.addColumn("Meses");
        dt.addColumn("Forma Pago");
        dt.addColumn("Tipo Oferta");
        
        dao = new GestorOperacion();
        Model.Operacion u = new Model.Operacion();
        ArrayList<Operacion> list = dao.verOperaciones(filtro);

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[11];
                u = list.get(i);
                fila[0] = u.getIDoperacion();
                fila[1] = u.getIdvendedor();
                fila[2] = u.getIDvehiculo();
                fila[3] = u.getIDcliente();
                fila[4] = u.getDate();
                fila[5] = u.getNumdias();
                fila[6] = u.getImporte();
                fila[7] = u.getFinanciacion();
                fila[8] = u.getMeses();
                fila[9] = u.getFormapago();
                fila[10] = u.getTipooferta();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(100);
        }
    }
}


