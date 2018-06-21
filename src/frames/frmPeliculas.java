
package frames;

import clases.Actor;
import clases.Clasificacion;
import clases.ControladorActor;
import clases.ControladorClasificacion;
import clases.ControladorDirector;
import clases.ControladorGenero;
import clases.Pelicula;
import clases.ControladorPelicula;
import clases.ControladorPeliculaActor;
import clases.ControladorPeliculaClasificacion;
import clases.ControladorPeliculaDirector;
import clases.ControladorPeliculaGenero;
import clases.Director;
import clases.ErrorPelicula;
import clases.Genero;
import clases.MyTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class frmPeliculas extends javax.swing.JFrame {

    private DefaultTableModel modeloPeliculas;
    MyTableModel modeloActores;
    MyTableModel modeloDirectores;
    MyTableModel modeloGeneros;
    DefaultComboBoxModel modeloClasificacion;
    
    /**
     * Creates new form frmAsignatura
     */
    public frmPeliculas() {
        initComponents();
        jFrame1.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        jFrame1.setLocationRelativeTo(null);
        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        rellenoTabla();
    }
    
    
    //---------------------creacion de tabla--------------------------------
    public void rellenoTabla(){
        String[] encabezadosTabla={"Código","Pelicula"};
        modeloPeliculas=new DefaultTableModel();
        ArrayList<Pelicula> asignaturas = new ArrayList();
        Object[] fila = new Object[5];
        
        try {
            asignaturas = ControladorPelicula.Buscar();
            modeloPeliculas.setColumnIdentifiers(encabezadosTabla);
            Iterator<Pelicula> peli = asignaturas.iterator();
        
            while (peli.hasNext()) {
                    
                    fila[0] = peli.next();
                    fila[1] = peli.next();
                    fila[2] = peli.next();
                    fila[3] = peli.next();
                    fila[4] = peli.next();
                    
                    
                    modeloPeliculas.addRow(fila);
                    tblPelicula.setModel(modeloPeliculas);
                }
            
        } catch (ErrorPelicula ex) {
            Logger.getLogger(frmPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }   
    
    //---------------------creacion de tabla--------------------------------
    public void rellenoTablaActor(){
        
        modeloActores=new MyTableModel("Codigo","Actor");
        ArrayList<Actor> asignaturas = new ArrayList();
        Object[] fila = new Object[5];
        
        try {
            int seleccion = tblPelicula.getSelectedRow();
            asignaturas = ControladorPeliculaActor.BuscarActorPeliculas(tblPelicula.getValueAt(seleccion, 0).toString());
            
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
            int seleccion = tblPelicula.getSelectedRow();
            sucursales = ControladorPeliculaClasificacion.BuscarClasificacionPeliculas(tblPelicula.getValueAt(seleccion, 0).toString());
            
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
            int seleccion = tblPelicula.getSelectedRow();
            asignaturas = ControladorPeliculaDirector.BuscarDirectorPeliculas(tblPelicula.getValueAt(seleccion, 0).toString());
            
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
    
    public void llenandoTxtPeli(){
        Pelicula peli=new Pelicula();
        int seleccion; 
        seleccion = tblPelicula.getSelectedRow();
        try {
            peli = ControladorPelicula.BuscarPelicula(tblPelicula.getValueAt(seleccion, 0).toString());
            
            txtEstreno.setText(peli.getEstreno());
            txtPeliculaDuracion.setText(peli.getDuracion());
            txtSinopsis.setText(peli.getSinopsis());
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

        jFrame1 = new javax.swing.JFrame();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoPelicula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPelicula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPeliculaDuracion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEstreno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSinopsis = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbClasificacion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblActores = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDirectores = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGeneros = new javax.swing.JTable();
        lblAgregar1 = new javax.swing.JLabel();
        lblCancelar = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblDetalles = new javax.swing.JLabel();
        lblModificar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPelicula = new javax.swing.JTable();
        lblAgregar = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Código:");
        jFrame1.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));
        jFrame1.getContentPane().add(txtCodigoPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 180, -1));

        jLabel1.setText("Pelicula:");
        jFrame1.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));
        jFrame1.getContentPane().add(txtPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 180, -1));

        jLabel2.setText("Duracion:");
        jFrame1.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));
        jFrame1.getContentPane().add(txtPeliculaDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 180, -1));

        jLabel3.setText("Estreno:");
        jFrame1.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));
        jFrame1.getContentPane().add(txtEstreno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 180, -1));

        jLabel10.setText("Sinopsis:");
        jFrame1.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));
        jFrame1.getContentPane().add(txtSinopsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 180, -1));

        jLabel6.setText("Clasificacion:");
        jFrame1.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        cmbClasificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jFrame1.getContentPane().add(cmbClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 190, -1));

        jLabel5.setText("Actor:");
        jFrame1.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        jLabel7.setText("Director:");
        jFrame1.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, -1, -1));

        jLabel9.setText("Genero:");
        jFrame1.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, -1, -1));

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

        jFrame1.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 330, 90));

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

        jFrame1.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 330, 90));

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

        jFrame1.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 330, 90));

        lblAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        lblAgregar1.setText("Agregar");
        lblAgregar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregar1MouseClicked(evt);
            }
        });
        jFrame1.getContentPane().add(lblAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, -1, -1));

        lblCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar.png"))); // NOI18N
        lblCancelar.setText("Cancelar");
        lblCancelar.setMinimumSize(new java.awt.Dimension(600, 600));
        lblCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelarMouseClicked(evt);
            }
        });
        jFrame1.getContentPane().add(lblCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 440, -1, -1));

        jLabel11.setText("MODIFICAR");
        jFrame1.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cuaderno.png"))); // NOI18N
        lblDetalles.setText("Detalles");
        lblDetalles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDetalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDetallesMouseClicked(evt);
            }
        });
        getContentPane().add(lblDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, -1, -1));

        lblModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar.png"))); // NOI18N
        lblModificar.setText("modificar");
        lblModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificarMouseClicked(evt);
            }
        });
        getContentPane().add(lblModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, -1));

        jLabel4.setText("CARTELERA");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        lblEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete.png"))); // NOI18N
        lblEliminar.setText("eliminar");
        lblEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarMouseClicked(evt);
            }
        });
        getContentPane().add(lblEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, -1));

        tblPelicula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Pelicula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPelicula);
        if (tblPelicula.getColumnModel().getColumnCount() > 0) {
            tblPelicula.getColumnModel().getColumn(0).setResizable(false);
            tblPelicula.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 700, 90));

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        lblAgregar.setText("agregar");
        lblAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarMouseClicked(evt);
            }
        });
        getContentPane().add(lblAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/back.png"))); // NOI18N
        jLabel12.setText("Regresar");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblDetallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetallesMouseClicked
        if(tblPelicula.getSelectedRow()!=-1){
            int seleccion; 
            seleccion = tblPelicula.getSelectedRow();
            frmPeliculaDetalle detalle=new frmPeliculaDetalle();
            detalle.setVisible(true);
            this.setVisible(false);
            
            detalle.txtCodigoPelicula.setText(tblPelicula.getValueAt(seleccion, 0).toString());
            detalle.txtPelicula.setText((tblPelicula.getValueAt(seleccion, 1).toString()));
            
            
            modeloPeliculas=new DefaultTableModel();
            
            Genero genero = new Genero();
            Actor actor=new Actor();
            Director director=new Director();
            Pelicula pelicula=new Pelicula();
            Clasificacion clasificacion=new Clasificacion();
            Object[] fila = new Object[5];
        
        try {
            genero = ControladorGenero.BuscarGenero(tblPelicula.getValueAt(seleccion, 0).toString());
            actor = ControladorActor.BuscarActor(tblPelicula.getValueAt(seleccion, 0).toString());
            director = ControladorDirector.BuscarDirector(tblPelicula.getValueAt(seleccion, 0).toString());
            pelicula=ControladorPelicula.BuscarPelicula(tblPelicula.getValueAt(seleccion, 0).toString());
            clasificacion = ControladorClasificacion.BuscarClasificacion(tblPelicula.getValueAt(seleccion, 0).toString());

            detalle.txtGenero.setText(genero.getGenero());
            detalle.txtActores.setText(actor.getActor());
            detalle.txtDirectores.setText(director.getDirector());
            detalle.txtClasificacion.setText(clasificacion.getClasificacion()); 
            detalle.txtPeliculaDuracion.setText(pelicula.getDuracion());
            detalle.txtEstreno.setText(pelicula.getEstreno());
            detalle.txtSinopsis.setText(pelicula.getSinopsis());
            
            
            
            
        } catch (ErrorPelicula ex) {
            Logger.getLogger(frmPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_lblDetallesMouseClicked

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        Pelicula peli=new Pelicula();
        if(tblPelicula.getSelectedRow()!=-1){
            try {
                int seleccion;
                seleccion = tblPelicula.getSelectedRow();
                peli.setIdPelicula(tblPelicula.getValueAt(seleccion, 0).toString());
                ControladorPelicula.Eliminar(peli);
                JOptionPane.showMessageDialog(null, "La eliminacion fue correcta");
               modeloPeliculas.removeRow(tblPelicula.getSelectedRow());
            } catch (ErrorPelicula ex) {
                JOptionPane.showMessageDialog(null, "Elija una fila de la tabla");
            }
        }
    }//GEN-LAST:event_lblEliminarMouseClicked

    private void lblAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseClicked
        frmPeliculaAgregar add=new frmPeliculaAgregar();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblAgregarMouseClicked

    private void lblModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarMouseClicked
         if(tblPelicula.getSelectedRow()!=-1){
            int seleccion; 
            jFrame1.setVisible(true);
            this.setVisible(false);
            
            seleccion = tblPelicula.getSelectedRow();
            txtCodigoPelicula.setText(tblPelicula.getValueAt(seleccion, 0).toString());
            txtPelicula.setText((tblPelicula.getValueAt(seleccion, 1).toString()));
            llenandoTxtPeli();
            
            rellenoTablaActor();
            rellenoTablaDirectores();
            rellenoTablaGenero();
            rellenoComboClasifiacion();
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_lblModificarMouseClicked

    private void lblAgregar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregar1MouseClicked
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
                    ControladorPelicula.Modificar(peli);
                    String valorCmb=cmbClasificacion.getSelectedItem().toString();
                    Clasificacion cl=new Clasificacion();
                    cl=ControladorClasificacion.obtenerId(valorCmb);

                    ControladorPeliculaClasificacion.Modificar(peli.getIdPelicula(), cl.getIdClasificacion());

                    //                    LLenando la bd con los valores de la tabla
                    for (int i = 0; i < cuentaActores; i++) {
                        Vector rowActores=(Vector)modeloActores.getDataVector().get(i);
                        boolean valorActor=(boolean)rowActores.get(2);
                        if (valorActor) {
                            try {
                                String codActor=rowActores.get(1).toString();
                                ControladorPeliculaActor.Modificar(peli.getIdPelicula(), codActor);
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
                                String codDirector=rowDirectores.get(1).toString();
                                ControladorPeliculaDirector.Modificar(peli.getIdPelicula(), codDirector);
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
                                ControladorPeliculaGenero.Modificar(peli.getIdPelicula(), codGeneros);
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
    }//GEN-LAST:event_lblAgregar1MouseClicked

    private void lblCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelarMouseClicked
        jFrame1.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_lblCancelarMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        frmMenu menu=new frmMenu();
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

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
            java.util.logging.Logger.getLogger(frmPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPeliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbClasificacion;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblAgregar1;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblDetalles;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblModificar;
    private javax.swing.JTable tblActores;
    private javax.swing.JTable tblDirectores;
    private javax.swing.JTable tblGeneros;
    private javax.swing.JTable tblPelicula;
    public javax.swing.JTextField txtCodigoPelicula;
    private javax.swing.JTextField txtEstreno;
    public javax.swing.JTextField txtPelicula;
    private javax.swing.JTextField txtPeliculaDuracion;
    private javax.swing.JTextField txtSinopsis;
    // End of variables declaration//GEN-END:variables
}
