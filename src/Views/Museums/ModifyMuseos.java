/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Museums;

import CRUD.ReadMuseos;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class ModifyMuseos extends javax.swing.JFrame {

    /**
     * Creates new form ShowMuseos
     */
    public ModifyMuseos() {
        initComponents();
        showTable();
        this.setTitle("Museos registrados");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //tableData.setEditingRow(NORMAL);
        //tableData.isCellEditable(ERROR, NORMAL);
        //tableData.setEnabled(false);
    }

    

    public void columnMoved(TableColumnModelEvent e) {
        tableData.columnMoved(e);
    }
    
    
    
    public void showTable()
    {
        System.out.println("Accediendo a la base de datos...");
        String textUri = "mongodb://luis:conde@ds048878.mongolab.com:48878/MongoLab-l";
        //String textUri = "mongodb://alex:jimenez@ds023438.mlab.com/?authSource=museosapp&authMechanism=MONGODB-X509";
        MongoClientURI uri = new MongoClientURI(textUri);
        MongoClient mongoClient = new MongoClient(uri);
        DBCursor cursor = null;
        DBCursor cursor2 = null;
        
        DB db = mongoClient.getDB( "MongoLab-l" );
        
        DBCollection items = db.getCollection("museos");
        cursor = items.find();
        
        //Obtenemos el número de colecciones para establecer el ID del siguiente museo.
        long count = (items.count());
        //Parseamos el valor de la variable "count" a un String 
        //para poder mostrarlo en pantalla.
        String count_museos = String.valueOf(count);
        lblCountMuseos.setText(count_museos);
        
        String[] columnNames = {"Nombre", "Categoría", "URL Imagen", "Teléfono", "Dirección", "Latitud", "Longitud", "Descripcion", "FbID", "TwitterId", "Instagram", "Web"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        while(cursor.hasNext()) {
                    DBObject obj = cursor.next();
                    String nombre = (String)obj.get("nombre");
                    String categoria = (String)obj.get("categoria");
//                    ObjectId id = (ObjectId)obj.get("_id");
                    //String id = (String)obj.get("id_pieza");
                    String img = (String)obj.get("imagen");
                    String tel = (String)obj.get("telefono");
                    String direccion = (String)obj.get("direccion");
                    String lat = (String)obj.get("latitud");
                    String lon = (String)obj.get("longitud");
                    String desc = (String)obj.get("descripcionCorta");
                    String fbid = (String)obj.get("facebookid");
                    String twid = (String)obj.get("twitterId");
                    String inst = (String)obj.get("instagram");
                    if(inst==("")){ System.out.println("HOLI BB");}
                    String web = (String)obj.get("web");
                    model.addRow(new Object[] { nombre, categoria, img, tel, direccion, lat, lon, desc, fbid, twid, inst, web });
                }
                
                tableData.setModel(model);
                tableData.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuTabla = new javax.swing.JPopupMenu();
        Modificar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblCountMuseos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex) {

                return true; //Las celdas no son editables.

            }
        };
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        MenuTabla.add(Modificar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new ImageIcon(getClass().getResource("/Icons/icon.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(194, 23, 91));

        jLabel4.setFont(new java.awt.Font("Segoe WP Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Seleccione el Museo en el que desea editar la información:");

        lblCountMuseos.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lblCountMuseos.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe WP Light", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Museos registrados:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblCountMuseos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblCountMuseos))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(137, 14, 79), 3, true), "Museos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(194, 23, 91))); // NOI18N

        jScrollPane1.setBorder(null);

        tableData.setForeground(new java.awt.Color(137, 14, 79));
        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableData.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableData.setComponentPopupMenu(MenuTabla);
        tableData.setRowHeight(30);
        tableData.setSelectionBackground(new java.awt.Color(194, 23, 91));
        tableData.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableData);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        jLabel1.setText("Nombre del Museo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 775, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        // TODO add your handling code here:
        ReadMuseos rm = new ReadMuseos();
        rm.readDocumt(txtName.getText());
    }//GEN-LAST:event_txtNameKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        new MuseoCRUD().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // TODO add your handling code here:
        int fila = tableData.getSelectedRow();
        String nombre, categoria, imagen, tel, direccion, lat, lon, descripcion, fbid, twitterid, instagram, web;
        if(fila>=0)
        {   
            //Obtenemos los valores que actualmente tiene cada campo de la tabla.
            nombre = tableData.getValueAt(fila, 0).toString();
            categoria = tableData.getValueAt(fila, 1).toString();
            imagen = tableData.getValueAt(fila, 2).toString();
            tel = tableData.getValueAt(fila, 3).toString();
            lat = tableData.getValueAt(fila, 4).toString();
            lon = tableData.getValueAt(fila, 5).toString();
            descripcion = tableData.getValueAt(fila, 6).toString();
            fbid = tableData.getValueAt(fila, 7).toString();
            twitterid = tableData.getValueAt(fila, 8).toString();
            instagram = tableData.getValueAt(fila, 9).toString();
            web = tableData.getValueAt(fila, 10).toString();
            //btnGuardar.setEnabled(true);
        }else
            JOptionPane.showMessageDialog(null, "Debe elegir el elemento de la tabla que desea modificar.", "No se seleccionó ningún elemento.", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_ModificarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModifyMuseos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyMuseos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyMuseos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyMuseos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyMuseos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuTabla;
    private javax.swing.JMenuItem Modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCountMuseos;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
