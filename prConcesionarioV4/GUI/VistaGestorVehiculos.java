package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.GestorVehiculos;
import Model.Vehiculo;
import Tabla.TablaGestorVehiculos;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.Color;

@SuppressWarnings("serial")
public class VistaGestorVehiculos extends JFrame {

	  private javax.swing.JButton BtnFoto;
	    private javax.swing.JButton BtnAdd;
	    private javax.swing.JButton BtnEdit;
	    private javax.swing.JButton BtnDel;
	    private javax.swing.JButton BtnClean;
	    private javax.swing.JButton BtnExit;
	    private javax.swing.JButton BtnSearch;
	    private javax.swing.JButton calcular;

	    private JLabel texto_Modelo;
	    private javax.swing.JLabel texto_Precio;
	    private javax.swing.JLabel texto_Marca;
	    private javax.swing.JLabel texto_Codigo;
	    private javax.swing.JLabel texto_Estado;
	    private javax.swing.JLabel texto_TipoOferta;
	    private javax.swing.JLabel texto_Kilometros;
	    private javax.swing.JLabel texto_Cilindrada;
	    private javax.swing.JLabel texto_TipoCombustible;
	    private javax.swing.JLabel texto_TipoCambio;
	    private javax.swing.JLabel texto_AnyoFabricacion;
	    private javax.swing.JLabel texto_PrecioSinIva;
	    private javax.swing.JLabel texto_Matricula;
	    private javax.swing.JLabel texto_Disp;
	    
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    
	    private javax.swing.JScrollPane jScrollPane1;
	    
	    private javax.swing.JTable tabla;
	    
	    private javax.swing.JTextField txtc;
	    private javax.swing.JTextField txtMarca;
	    private javax.swing.JTextField txtModelo;
	    private javax.swing.JComboBox<String> txtEstado;
	    private javax.swing.JTextField txtPrecio;
	    private javax.swing.JTextField txtRuta;
	    private javax.swing.JComboBox<String> txtTipoOferta;
	    private javax.swing.JTextField txtKilometros;
	    private javax.swing.JTextField txtCilindrada;
	    private javax.swing.JComboBox<String> txtTipoCombustible;
	    private javax.swing.JComboBox<String> txtTipoCambio;
	    private javax.swing.JTextField txtAnyoFabricacion;
	    private javax.swing.JTextField txtPrecioSinIva;
	    private javax.swing.JTextField txtMatricula;
	    private javax.swing.JComboBox<String> txtDisp;
	    
	    private JComboBox<String> filtro;
  
  GestorVehiculos dao;
  Vehiculo vo = new Vehiculo();
  TablaGestorVehiculos t = new TablaGestorVehiculos();
  
  int codigo = 0;
  public int idVendedor;
  public String rol;
  private JPanel panel;
  
