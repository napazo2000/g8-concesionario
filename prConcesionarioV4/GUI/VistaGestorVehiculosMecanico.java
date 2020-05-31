package Visual;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import Conexion.Conectar;
import Model.GestorVehiculos;
import Model.Vehiculo;
import Tabla.TablaGestorVehiculos;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VistaGestorVehiculosMecanico extends JFrame {
	    private javax.swing.JButton BtnEdit;
	    private javax.swing.JButton BtnExit;
	    private javax.swing.JButton BtnSearch;
	    private javax.swing.JLabel texto_Codigo;
	    private javax.swing.JLabel texto_Disp;
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
  private JPanel panel;
  
  public VistaGestorVehiculosMecanico(int id,String r) {
  	getContentPane().setBackground(new Color(224, 255, 255));
	  idVendedor = id;
	  rol = r;
      initComponents();
      filtro.setSelectedIndex(0);
      
      t.verVehiculos(tabla, filtro.getSelectedItem().toString(),rol);    
      //setExtendedState(MAXIMIZED_BOTH);
	  setSize(1920,1080);
  }

private void initComponents() {

      jScrollPane1 = new javax.swing.JScrollPane();
      tabla = new javax.swing.JTable();
      
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
      
      panel = new JPanel();
      panel.setBorder(null);
      panel.setBackground(new Color(175, 238, 238));

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      layout.setHorizontalGroup(
      	layout.createParallelGroup(Alignment.LEADING)
      		.addGroup(layout.createSequentialGroup()
      			.addContainerGap()
      			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
      				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      				.addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1899, Short.MAX_VALUE))
      			.addContainerGap(69, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
      	layout.createParallelGroup(Alignment.TRAILING)
      		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
      			.addContainerGap()
      			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 888, GroupLayout.PREFERRED_SIZE)
      			.addPreferredGap(ComponentPlacement.RELATED)
      			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
      			.addGap(28))
      );
      
            BtnEdit = new javax.swing.JButton();
            BtnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
            
                  BtnEdit.setText("Modificar");
                  
                    texto_Codigo = new javax.swing.JLabel();
                    texto_Codigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
                    texto_Codigo.setText("Codigo:");
                  
                  txtc = new javax.swing.JTextField();
                  txtc.setFont(new Font("Tahoma", Font.PLAIN, 20));
                  
                        txtc.setEditable(false);
                        txtc.setBackground(new java.awt.Color(204, 204, 255));
                  texto_Disp = new javax.swing.JLabel();   
                  texto_Disp.setFont(new Font("Tahoma", Font.PLAIN, 20));
                  
                        texto_Disp.setText("Disponible:");
                  
                  txtDisp = new javax.swing.JComboBox<String>();
                  txtDisp.setFont(new Font("Tahoma", Font.PLAIN, 20));
                  txtDisp.addItem("Si");
                  txtDisp.addItem("No");
                  filtro = new JComboBox<String>();
                  filtro.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
                  
                    BtnSearch = new javax.swing.JButton();
                    BtnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
                    
                    BtnSearch.setText("Filtrar");
                    BtnSearch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            BtnSearchActionPerformed(evt);
                        }
                    });
                  BtnExit = new javax.swing.JButton();
                  BtnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
                  
                  BtnExit.setText("Atrás");
                  BtnExit.addActionListener(new java.awt.event.ActionListener() {
                  	public void actionPerformed(java.awt.event.ActionEvent evt) {
                  		BtnExitActionPerformed(evt);
                  	}
                  });
                  GroupLayout gl_panel = new GroupLayout(panel);
                  gl_panel.setHorizontalGroup(
                  	gl_panel.createParallelGroup(Alignment.LEADING)
                  		.addGroup(gl_panel.createSequentialGroup()
                  			.addContainerGap()
                  			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                  				.addComponent(texto_Disp)
                  				.addComponent(texto_Codigo))
                  			.addPreferredGap(ComponentPlacement.UNRELATED)
                  			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
                  				.addComponent(txtc)
                  				.addComponent(txtDisp, 0, 180, Short.MAX_VALUE))
                  			.addPreferredGap(ComponentPlacement.UNRELATED)
                  			.addComponent(BtnEdit)
                  			.addGap(41)
                  			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                  				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                  					.addComponent(BtnSearch)
                  					.addPreferredGap(ComponentPlacement.RELATED, 1227, Short.MAX_VALUE)
                  					.addComponent(BtnExit, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                  				.addComponent(filtro, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
                  			.addContainerGap())
                  );
                  gl_panel.setVerticalGroup(
                  	gl_panel.createParallelGroup(Alignment.TRAILING)
                  		.addGroup(gl_panel.createSequentialGroup()
                  			.addContainerGap(21, Short.MAX_VALUE)
                  			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                  				.addComponent(texto_Codigo)
                  				.addComponent(txtc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  				.addComponent(filtro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                  			.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                  			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                  				.addComponent(texto_Disp)
                  				.addComponent(txtDisp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  				.addComponent(BtnExit)
                  				.addComponent(BtnSearch))
                  			.addContainerGap())
                  		.addGroup(gl_panel.createSequentialGroup()
                  			.addContainerGap(51, Short.MAX_VALUE)
                  			.addComponent(BtnEdit)
                  			.addGap(32))
                  );
                  panel.setLayout(gl_panel);
                  BtnEdit.addActionListener(new java.awt.event.ActionListener() {
                      public void actionPerformed(java.awt.event.ActionEvent evt) {
                          BtnEditActionPerformed(evt);
                      }
                  });
      getContentPane().setLayout(layout);

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
