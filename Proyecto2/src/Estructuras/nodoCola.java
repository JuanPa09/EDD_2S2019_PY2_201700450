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
public class nodoCola {
    nodoCola siguiente;
    public String contra="";
    public String nombre="";
    public Matriz matriz;
    
    public nodoCola(String nombre, String contra,Matriz matriz){
        this.nombre=nombre;
        this.contra=contra;
        this.matriz=matriz;
    }
    
    
    
}
