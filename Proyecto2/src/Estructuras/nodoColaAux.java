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
public class nodoColaAux {
    nodoColaAux siguiente;
    public nodoAVL temp;
    public nodoColaAux(nodoAVL temp){
        this.temp=temp;
        this.siguiente=null;
    }
    
    
}
