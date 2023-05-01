/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import com.mycompany.ugallery.Imagen;

/**
 *
 * @author josse
 */
public class NodoImagen {
    private Imagen Imagen;
    private NodoImagen siguiente;
    private NodoImagen anterior;
    
    public NodoImagen(Imagen Imagen){
        this.Imagen = Imagen;
    }

    public NodoImagen(Imagen Imagen, NodoImagen siguiente, NodoImagen anterior) {
        this.Imagen = Imagen;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public Imagen getImagen() {
        return Imagen;
    }

    public void setImagen(Imagen Imagen) {
        this.Imagen = Imagen;
    }

    public NodoImagen getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoImagen siguiente) {
        this.siguiente = siguiente;
    }

    public NodoImagen getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoImagen anterior) {
        this.anterior = anterior;
    }
    
    
}
