package Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;

//En esta clase, a diferencia del panel de empleado, tendrá menos opciones, ya que el mecánico solo gestionará los vehículo
//que necesiten revisión

@SuppressWarnings("serial")
public class VistaPanelMecanico extends JFrame {
	//variables
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
		idMecanico = id;
		rol = r;
		//inicia componentes
		initComponents();
		setExtendedState(MAXIMIZED_BOTH);
	}
	
	public void initComponents() {
		
		Font negrita = new Font("Arial", Font.BOLD, 30);
		Font estandar = new Font("Arial", Font.PLAIN, 22);
		
		bienvenido = new javax.swing.JLabel();
		bienvenido.setFont(negrita);
		
		title = new javax.swing.JLabel();
		title.setFont(estandar);
		title.setText("PANEL DE CONTROL:");
		title.setFont(negrita);
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
		panel1 = new javax.swing.JPanel();
		panel2 = new javax.swing.JPanel();
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
        //paneles
        javax.swing.GroupLayout jPanel0Layout = new javax.swing.GroupLayout(panel0);
        jPanel0Layout.setHorizontalGroup(
        	jPanel0Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, jPanel0Layout.createSequentialGroup()
        			.addGap(43)
        			.addComponent(bienvenido)
        			.addContainerGap(1457, Short.MAX_VALUE))
        		.addGroup(jPanel0Layout.createSequentialGroup()
        			.addGap(1144)
        			.addGroup(jPanel0Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(miPerfil, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        				.addComponent(BtnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(193))
        );
        jPanel0Layout.setVerticalGroup(
        	jPanel0Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel0Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel0Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(bienvenido)
        				.addComponent(BtnExit))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(miPerfil, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(57, Short.MAX_VALUE))
        );
        panel0.setLayout(jPanel0Layout);
        
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
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.CENTER)
        		.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        			.addContainerGap(102, Short.MAX_VALUE)
        			.addComponent(gestorVehiculos, 300, 300, 300)
        			.addGap(96))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        			.addContainerGap(37, Short.MAX_VALUE)
        			.addComponent(gestorVehiculos, 100, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        panel2.setLayout(jPanel2Layout);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.CENTER)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(panel0, GroupLayout.DEFAULT_SIZE, 1500, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(542)
        					.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(461)
        					.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 500, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.CENTER)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, 10)
        			.addComponent(panel0, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        			.addGap(5)
        			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        );
        getContentPane().setLayout(layout);

            pack();
            setLocationRelativeTo(null);
	}
	//acción atrás
	private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {
		VistaIniciarSesion v = new VistaIniciarSesion();
		v.setVisible(true);
		dispose();
	}
	//acción botón gestorVehiculos
	private void gestorVehiculosActionPerformed(java.awt.event.ActionEvent evy) {
		VistaGestorVehiculosMecanico v = new VistaGestorVehiculosMecanico(idMecanico, rol);
		v.setVisible(true);
		dispose();
	}
	//acción botón miPerfil
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
