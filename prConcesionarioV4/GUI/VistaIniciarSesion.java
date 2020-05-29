
package Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Conexion.Conectar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class VistaIniciarSesion extends JFrame {
	private javax.swing.JLabel title;	
	private javax.swing.JLabel texto_Usuario;
	private javax.swing.JLabel texto_Password;
	private javax.swing.JLabel msg;
	public javax.swing.JTextField txtUsuario;
	public javax.swing.JPasswordField txtPassword;
	private javax.swing.JLabel logo;
	private javax.swing.JPanel panel0;
	private javax.swing.JPanel panel1;
	private javax.swing.JPanel panel2;
	private javax.swing.JButton BtnLogin;
	
	public VistaIniciarSesion() {
		getContentPane().setBackground(new Color(224, 255, 255));
		initComponents();
		setExtendedState(MAXIMIZED_BOTH);
	}
	
	private void initComponents() {
		Font negrita = new Font("Arial", Font.BOLD, 30);
		Font estandar = new Font("Arial", Font.PLAIN, 20);
		Font italic = new Font("Arial", Font.ITALIC, 20);
		
        ImageIcon imagen=new ImageIcon("imagenes"+File.separator+"logo.png");
        logo = new javax.swing.JLabel(imagen);
		
		texto_Usuario = new javax.swing.JLabel();
		texto_Usuario.setForeground(Color.WHITE);
		texto_Usuario.setFont(new Font("Arial", Font.BOLD, 25));
		texto_Password = new javax.swing.JLabel();
		texto_Password.setForeground(Color.WHITE);
		texto_Password.setFont(new Font("Arial", Font.BOLD, 25));
		title = new javax.swing.JLabel();
		title.setText("Concesionario Grupo 8");
		title.setFont(new Font("Arial", Font.BOLD, 60));
		msg = new javax.swing.JLabel();
		msg.setFont(italic);
		msg.setBackground(Color.red);
		msg.setOpaque(true);
		
		txtUsuario = new javax.swing.JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPassword = new javax.swing.JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		BtnLogin = new javax.swing.JButton();
		BtnLogin.setText("Acceder");
		BtnLogin.setFont(new Font("Arial", Font.BOLD, 25));
		BtnLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BtnLoginActionListener(evt);
			}
		});
				
		panel0 = new javax.swing.JPanel();
		panel0.setBackground(new Color(224, 255, 255));
		panel1 = new javax.swing.JPanel();
		panel1.setBackground(new Color(224, 255, 255));
		panel2 = new javax.swing.JPanel();
		panel2.setBackground(Color.DARK_GRAY);
		
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar sesion");
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
           
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(10, 10, 10)
                )
            .addComponent(logo)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(logo)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(title)
                        )
                    .addGap(20, 20, 20)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        
        texto_Usuario.setText("Usuario:");
        texto_Password.setText("Contraseña:");
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 255, 255));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(224, 255, 255));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(panel0, GroupLayout.PREFERRED_SIZE, 1903, GroupLayout.PREFERRED_SIZE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(10)
        							.addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(18)
        							.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        			.addGap(132))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panel0, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE))
        				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE))
        			.addContainerGap())
        );
        
        JLabel lblNewLabel = new JLabel("INICIO DE SESION");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\Im\u00E1genes\\prConcesionarioV4\\imagenes\\logo.png"));
        
        JLabel msg_1 = new JLabel();
        msg_1.setOpaque(true);
        msg_1.setFont(new Font("Arial", Font.ITALIC, 20));
        msg_1.setBackground(Color.RED);
        GroupLayout gl_panel2 = new GroupLayout(panel2);
        gl_panel2.setHorizontalGroup(
        	gl_panel2.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel2.createSequentialGroup()
        			.addContainerGap(277, Short.MAX_VALUE)
        			.addComponent(lblNewLabel_1)
        			.addGap(274))
        		.addGroup(gl_panel2.createSequentialGroup()
        			.addContainerGap(166, Short.MAX_VALUE)
        			.addComponent(lblNewLabel)
        			.addGap(151))
        		.addGroup(gl_panel2.createSequentialGroup()
        			.addGap(256)
        			.addComponent(BtnLogin)
        			.addContainerGap(264, Short.MAX_VALUE))
        		.addGroup(gl_panel2.createSequentialGroup()
        			.addGap(84)
        			.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
        				.addComponent(texto_Usuario)
        				.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(texto_Password)
        					.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        					.addComponent(txtUsuario)))
        			.addContainerGap(75, Short.MAX_VALUE))
        		.addGroup(Alignment.LEADING, gl_panel2.createSequentialGroup()
        			.addGap(119)
        			.addComponent(msg_1)
        			.addContainerGap(532, Short.MAX_VALUE))
        );
        gl_panel2.setVerticalGroup(
        	gl_panel2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel2.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel_1)
        			.addGap(18)
        			.addComponent(lblNewLabel)
        			.addGap(62)
        			.addComponent(texto_Usuario)
        			.addGap(18)
        			.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(texto_Password)
        			.addGap(18)
        			.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(58)
        			.addComponent(BtnLogin, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        			.addGap(26)
        			.addComponent(msg_1)
        			.addGap(27))
        );
        panel2.setLayout(gl_panel2);
        GroupLayout gl_panel0 = new GroupLayout(panel0);
        gl_panel0.setHorizontalGroup(
        	gl_panel0.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 1500, Short.MAX_VALUE)
        );
        gl_panel0.setVerticalGroup(
        	gl_panel0.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 200, Short.MAX_VALUE)
        );
        panel0.setLayout(gl_panel0);
        getContentPane().setLayout(groupLayout);

            pack();
            setLocationRelativeTo(null);
	}
	
	@SuppressWarnings("deprecation")
	private void BtnLoginActionListener(java.awt.event.ActionEvent evt) {
		if(ok(txtUsuario.getText(),txtPassword.getText())) {
			String rol = rol(txtUsuario.getText(),txtPassword.getText());
			String n;
			switch(rol) {
			case "Empleado": 
				VistaPanelEmpleado e = new VistaPanelEmpleado(pasarId(txtUsuario.getText(),txtPassword.getText()),rol); 
				n = ponerNombre(pasarId(txtUsuario.getText(),txtPassword.getText()));
				e.bienvenido.setText("Bienvenido, " + n);
				e.setVisible(true);
				dispose();
				break;
			case "Mecánico": 
				VistaPanelMecanico m = new VistaPanelMecanico(pasarId(txtUsuario.getText(),txtPassword.getText()),rol);
				n = ponerNombre(pasarId(txtUsuario.getText(),txtPassword.getText()));
				m.bienvenido.setText("Bienvenido, " + n);
				m.setVisible(true);
				dispose();
				break;
			}
		} else {
			msg.setText("ERROR: usuario o contraseña incorrrectos");
		}
	}
	
	public static String ponerNombre(int id) {
		String n = null;
		Conectar conec = new Conectar();
        String sql = "SELECT nombre FROM usuario WHERE idUsuario = ?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            n = rs.getString(1);
        }catch(SQLException ex1){
            System.out.println(ex1.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }
            catch(Exception ex){}
        }  
        return n;
	}
	
	public int pasarId(String user, String pass) {
		int id = 0; 
		Conectar conec = new Conectar();
	        String sql = "SELECT idUsuario FROM usuario WHERE correo = ? AND password = ?";
	        ResultSet rs = null;
	        PreparedStatement ps = null;
	        try{
	            ps = conec.getConnection().prepareStatement(sql);
	            ps.setString(1, user);
	            ps.setString(2, pass);
	            rs = ps.executeQuery();
	            rs.next();
	            id = rs.getInt(1);
	        }catch(SQLException ex1){
	            System.out.println(ex1.getMessage());
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }finally{
	            try{
	                ps.close();
	                rs.close();
	                conec.desconectar();
	            }
	            catch(Exception ex){}
	        }   
			return id;
	}
	
	private boolean ok(String user, String pass) {
		boolean ok = false;
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM usuario WHERE correo = ? AND password = ?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
            	ok = true;
            } else {
            	ok = false;
            }
        }catch(SQLException ex1){
            System.out.println(ex1.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }
            catch(Exception ex){}
        }   
		return ok;
	}
	
	private String rol(String user, String password) {
		String rol = null;
		 Conectar conec = new Conectar();
	        String sql = "SELECT tipoRol FROM usuario WHERE correo = ? AND password = ?";
	        ResultSet rs = null;
	        PreparedStatement ps = null;
	        try{
	        	ps = conec.getConnection().prepareStatement(sql);
	            ps.setString(1, user);
	            ps.setString(2, password);
	        	rs = ps.executeQuery();
	            rs.next();
	            rol = rs.getString(1);
	        }catch(SQLException ex1){
	            System.out.println(ex1.getMessage());
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }finally{
	            try{
	                ps.close();
	                rs.close();
	                conec.desconectar();
	            }catch(Exception ex){}
	        }   
			return rol;
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
            java.util.logging.Logger.getLogger(VistaIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	VistaIniciarSesion v = new VistaIniciarSesion();
            	v.setVisible(true);

            }
        });
    }
}