/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Museums;

import BD.ConexionBD;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Alex
 */
public class AuthAdminMuseo extends javax.swing.JFrame {
    
    public class PresionarTecla extends KeyAdapter {
 
      public void keyPressed(KeyEvent ke) {
          if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
              //btnAceptarActionPerformed(null);
              String usuario = txtUsuario.getText();
              String contraseña = new String(txtContraseña.getPassword());
              try {
                  acceder(usuario, contraseña);
              } catch (UnsupportedLookAndFeelException ex) {
                  Logger.getLogger(AuthAdminMuseo.class.getName()).log(Level.SEVERE, null, ex);
              }
              
          }
      }
    }

    /**
     * Creates new form IngresoAlSistema
     */
    public AuthAdminMuseo() {
        
        initComponents();
        this.setTitle("Verificación de usuario y contraseña Administrador de Museos.");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    //Creamos la conexión con la Base de Datos.
    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    
    //Acceso con MySQL remoto.
    void acceder(String usuario, String contraseña) throws UnsupportedLookAndFeelException
    {
       String cap = "";
       String sql = "SELECT user, password FROM adminmuseo WHERE user='"+usuario+"' && password='"+contraseña+"'";
       
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next())
            {
//                JOptionPane.showMessageDialog(null, "Bienvenido.");
//                Principal ventanaPrincipal = new Principal();
//                ventanaPrincipal.setVisible(true);
                new MuseoCRUD().setVisible(true);
                this.dispose();
            }else
            {
//                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
                JOptionPane.showMessageDialog(AuthAdminMuseo.this, "El usuario o la contraseña son incorrectos.", "Error al intentar ingresar.", JOptionPane.ERROR_MESSAGE);
            }
            
//            while(rs.next())
//            {
//                cap = rs.getString("tipousuario");
//            }
//            if(cap.equals("1"))
//            {
//                  this.setVisible(false);
//                    JOptionPane.showMessageDialog(null, "Bienvenido.");
//                     RegistroProfesor ventanaRegistroProfesor = new RegistroProfesor();
//                    ventanaRegistroProfesor.setVisible(true);
//                    //ingreso.pack();
//                     //ventanaadmin.lblusu.setText(usuario);
//        
//                
//            }
//            if(cap.equals("0"))
//            {
//            this.setVisible(false);
//                    JOptionPane.showMessageDialog(null, "Bienvenido");
//                     ventanacliente ingresos = new ventanacliente();
//                    ingresos.setVisible(true);
//                    ingresos.pack();
//                     ventanacliente.lblconectado.setText(usuario);
//            }
//            if((!cap.equals("Administrador"))&& (!cap.equals("Invitado")))
//            {
//                JOptionPane.showMessageDialog(this, "No existe sus datos");
//            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthAdminMuseo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
    
    //Acceso con MongoDB remoto.
    public void accessAdminMuseo(String qery1, String qery2)
    {
        System.out.println("Accediendo a la base de datos...");
        String textUri = "mongodb://alex:jimenez@ds023438.mlab.com:23438/museosapp";
        //String textUri = "mongodb://alex:jimenez@ds023438.mlab.com/?authSource=museosapp&authMechanism=MONGODB-X509";
        MongoClientURI uri = new MongoClientURI(textUri);
        MongoClient mongoClient = new MongoClient(uri);
           
        DB db = mongoClient.getDB( "museosapp" );
        
        DBCollection items = db.getCollection("usersAdmin");
        
        BasicDBObject user = new BasicDBObject();
        BasicDBObject pass = new BasicDBObject();
        user.put("user", qery1);
        pass.put("password", qery2);
        DBCursor cursor = items.find(user);
        DBCursor cursor2 = items.find(pass);
        // Print out "highest" priority items
        //System.out.println("query con la pieza 6:\n");
        System.out.println("Leyendo el documento de la colección...");
        
        //if(cursor.hasNext()){System.out.println("Se ha encontrado en la base...");}
          //  else{System.out.println("NO se encontró en la base...");}
        
        boolean bandUser = false;
        boolean bandPass = false;
          
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
            System.out.println("Acceso realizado correctamente.");
            bandUser=true;
            
            if(cursor.hasNext()){System.out.println("Se ha encontrado en la base...");}
            else{System.out.println("NO se encontró en la base...");}
        }System.out.println(bandUser);
        
        while (cursor2.hasNext()) {
            System.out.println(cursor2.next());
            System.out.println("Acceso realizado correctamente.");
            bandPass=true;
            
            if(cursor2.hasNext()){System.out.println("Se ha encontrado en la base...");}
            else{System.out.println("NO se encontró en la base...");}
        }System.out.println(bandPass);
        
        if(bandUser==true && bandPass==true)
        {
            new MuseoCRUD().setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(AuthAdminMuseo.this, "El usuario o la contraseña son incorrectos.", "Error al intentar ingresar.", JOptionPane.ERROR_MESSAGE);
        }
        
        mongoClient.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIngresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage( new ImageIcon(getClass().getResource("/Img/rsz_rsz_12icon.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(137, 14, 79), 3, true), "Ingrese usuario y contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe WP Light", 1, 18), new java.awt.Color(194, 23, 91))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(194, 23, 91));
        jLabel1.setText("Usuario:");

        jLabel2.setForeground(new java.awt.Color(194, 23, 91));
        jLabel2.setText("Constraseña:");

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/shapes.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminmuseo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(194, 23, 91));

        jLabel4.setFont(new java.awt.Font("Segoe WP Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Autenticación de Administrador de Museos.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(51, 225, Short.MAX_VALUE)
                        .addComponent(btnIngresar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnIngresar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        /*try {
            new Principal().setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VerRegistrosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        String usuario = txtUsuario.getText();
        String contraseña = new String(txtContraseña.getPassword());
        accessAdminMuseo(usuario, contraseña);
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
        txtUsuario.requestFocus();
        txtUsuario.transferFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
        txtContraseña.transferFocus();
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        /*try {
            new Principal().setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VerRegistrosProfesores.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(IngresoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(IngresoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(IngresoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(IngresoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new IngresoSistema().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
