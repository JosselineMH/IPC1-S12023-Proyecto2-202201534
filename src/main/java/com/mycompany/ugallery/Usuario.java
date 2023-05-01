/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ugallery;

import estructuras.ListaDobleImagen;
import java.util.ArrayList;

/**
 *
 * @author josse
 */
public class Usuario {
    public String nombreusuario; 
    public String categoriageneral;
    ArrayList<Categoria> listacategoria = new ArrayList<Categoria>();
    
    public Usuario(String nombreusuario){
        this.nombreusuario = nombreusuario;
        Usuario usuarioExistente = (Usuario) AppState.listausuarios.find(nombreusuario);
        if (usuarioExistente == null) {
            Categoria addcategoria = new Categoria();
            addcategoria.setNombreCategoria("General");
            listacategoria.add(addcategoria);
        }      
    }
    
    public void agregarCategoria(Categoria categoria) {
    this.listacategoria.add(categoria);
    }
    
    public void eliminarCategoria(Categoria categoria) {
        ListaDobleImagen listaImagenes = categoria.getListaimagenes();
        for (int i = 0; i < listaImagenes.getSize(); i++) {
            Imagen imagen = (Imagen) listaImagenes.get(i);
            listaImagenes.delete(imagen);
        }
        listacategoria.remove(categoria);
    }
    
    public Categoria buscarCategoria(String nombreCategoria) {
    for (Categoria categoria : listacategoria) {
        if (categoria.getNombreCategoria().equals(nombreCategoria)) {
            return categoria;
        }
    }
    return null;
    }
    
    public void eliminarTodasLasImagenesDeCategoria(String nombreCategoria) {
        Categoria categoria = buscarCategoria(nombreCategoria);
        if (categoria != null) {
            ListaDobleImagen listaImagenes = categoria.getListaimagenes();
            while (listaImagenes.getSize() > 0) {
                Imagen imagen = (Imagen) listaImagenes.get(0);
                listaImagenes.delete(imagen);
            }
        }
    }
    
    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public ArrayList<Categoria> getListaCategorias() {
        return listacategoria;
    }

    public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listacategoria = listaCategorias;
    }
    
    
}
