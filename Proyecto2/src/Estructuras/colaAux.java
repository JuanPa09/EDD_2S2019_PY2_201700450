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
public class colaAux {
    
    nodoColaAux raiz,fin;
    
    public void insertar(nodoAVL temp){
        nodoColaAux nuevo = new nodoColaAux(temp);
        if (raiz==null) {
            raiz=nuevo;
            fin=nuevo;
        }else{
            fin.siguiente=nuevo;
            fin=nuevo;
        }
    }
    
    
}
