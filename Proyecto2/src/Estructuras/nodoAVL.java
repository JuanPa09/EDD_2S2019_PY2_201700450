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
public class nodoAVL {
    public String nombre;
    String contenido;
    int fe;
    int height;
    String timestamp;
    String Propietario;
    public nodoAVL left,right;
    
    public nodoAVL(String nombre,String contenido){
        this.nombre=nombre;
        this.contenido=contenido;
        this.fe=0;
        this.left=null;
        this.right=null;
    }
    
}
