package Visual;

import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.GestorOperacion;
import Model.Operacion;
import Tabla.TablaGestorOperacion;

@SuppressWarnings("serial")
public class VistaGestorOperaciones extends JFrame {
	//variables
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnDel;
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnSearch;
    private javax.swing.JButton BtnClean;
    
    private javax.swing.JLabel texto_IDoperacion;
    private javax.swing.JLabel texto_IDvendedor;
    private javax.swing.JLabel texto_IDvehiculo;
    private javax.swing.JLabel texto_IDcliente;
    private javax.swing.JLabel texto_fecha;
    private javax.swing.JLabel texto_NumDias;
    private javax.swing.JLabel texto_Importe;
    private javax.swing.JLabel texto_Financiacion;
    private javax.swing.JLabel texto_Meses;
    private javax.swing.JLabel texto_FormaPago;
    private javax.swing.JLabel texto_TipoOferta;
    
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    
    private javax.swing.JScrollPane jScrollPane1;
    
    private javax.swing.JTable tabla;
    
    private javax.swing.JTextField txtc;
    private javax.swing.JTextField txtIDvendedor;
    private javax.swing.JTextField txtIDvehiculo;
    private javax.swing.JTextField txtIDcliente;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNumDias;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JComboBox<String> txtFinanciacion;
    private javax.swing.JTextField txtMeses;
    private javax.swing.JComboBox<String> txtFormaPago;
    private javax.swing.JComboBox<String> txtTipoOferta;
    
    private JComboBox<String> filtro;
    
GestorOperacion gu;
Operacion u = new Operacion();
TablaGestorOperacion t = new TablaGestorOperacion();

int codigo = 0;

public int idVendedor;
public String tipoRol;

public VistaGestorOperaciones(int id, String rol) {
	idVendedor = id;
	tipoRol = rol;
	//inicia componentes
    initComponents();
	//inicializa el filtro en 0(sin seleccion)
    filtro.setSelectedIndex(0);
    
    t.verOperaciones(tabla, filtro.getSelectedItem().toString());
    
    setExtendedState(MAXIMIZED_BOTH);
}
//metodo limpiar, establece todas las variables vacias
public void limpiar(){
    txtc.setText("");
    txtIDvendedor.setText("");
    txtIDvehiculo.setText("");
    txtIDcliente.setText("");
    txtNumDias.setText("");
    txtImporte.setText("");
    txtMeses.setText("");
    codigo = 0;
}
//metodo inicia componentes
private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    tabla = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    
    BtnDel = new javax.swing.JButton();
    BtnEdit = new javax.swing.JButton();
    BtnClean = new javax.swing.JButton();
    BtnSearch = new javax.swing.JButton();
    BtnBack = new javax.swing.JButton();
    
    texto_IDoperacion = new javax.swing.JLabel();
    texto_IDvendedor = new javax.swing.JLabel();
    texto_IDvehiculo = new javax.swing.JLabel();
    texto_IDcliente = new javax.swing.JLabel();
    texto_fecha = new javax.swing.JLabel();
    texto_NumDias = new javax.swing.JLabel();
    texto_Importe = new javax.swing.JLabel();
    texto_Financiacion = new javax.swing.JLabel();
    texto_Meses = new javax.swing.JLabel();
    texto_FormaPago = new javax.swing.JLabel();
    texto_TipoOferta = new javax.swing.JLabel();  
    
    txtIDvendedor = new javax.swing.JTextField();
    txtIDvehiculo = new javax.swing.JTextField();
    txtIDcliente = new javax.swing.JTextField();
    txtFecha = new com.toedter.calendar.JDateChooser();
    txtNumDias = new javax.swing.JTextField();
    txtImporte = new javax.swing.JTextField();
    txtMeses = new javax.swing.JTextField();
    txtc = new javax.swing.JTextField();
    //añadir las distintas opciones del filtro
    filtro = new JComboBox<String>();
    filtro.addItem("default");
    filtro.addItem("IDvendedor");
    filtro.addItem("IDvehiculo");
    filtro.addItem("IDcliente");
    filtro.addItem("Date");
    filtro.addItem("Numdias");
    filtro.addItem("Importe");
    filtro.addItem("Financiacion");
    filtro.addItem("Meses");
    filtro.addItem("Formapago");
    filtro.addItem("Tipooferta");
    //opciones de financiacion
    txtFinanciacion = new javax.swing.JComboBox<String>();
    txtFinanciacion.addItem("Si");
    txtFinanciacion.addItem("No");
    //opciones de forma de pago
    txtFormaPago = new javax.swing.JComboBox<String>();
    txtFormaPago.addItem("Efectivo");
    txtFormaPago.addItem("Tarjeta");
    txtFormaPago.addItem("Transferencia");
    //opciones de tipo de pago
    txtTipoOferta = new javax.swing.JComboBox<String>();
    txtTipoOferta.addItem("Venta");
    txtTipoOferta.addItem("Alquiler");
    
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Gestor de operaciones");

