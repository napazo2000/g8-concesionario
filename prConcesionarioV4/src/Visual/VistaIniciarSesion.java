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
		texto_Usuario.setFont(estandar);
		texto_Password = new javax.swing.JLabel();
		texto_Password.setFont(estandar);
		title = new javax.swing.JLabel();
		title.setText("Concesionario Grupo 8");
		title.setFont(negrita);
		msg = new javax.swing.JLabel();
		msg.setFont(italic);
		msg.setBackground(Color.red);
		msg.setOpaque(true);
		
		txtUsuario = new javax.swing.JTextField();
		txtPassword = new javax.swing.JPasswordField();
		
		BtnLogin = new javax.swing.JButton();
		BtnLogin.setText("Acceder");
		BtnLogin.setFont(estandar);
		BtnLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BtnLoginActionListener(evt);
			}
		});
				
		panel0 = new javax.swing.JPanel();
		panel1 = new javax.swing.JPanel();
		panel2 = new javax.swing.JPanel();
		
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
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 20)
                        .addComponent(msg)
                        .addGap(18, 18, 18)
                        )
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    		.addComponent(texto_Usuario)
                    		.addComponent(texto_Password)
                            )
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER, false)
                            .addComponent(txtUsuario,javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtPassword,javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            )))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(texto_Usuario)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(texto_Password)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnLogin)
                    .addComponent(msg))  
                .addContainerGap())
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                		.addComponent(panel0, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, javax.swing.GroupLayout.PREFERRED_SIZE)
                		.addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   )
                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                    .addContainerGap(5, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    		.addGroup(layout.createSequentialGroup()
                        		 .addComponent(panel0, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        		 .addGroup(layout.createSequentialGroup()
                        		 .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        		 .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        		 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                           )
                        )
                    .addContainerGap())
            );

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
