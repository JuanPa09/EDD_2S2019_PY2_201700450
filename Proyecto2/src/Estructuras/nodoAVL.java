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
    public String contenido;
    public int fe;
    int height;
    public String timestamp;
    public String Propietario;
    public nodoAVL left,right;
    
    public nodoAVL(String nombre,String contenido,String timestamp,String Propietario){
        this.nombre=nombre;
        this.contenido=contenido;
        this.fe=0;
        this.Propietario=Propietario;
        this.timestamp=timestamp;
        this.left=null;
        this.right=null;
    }
    
}
