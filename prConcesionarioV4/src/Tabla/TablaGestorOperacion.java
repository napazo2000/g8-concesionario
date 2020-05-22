package Tabla;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.GestorOperacion;
import Model.Operacion;

public class TablaGestorOperacion {
	 GestorOperacion dao = null;


	    @SuppressWarnings("serial")
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
	        dt.addColumn("Fecha");
	        dt.addColumn("Días");
	        dt.addColumn("Importe");
	        dt.addColumn("Financiación");
	        dt.addColumn("Meses");
	        dt.addColumn("Forma de pago");
	        dt.addColumn("Tipo de oferta");

	        dao = new GestorOperacion();
	        Operacion u = new Model.Operacion();
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
