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
public class Cola {
    
    nodoCola raiz;
    nodoCola fin;
    
    
    
    
    
    public void Ingresar(String nombre, String contra){
        nodoCola nuevo = new nodoCola(nombre,contra);
        nodoCola temp = raiz;
        
        if (raiz==null) {
            raiz=nuevo;
            fin=nuevo;
        }else{
            fin.siguiente=nuevo;
            fin=nuevo;
        }      
    }
    
    
    public void Reinsertar(tablaHash tabla){
        nodoCola temp = raiz;
        while(temp!=null){
            tabla.agregarUsuario(temp.nombre, temp.contra);
            temp=temp.siguiente;
        }
    
    }
    
    
    
    
}
