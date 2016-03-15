/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;
import org.bson.types.ObjectId;

/**
 *
 * @author Alejandro
 */
public class FormularioMuseos extends javax.swing.JFrame {

    /**
     * Creates new form Mus
     */
    public FormularioMuseos() {
        initComponents();
        this.setTitle("Formulario para Museos de Puebla");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        lblLlenado.setVisible(false);
        panelEstado.setVisible(false);
    }
    
    public void isWrong()
    {
        panelEstado.setVisible(true);
        lblWrong.setVisible(true);
        lblGood.setVisible(false);
        lblLlenado.setForeground(Color.red);
        lblLlenado.setText("Por favor, llena todos los campos requeridos.");
    }
    
    public void isCorrect()
    {
        panelEstado.setVisible(true);
        lblWrong.setVisible(false);
        lblGood.setVisible(true);
    }
    
    public void cleanJTextField()
    {
        txtNombreMuseo.setText("");
        txtCategoria.setText("");
        txtIdMuseo.setText("");
        txtTelefono.setText("");
        txtLatitud.setText("");
        txtLongitud.setText("");
        txtDescripcion.setText("");
        txtFacebookId.setText("");
        txtTwitterId.setText("");
        txtWeb.setText("");
        txtImagen.setText("");
    }
    
    public void isComplete()
    {
        String museo = txtNombreMuseo.getText();
        String categoria = txtCategoria.getText();
        String idm = txtIdMuseo.getText();
        String tel = txtTelefono.getText();
        String lat = txtLatitud.getText();
        String lon = txtLongitud.getText();
        String des = txtDescripcion.getText();
        String fbid = txtFacebookId.getText();
        String twid = txtTwitterId.getText();
        String web = txtWeb.getText();
        String img = txtImagen.getText();
        if (museo.equals("") || categoria.equals("") || idm.equals("") || tel.equals("")
                || lat.equals("") || lon.equals("") || des.equals("") || fbid.equals("")
                || twid.equals("") || web.equals("") || img.equals(""))
        {
           lblLlenado.setVisible(true);
           System.out.println("Por favor, llena todos los campos requeridos.");
           isWrong();
        }else 
        {
           isCorrect();
           lblLlenado.setVisible(false);
           System.out.println("Accediendo a la base de datos...");
           btnCargarMuseo.setEnabled(false);
           String textUri = "mongodb://luis:conde@ds048878.mongolab.com:48878/MongoLab-l";
           //String textUri = "mongodb://alex:jimenez@ds023438.mlab.com/?authSource=museosapp&authMechanism=MONGODB-X509";
           MongoClientURI uri = new MongoClientURI(textUri);
           MongoClient mongoClient = new MongoClient(uri);
           
           DB db = mongoClient.getDB( "MongoLab-l" );
           
           System.out.println("Creando el documento en la colección...");
               
               DBCollection items = db.getCollection("museos");
               //Obtenemos el número de colecciones para establecer el ID del siguiente museo.
               long count = items.count();
               BasicDBObject doc1 = new BasicDBObject();
               doc1.put("nombre", txtNombreMuseo.getText());
               doc1.put("categoria", txtCategoria.getText());
               //doc1.put("id", (count+1));
               doc1.put("id", txtIdMuseo.getText());
               doc1.put("imagen", txtImagen.getText());
               doc1.put("telefono", txtTelefono.getText());
               doc1.put("latitud", txtLatitud.getText());
               doc1.put("longitud", txtLongitud.getText());
               doc1.put("descripcion", txtDescripcion.getText());
               doc1.put("facebookid", txtLongitud.getText());
               doc1.put("twitterId", txtTwitterId.getText());
               doc1.put("web", txtWeb.getText());
               items.insert(doc1);
               ObjectId id = (ObjectId)doc1.get( "_id" );
               System.out.println("Document ID: "+doc1.get("_id"));
               System.out.println("Se ha insertado 1 documento a la colección.");
               lblLlenado.setVisible(true);
               lblLlenado.setForeground(Color.green);
               lblLlenado.setText("Se ha insertado el documento. ");
               cleanJTextField();
               btnCargarMuseo.setEnabled(true);
               mongoClient.close();
        }
    }

