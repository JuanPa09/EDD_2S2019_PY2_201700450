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
public class Bitacora {
    public nodoBitacora top,bottom;
    
    public void insertar(String nombre){
        nodoBitacora nuevo= new nodoBitacora(nombre);
        
        if (top==null) {
            top=nuevo;
            bottom=nuevo;
        }else{
            nodoBitacora temp = top;
            nuevo.siguiente=temp;
            top=nuevo;
        }
    }
    
}
