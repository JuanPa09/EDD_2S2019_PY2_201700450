/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author juanp
 */
public class nodoBitacora {
    public nodoBitacora siguiente;
    public String nombre;
    public String timestamp;
    
    public nodoBitacora(String ruta,String timestamp){
        this.nombre=ruta;
        this.timestamp=timestamp;
    }
    
    
}
