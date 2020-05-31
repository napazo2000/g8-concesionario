package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import Model.GestorVehiculos;
import Model.Vehiculo;
import Tabla.TablaGestorUsuariosCompraAlquiler;
import Tabla.TablaGestorVehiculosCompraAlquiler;

@SuppressWarnings("serial")
public class VistaAlquiler extends JFrame {

	private javax.swing.JLabel title;
	private javax.swing.JLabel texto_Vehiculo;
	private javax.swing.JTextField txtCodigoV;
	private javax.swing.JLabel texto_Cliente;
	private javax.swing.JTextField txtCodigoC;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tablaVehiculos;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable tablaClientes;
	private javax.swing.JPanel botonera;
	private javax.swing.JButton BtnBack;
	private javax.swing.JButton BtnSig;
	private javax.swing.JButton BtnFiltroV;
	private javax.swing.JButton BtnFiltroC;
	private javax.swing.JComboBox<String> filtroV;
	private javax.swing.JComboBox<String> filtroC;
	
	public int idVendedor;
	public String tipoRol;
	//creamos un objeto tipo gestoVehiculo
	GestorVehiculos gestorV;
	//inicializamos un objeto tipo vehiculo
    Vehiculo v = new Vehiculo();
	//inicializamos variables de tablas
    TablaGestorVehiculosCompraAlquiler tablaV = new TablaGestorVehiculosCompraAlquiler();
    TablaGestorUsuariosCompraAlquiler tablaC = new TablaGestorUsuariosCompraAlquiler();
    
    int codigoV = 0;
    int codigoC = 0;
	
    public VistaAlquiler(int id, String rol) {
	    //variables
    	idVendedor = id;
    	tipoRol = rol;
    	System.out.print(idVendedor);
	    //iniciamos componentes
        initComponents();
	    //ampliamos tabla a tamaño maximo de pantalla
        setExtendedState(MAXIMIZED_BOTH);
        //a traves de las tablas creadas anteriormente, utilizamos metodo de cada clase, ver vehiculo y ver usuarios
       tablaV.verVehiculos(tablaVehiculos, "default","Alquiler");
       tablaC.verUsuarios(tablaClientes, "default");
    }

