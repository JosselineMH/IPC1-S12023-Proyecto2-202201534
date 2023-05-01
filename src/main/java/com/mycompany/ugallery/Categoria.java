/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ugallery;

import estructuras.ListaDobleImagen;
import javax.swing.*;

/**
 *
 * @author josse
 */
public class Categoria {
   
    private String nombreCategoria;
    private JTextField NombreImagen;
    private JLabel ImagenLBL;
    ListaDobleImagen listaimagenes = new ListaDobleImagen();
    
    public void agregarImagen(Imagen imagen) {
      listaimagenes.add(imagen);
    }
    
    
    public void eliminarImagen(Imagen imagen) {
      listaimagenes.delete(imagen);
    }
    public void ImprimirImagenes() {
      listaimagenes.Imprimir();
    }
    public void SiguienteImagen(JTextField NombreImagen, JLabel ImagenLBL){
        listaimagenes.Siguiente(NombreImagen, ImagenLBL);
    }
    public void AnteriorImagen(JTextField NombreImagen, JLabel ImagenLBL){
        listaimagenes.Anterior(NombreImagen, ImagenLBL);
    }

    public ListaDobleImagen getListaimagenes() {
        return listaimagenes;
    }

    public void setListaimagenes(ListaDobleImagen listaimagenes) {
        this.listaimagenes = listaimagenes;
    }

     
    
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    
}