    tabla.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
	    //orden de variables
        new String [] {
            "ID Operacion", "ID Vendedor", "ID Vehiculo", "ID Cliente", "Fecha", "Número de días", "Importe", "Financiación", "Meses", "Forma de pago", "Tipo de oferta"
        }
    ));
	//boton añadir
    tabla.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablaMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tabla);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
	//boton eliminar
    BtnDel.setText("Eliminar");
    BtnDel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnDelActionPerformed(evt);
        }
    });
	//boton modificar
    BtnEdit.setText("Modificar");
    BtnEdit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnEditActionPerformed(evt);
        }
    });
	//boton limpiar
    BtnClean.setText("Limpiar");
    BtnClean.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnCleanActionPerformed(evt);
        }
    });
    //boton atras, para volver al menu principal
    BtnBack.setText("Atrás");
    BtnBack.addActionListener(new java.awt.event.ActionListener() {
    	public void actionPerformed(ActionEvent evt) {
    		BtnBackActionPerformed(evt);
    	}
    });
    //boton filtrar, para filtrar los vehiculo según preferencias
    BtnSearch.setText("Filtrar");
    BtnSearch.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnSearchActionPerformed(evt);
        }
    });
    
   
	//paneles 
    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(BtnEdit)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
            .addComponent(BtnDel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
            .addComponent(BtnClean)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
            .addComponent(BtnBack)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
            .addComponent(filtro)
            .addComponent(BtnSearch)
            .addGap(10, 10, 10)
            )
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            	.addComponent(BtnDel)
                .addComponent(BtnEdit)
                .addComponent(BtnClean)
                .addComponent(BtnBack)
                .addComponent(filtro)
                .addComponent(BtnSearch))
            .addGap(18, 18, 18)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
	//marca texto para cada opcion
    texto_IDoperacion.setText("ID operación:");
    
    texto_IDvendedor.setText("ID vendedor:");

    texto_IDvehiculo.setText("ID vehiculo:");
    
    texto_IDcliente.setText("ID cliente:");
    
    texto_fecha.setText("Fecha:");
    
    texto_NumDias.setText("Número de días:");
    
    texto_Importe.setText("Importe:");
    
    texto_Financiacion.setText("Financiación:");
    
    texto_Meses.setText("Meses:");
    
    texto_FormaPago.setText("Forma de pago:");
    
    texto_TipoOferta.setText("Tipo de oferta:");

    txtc.setEditable(false);
    txtc.setBackground(new java.awt.Color(204, 204, 255));
	//paneles con opciones de operacion
    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
             .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                		.addComponent(texto_IDvendedor)
                		.addComponent(texto_IDvehiculo)
                		.addComponent(texto_IDcliente)
                		.addComponent(texto_fecha)
                		.addComponent(texto_NumDias)
                		.addComponent(texto_Importe)
                		.addComponent(texto_Financiacion)
                		.addComponent(texto_Meses)
                		.addComponent(texto_FormaPago)
                		.addComponent(texto_TipoOferta)
                        .addComponent(texto_IDoperacion)
                        )
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtIDvendedor)
                        .addComponent(txtIDvehiculo)
                        .addComponent(txtIDcliente)
                        .addComponent(txtFecha)
                        .addComponent(txtNumDias)
                        .addComponent(txtImporte)
                        .addComponent(txtFinanciacion)
                        .addComponent(txtMeses)
                        .addComponent(txtFormaPago)
                        .addComponent(txtTipoOferta)
                        .addComponent(txtc, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        )))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_IDoperacion)
                    .addComponent(txtc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 20)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(texto_IDvendedor)
                .addComponent(txtIDvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_IDvehiculo)
                    .addComponent(txtIDvehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18) 
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_IDcliente)
                    .addComponent(txtIDcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 20)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_fecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 20)    
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_NumDias)
                    .addComponent(txtNumDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Importe)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Financiacion)
                    .addComponent(txtFinanciacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)                
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Meses)
                    .addComponent(txtMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_FormaPago)
                    .addComponent(txtFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_TipoOferta)
                    .addComponent(txtTipoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)  
            .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            		.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
               )
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(5, 10)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            		.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
            		.addGroup(layout.createSequentialGroup()
                		 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                		 .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                   )
                )
            .addContainerGap())
    );

    pack();
    setLocationRelativeTo(null);
}
//accion boton limpiar
private void BtnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCleanActionPerformed
    limpiar();
}
//accion boton buscar
private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {
	t.verOperaciones(tabla,filtro.getSelectedItem().toString());
}
//accion dentro de la tabla
private void tablaMouseClicked(java.awt.event.MouseEvent evt) {
    int clic = tabla.rowAtPoint(evt.getPoint());
    //obtenemos para cada variable su valor
    codigo = (int)tabla.getValueAt(clic, 0);
    int vendedor = (int)tabla.getValueAt(clic, 1);
    int vehiculo = (int)tabla.getValueAt(clic, 2);
    int cliente = (int)tabla.getValueAt(clic, 3);
    int NumDias = (int)tabla.getValueAt(clic, 5);
    double importe = (double)tabla.getValueAt(clic, 6);
    String finan = ""+tabla.getValueAt(clic, 7);
    int meses = (int)tabla.getValueAt(clic, 8);
    String pago = ""+tabla.getValueAt(clic, 9);
    String oferta = ""+tabla.getValueAt(clic, 10);
    
    txtc.setText(String.valueOf(codigo));
    System.out.println(txtc);
    txtIDvendedor.setText(String.valueOf(vendedor));
    txtIDvehiculo.setText(String.valueOf(vehiculo));
    txtIDcliente.setText(String.valueOf(cliente));
    txtNumDias.setText(String.valueOf(NumDias));
    txtImporte.setText(String.valueOf(importe));
   
    if(finan.equals("Si")) {
    	txtFinanciacion.setSelectedIndex(0);
    } else {
    	txtFinanciacion.setSelectedIndex(1);
    }
   
    txtMeses.setText(String.valueOf(meses));
   
    if(pago.equals("Efectivo")) {
    	txtFormaPago.setSelectedIndex(0);
    } else if(pago.equals("Tarjeta")) {
    	txtFormaPago.setSelectedIndex(1);
    } else {
    	txtFormaPago.setSelectedIndex(2);
    }
    
    if(oferta.equals("Venta")) {
    	txtTipoOferta.setSelectedIndex(0);
    } else {
    	txtTipoOferta.setSelectedIndex(1);
    }
  
}
//accion boton editar,  mofidica las variables sobre una operacion ya creada
private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {
    int id = Integer.parseInt(txtc.getText());
    int vendedor = Integer.parseInt(txtIDvendedor.getText());
    int vehiculo = Integer.parseInt(txtIDvehiculo.getText());
    int cliente = Integer.parseInt(txtIDcliente.getText());
    Date date = txtFecha.getDate();
	String fecNac = DateFormat.getDateInstance().format(date);
	int NumDias = Integer.parseInt(txtNumDias.getText());
    double importe = Double.parseDouble(txtImporte.getText());
    String finan = txtFinanciacion.getSelectedItem().toString();
    int meses = Integer.parseInt(txtMeses.getText());
    String formaPago = txtFormaPago.getSelectedItem().toString();
    String tipoOferta = txtTipoOferta.getSelectedItem().toString();
    
    this.modificar(vendedor, vehiculo, cliente, fecNac, NumDias, importe, finan, meses, formaPago, tipoOferta, id);
    t.verOperaciones(tabla,filtro.getSelectedItem().toString());
    limpiar();
}
//accion boton eleminar, eliminar la operacion seleccionada
private void BtnDelActionPerformed(java.awt.event.ActionEvent evt) {
    int id = Integer.parseInt(txtc.getText());
    int a = JOptionPane.showConfirmDialog(null, "Desea eliminar este producto","Mensaje",JOptionPane.OK_CANCEL_OPTION);
    if(a == 0){
        this.eliminar(id);
        limpiar();
    }
    t.verOperaciones(tabla,filtro.getSelectedItem().toString());
}
//accion boton volver, vuelve al panel del mecánico
private void BtnBackActionPerformed(ActionEvent evt) {
	VistaPanelEmpleado e = new VistaPanelEmpleado(idVendedor,tipoRol); 
	String n = VistaIniciarSesion.ponerNombre(idVendedor);
	e.bienvenido.setText("Bienvenido, " + n);
	e.setVisible(true);
	dispose();
}
//modifica los valores de las variables
public void modificar(int idvendedor,int IDvehiculo, int iDcliente, String date, int numdias, double importe, String financiacion, int meses, String formapago, String tipooferta, int id){
    Operacion o = new Operacion();
    gu = new GestorOperacion();
    
    o.setIDoperacion(id);
    o.setIdvendedor(idvendedor);
    o.setIDvehiculo(IDvehiculo);
    o.setIDcliente(iDcliente);
    o.setDate(date);
    o.setNumdias(numdias);
    o.setImporte(importe);
    o.setFinanciacion(financiacion);
    o.setMeses(meses);
    o.setFormapago(formapago);
    o.setTipooferta(tipooferta);
    gu.editOperacion(o);
}
 
public void eliminar(int id){
    Operacion o = new Operacion();
    gu = new GestorOperacion();
    
    o.setIDoperacion(codigo);
    
    gu.delOperacion(o);
}
/**
 * @param args the command line arguments
 */
public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(VistaGestorOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(VistaGestorOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(VistaGestorOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(VistaGestorOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

   java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        	VistaGestorOperaciones v = new VistaGestorOperaciones(0,null);
        	v.setVisible(true);

        }
    });
} 
}