    private void initComponents() {
	//tipografia
    	Font negrita = new Font("Calibri", Font.BOLD, 30);
    	
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ASISTENTE DE ALQUILER");
        //datos visuales
        title = new javax.swing.JLabel();        
        title.setText("  Asistente de alquiler");
        title.setFont(negrita);
        
        texto_Vehiculo = new javax.swing.JLabel();
        texto_Vehiculo.setText("Vehículo seleccionado:");
        
        texto_Cliente = new javax.swing.JLabel();
        texto_Cliente.setText("Cliente seleccionado:");
        
        txtCodigoV = new javax.swing.JTextField();
        txtCodigoC = new javax.swing.JTextField();
        
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        tablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
		//variable con orden de datos de vehiculo
            new String [] {
                "ID Vehiculo", "Marca", "Modelo", "Estado", "Precio", "Kilometros", "Cilindrada", "Combustible", "Cambio", "Año", "PrecioSinIva","Matricula", "Unidades", "Imagen"
            }
        ));
	    //para que funcionen los botones
        tablaVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVehiculosMouseClicked(evt);
            }
        });
        //paneles visuales
        jScrollPane1.setViewportView(tablaVehiculos);
   
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
		//variable con datos de usuario
                new String [] {
                    "ID Usuario", "Correo", "Password", "DNI", "Nombre", "Apellidos", "Fecha de Nacimiento", "Móvil", "Dirección", "Código postal", "Ciudad", "Provincia", "Tipo de Rol", "Imagen"
                }
            ));
            tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tablaClientesMouseClicked(evt);
                }
            });
            jScrollPane2.setViewportView(tablaClientes);
            
            //boton atrás
            BtnBack = new javax.swing.JButton();
            BtnBack.setText("Atrás");
            BtnBack.addActionListener(new java.awt.event.ActionListener() {
            	public void actionPerformed(ActionEvent evt) {
					BtnBackActionPerformed(evt);}
            });
            //botón siguiente
            BtnSig = new javax.swing.JButton();
            BtnSig.setText("Siguiente");
            BtnSig.addActionListener(new java.awt.event.ActionListener() {
            	public void actionPerformed(ActionEvent evt) {
					BtnSigActionPerformed(evt);
				}
            });
        	//parametros para filtrar por vehiculo
            filtroV = new javax.swing.JComboBox<String>();
            filtroV.addItem("default");
            filtroV.addItem("marca");
            filtroV.addItem("modelo");
            filtroV.addItem("estado");
            filtroV.addItem("tipoOferta");
            filtroV.addItem("kilometros");
            filtroV.addItem("cilindrada");
            filtroV.addItem("tipoCombustible");
            filtroV.addItem("tipoCambio");
            filtroV.addItem("AnyoFabricacion");
            filtroV.addItem("matricula");
            filtroV.addItem("unidades");
            
            //botón del filtro
            BtnFiltroV = new javax.swing.JButton();
            BtnFiltroV.setText("Filtrar vehiculo");
            BtnFiltroV.addActionListener(new java.awt.event.ActionListener() {
            	public void actionPerformed(ActionEvent evt) {
            		BtnFiltroVActionPerformed(evt);
				}
            });
            //filtrar por usuario
            filtroC = new javax.swing.JComboBox<String>();
            filtroC.addItem("default");
            filtroC.addItem("correo");
            filtroC.addItem("dni");
            filtroC.addItem("nombre");
            filtroC.addItem("apellidos");
            filtroC.addItem("fecNac");
            filtroC.addItem("movil");
            filtroC.addItem("direccion");
            filtroC.addItem("codPostal");
            filtroC.addItem("ciudad");
            filtroC.addItem("provincia");
            filtroC.addItem("tipoRol");
           
            BtnFiltroC = new javax.swing.JButton();
            BtnFiltroC.setText("Filtrar cliente");
            BtnFiltroC.addActionListener(new java.awt.event.ActionListener() {
            	public void actionPerformed(ActionEvent evt) {
					BtnFiltroCActionPerformed(evt);	
				}
            });
	    //panel horizontal
            //ajustes de los botones, añadiendo los datos del vehiculo y los botones correspondientes
            botonera = new javax.swing.JPanel();
            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(botonera);
            botonera.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(BtnBack)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addComponent(filtroV)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addComponent(BtnFiltroV)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addComponent(texto_Vehiculo)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addComponent(txtCodigoV,  javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addComponent(filtroC)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addComponent(BtnFiltroC)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addComponent(texto_Cliente)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addComponent(txtCodigoC,  javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addComponent(BtnSig)
                    .addGap(10, 10, 10)
                    )
            );
	    //panel vertical
	    //panel donde se alojan los componentes del filtro y los botones
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnBack)
                        .addComponent(filtroV)
                        .addComponent(BtnFiltroV)
                        .addComponent(texto_Vehiculo)
                        .addComponent(txtCodigoV)
                        .addComponent(filtroC)
                        .addComponent(BtnFiltroC)
                        .addComponent(texto_Cliente)
                        .addComponent(txtCodigoC)
                        .addComponent(BtnSig))
                    .addGap(18, 18, 18)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 300,  javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
            		.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720,  javax.swing.GroupLayout.PREFERRED_SIZE)
            		.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640,  javax.swing.GroupLayout.PREFERRED_SIZE)
            		)
            .addComponent(botonera)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 80,  javax.swing.GroupLayout.PREFERRED_SIZE)
            
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
             )
            .addGroup(layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                   .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(botonera)
            		)
        );

        pack(); 
    }
	//seleecion del vehiculo al hacer click encima
    private void tablaVehiculosMouseClicked(MouseEvent evt) {
    	 int clic = tablaVehiculos.rowAtPoint(evt.getPoint());
       
         codigoV = (int)tablaVehiculos.getValueAt(clic, 0);
         txtCodigoV.setText(String.valueOf(codigoV));
    }
    
    private void tablaClientesMouseClicked(MouseEvent evt) {
   	 int clic = tablaClientes.rowAtPoint(evt.getPoint());
      
        codigoC = (int)tablaClientes.getValueAt(clic, 0);
        txtCodigoC.setText(String.valueOf(codigoC));
   }
    //boton volver
    private void BtnBackActionPerformed(ActionEvent evt) {
    	VistaPanelEmpleado e = new VistaPanelEmpleado(idVendedor,tipoRol); 
		String n = VistaIniciarSesion.ponerNombre(idVendedor);
		e.bienvenido.setText("Bienvenido, " + n);
		e.setVisible(true);
		dispose();
	  }
    //boton filtro vehiculo
    private void BtnFiltroVActionPerformed(ActionEvent evt) {
	    //utiliza la variable tablaV para ver los vehiculos, introduciendo los parametros correspondientes
    	tablaV.verVehiculos(tablaVehiculos,filtroV.getSelectedItem().toString(), "Alquiler");
    }
    //boton filtro usuario
    private void BtnFiltroCActionPerformed(ActionEvent evt) {
	     //utiliza la variable tablaC para ver los usuarios, introduciendo los parametros correspondientes
    	tablaC.verUsuarios(tablaClientes,filtroC.getSelectedItem().toString()); 	
    }
    //boton siguiente
    private void BtnSigActionPerformed(ActionEvent evt) {
	   //varible tipo vistaAlquiler y lo inicializa con parametros
    	VistaAlquiler2 v = new VistaAlquiler2(codigoV,codigoC, idVendedor, tipoRol);
    	v.setVisible(true);
    	dispose();
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAlquiler(0,null).setVisible(true);
            }
        });
    }
}