    public void createDocument()
     {
        isComplete();
     }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtNombreMuseo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdMuseo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLatitud = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtLongitud = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtFacebookId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTwitterId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtWeb = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtImagen = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnCargarMuseo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblLlenado = new javax.swing.JLabel();
        panelEstado = new javax.swing.JPanel();
        lblWrong = new javax.swing.JLabel();
        lblGood = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/Icons/icon.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(137, 14, 79));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Llene el formato siguiente para poder cargar un Museo a la base de datos.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabel1.setForeground(new java.awt.Color(194, 23, 91));
        jLabel1.setText("Nombre del Museo:");

        jLabel2.setForeground(new java.awt.Color(194, 23, 91));
        jLabel2.setText("Categoría:");

        jLabel3.setForeground(new java.awt.Color(194, 23, 91));
        jLabel3.setText("Id:");

        jLabel5.setForeground(new java.awt.Color(194, 23, 91));
        jLabel5.setText("Teléfono:");

        jLabel8.setForeground(new java.awt.Color(194, 23, 91));
        jLabel8.setText("Latitud:");

        jLabel16.setForeground(new java.awt.Color(194, 23, 91));
        jLabel16.setText("Longitud:");

        jLabel15.setForeground(new java.awt.Color(194, 23, 91));
        jLabel15.setText("Descripción:");

        jLabel11.setForeground(new java.awt.Color(194, 23, 91));
        jLabel11.setText("Facebook Id:");

        jLabel10.setForeground(new java.awt.Color(194, 23, 91));
        jLabel10.setText("Twitter Id:");

        jLabel9.setForeground(new java.awt.Color(194, 23, 91));
        jLabel9.setText("Página web:");

        jLabel17.setForeground(new java.awt.Color(194, 23, 91));
        jLabel17.setText("Imagen (URL):");

        btnCargarMuseo.setBackground(new java.awt.Color(137, 14, 79));
        btnCargarMuseo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/arrows.png"))); // NOI18N
        btnCargarMuseo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarMuseoActionPerformed(evt);
            }
        });

        lblLlenado.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblLlenado.setForeground(new java.awt.Color(204, 0, 0));
        lblLlenado.setText("Por favor, llena todos los campos requeridos.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblLlenado)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblLlenado)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lblWrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cross.png"))); // NOI18N

        lblGood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/school.png"))); // NOI18N

        javax.swing.GroupLayout panelEstadoLayout = new javax.swing.GroupLayout(panelEstado);
        panelEstado.setLayout(panelEstadoLayout);
        panelEstadoLayout.setHorizontalGroup(
            panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadoLayout.createSequentialGroup()
                .addComponent(lblWrong)
                .addGap(18, 18, 18)
                .addComponent(lblGood))
        );
        panelEstadoLayout.setVerticalGroup(
            panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWrong)
            .addComponent(lblGood)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreMuseo, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdMuseo, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addGap(18, 18, 18)
                            .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtFacebookId, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtTwitterId, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCargarMuseo)
                                .addGap(18, 18, 18)
                                .addComponent(panelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreMuseo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdMuseo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFacebookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTwitterId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCargarMuseo)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(panelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarMuseoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarMuseoActionPerformed
        // TODO add your handling code here:
        createDocument();
    }//GEN-LAST:event_btnCargarMuseoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new Seleccion().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarMuseo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblGood;
    private javax.swing.JLabel lblLlenado;
    private javax.swing.JLabel lblWrong;
    private javax.swing.JPanel panelEstado;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFacebookId;
    private javax.swing.JTextField txtIdMuseo;
    private javax.swing.JTextField txtImagen;
    private javax.swing.JTextField txtLatitud;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtNombreMuseo;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTwitterId;
    private javax.swing.JTextField txtWeb;
    // End of variables declaration//GEN-END:variables
}
