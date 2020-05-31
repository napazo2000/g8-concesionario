package Visual;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.GestorUsuarios;
import Model.Usuario;
import Tabla.TablaGestorUsuarios;

@SuppressWarnings("serial")
public class VistaGestorUsuarios extends JFrame {
//variables
  	private javax.swing.JButton BtnFoto;
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnDel;
    private javax.swing.JButton BtnClean;
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnSearch;
    
    private javax.swing.JLabel texto_Password;
    private javax.swing.JLabel texto_Correo;
    private javax.swing.JLabel texto_Codigo;
    private javax.swing.JLabel texto_Dni;
    private javax.swing.JLabel texto_Nombre;
    private javax.swing.JLabel texto_Apellidos;
    private javax.swing.JLabel texto_FecNac;
    private javax.swing.JLabel texto_Movil;
    private javax.swing.JLabel texto_Direccion;
    private javax.swing.JLabel texto_CodPostal;
    private javax.swing.JLabel texto_Ciudad;
    private javax.swing.JLabel texto_Provincia;
    
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    
    private javax.swing.JScrollPane jScrollPane1;
    
    private javax.swing.JTable tabla;
    
    private javax.swing.JTextField txtc;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtApellidos;
    private com.toedter.calendar.JDateChooser txtFecNac;
    private javax.swing.JTextField txtMovil;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtCodPostal;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtProvincia;
    