  public VistaGestorVehiculos(int id,String r) {
  	getContentPane().setBackground(new Color(224, 255, 255));
	  idVendedor = id;
	  rol = r;
      initComponents();
      filtro.setSelectedIndex(0);
      
      t.verVehiculos(tabla, filtro.getSelectedItem().toString(),rol);
      
      panel = new JPanel();
      panel.setBackground(new Color(224, 255, 255));
      GroupLayout groupLayout = new GroupLayout(getContentPane());
      groupLayout.setHorizontalGroup(
      	groupLayout.createParallelGroup(Alignment.LEADING)
      		.addGroup(groupLayout.createSequentialGroup()
      			.addContainerGap()
      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1567, Short.MAX_VALUE)
      				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 1567, Short.MAX_VALUE))
      			.addPreferredGap(ComponentPlacement.RELATED)
      			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
      				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
      				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addContainerGap())
      );
      groupLayout.setVerticalGroup(
      	groupLayout.createParallelGroup(Alignment.TRAILING)
      		.addGroup(groupLayout.createSequentialGroup()
      			.addGap(12)
      			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
      					.addGap(15)
      					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
      					.addGap(26)
      					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)))
      			.addContainerGap())
      );
      getContentPane().setLayout(groupLayout);
      
      setExtendedState(MAXIMIZED_BOTH);
  }

  
  public void limpiar(){
      txtc.setText("");
      txtMarca.setText("");
      txtModelo.setText("");
      txtKilometros.setText("");
      txtCilindrada.setText("");
      txtAnyoFabricacion.setText("");
      txtPrecioSinIva.setText("");
      txtPrecio.setText("");
      txtMatricula.setText("");
      txtRuta.setText("");
      codigo = 0;
  }
  
  private void initComponents() {

      jScrollPane1 = new javax.swing.JScrollPane();
      tabla = new javax.swing.JTable();
      jPanel1 = new javax.swing.JPanel();
      jPanel1.setBackground(new Color(175, 238, 238));
      jPanel2 = new javax.swing.JPanel();
      jPanel2.setBackground(new Color(175, 238, 238));
      
      BtnAdd = new javax.swing.JButton();
      BtnDel = new javax.swing.JButton();
      BtnEdit = new javax.swing.JButton();
      BtnClean = new javax.swing.JButton();
      BtnFoto = new javax.swing.JButton();
      BtnSearch = new javax.swing.JButton();
      BtnExit = new javax.swing.JButton();
      
      texto_Marca = new javax.swing.JLabel();
      texto_Modelo = new javax.swing.JLabel();
      texto_Precio = new javax.swing.JLabel();
      texto_Estado = new javax.swing.JLabel();
      texto_Modelo = new javax.swing.JLabel();
      texto_Codigo = new javax.swing.JLabel();
      texto_TipoOferta = new javax.swing.JLabel();
      texto_Kilometros = new javax.swing.JLabel();
      texto_Cilindrada = new javax.swing.JLabel();
      texto_TipoCombustible = new javax.swing.JLabel();
      texto_TipoCambio = new javax.swing.JLabel();
      texto_AnyoFabricacion = new javax.swing.JLabel();
      texto_PrecioSinIva = new javax.swing.JLabel();
      texto_Matricula = new javax.swing.JLabel();
      texto_Disp = new javax.swing.JLabel();   
      
      txtRuta = new javax.swing.JTextField();
      txtMarca = new javax.swing.JTextField();
      txtPrecio = new javax.swing.JTextField();
      txtModelo = new javax.swing.JTextField();
      txtEstado = new javax.swing.JComboBox<String>();
      txtEstado.addItem("Nuevo");
      txtEstado.addItem("Seminuevo");
      txtTipoOferta = new javax.swing.JComboBox<String>();
      txtTipoOferta.addItem("Venta");
      txtTipoOferta.addItem("Alquiler");
      txtKilometros = new javax.swing.JTextField();
      txtCilindrada = new javax.swing.JTextField();
      txtTipoCombustible = new javax.swing.JComboBox<String>();
      txtTipoCombustible.addItem("Gasolina");
      txtTipoCombustible.addItem("Diésel");
      txtTipoCombustible.addItem("GLP");
      txtTipoCombustible.addItem("Eléctrico");
      txtTipoCombustible.addItem("Híbrido");
      txtTipoCambio = new javax.swing.JComboBox<String>();
      txtTipoCambio.addItem("Manual");
      txtTipoCambio.addItem("Automático");
      txtAnyoFabricacion = new javax.swing.JTextField();
      txtPrecioSinIva = new javax.swing.JTextField();
      txtMatricula = new javax.swing.JTextField();
      txtDisp = new javax.swing.JComboBox<String>();
      txtDisp.addItem("Si");
      txtDisp.addItem("No");
      
      txtc = new javax.swing.JTextField();
      filtro = new JComboBox<String>();
      filtro.addItem("default");
      filtro.addItem("marca");
      filtro.addItem("modelo");
      filtro.addItem("estado");
      filtro.addItem("tipoOferta");
      filtro.addItem("kilometros");
      filtro.addItem("cilindrada");
      filtro.addItem("tipoCombustible");
      filtro.addItem("tipoCambio");
      filtro.addItem("AnyoFabricacion");
      filtro.addItem("matricula");
      
      calcular = new javax.swing.JButton();
      calcular.setText("QUITAR IVA");
      calcular.addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent evt) {
    		 BtnCalcActionPerformed(evt);
    	 } 
      });
      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("Gestor de vehiculos");

      tabla.setModel(new javax.swing.table.DefaultTableModel(
          new Object [][] {
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null}
          },
          new String [] {
              "ID Vehiculo", "Marca", "Modelo", "Estado", "Tipo Oferta", "Precio", "Kilometros", "Cilindrada", "Combustible", "Cambio", "Año", "PrecioSinIva", "Matricula", "Imagen"
          }
      ));
      tabla.addMouseListener(new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
              tablaMouseClicked(evt);
          }
      });
      jScrollPane1.setViewportView(tabla);

      jPanel1.setBorder(null);

      BtnAdd.setText("Agregar");
      BtnAdd.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              BtnAddActionPerformed(evt);
          }
      });

      BtnDel.setText("Eliminar");
      BtnDel.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              BtnDelActionPerformed(evt);
          }
      });

      BtnEdit.setText("Modificar");
      BtnEdit.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              BtnEditActionPerformed(evt);
          }
      });

      BtnClean.setText("Limpiar");
      BtnClean.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              BtnCleanActionPerformed(evt);
          }
      });
      
      BtnExit.setText("Atrás");
      BtnExit.addActionListener(new java.awt.event.ActionListener() {
      	public void actionPerformed(java.awt.event.ActionEvent evt) {
      		BtnExitActionPerformed(evt);
      	}
      });
      
      BtnSearch.setText("Filtrar");
      BtnSearch.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              BtnSearchActionPerformed(evt);
          }
      });
      
     

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
          jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(BtnAdd)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
              .addComponent(BtnEdit)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
              .addComponent(BtnDel)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
              .addComponent(BtnClean)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
              .addComponent(BtnExit)
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
                  .addComponent(BtnAdd)
                  .addComponent(BtnDel)
                  .addComponent(BtnEdit)
                  .addComponent(BtnClean)
                  .addComponent(BtnExit)
                  .addComponent(filtro)
                  .addComponent(BtnSearch))
              .addGap(18, 18, 18)
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jPanel2.setBorder(null);

      txtRuta.setEditable(false);
      txtRuta.setBackground(new java.awt.Color(204, 204, 255));

      BtnFoto.setText("Foto");
      BtnFoto.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              BtnFotoActionPerformed(evt);
          }
      });

      texto_Marca.setText("Marca:");

      texto_Modelo.setText("Modelo:");
      
      texto_Estado.setText("Estado:");
      
      texto_TipoOferta.setText("Tipo Oferta:");
      
      texto_Kilometros.setText("Kilómetros");
      
      texto_Cilindrada.setText("Cilindrada:");
      
      texto_TipoCombustible.setText("Combustible:");
      
      texto_TipoCambio.setText("Cambio:");
      
      texto_AnyoFabricacion.setText("Año de Fabricación:");
      
      texto_PrecioSinIva.setText("Precio sin Iva:");
      
      texto_Matricula.setText("Matricula:");
      
      texto_Disp.setText("Disponible:");

      texto_Precio.setText("Importe:");
      
      texto_Codigo.setText("Codigo:");

      txtc.setEditable(false);
      txtc.setBackground(new java.awt.Color(204, 204, 255));

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2Layout.setHorizontalGroup(
      	jPanel2Layout.createParallelGroup(Alignment.LEADING)
      		.addGroup(jPanel2Layout.createSequentialGroup()
      			.addContainerGap()
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false)
      				.addGroup(jPanel2Layout.createSequentialGroup()
      					.addComponent(txtRuta, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
      					.addGap(18)
      					.addComponent(BtnFoto, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
      				.addGroup(jPanel2Layout.createSequentialGroup()
      					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
      						.addComponent(texto_Marca)
      						.addComponent(texto_Modelo)
      						.addComponent(texto_Precio)
      						.addComponent(texto_TipoCombustible)
      						.addComponent(texto_TipoCambio)
      						.addComponent(texto_AnyoFabricacion)
      						.addComponent(texto_PrecioSinIva)
      						.addComponent(texto_Codigo)
      						.addComponent(texto_Matricula)
      						.addComponent(texto_Disp)
      						.addComponent(texto_Estado)
      						.addComponent(texto_TipoOferta)
      						.addComponent(texto_Kilometros)
      						.addComponent(texto_Cilindrada))
      					.addGap(18)
      					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
      						.addComponent(txtCilindrada, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
      						.addComponent(txtKilometros, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
      						.addComponent(txtTipoOferta, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      						.addComponent(txtEstado, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      						.addComponent(txtMatricula, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
      						.addComponent(txtMarca, Alignment.LEADING)
      						.addComponent(txtModelo, Alignment.LEADING)
      						.addComponent(txtPrecio, Alignment.LEADING)
      						.addComponent(txtTipoCombustible, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      						.addComponent(txtTipoCambio, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      						.addComponent(txtAnyoFabricacion, Alignment.LEADING)
      						.addComponent(txtc, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
      						.addGroup(jPanel2Layout.createSequentialGroup()
      							.addComponent(txtPrecioSinIva, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
      							.addPreferredGap(ComponentPlacement.UNRELATED)
      							.addComponent(calcular))
      						.addComponent(txtDisp, Alignment.LEADING, 0, 183, Short.MAX_VALUE))))
      			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel2Layout.setVerticalGroup(
      	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
      		.addGroup(jPanel2Layout.createSequentialGroup()
      			.addContainerGap()
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(texto_Codigo)
      				.addComponent(txtc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addGap(20)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(texto_Marca)
      				.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addGap(18)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(texto_Modelo)
      				.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addPreferredGap(ComponentPlacement.UNRELATED)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(texto_Estado)
      				.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addGap(14)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
      				.addComponent(texto_TipoOferta)
      				.addComponent(txtTipoOferta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addGap(18)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(texto_Kilometros)
      				.addComponent(txtKilometros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addPreferredGap(ComponentPlacement.UNRELATED)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(texto_Cilindrada)
      				.addComponent(txtCilindrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addGap(18)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(texto_Precio)
      				.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addGap(18)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(texto_TipoCombustible)
      				.addComponent(txtTipoCombustible, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addGap(18)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(texto_TipoCambio)
      				.addComponent(txtTipoCambio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addGap(18)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(texto_AnyoFabricacion)
      				.addComponent(txtAnyoFabricacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addGap(18)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(texto_PrecioSinIva)
      				.addComponent(txtPrecioSinIva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      				.addComponent(calcular))
      			.addGap(18)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(texto_Matricula)
      				.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addGap(18)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(txtDisp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      				.addComponent(texto_Disp))
      			.addGap(18)
      			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
      				.addComponent(txtRuta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      				.addComponent(BtnFoto))
      			.addContainerGap())
      );
      jPanel2.setLayout(jPanel2Layout);

      pack();
      setLocationRelativeTo(null);
  }

  private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {
	 	VistaPanelEmpleado e = new VistaPanelEmpleado(idVendedor,rol); 
		String n = VistaIniciarSesion.ponerNombre(idVendedor);
		e.bienvenido.setText("Bienvenido, " + n);
		e.setVisible(true);
		dispose();
	}
  
  private void BtnCleanActionPerformed(java.awt.event.ActionEvent evt) {
      limpiar();
  }
  
  private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {
  	t.verVehiculos(tabla,filtro.getSelectedItem().toString(),rol);
  }
  
  private void BtnFotoActionPerformed(java.awt.event.ActionEvent evt) {
      JFileChooser j = new JFileChooser();
      FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
      j.setFileFilter(fil);
      
      int s = j.showOpenDialog(this);
      if(s == JFileChooser.APPROVE_OPTION){
          String ruta = j.getSelectedFile().getAbsolutePath();
          txtRuta.setText(ruta);
      }
  }

  private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {
      int disp = 0; 
      String marca = txtMarca.getText();
      String modelo = txtModelo.getText();
      String estado = txtEstado.getSelectedItem().toString();
      String tipoOferta = txtTipoOferta.getSelectedItem().toString();
      double precio = Double.parseDouble(txtPrecio.getText());
      int kilometros = Integer.parseInt(txtKilometros.getText());
      String cilindrada = txtCilindrada.getText();
      String combustible = txtTipoCombustible.getSelectedItem().toString();
      String cambio = txtTipoCambio.getSelectedItem().toString();
      int anyo = Integer.parseInt(txtAnyoFabricacion.getText());
      double precioSinIva = Double.parseDouble(txtPrecioSinIva.getText());
      String matricula = txtMatricula.getText();
      if(txtDisp.getSelectedItem().toString().equals("Si")) {
    	  disp = 1;
      }
      File ruta = new File(txtRuta.getText());
      
      this.agregar(marca, modelo, estado, tipoOferta, precio, kilometros, cilindrada, combustible, cambio, anyo, precioSinIva, matricula,disp,ruta);
      t.verVehiculos(tabla,filtro.getSelectedItem().toString(),rol);
      
  }

  private void tablaMouseClicked(java.awt.event.MouseEvent evt) {
      int clic = tabla.rowAtPoint(evt.getPoint());
      
      codigo = (int)tabla.getValueAt(clic, 0);
      String marca = ""+tabla.getValueAt(clic, 1);
      String modelo = ""+tabla.getValueAt(clic, 2);
      String estado = ""+tabla.getValueAt(clic, 3);
      String tipoOferta = ""+tabla.getValueAt(clic, 4);
      double precio = (double)tabla.getValueAt(clic, 5);
      int kilometros = (int)tabla.getValueAt(clic, 6);
      String cilindrada = ""+tabla.getValueAt(clic, 7);
      String tipoCombustible = ""+tabla.getValueAt(clic, 8);
      String tipoCambio = ""+tabla.getValueAt(clic, 9);
      int AnyoFabricacion = (int)tabla.getValueAt(clic, 10);
      double precioSinIva = (double)tabla.getValueAt(clic, 11);
      String matricula = ""+tabla.getValueAt(clic, 12);
      
      txtc.setText(String.valueOf(codigo));
      System.out.println(txtc);
      txtMarca.setText(marca);
      txtModelo.setText(modelo);
      
      switch(estado) {
	      case "Nuevo": txtEstado.setSelectedIndex(0); break;
	      case "Seminuevo": txtEstado.setSelectedIndex(1); break;
      }
      
      switch(tipoOferta) {
	      case "Venta": txtTipoOferta.setSelectedIndex(0); break;
	      case "Alquiler": txtTipoOferta.setSelectedIndex(1); break;
      }

      txtKilometros.setText(String.valueOf(kilometros));
      txtCilindrada.setText(String.valueOf(cilindrada));
      txtPrecio.setText(String.valueOf(precio));
 
      switch(tipoCombustible) {
	      case "Gasolina:": txtTipoCombustible.setSelectedIndex(0); break;
	      case "Diésel": txtTipoCombustible.setSelectedIndex(1); break;
	      case "GLP": txtTipoCombustible.setSelectedIndex(2); break;
	      case "Eléctrico": txtTipoCombustible.setSelectedIndex(3); break;
	      case "Híbrido": txtTipoCombustible.setSelectedIndex(4); break;
      }

      switch(tipoCambio) {
	      case "Manual": txtTipoCambio.setSelectedIndex(0); break;
	      case "Automático": txtTipoCambio.setSelectedIndex(1); break;
      }

      txtAnyoFabricacion.setText(String.valueOf(AnyoFabricacion));
      txtPrecioSinIva.setText(String.valueOf(precioSinIva));
      txtMatricula.setText(matricula);
      txtRuta.setText("");
      
  }

  private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {
      int disp = 0;
	  int id = Integer.parseInt(txtc.getText());
      String marca = txtMarca.getText();
      String modelo = txtModelo.getText();
      String estado = txtEstado.getSelectedItem().toString();
      String tipoOferta = txtTipoOferta.getSelectedItem().toString();
      double precio = Double.parseDouble(txtPrecio.getText());
      int kilometros = Integer.parseInt(txtKilometros.getText());
      String cilindrada = txtCilindrada.getText();
      String tipoCombustible = txtTipoCombustible.getSelectedItem().toString();
      String tipoCambio = txtTipoCambio.getSelectedItem().toString();
      int anyoFabricacion = Integer.parseInt(txtAnyoFabricacion.getText());
      double precioSinIva = Double.parseDouble(txtPrecioSinIva.getText());
      String matricula = txtMatricula.getText();
      if(txtDisp.getSelectedItem().toString().equals("Si")) {
    	  disp = 1;
      } 
      File ruta = new File(txtRuta.getText());
      
      this.modificar(marca, modelo, estado, tipoOferta, precio, kilometros, cilindrada, tipoCombustible, tipoCambio, anyoFabricacion, precioSinIva, matricula, disp, ruta, id);
      t.verVehiculos(tabla,filtro.getSelectedItem().toString(),rol);
      limpiar();
  }

  private void BtnDelActionPerformed(java.awt.event.ActionEvent evt) {
      int id = Integer.parseInt(txtc.getText());
      int a = JOptionPane.showConfirmDialog(null, "Desea eliminar este producto","Mensaje",JOptionPane.OK_CANCEL_OPTION);
      if(a == 0){
          this.eliminar(id);
          limpiar();
      }
      t.verVehiculos(tabla,filtro.getSelectedItem().toString(),rol);
  }

  private void BtnCalcActionPerformed(ActionEvent evt) {
	  double PrecioSinIva = Double.parseDouble(txtPrecio.getText()) - (0.21*Double.parseDouble(txtPrecio.getText()));
	  txtPrecioSinIva.setText(String.valueOf(PrecioSinIva));
  }
  
  public void agregar(String marca, String modelo, String estado, String tipoOferta, double precio, int kilometros, String cilindrada, String combustible, String cambio, int anyo, double precioSinIva, String matricula, int disp, File ruta){
      Vehiculo v = new Vehiculo();
      dao = new GestorVehiculos();
     
      v.setMarca(marca);
      v.setModelo(modelo);
      v.setEstado(estado);
      v.setTipoOferta(tipoOferta);
      v.setPrecio(precio);
      v.setKilometros(kilometros);
      v.setCilindrada(cilindrada);
      v.setTipoCombustible(combustible);
      v.setTipoCambio(cambio);
      v.setAnyoFabricacion(anyo);
      v.setPrecioSinIva(precioSinIva);
      v.setMatricula(matricula);
      v.setDisponibilidad(disp);
      
      try{
          byte[] icono = new byte[(int) ruta.length()];
          InputStream input = new FileInputStream(ruta);
          input.read(icono);
          v.setFoto(icono);
          input.close();
      }catch(Exception ex){
          v.setFoto(null);
      }
      dao.addVehiculo(v);
      limpiar();
  }
  
  public void modificar(String marca, String modelo, String estado, String tipoOferta, double precio, int kilometros, String cilindrada, String combustible, String cambio, int anyo, double precioSinIva, String matricula, int disp, File ruta, int id){
      Vehiculo v = new Vehiculo();
      dao = new GestorVehiculos();
      
      v.setIdVehiculo(id);
      v.setMarca(marca);
      v.setModelo(modelo);
      v.setEstado(estado);
      v.setTipoOferta(tipoOferta);
      v.setPrecio(precio);
      v.setKilometros(kilometros);
      v.setCilindrada(cilindrada);
      v.setTipoCombustible(combustible);
      v.setTipoCambio(cambio);
      v.setAnyoFabricacion(anyo);
      v.setPrecioSinIva(precioSinIva);
      v.setMatricula(matricula);
      v.setDisponibilidad(disp);
      
      try{
          byte[] icono = new byte[(int) ruta.length()];
          InputStream input = new FileInputStream(ruta);
          input.read(icono);
          v.setFoto(icono);
          input.close();
      }catch(Exception ex){
          v.setFoto(null);
      }
      dao.editVehiculo(v);
  }
   
  public void eliminar(int id){
      Vehiculo v = new Vehiculo();
      dao = new GestorVehiculos();
      
      v.setIdVehiculo(codigo);
      
      dao.delVehiculo(v);
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
          java.util.logging.Logger.getLogger(VistaGestorVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(VistaGestorVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(VistaGestorVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(VistaGestorVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      
      java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
          	VistaGestorVehiculos v = new VistaGestorVehiculos(0,null);
          	v.setVisible(true);

          }
      });
  } 
}
