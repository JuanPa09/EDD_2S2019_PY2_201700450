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
public class nodoHash {
    nodoHash anterior=null;
    public nodoHash siguiente=null;
    public nodoHash sigdatos=null;
    public String indice="";
    public String contra="";
    public String nombre="";
    public Matriz miscarpetas;
    
    public nodoHash(String indice){
        this.indice=indice;
    }
    
    public nodoHash(String nombre, String contra,Matriz carpetas){
        this.nombre=nombre;
        this.contra=contra;
        this.miscarpetas=carpetas;
    }
    
    
    
}
