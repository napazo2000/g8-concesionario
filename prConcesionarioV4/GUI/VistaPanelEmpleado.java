package Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VistaPanelEmpleado extends JFrame {
	public javax.swing.JLabel bienvenido;
	private javax.swing.JLabel title;
	private javax.swing.JButton ultimasGestiones;
	private javax.swing.JButton venta;
	private javax.swing.JButton alquiler;
	private javax.swing.JButton gestorVehiculos;
	private javax.swing.JButton gestorUsuarios;
	private javax.swing.JButton miPerfil;
	private javax.swing.JButton BtnExit;

	private javax.swing.JPanel panel0;
	private javax.swing.JPanel panel1;
	private javax.swing.JPanel panel2;
	
	public static int idVendedor;
	public static String rol;
	
	public VistaPanelEmpleado(int value, String r) {
		getContentPane().setBackground(new Color(224, 255, 255));
		idVendedor = value;
		rol = r;
		initComponents();
		setExtendedState(MAXIMIZED_BOTH);
	}
	
	public void initComponents() {
		Font negrita = new Font("Arial", Font.BOLD, 30);
		Font estandar = new Font("Arial", Font.PLAIN, 22);
		Font italic = new Font("Arial", Font.ITALIC, 30);
		
		ultimasGestiones = new javax.swing.JButton();
		venta = new javax.swing.JButton();
		alquiler = new javax.swing.JButton();
		gestorVehiculos = new javax.swing.JButton();
		gestorUsuarios = new javax.swing.JButton();
		miPerfil = new javax.swing.JButton();
		BtnExit = new javax.swing.JButton();
		
		BtnExit.setFont(estandar);
		ultimasGestiones.setFont(estandar);
		venta.setFont(estandar);
		alquiler.setFont(estandar);
		gestorVehiculos.setFont(estandar);
		gestorUsuarios.setFont(estandar);
		miPerfil.setFont(estandar);
		
		BtnExit.setText("Cerrar sesión");
		BtnExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BtnExitActionPerformed(evt);
			}
		});
		
		ultimasGestiones.setText("Últimas gestiones");
		ultimasGestiones.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
					ultimasGestionesActionPerformed(evt);				
			}
		});
		
		venta.setText("Nueva venta");
		venta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ventaActionPerformed(evt);
			}
		});	
		
		alquiler.setText("Nuevo alquiler");
		alquiler.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				alquilerActionPerformed(evt);
			}
		});
		
		gestorVehiculos.setText("Gestor de Vehículos");
		gestorVehiculos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gestorVehiculosActionPerformed(evt);
			}
		});
		
		gestorUsuarios.setText("Gestor de clientes");
		gestorUsuarios.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gestorUsuariosActionPerformed(evt);
			}
		});
		
		miPerfil.setText("Mi perfil");
		miPerfil.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				miPerfilActionPerformed(evt);
			}
		});
		
		panel0 = new javax.swing.JPanel();
		panel0.setBackground(new Color(175, 238, 238));
		panel2 = new javax.swing.JPanel();
		panel2.setBackground(new Color(224, 255, 255));
		panel2.setBorder(null);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel de Control");
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.CENTER)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.CENTER, jPanel2Layout.createSequentialGroup()
        					.addComponent(ultimasGestiones, 300, 300, 300)
        					.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, 20)
        					.addComponent(venta, 300, 300, 300)
        					.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, 20)
        					.addComponent(alquiler, 300, 300, 300)
        					.addContainerGap())
        				.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        					.addComponent(gestorVehiculos, 300, 300, 300)
        					.addGap(18)
        					.addComponent(gestorUsuarios, 300, 300, 300)
        					.addGap(169))))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(ultimasGestiones, 100, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(venta, 100, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(alquiler, 100, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, 20)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(gestorUsuarios, 100, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(gestorVehiculos, 100, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, 20))
        );
        panel2.setLayout(jPanel2Layout);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 255, 255));
        
        title = new javax.swing.JLabel();
        title.setBackground(new Color(175, 238, 238));
        title.setFont(estandar);
        title.setText("PANEL DE CONTROL:");
        title.setFont(negrita);
        panel1 = new javax.swing.JPanel();
        panel1.setBackground(new Color(175, 238, 238));
        
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel1);
		panel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
		    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
		        .addContainerGap()
		        .addComponent(title)
		        .addGap(10, 10, 10)
		        )
		);
		jPanel1Layout.setVerticalGroup(
		    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel1Layout.createSequentialGroup()
		        .addContainerGap()
		        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		            .addComponent(title))
		        .addGap(18, 18, 18)
		        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
        GroupLayout gl_panel0 = new GroupLayout(panel0);
        gl_panel0.setHorizontalGroup(
        	gl_panel0.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel0.createSequentialGroup()
        			.addGap(798)
        			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(597)
        			.addGroup(gl_panel0.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(miPerfil, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(BtnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap(33, Short.MAX_VALUE))
        );
        gl_panel0.setVerticalGroup(
        	gl_panel0.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel0.createSequentialGroup()
        			.addGroup(gl_panel0.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel0.createSequentialGroup()
        					.addGap(46)
        					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel0.createSequentialGroup()
        					.addGap(22)
        					.addComponent(miPerfil)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(BtnExit)))
        			.addContainerGap(26, Short.MAX_VALUE))
        );
        panel0.setLayout(gl_panel0);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(224, 255, 255));
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(224, 255, 255));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 963, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED))
        				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(432)))
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
        			.addGap(2))
        		.addComponent(panel0, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1928, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(panel0, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        					.addGroup(groupLayout.createSequentialGroup()
        						.addGap(190)
        						.addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addGap(125)
        						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        
        bienvenido = new javax.swing.JLabel();
        bienvenido.setVerticalAlignment(SwingConstants.BOTTOM);
        bienvenido.setFont(italic);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(234)
        			.addComponent(bienvenido)
        			.addContainerGap(234, Short.MAX_VALUE))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(5)
        			.addComponent(bienvenido)
        			.addContainerGap(874, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("D:\\Im\u00E1genes\\prConcesionarioV4\\imagenes\\logo.png"));
        panel_2.add(lblNewLabel);
        getContentPane().setLayout(groupLayout);

            pack();
            setLocationRelativeTo(null);
	}
	
	private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {
		VistaIniciarSesion v = new VistaIniciarSesion();
		v.setVisible(true);
		dispose();
	}
	
	private void ultimasGestionesActionPerformed(ActionEvent evt) {
		VistaGestorOperaciones v = new VistaGestorOperaciones(idVendedor,rol);
		v.setVisible(true);
		dispose();
	}
	
	private void ventaActionPerformed(ActionEvent evt) {
		VistaVenta v = new VistaVenta(idVendedor,rol);
		v.setVisible(true);
		dispose();
	}

	private void alquilerActionPerformed(ActionEvent evt) {
		VistaAlquiler v = new VistaAlquiler(idVendedor,rol);
		v.setVisible(true);
		dispose();
	}
	
	private void gestorVehiculosActionPerformed(java.awt.event.ActionEvent evt) {
		VistaGestorVehiculos v = new VistaGestorVehiculos(idVendedor,rol);
		v.setVisible(true);
		dispose();
	}
	
	private void gestorUsuariosActionPerformed(java.awt.event.ActionEvent evt) {
		VistaGestorUsuarios v = new VistaGestorUsuarios(idVendedor,rol);
		v.setVisible(true);
		dispose();
	}
	
	private void miPerfilActionPerformed(ActionEvent evt) {
		VistaMiPerfil v = new VistaMiPerfil(idVendedor,rol);
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
            java.util.logging.Logger.getLogger(VistaPanelEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPanelEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPanelEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPanelEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	new VistaPanelEmpleado(0,null).setVisible(true);
            }
        });
    } 
}