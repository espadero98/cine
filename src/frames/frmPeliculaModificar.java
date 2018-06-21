/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import clases.Actor;
import clases.Clasificacion;
import clases.ControladorActor;
import clases.ControladorClasificacion;
import clases.ControladorDirector;
import clases.ControladorGenero;
import clases.ControladorPelicula;
import clases.ControladorPeliculaActor;
import clases.ControladorPeliculaClasificacion;
import clases.ControladorPeliculaDirector;
import clases.ControladorPeliculaGenero;
import clases.Director;
import clases.ErrorPelicula;
import clases.Genero;
import clases.MyTableModel;
import clases.Pelicula;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enrique
 */
public class frmPeliculaModificar extends javax.swing.JFrame {

    /**
     * Creates new form frmAsignaturaAgregar
     */
    
    MyTableModel modeloActores;
    MyTableModel modeloDirectores;
    MyTableModel modeloGeneros;
    DefaultComboBoxModel modeloClasificacion;
    String codigoo="";
    public frmPeliculaModificar() {
        initComponents();
        rellenoTablaActor();
        rellenoTablaDirectores();
        rellenoTablaGenero();
        rellenoComboClasifiacion();
    }
    
    //---------------------creacion de tabla--------------------------------
    public void rellenoTablaActor(){
        
        modeloActores=new MyTableModel("Codigo","Actor");
        ArrayList<Actor> asignaturas = new ArrayList();
        Object[] fila = new Object[5];
        
        try {
            System.out.println(codigoo);
            if (codigoo.equals("")) {
                System.out.println("vacio");
            }
            asignaturas = ControladorPeliculaActor.BuscarActorPeliculas(txtCodigoPelicula.getText());
            
            Iterator<Actor> peli = asignaturas.iterator();
        
            while (peli.hasNext()) {
                    
                    fila[0] = peli.next();
                    fila[1] = peli.next();
                    fila[2]=false;
                    
                    
                    modeloActores.addRow(fila);
                    tblActores.setModel(modeloActores);
                    
                }
            
        } catch (ErrorPelicula ex) {
            Logger.getLogger(frmPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }  
    
    //---------------------creacion de combo--------------------------------
    public void rellenoComboClasifiacion(){
         cmbClasificacion.removeAll();
         modeloClasificacion=new DefaultComboBoxModel();
        modeloClasificacion.removeAllElements();
        Object[] opcion=new Object[1];
        
        
            ArrayList<Clasificacion> sucursales=new ArrayList<>();
        try {
            sucursales = ControladorClasificacion.Buscar();
        } catch (ErrorPelicula ex) {
            Logger.getLogger(frmPeliculaModificar.class.getName()).log(Level.SEVERE, null, ex);
        }
            Iterator iterador=sucursales.iterator();
            
            while(iterador.hasNext()){
                
                opcion[0]=iterador.next();
                modeloClasificacion.addElement(iterador.next());
                
            }
            
            cmbClasificacion.setModel(modeloClasificacion);
        
     }  
    //---------------------creacion de tabla--------------------------------
    public void rellenoTablaDirectores(){
        
        modeloDirectores=new MyTableModel("Código","Director");
        ArrayList<Director> asignaturas = new ArrayList();
        Object[] fila = new Object[5];
        
        try {
            asignaturas = ControladorDirector.Buscar();
            
            Iterator<Director> peli = asignaturas.iterator();
        
            while (peli.hasNext()) {
                    
                    fila[0] = peli.next();
                    fila[1] = peli.next();
                    fila[2]=false;
                    
                    
                    modeloDirectores.addRow(fila);
                    tblDirectores.setModel(modeloDirectores);
                }
            
        } catch (ErrorPelicula ex) {
            Logger.getLogger(frmPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     } 
    
    //---------------------creacion de tabla--------------------------------
    public void rellenoTablaGenero(){
//        String[] encabezadosTabla={"Código","Genero","Seleccion"};
        
        ArrayList<Genero> asignaturas = new ArrayList();
        Object[] fila = new Object[5];
        modeloGeneros=new MyTableModel("Codigo","Genero");
        
        try {
            asignaturas = ControladorGenero.Buscar();
//            modeloGenero.setColumnIdentifiers(encabezadosTabla);
            Iterator<Genero> peli = asignaturas.iterator();
        
            while (peli.hasNext()) {
                    
                    fila[0] = peli.next();
                    fila[1] = peli.next();
                    fila[2]=false;
                    
                    
                    modeloGeneros.addRow(fila);
                    tblGeneros.setModel(modeloGeneros);
                }
            
        } catch (ErrorPelicula ex) {
            Logger.getLogger(frmPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        lblAgregar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPelicula = new javax.swing.JTextField();
        txtPeliculaDuracion = new javax.swing.JTextField();
        txtCodigoPelicula = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblCancelar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEstreno = new javax.swing.JTextField();
        txtSinopsis = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbClasificacion = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGeneros = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblActores = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDirectores = new javax.swing.JTable();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Pelicula:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel2.setText("Duracion:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        lblAgregar.setText("Agregar");
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarMouseClicked(evt);
            }
        });
        getContentPane().add(lblAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, -1, -1));

        jLabel7.setText("Agregar Pelicula");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));
        getContentPane().add(txtPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 180, -1));
        getContentPane().add(txtPeliculaDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 180, -1));
        getContentPane().add(txtCodigoPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 180, -1));

        jTextField6.setText("jTextField1");
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        jLabel8.setText("Código:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        lblCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar.png"))); // NOI18N
        lblCancelar.setText("Cancelar");
        getContentPane().add(lblCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 440, -1, -1));

        jLabel3.setText("Estreno:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));
        getContentPane().add(txtEstreno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 180, -1));
        getContentPane().add(txtSinopsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 180, -1));

        jLabel4.setText("Actor:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        jLabel5.setText("Director:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, -1, -1));

        jLabel6.setText("Clasificacion:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        jLabel9.setText("Genero:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, -1, -1));

        jLabel10.setText("Sinopsis:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        cmbClasificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 190, -1));

        tblGeneros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblGeneros);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 330, 90));

        tblActores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblActores);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 330, 90));

        tblDirectores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblDirectores);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 330, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseClicked
        String id=txtCodigoPelicula.getText();
        String pelicula=txtPelicula.getText();
        String duracion=txtPeliculaDuracion.getText();
        String estreno=txtEstreno.getText();
        String sinopsis=txtSinopsis.getText();
        
        if (id.isEmpty() && pelicula.isEmpty() && duracion.isEmpty() && estreno.isEmpty() && sinopsis.isEmpty()) {
            JOptionPane.showMessageDialog(null, "rellene todos los campos por favor");
        }else{
            int contA=0,contD=0,contG=0;
            int cuentaActores=modeloActores.getRowCount();
            int cuentaDirectores=modeloDirectores.getRowCount();
            int cuentaGeneros=modeloGeneros.getRowCount();
            

            for (int i = 0; i < cuentaActores; i++) {
                Vector rowActores=(Vector)modeloActores.getDataVector().get(i);
                boolean valorActor=(boolean)rowActores.get(2);
                if (valorActor) {
                    contA++;
                }
            }
            
            for (int i = 0; i < cuentaDirectores; i++) {
                Vector rowDirectores=(Vector)modeloDirectores.getDataVector().get(i);
                boolean valorDirector=(boolean)rowDirectores.get(2);
                if (valorDirector) {
                    contD++;
                }
            }
            
            for (int i = 0; i < cuentaGeneros; i++) {
                Vector rowGeneros=(Vector)modeloGeneros.getDataVector().get(i);
                boolean valorGeneros=(boolean)rowGeneros.get(2);
                if (valorGeneros) {
                    contG++;
                }
            }
            
            if ((contA>=1) && (contD>=1) && (contG>=1)) {
                
                try {
                    Pelicula peli=new Pelicula();
                    
                    peli.setIdPelicula(id);
                    peli.setPelicula(pelicula);
                    peli.setDuracion(duracion);
                    peli.setEstreno(estreno);
                    peli.setSinopsis(sinopsis);
                    ControladorPelicula.Agregar(peli);
                    String valorCmb=cmbClasificacion.getSelectedItem().toString();
                    Clasificacion cl=new Clasificacion();
                    cl=ControladorClasificacion.obtenerId(valorCmb);
                    
                    ControladorPeliculaClasificacion.Agregar(peli.getIdPelicula(), cl.getIdClasificacion());
                    
//                    LLenando la bd con los valores de la tabla
                    for (int i = 0; i < cuentaActores; i++) {
                        Vector rowActores=(Vector)modeloActores.getDataVector().get(i);
                        boolean valorActor=(boolean)rowActores.get(2);
                        if (valorActor) {
                            try {
                                String codActor=rowActores.get(0).toString();
                                ControladorPeliculaActor.Agregar(peli.getIdPelicula(), codActor);
                            } catch (ErrorPelicula ex) {
                                Logger.getLogger(frmPeliculaModificar.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    
                    for (int i = 0; i < cuentaDirectores; i++) {
                        Vector rowDirectores=(Vector)modeloDirectores.getDataVector().get(i);
                        boolean valorDirector=(boolean)rowDirectores.get(2);
                        if (valorDirector) {
                            try {
                                String codDirector=rowDirectores.get(0).toString();
                                ControladorPeliculaDirector.Agregar(peli.getIdPelicula(), codDirector);
                            } catch (ErrorPelicula ex) {
                                Logger.getLogger(frmPeliculaModificar.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    
                    for (int i = 0; i < cuentaGeneros; i++) {
                        Vector rowGeneros=(Vector)modeloGeneros.getDataVector().get(i);
                        boolean valorGeneros=(boolean)rowGeneros.get(2);
                        if (valorGeneros) {
                            try {
                                String codGeneros=rowGeneros.get(0).toString();
                                ControladorPeliculaGenero.Agregar(peli.getIdPelicula(), codGeneros);
                            } catch (ErrorPelicula ex) {
                                Logger.getLogger(frmPeliculaModificar.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    
                    System.out.println("Todo se ejecuto con exito");
                } catch (ErrorPelicula ex) {
                    Logger.getLogger(frmPeliculaModificar.class.getName()).log(Level.SEVERE, null, ex);
                }
             
            }else{
                System.out.println("Seleccione alguna opcion de las tablas");
            }
            
            
            
        }
    }//GEN-LAST:event_lblAgregarMouseClicked

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
            java.util.logging.Logger.getLogger(frmPeliculaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPeliculaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPeliculaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPeliculaModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmPeliculaModificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbClasificacion;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JTable tblActores;
    private javax.swing.JTable tblDirectores;
    private javax.swing.JTable tblGeneros;
    public javax.swing.JTextField txtCodigoPelicula;
    private javax.swing.JTextField txtEstreno;
    public javax.swing.JTextField txtPelicula;
    private javax.swing.JTextField txtPeliculaDuracion;
    private javax.swing.JTextField txtSinopsis;
    // End of variables declaration//GEN-END:variables
}
