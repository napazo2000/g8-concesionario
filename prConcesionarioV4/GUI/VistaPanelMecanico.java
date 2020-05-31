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

@SuppressWarnings("serial")
public class VistaPanelMecanico extends JFrame {
	public javax.swing.JLabel bienvenido;
	private javax.swing.JLabel title;
	private javax.swing.JButton gestorVehiculos;
	private javax.swing.JButton miPerfil;
	private javax.swing.JButton BtnExit;
	
	private javax.swing.JPanel panel0;
	private javax.swing.JPanel panel1;
	private javax.swing.JPanel panel2;
	
	public static int idMecanico;
	public static String rol;
	
	public VistaPanelMecanico(int id, String r) {
		getContentPane().setBackground(new Color(224, 255, 255));
		idMecanico = id;
		rol = r;
		initComponents();
		//setExtendedState(MAXIMIZED_BOTH);.
		setSize(1928,1080);
	}
	
	public void initComponents() {
		Font negrita = new Font("Arial", Font.BOLD, 30);
		Font estandar = new Font("Arial", Font.PLAIN, 22);
		gestorVehiculos = new javax.swing.JButton();
		BtnExit = new javax.swing.JButton();
		
		BtnExit.setFont(estandar);
		gestorVehiculos.setFont(estandar);
		
		BtnExit.setText("Cerrar sesión");
		BtnExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BtnExitActionPerformed(evt);
			}
		});
		
		gestorVehiculos.setText("Gestor de Vehículos");
		gestorVehiculos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gestorVehiculosActionPerformed(evt);
			}
		});
		
		panel0 = new javax.swing.JPanel();
		panel0.setBackground(new Color(175, 238, 238));
		panel2 = new javax.swing.JPanel();
		panel2.setBackground(new Color(224, 255, 255));
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel de Control");
        miPerfil = new javax.swing.JButton();
        miPerfil.setFont(estandar);
        
        miPerfil.setText("Mi perfil");
        miPerfil.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		miPerfilActionPerformed(evt);
        	}
        });
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(gestorVehiculos, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(gestorVehiculos, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        			.addContainerGap())
        );
        panel2.setLayout(jPanel2Layout);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 255, 255));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(224, 255, 255));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("D:\\Im\u00E1genes\\prConcesionarioV4\\imagenes\\logo.png"));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 682, GroupLayout.PREFERRED_SIZE)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(18)
        							.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(227)
        							.addComponent(lblNewLabel)))
        					.addGap(25)
        					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
        					.addContainerGap())
        				.addComponent(panel0, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 1927, GroupLayout.PREFERRED_SIZE)))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(panel0, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(125)
        					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
        					.addGap(121)
        					.addComponent(lblNewLabel))
        				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE))
        			.addContainerGap())
        );
        
        bienvenido = new javax.swing.JLabel();
        panel.add(bienvenido);
        bienvenido.setFont(negrita);
        
        title = new javax.swing.JLabel();
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
        		.addGroup(Alignment.TRAILING, gl_panel0.createSequentialGroup()
        			.addGap(793)
        			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(587)
        			.addGroup(gl_panel0.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(miPerfil, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(BtnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
        			.addGap(21))
        );
        gl_panel0.setVerticalGroup(
        	gl_panel0.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel0.createSequentialGroup()
        			.addGap(34)
        			.addComponent(BtnExit)
        			.addGap(18)
        			.addComponent(miPerfil)
        			.addGap(28))
        		.addGroup(Alignment.TRAILING, gl_panel0.createSequentialGroup()
        			.addContainerGap(75, Short.MAX_VALUE)
        			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        panel0.setLayout(gl_panel0);
        getContentPane().setLayout(groupLayout);

            pack();
            setLocationRelativeTo(null);
	}
	
	private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {
		VistaIniciarSesion v = new VistaIniciarSesion();
		v.setVisible(true);
		dispose();
	}
	
	private void gestorVehiculosActionPerformed(java.awt.event.ActionEvent evy) {
		VistaGestorVehiculosMecanico v = new VistaGestorVehiculosMecanico(idMecanico, rol);
		v.setVisible(true);
		dispose();
	}
	private void miPerfilActionPerformed(ActionEvent evt) {
		VistaMiPerfil v = new VistaMiPerfil(idMecanico,rol);
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
            java.util.logging.Logger.getLogger(VistaPanelMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPanelMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPanelMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPanelMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	new VistaPanelMecanico(0,null).setVisible(true);
            }
        });
    } 
}
