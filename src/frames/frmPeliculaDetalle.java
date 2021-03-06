/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import clases.Pelicula;
import javax.swing.JOptionPane;

/**
 *
 * @author Enrique
 */
public class frmPeliculaDetalle extends javax.swing.JFrame {

    /**
     * Creates new form frmAsignaturaAgregar
     */
    public frmPeliculaDetalle() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPelicula = new javax.swing.JTextField();
        txtPeliculaDuracion = new javax.swing.JTextField();
        txtCodigoPelicula = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblRegresar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEstreno = new javax.swing.JTextField();
        txtClasificacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtActores = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDirectores = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSinopsis = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Pelicula:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel2.setText("Duracion:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jLabel7.setText("Detalles Pelicula");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        txtPelicula.setEditable(false);
        getContentPane().add(txtPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 180, -1));

        txtPeliculaDuracion.setEditable(false);
        getContentPane().add(txtPeliculaDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 180, -1));

        txtCodigoPelicula.setEditable(false);
        getContentPane().add(txtCodigoPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 180, -1));

        jTextField6.setText("jTextField1");
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        jLabel8.setText("Código:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        lblRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/back.png"))); // NOI18N
        lblRegresar.setText("Regresar");
        lblRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarMouseClicked(evt);
            }
        });
        getContentPane().add(lblRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, -1, -1));

        jLabel3.setText("Estreno:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        txtEstreno.setEditable(false);
        getContentPane().add(txtEstreno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 180, -1));

        txtClasificacion.setEditable(false);
        getContentPane().add(txtClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 180, -1));

        jLabel4.setText("Clasificacion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));

        jLabel5.setText("Actores:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));

        txtActores.setEditable(false);
        getContentPane().add(txtActores, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 180, -1));

        jLabel6.setText("Directores:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, -1, -1));

        txtDirectores.setEditable(false);
        getContentPane().add(txtDirectores, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 180, -1));

        jLabel9.setText("Sinopsis:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        txtSinopsis.setEditable(false);
        getContentPane().add(txtSinopsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 180, -1));

        jLabel10.setText("Genero:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        txtGenero.setEditable(false);
        getContentPane().add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 180, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
       frmPeliculas peli=new frmPeliculas();
       peli.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_lblRegresarMouseClicked

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
            java.util.logging.Logger.getLogger(frmPeliculaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPeliculaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPeliculaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPeliculaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPeliculaDetalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblRegresar;
    public javax.swing.JTextField txtActores;
    public javax.swing.JTextField txtClasificacion;
    public javax.swing.JTextField txtCodigoPelicula;
    public javax.swing.JTextField txtDirectores;
    public javax.swing.JTextField txtEstreno;
    public javax.swing.JTextField txtGenero;
    public javax.swing.JTextField txtPelicula;
    public javax.swing.JTextField txtPeliculaDuracion;
    public javax.swing.JTextField txtSinopsis;
    // End of variables declaration//GEN-END:variables
}
