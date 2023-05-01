/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import com.mycompany.ugallery.Imagen;
import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author josse
 */
public class ListaDobleImagen extends EstructuraDeDatos{
    NodoImagen  primerNodo;
    NodoImagen ultimoNodo;
    public ImageIcon icono;

    
    public boolean isEmpty() {
        return primerNodo == null;
    }
    
    @Override
    public void add(Object e) {
        Imagen imagen = (Imagen)e;
        if (primerNodo==null) {
            primerNodo = ultimoNodo= new NodoImagen(imagen);
        }else {
            NodoImagen nuevoNodo = new NodoImagen(imagen, null, ultimoNodo);
            ultimoNodo.setSiguiente(nuevoNodo);
            ultimoNodo = nuevoNodo;
        } 
        index++;
    }
    
    public void clear() {
        index = 0;
        primerNodo = null;
        ultimoNodo = null;
    }
    
    public void Imprimir(){
        if(primerNodo==null){
            System.out.println("null");
            return;
        }
        NodoImagen NodoAuxiliar=primerNodo;
        while(NodoAuxiliar!=null){
            System.out.print(NodoAuxiliar.getImagen().getNombre()+"<--->");
            NodoAuxiliar=NodoAuxiliar.getSiguiente();
        }
        System.out.println("null");
    }
    
    public void Siguiente(JTextField NombreImagen, JLabel ImagenLBL){
        String nombreImagen=NombreImagen.getText();
        if(primerNodo==null){
            return;
        }
        NodoImagen NodoAuxiliar1=primerNodo;
        for (int i=0; i < index; i++) {
            if(NodoAuxiliar1.getImagen().nombre.equals(nombreImagen)){
                NodoAuxiliar1 = NodoAuxiliar1.getSiguiente();
                if(NodoAuxiliar1==null){
                    return;
                }else{
                    NombreImagen.setText(String.valueOf(NodoAuxiliar1.getImagen().getNombre()));
                    icono = NodoAuxiliar1.getImagen().imageIcon;
                    Image Imagen = icono.getImage();
                    Imagen = Imagen.getScaledInstance(ImagenLBL.getWidth(), ImagenLBL.getHeight(), Image.SCALE_DEFAULT);
                    ImagenLBL.setIcon(new ImageIcon(Imagen));
                    break;    
                }
            }else{
                NodoAuxiliar1 = NodoAuxiliar1.getSiguiente();
            } 
        }
    }
    
    public void Anterior(JTextField NombreImagen, JLabel ImagenLBL){
        String nombreImagen=NombreImagen.getText();
        if(ultimoNodo==null){
            return;
        } 
        NodoImagen NodoAuxiliar1=ultimoNodo;
        for (int i = 0; i < index; i++) {
            if(NodoAuxiliar1.getImagen().nombre.equals(nombreImagen)){
                NodoAuxiliar1 = NodoAuxiliar1.getAnterior();
                if(NodoAuxiliar1==null){
                    break;
                }else{
                    NombreImagen.setText(String.valueOf(NodoAuxiliar1.getImagen().getNombre()));
                    icono = NodoAuxiliar1.getImagen().imageIcon;
                    Image Imagen = icono.getImage();
                    Imagen = Imagen.getScaledInstance(ImagenLBL.getWidth(), ImagenLBL.getHeight(), Image.SCALE_DEFAULT);
                    ImagenLBL.setIcon(new ImageIcon(Imagen));
                    break;
                }
            }else{
                NodoAuxiliar1 = NodoAuxiliar1.getAnterior();
            }
        } 
    }

   
    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object e) {
        if(primerNodo==null){
           return null;
        } 
        String NombreImagen = e.toString();
        NodoImagen NodoAuxiliar =primerNodo;
        for (int i = 0; i < index; i++) {
            if(NodoAuxiliar.getImagen().getNombre().equals(NombreImagen)){
                return NodoAuxiliar.getImagen();
            }
            NodoAuxiliar = NodoAuxiliar.getSiguiente();
        }
        return null;
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getSize() {
        return index;
    }

    @Override
    public Object get(int i) {
        if(primerNodo==null){
           return null;
        } 
        
        if (i < 0  || i > index) {
            return new IndexOutOfBoundsException();
        }
        
        NodoImagen nodoAuxiliar = primerNodo;
        for (int contador = 0; contador < i; contador++) {
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return nodoAuxiliar.getImagen();
    }
  

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object e) {
        String nombreImagen=e.toString();
        NodoImagen nodoAuxiliar=primerNodo;
        while(nodoAuxiliar!=null&&!nodoAuxiliar.getImagen().getNombre().equals(nombreImagen)){
            nodoAuxiliar=nodoAuxiliar.getSiguiente();
        }
        if(nodoAuxiliar==null){
            return;
        }else if(nodoAuxiliar==primerNodo){
            primerNodo=primerNodo.getSiguiente();
            primerNodo.setAnterior(null);
            
        }else if(nodoAuxiliar==ultimoNodo){
            ultimoNodo= ultimoNodo.getAnterior();
            ultimoNodo.setSiguiente(null);
        }else{
            nodoAuxiliar.getAnterior().setSiguiente(nodoAuxiliar.getSiguiente());
            nodoAuxiliar.getSiguiente().setAnterior(nodoAuxiliar.getAnterior());
        }
        index--;
    }
    
}
