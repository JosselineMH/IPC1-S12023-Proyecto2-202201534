/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ugallery;

import handlers.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JOptionPane;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author josse
 */
public class ConvertidorJFrame extends javax.swing.JFrame {
    public HiloImagenes hiloImagenes;
    public Thread HiloImagenes;
    public  int imgTotal=0, imgProcesadas=0;
    

    public ConvertidorJFrame() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("CONVERTIDOR");
        
       
        AppState.listausuarios.LlenarUsuarios(usuarioCombo);
    }
    

    
    public class HiloImagenes implements Runnable{
        JProgressBar barraproceso;
        public boolean ValidarHilo=true;
        public ArrayList<String> listaImagen;
        JTextArea colaEjecucion;
        int total=0;
        int progreso=0;
        
        public HiloImagenes(ArrayList<String>listaImagen,JTextArea colaEjecucion, JProgressBar barraproceso){
            this.listaImagen=listaImagen;
            this.colaEjecucion=colaEjecucion;
            this.barraproceso = barraproceso;
            for (int i = 0; i <listaImagen.size(); i++) {
                total++;
            }
            progreso=100/total;
        }
        @Override
        public void run() {
            while(ValidarHilo){
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException ex) {
                    Logger.getLogger(ConvertidorJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i <listaImagen.size(); i++) {
                    if(BMPCb.isSelected()==true){
                        JPEGtoBMPImage HanderJPEGtoBMP= new JPEGtoBMPImage(listaImagen.get(i));
                        try{
                            JPEGHandler.runHandler(HanderJPEGtoBMP);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        File archivo = new File(listaImagen.get(i).toString());
                        String fileName=archivo.getName();

                        String nombre = FilenameUtils.getBaseName(fileName);
                        colaEjecucion.append("Convirtiendo de JPEG a BMP la imagen: "+nombre+"..."+"\n");
                    } 
                    if(CopiaCb.isSelected()==true){
                        BmpHandlerCopy HandlerCopia= new BmpHandlerCopy(listaImagen.get(i));
                        try{
                            JPEGHandler.runHandler(HandlerCopia);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        File archivo = new File(listaImagen.get(i).toString());
                        String fileName=archivo.getName();

                        String nombre = FilenameUtils.getBaseName(fileName);
                        colaEjecucion.append("Realizando una copia de la imagen: "+nombre+"..."+"\n");
                    }
                    if(ColoresCb.isSelected()==true){
                        JPEGImageHandlerColors HandlerColores = new JPEGImageHandlerColors(listaImagen.get(i));
                        try{
                            JPEGHandler.runHandler(HandlerColores);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        File archivo = new File(listaImagen.get(i).toString());
                        String fileName=archivo.getName();

                        String nombre = FilenameUtils.getBaseName(fileName);
                        colaEjecucion.append("Aplicando filtros Rojo, Verde, Azul y Sepia a la imagen: "+nombre+"..."+"\n");
                    }
                    if(modificarCb.isSelected()==true){
                        JPEGImageHandlerRotator Handlermodificar = new JPEGImageHandlerRotator(listaImagen.get(i));
                        try{
                            JPEGHandler.runHandler(Handlermodificar);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        File archivo = new File(listaImagen.get(i).toString());
                        String fileName=archivo.getName();

                        String nombre = FilenameUtils.getBaseName(fileName);
                        colaEjecucion.append("Aplicando filtros de rotación horizaontal y vertical a la imagen: "+nombre+"..."+"\n");
                    }
                    if(blanconegroCb.isSelected()==true){
                        JPEGImageHandlerBN HandlerBN = new JPEGImageHandlerBN(listaImagen.get(i));
                        try{
                            JPEGHandler.runHandler(HandlerBN);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        File archivo = new File(listaImagen.get(i).toString());
                        String fileName=archivo.getName();

                        String nombre = FilenameUtils.getBaseName(fileName);
                        colaEjecucion.append("Aplicando filtro Blanco Y Negro a la imagen: "+nombre+"..."+"\n");
                    } 
                    
                    imgProcesadas++;
                    if(imgProcesadas<=imgTotal){
                        barraproceso.setValue(barraproceso.getValue()+(progreso+1));
                    }
                     
                }
                JOptionPane.showMessageDialog(null, "EL proceso ha finalizado", "Filtros Aplicados", JOptionPane.INFORMATION_MESSAGE);
                BMPCb.setSelected(false);
                CopiaCb.setSelected(false);
                ColoresCb.setSelected(false);
                modificarCb.setSelected(false);
                blanconegroCb.setSelected(false);
                barraproceso.setValue(0);
                consolaArea.setText("");
                imgTotal=0;
                imgProcesadas=0;
                ValidarHilo=false;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usuarioCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        categoriaCombo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        regresarBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        colaImagenesList = new javax.swing.JList<>();
        BMPCb = new javax.swing.JCheckBox();
        CopiaCb = new javax.swing.JCheckBox();
        ColoresCb = new javax.swing.JCheckBox();
        modificarCb = new javax.swing.JCheckBox();
        blanconegroCb = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        consolaArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 54, 60));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");

        usuarioCombo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        usuarioCombo.setForeground(new java.awt.Color(0, 0, 0));
        usuarioCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioComboActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Categoría:");

        categoriaCombo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        categoriaCombo.setForeground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(235, 73, 96));
        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 73, 96)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        regresarBtn.setBackground(new java.awt.Color(154, 185, 152));
        regresarBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        regresarBtn.setForeground(new java.awt.Color(255, 255, 255));
        regresarBtn.setText("REGRESAR ");
        regresarBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(154, 185, 152)));
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cola de Procesamiento");

        colaImagenesList.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        colaImagenesList.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(colaImagenesList);

        BMPCb.setBackground(new java.awt.Color(41, 54, 60));
        BMPCb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        BMPCb.setForeground(new java.awt.Color(255, 255, 255));
        BMPCb.setText("JPG A BMP ");

        CopiaCb.setBackground(new java.awt.Color(41, 54, 60));
        CopiaCb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        CopiaCb.setForeground(new java.awt.Color(255, 255, 255));
        CopiaCb.setText("Copia JPEG");

        ColoresCb.setBackground(new java.awt.Color(41, 54, 60));
        ColoresCb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        ColoresCb.setForeground(new java.awt.Color(255, 255, 255));
        ColoresCb.setText("Rojo, Verde, Azul y Sepia");

        modificarCb.setBackground(new java.awt.Color(41, 54, 60));
        modificarCb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        modificarCb.setForeground(new java.awt.Color(255, 255, 255));
        modificarCb.setText("Modificar Imagen");

        blanconegroCb.setBackground(new java.awt.Color(41, 54, 60));
        blanconegroCb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        blanconegroCb.setForeground(new java.awt.Color(255, 255, 255));
        blanconegroCb.setText("Blanco y Negro");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad Procesada");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Consola de Ejecución");

        progressBar.setForeground(new java.awt.Color(0, 204, 51));

        jButton2.setBackground(new java.awt.Color(235, 73, 96));
        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Ejecutar en Paralelo");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 73, 96)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        consolaArea.setColumns(20);
        consolaArea.setRows(5);
        jScrollPane2.setViewportView(consolaArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usuarioCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categoriaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(regresarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(blanconegroCb, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ColoresCb, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CopiaCb, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modificarCb, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(BMPCb)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(progressBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(188, 188, 188)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(253, 253, 253)
                                .addComponent(jLabel5)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usuarioCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(categoriaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BMPCb)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(CopiaCb)
                        .addGap(18, 18, 18)
                        .addComponent(ColoresCb)
                        .addGap(18, 18, 18)
                        .addComponent(modificarCb)
                        .addGap(18, 18, 18)
                        .addComponent(blanconegroCb)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(regresarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        InicioJFrame pr = new InicioJFrame();
        pr.setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarBtnActionPerformed

    
    
    
    
    private void usuarioComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioComboActionPerformed
        this.categoriaCombo.removeAllItems();
        Usuario usuarioActual = (Usuario) AppState.listausuarios.find(usuarioCombo.getSelectedItem()); 
        for (int i=0; i<usuarioActual.listacategoria.size(); i++) {
            categoriaCombo.addItem(usuarioActual.listacategoria.get(i).getNombreCategoria());
        }
    }//GEN-LAST:event_usuarioComboActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Usuario usuarioActual = (Usuario) AppState.listausuarios.find(usuarioCombo.getSelectedItem()); 
        Categoria categoria = (Categoria)usuarioActual.listacategoria.get(categoriaCombo.getSelectedIndex());
        if(categoria.getListaimagenes().get(0)==null){
            JOptionPane.showMessageDialog(null, "No existen imágenes en la categoria "+categoriaCombo.getSelectedItem()+".", "Ugallery", JOptionPane.INFORMATION_MESSAGE);
        }else{
            categoria.retornarNombre(colaImagenesList);
            JOptionPane.showMessageDialog(null, "Imágenes de la categoría "+categoriaCombo.getSelectedItem()+" agregadas a la cola de procesamiento.", "Ugallery", JOptionPane.INFORMATION_MESSAGE);
            
        }
  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if (colaImagenesList.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(null, "No se han agregado Imagenes a la cola de procesamiento", "Ugallery", JOptionPane.INFORMATION_MESSAGE);
        }else if(BMPCb.isSelected()==false && CopiaCb.isSelected()==false && ColoresCb.isSelected()== false && modificarCb.isSelected()==false && blanconegroCb.isSelected()==false){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una de las opciones", "EDITOR", JOptionPane.WARNING_MESSAGE);
        }else{
            ArrayList<String>listaImagen1= new ArrayList<String>();
            Usuario usuarioActual = (Usuario) AppState.listausuarios.find(usuarioCombo.getSelectedItem());
            Categoria categoria = (Categoria)usuarioActual.listacategoria.get(categoriaCombo.getSelectedIndex());
            categoria.getListaimagenes().listaImagen(listaImagen1);
            int numItems = colaImagenesList.getModel().getSize();
            imgTotal = numItems;


            hiloImagenes= new HiloImagenes(listaImagen1, consolaArea, progressBar);
            HiloImagenes = new Thread(hiloImagenes);
            HiloImagenes.start();
        }
            
       
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ConvertidorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConvertidorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConvertidorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConvertidorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConvertidorJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox BMPCb;
    private javax.swing.JCheckBox ColoresCb;
    private javax.swing.JCheckBox CopiaCb;
    private javax.swing.JCheckBox blanconegroCb;
    private javax.swing.JComboBox<String> categoriaCombo;
    private javax.swing.JList<String> colaImagenesList;
    private javax.swing.JTextArea consolaArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox modificarCb;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JComboBox<String> usuarioCombo;
    // End of variables declaration//GEN-END:variables
}