    private JComboBox<String> filtro;
    
GestorUsuarios gu;
Usuario u = new Usuario();
TablaGestorUsuarios t = new TablaGestorUsuarios();

int codigo = 0;

public int idVendedor;
public String tipoRol;

public VistaGestorUsuarios(int id, String rol) {
	idVendedor = id;
	tipoRol = rol;
	//inicia componentes y establece seleccion base para el filtro
    initComponents();
    filtro.setSelectedIndex(0);
    
    t.verUsuarios(tabla, filtro.getSelectedItem().toString());
    
    setExtendedState(MAXIMIZED_BOTH);
}
//establecer todas las varibles vacias o a 0
public void limpiar(){
    txtc.setText("");
    txtCorreo.setText("");
    txtPassword.setText("");
    txtDni.setText("");
    txtNombre.setText("");
    txtApellidos.setText("");
    txtMovil.setText("");
    txtDireccion.setText("");
    txtCodPostal.setText("");
    txtCiudad.setText("");
    txtProvincia.setText("");
    txtRuta.setText("");
    codigo = 0;
}

private void initComponents() {
//inicializar todas la variables, tablas, botones, paneles
    jScrollPane1 = new javax.swing.JScrollPane();
    tabla = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    
    BtnAdd = new javax.swing.JButton();
    BtnDel = new javax.swing.JButton();
    BtnEdit = new javax.swing.JButton();
    BtnClean = new javax.swing.JButton();
    BtnFoto = new javax.swing.JButton();
    BtnSearch = new javax.swing.JButton();
    BtnBack = new javax.swing.JButton();
    
    texto_Correo = new javax.swing.JLabel();
    texto_Password = new javax.swing.JLabel();
    texto_Dni = new javax.swing.JLabel();
    texto_Password = new javax.swing.JLabel();
    texto_Codigo = new javax.swing.JLabel();
    texto_Nombre = new javax.swing.JLabel();
    texto_Apellidos = new javax.swing.JLabel();
    texto_FecNac = new javax.swing.JLabel();
    texto_Movil = new javax.swing.JLabel();
    texto_Direccion = new javax.swing.JLabel();
    texto_CodPostal = new javax.swing.JLabel();
    texto_Ciudad = new javax.swing.JLabel();
    texto_Provincia = new javax.swing.JLabel();  
    
    txtRuta = new javax.swing.JTextField();
    txtCorreo = new javax.swing.JTextField();
    txtPassword = new javax.swing.JTextField();
    txtNombre = new javax.swing.JTextField();
    txtDni = new javax.swing.JTextField();
    txtApellidos = new javax.swing.JTextField();
    txtFecNac = new com.toedter.calendar.JDateChooser();
    txtMovil = new javax.swing.JTextField();
    txtDireccion = new javax.swing.JTextField();
    txtCodPostal = new javax.swing.JTextField();
    txtCiudad = new javax.swing.JTextField();
    txtProvincia = new javax.swing.JTextField();
    txtc = new javax.swing.JTextField();
    
    filtro = new JComboBox<String>();
    filtro.addItem("default");
    filtro.addItem("correo");
    filtro.addItem("dni");
    filtro.addItem("nombre");
    filtro.addItem("apellidos");
    filtro.addItem("fecNac");
    filtro.addItem("movil");
    filtro.addItem("direccion");
    filtro.addItem("codPostal");
    filtro.addItem("ciudad");
    filtro.addItem("provincia");
    filtro.addItem("tipoRol");
    
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Gestor de clientes");

    tabla.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
	    //orden de las variables
        new String [] {
            "ID Usuario", "Correo", "Password", "DNI", "Nombre", "Apellidos", "Fecha de Nacimiento", "Móvil", "Dirección", "Código postal", "Ciudad", "Provincia", "Imagen"
        }
    ));
	//boton para añadir 
    tabla.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablaMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tabla);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

    BtnAdd.setText("Agregar");
    BtnAdd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnAddActionPerformed(evt);
        }
    });
	//boton para eliminar
    BtnDel.setText("Eliminar");
    BtnDel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnDelActionPerformed(evt);
        }
    });
	//boton para modificar
    BtnEdit.setText("Modificar");
    BtnEdit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnEditActionPerformed(evt);
        }
    });
	//boton para limpiar
    BtnClean.setText("Limpiar");
    BtnClean.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnCleanActionPerformed(evt);
        }
    });
    //boton para volver al menu empleado
    BtnBack.setText("Atrás");
    BtnBack.addActionListener(new java.awt.event.ActionListener() {
    	public void actionPerformed(ActionEvent evt) {
    		BtnBackActionPerformed(evt);
    	}
    });
    //boton para filtrar según seleccion
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
            .addComponent(BtnAdd)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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
                .addComponent(BtnAdd)
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

    txtRuta.setEditable(false);
    txtRuta.setBackground(new java.awt.Color(204, 204, 255));

    BtnFoto.setText("Foto");
    BtnFoto.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnFotoActionPerformed(evt);
        }
    });
	//texto para la colocación de las variables
    texto_Correo.setText("Correo:");

    texto_Password.setText("Contraseña:");
    
    texto_Dni.setText("DNI:");
    
    texto_Nombre.setText("Nombre:");
    
    texto_Apellidos.setText("Apellidos:");
    
    texto_FecNac.setText("Fecha de Nacimiento:");
    
    texto_Movil.setText("Número de móvil:");
    
    texto_Direccion.setText("Dirección:");
    
    texto_CodPostal.setText("Código Postal:");
    
    texto_Ciudad.setText("Ciudad:");
    
    texto_Provincia.setText("Provincia:");

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
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addComponent(txtRuta, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(BtnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                		.addComponent(texto_Correo)
                		.addComponent(texto_Password)
                		.addComponent(texto_Dni)
                		.addComponent(texto_Nombre)
                		.addComponent(texto_Apellidos)
                		.addComponent(texto_FecNac)
                		.addComponent(texto_Movil)
                		.addComponent(texto_Direccion)
                		.addComponent(texto_CodPostal)
                		.addComponent(texto_Ciudad)
                		.addComponent(texto_Provincia)
                        .addComponent(texto_Codigo)
                        )
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCorreo)
                        .addComponent(txtPassword)
                        .addComponent(txtDni)
                        .addComponent(txtNombre)
                        .addComponent(txtApellidos)
                        .addComponent(txtFecNac)
                        .addComponent(txtMovil)
                        .addComponent(txtDireccion)
                        .addComponent(txtCodPostal)
                        .addComponent(txtCiudad)
                        .addComponent(txtProvincia)
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
                .addComponent(texto_Correo)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Password)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18) 
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Dni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 20)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Nombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 20)    
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Apellidos)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_FecNac)
                    .addComponent(txtFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Movil)
                    .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)                
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Direccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_CodPostal)
                    .addComponent(txtCodPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Ciudad)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Provincia)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BtnFoto))  
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
//accion eliminar
private void BtnCleanActionPerformed(java.awt.event.ActionEvent evt) {
    limpiar();
}
//accion buscar
private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {
	t.verUsuarios(tabla,filtro.getSelectedItem().toString());
}
//accion foto
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
//accion boton añadir
private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {   
    String correo = txtCorreo.getText();
    String password = txtPassword.getText();
    String dni = txtDni.getText();
    String nombre = txtNombre.getText();
    String apellidos = txtApellidos.getText();
    Date date = txtFecNac.getDate();
	String fecNac = DateFormat.getDateInstance().format(date);
	int movil = Integer.parseInt(txtMovil.getText());
    String direccion = txtDireccion.getText();
    int codPostal = Integer.parseInt(txtCodPostal.getText());
    String ciudad = txtCiudad.getText();
    String provincia = txtProvincia.getText();
    File ruta = new File(txtRuta.getText());
    String rol = "Cliente";
    
    this.agregar(correo, password, dni, nombre, apellidos, fecNac, movil, direccion, codPostal, ciudad, provincia, rol, ruta);
    t.verUsuarios(tabla,filtro.getSelectedItem().toString());
    
}
//accion tabla, para la seleccion de los usuarios
private void tablaMouseClicked(java.awt.event.MouseEvent evt) {
    int clic = tabla.rowAtPoint(evt.getPoint());
    
    codigo = (int)tabla.getValueAt(clic, 0);
    String correo = ""+tabla.getValueAt(clic, 1);
    String password = ""+tabla.getValueAt(clic, 2);
    String dni = ""+tabla.getValueAt(clic, 3);
    String nombre = ""+tabla.getValueAt(clic, 4);
    String apellidos = ""+tabla.getValueAt(clic, 5);
    int movil = (int)tabla.getValueAt(clic, 7);
    String direccion = ""+tabla.getValueAt(clic, 8);
    int codPostal = (int)tabla.getValueAt(clic, 9);
    String ciudad = ""+tabla.getValueAt(clic, 10);
    String provincia = ""+tabla.getValueAt(clic, 11);
    
    txtc.setText(String.valueOf(codigo));
    System.out.println(txtc);
    txtCorreo.setText(correo);
    txtPassword.setText(password);
    txtDni.setText(dni);
    txtNombre.setText(nombre);
    txtApellidos.setText(apellidos);
    txtMovil.setText(String.valueOf(movil));
    txtDireccion.setText(direccion);
    txtCodPostal.setText(String.valueOf(codPostal));
    txtCiudad.setText(ciudad);
    txtProvincia.setText(provincia);    
    txtRuta.setText("");
    
}
//accion editar
private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {
	int id = Integer.parseInt(txtc.getText());
    String correo = txtCorreo.getText();
    String password = txtPassword.getText();
    String dni = txtDni.getText();
    String nombre = txtNombre.getText();
    String apellidos = txtApellidos.getText();
    Date date = txtFecNac.getDate();
	String fecNac = DateFormat.getDateInstance().format(date);
	int movil = Integer.parseInt(txtMovil.getText());
    String direccion = txtDireccion.getText();
    int codPostal = Integer.parseInt(txtCodPostal.getText());
    String ciudad = txtCiudad.getText();
    String provincia = txtProvincia.getText();
    File ruta = new File(txtRuta.getText());
    String rol = "Cliente";
    
    this.modificar(correo, password, dni, nombre, apellidos, fecNac, movil, direccion, codPostal, ciudad, provincia, rol, ruta, id);
    t.verUsuarios(tabla,filtro.getSelectedItem().toString());
    limpiar();
}
//accion eliminar 
private void BtnDelActionPerformed(java.awt.event.ActionEvent evt) {
    int id = Integer.parseInt(txtc.getText());
    int a = JOptionPane.showConfirmDialog(null, "Desea eliminar este cliente","Mensaje",JOptionPane.OK_CANCEL_OPTION);
    if(a == 0){
        this.eliminar(id);
        limpiar();
    }
    t.verUsuarios(tabla,filtro.getSelectedItem().toString());
}
//accion volver
private void BtnBackActionPerformed(ActionEvent evt) {
	VistaPanelEmpleado e = new VistaPanelEmpleado(idVendedor,tipoRol); 
	String n = VistaIniciarSesion.ponerNombre(idVendedor);
	e.bienvenido.setText("Bienvenido, " + n);
	e.setVisible(true);
	dispose();
}
//crea la variable usuario y guarda cada variable dentro de esta
public void agregar(String correo, String password, String dni, String nombre, String apellidos, String fecNac, int movil, String direccion, int codPostal, String ciudad, String provincia, String tipoRol, File ruta){
    Usuario u = new Usuario();
    gu = new GestorUsuarios();
   
    u.setCorreo(correo);
    u.setPassword(password);
    u.setDni(dni);
    u.setNombre(nombre);
    u.setApellidos(apellidos);
    u.setFecNacimiento(fecNac);
    u.setMovil(movil);
    u.setDireccion(direccion);
    u.setCodPostal(codPostal);
    u.setCiudad(ciudad);
    u.setProvincia(provincia);
    u.setTipoRol(tipoRol);
    
    try{
        byte[] icono = new byte[(int) ruta.length()];
        InputStream input = new FileInputStream(ruta);
        input.read(icono);
        u.setFoto(icono);
        input.close();
    }catch(Exception ex){
        u.setFoto(null);
    }
    gu.addUsuario(u);
    limpiar();
}
//modifica un usuario ya creado
public void modificar(String correo, String password, String dni, String nombre, String apellidos, String fecNac, int movil, String direccion, int codPostal, String ciudad, String provincia,String tipoRol, File ruta, int id){
    Usuario u = new Usuario();
    gu = new GestorUsuarios();
    
    u.setIdUsuario(id);
    u.setCorreo(correo);
    u.setPassword(password);
    u.setDni(dni);
    u.setNombre(nombre);
    u.setApellidos(apellidos);
    u.setFecNacimiento(fecNac);
    u.setMovil(movil);
    u.setDireccion(direccion);
    u.setCodPostal(codPostal);
    u.setCiudad(ciudad);
    u.setProvincia(provincia);
    u.setTipoRol(tipoRol);
    
    try{
        byte[] icono = new byte[(int) ruta.length()];
        InputStream input = new FileInputStream(ruta);
        input.read(icono);
        u.setFoto(icono);
        input.close();
    }catch(Exception ex){
        u.setFoto(null);
    }
    gu.editUsuario(u);
}
 
public void eliminar(int id){
    Usuario u = new Usuario();
    gu = new GestorUsuarios();
    
    u.setIdUsuario(codigo);
    
    gu.delUsuario(u);
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
        java.util.logging.Logger.getLogger(VistaGestorUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(VistaGestorUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(VistaGestorUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(VistaGestorUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
  
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        	VistaGestorUsuarios v = new VistaGestorUsuarios(0,null);
        	v.setVisible(true);

        }
    });
} 
}
