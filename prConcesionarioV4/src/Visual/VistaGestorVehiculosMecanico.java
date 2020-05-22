package Visual;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import Conexion.Conectar;
import Model.GestorVehiculos;
import Model.Vehiculo;
import Tabla.TablaGestorVehiculos;

@SuppressWarnings("serial")
public class VistaGestorVehiculosMecanico extends JFrame {
	    private javax.swing.JButton BtnEdit;
	    private javax.swing.JButton BtnExit;
	    private javax.swing.JButton BtnSearch;
	    private javax.swing.JLabel texto_Codigo;
	    private javax.swing.JLabel texto_Disp;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTable tabla;
	    private javax.swing.JTextField txtc;
	    private javax.swing.JComboBox<String> txtDisp;
	    private JComboBox<String> filtro;
  
  GestorVehiculos dao;
  Vehiculo vo = new Vehiculo();
  TablaGestorVehiculos t = new TablaGestorVehiculos();
  
  int codigo = 0;
  public int idVendedor;
  public String rol;
  
  public VistaGestorVehiculosMecanico(int id,String r) {
	  idVendedor = id;
	  rol = r;
      initComponents();
      filtro.setSelectedIndex(0);
      
      t.verVehiculos(tabla, filtro.getSelectedItem().toString(),rol);    
      setExtendedState(MAXIMIZED_BOTH);
  }

private void initComponents() {

      jScrollPane1 = new javax.swing.JScrollPane();
      tabla = new javax.swing.JTable();
      jPanel1 = new javax.swing.JPanel();
      jPanel2 = new javax.swing.JPanel();

      BtnEdit = new javax.swing.JButton();
    
      BtnSearch = new javax.swing.JButton();
      BtnExit = new javax.swing.JButton();
    
      texto_Codigo = new javax.swing.JLabel();
      texto_Disp = new javax.swing.JLabel();   
      
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
      
      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("Gestor de vehiculos Mecanico");

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

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

      BtnEdit.setText("Modificar");
      BtnEdit.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              BtnEditActionPerformed(evt);
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
              .addComponent(BtnEdit)
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
                  .addComponent(BtnEdit)                  
                  .addComponent(BtnExit)
                  .addComponent(filtro)
                  .addComponent(BtnSearch))
              .addGap(18, 18, 18)
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

      texto_Disp.setText("Disponible:");
      texto_Codigo.setText("Codigo:");

      txtc.setEditable(false);
      txtc.setBackground(new java.awt.Color(204, 204, 255));

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
          jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
              .addContainerGap()
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  
                  .addGroup(jPanel2Layout.createSequentialGroup()
                      .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  		.addComponent(texto_Disp)
                        .addComponent(texto_Codigo)  
                      )
                      .addGap(18, 18, 18)
                      .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                          .addComponent(txtDisp)
                          .addComponent(txtc, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                          )))
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel2Layout.setVerticalGroup(
          jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
              .addContainerGap()
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(texto_Codigo)
                      .addComponent(txtc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 20)
              
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                          .addComponent(texto_Disp)
                          .addComponent(txtDisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

  private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {
	 	VistaPanelMecanico e = new VistaPanelMecanico(idVendedor,rol); 
		String n = VistaIniciarSesion.ponerNombre(idVendedor);
		e.bienvenido.setText("Bienvenido, " + n);
		e.setVisible(true);
		dispose();
	}
  
 
  private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {
  	t.verVehiculos(tabla,filtro.getSelectedItem().toString(),rol);
  }
  
  private void tablaMouseClicked(java.awt.event.MouseEvent evt) {
      int clic = tabla.rowAtPoint(evt.getPoint());
      codigo = (int)tabla.getValueAt(clic, 0);
      txtc.setText(String.valueOf(codigo));
  }

  private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {
      int disp = 0;
	  int id = Integer.parseInt(txtc.getText());
      if(txtDisp.getSelectedItem().toString().equals("Si")) {
    	  disp = 1;
      } 
      this.modificar(disp, id);
      t.verVehiculos(tabla,filtro.getSelectedItem().toString(),rol);
  }

 public void modificar( int disp, int id){
	  Conectar conec = new Conectar();
      String sql = "UPDATE vehiculo SET dispo = ? WHERE idVehiculo = ?;";
      PreparedStatement ps = null;
      try{
      	ps = conec.getConnection().prepareStatement(sql);
        ps.setInt(1, disp);
        ps.setInt(2, id);
        ps.executeUpdate();
      }catch(SQLException ex){
          System.out.println(ex.getMessage());
      }catch(Exception ex){
          System.out.println(ex.getMessage());
      }finally{
          try{
              ps.close();
              conec.desconectar();
          }catch(Exception ex){}
      }
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