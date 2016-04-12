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
import javax.swing.ImageIcon;
import org.bson.types.ObjectId;

/**
 *
 * @author Alejandro
 */
public class FormularioPiezas extends javax.swing.JFrame {

    /**
     * Creates new form FormularioPiezas
     */
    public FormularioPiezas() {
        initComponents();
        this.setTitle("Formulario para piezas de los museos");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        lblLlenado.setVisible(false);
        panelEstado.setVisible(false);
        txtIdPieza.setEnabled(false);
        idPieza();
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
        txtNombrePieza.setText("");
        txtCategoriaPieza.setText("");
        txtIdPieza.setText("");
        txtAutor.setText("");
        txtAño.setText("");
        txtDescripcion.setText("");
        txtImagen.setText("");
    }
    
    //Método para obtener el ID de la Pieza.
    public void idPieza()
    {
        System.out.println("Obteniendo el ID de la pieza próxima...");
        String textUri = "mongodb://luis:conde@ds048878.mongolab.com:48878/MongoLab-l";
           //String textUri = "mongodb://alex:jimenez@ds023438.mlab.com/?authSource=museosapp&authMechanism=MONGODB-X509";
           MongoClientURI uri = new MongoClientURI(textUri);
           MongoClient mongoClient = new MongoClient(uri);
           
           DB db = mongoClient.getDB( "MongoLab-l" );
           
           //System.out.println("Creando el documento en la colección...");
               
               DBCollection items = db.getCollection("piezas");
               //Obtenemos el número de colecciones para establecer el ID del siguiente museo.
               long count = (items.count()+1);
               //Parseamos el valor de la variable "count" a un String 
               //para poder almacenar el valor a la base de datos.
               String id_pieza = String.valueOf(count);
               txtIdPieza.setText(id_pieza);
    }
    
    public void isComplete()
    {
        String pieza = txtNombrePieza.getText();
        String categoria = txtCategoriaPieza.getText();
        String autor = txtAutor.getText();
        String año = txtAño.getText();
        String des = txtDescripcion.getText();
        String img = txtImagen.getText();
        if (pieza.equals("") || categoria.equals("") || autor.equals("") 
                || año.equals("") || des.equals("") || img.equals(""))
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
               
               DBCollection items = db.getCollection("piezas");
               //Obtenemos el número de colecciones para establecer el ID del siguiente museo.
               long count = (items.count()+1);
               //Parseamos el valor de la variable "count" a un String 
               //para poder almacenar el valor a la base de datos.
               String id_pieza = String.valueOf(count);
               BasicDBObject doc1 = new BasicDBObject();
               doc1.put("nombre", pieza);
               doc1.put("categoria", categoria);
               doc1.put("id_pieza", id_pieza);
               doc1.put("autor", autor);
               doc1.put("ano", año);
               doc1.put("descripcion", des);
               doc1.put("imagen", img);
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
               idPieza();
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

        jPanel2 = new javax.swing.JPanel();
        txtNombrePieza = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCategoriaPieza = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdPieza = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtImagen = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnCargarMuseo = new javax.swing.JButton();
        panelEstado = new javax.swing.JPanel();
        lblWrong = new javax.swing.JLabel();
        lblGood = new javax.swing.JLabel();
        lblLlenado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/Icons/icon.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(194, 23, 91));
        jLabel1.setText("Nombre de la Pieza:");

        jLabel2.setForeground(new java.awt.Color(194, 23, 91));
        jLabel2.setText("Categoría:");

        jLabel3.setForeground(new java.awt.Color(194, 23, 91));
        jLabel3.setText("Id:");

        jLabel5.setForeground(new java.awt.Color(194, 23, 91));
        jLabel5.setText("Autor:");

        jLabel8.setForeground(new java.awt.Color(194, 23, 91));
        jLabel8.setText("Descripción:");

        jLabel15.setForeground(new java.awt.Color(194, 23, 91));
        jLabel15.setText("Año:");

        jLabel17.setForeground(new java.awt.Color(194, 23, 91));
        jLabel17.setText("Imagen (URL):");

        btnCargarMuseo.setBackground(new java.awt.Color(137, 14, 79));
        btnCargarMuseo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/arrows.png"))); // NOI18N
        btnCargarMuseo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarMuseoActionPerformed(evt);
            }
        });

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

        lblLlenado.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblLlenado.setForeground(new java.awt.Color(204, 0, 0));
        lblLlenado.setText("Por favor, llena todos los campos requeridos.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtNombrePieza, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtCategoriaPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtIdPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblLlenado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(txtNombrePieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCategoriaPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(lblLlenado))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnCargarMuseo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(panelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(137, 14, 79));

        jLabel4.setFont(new java.awt.Font("Segoe WP Light", 1, 18)); // NOI18N
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarMuseoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarMuseoActionPerformed
        // TODO add your handling code here:
        createDocument();
    }//GEN-LAST:event_btnCargarMuseoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        new Seleccion().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioPiezas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioPiezas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioPiezas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioPiezas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioPiezas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarMuseo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblGood;
    private javax.swing.JLabel lblLlenado;
    private javax.swing.JLabel lblWrong;
    private javax.swing.JPanel panelEstado;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtCategoriaPieza;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIdPieza;
    private javax.swing.JTextField txtImagen;
    private javax.swing.JTextField txtNombrePieza;
    // End of variables declaration//GEN-END:variables
}
