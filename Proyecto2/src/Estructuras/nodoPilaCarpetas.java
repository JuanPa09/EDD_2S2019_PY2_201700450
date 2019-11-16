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
public class nodoPilaCarpetas {
    public nodoMatriz carpetaAnterior;
    nodoPilaCarpetas siguiente;
    public String ruta="vacio";
    
    public nodoPilaCarpetas(nodoMatriz temp,String ruta){
        carpetaAnterior=temp;
        this.ruta=ruta;
        siguiente=null;
    }
    
    public nodoPilaCarpetas(String ruta){
        this.ruta=ruta;
        
    }
    
}
