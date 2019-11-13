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
public class nodoMatriz {
    
    String padre;
    String hijo;
    String root;
    String carpeta;
    nodoMatriz arriba=null,abajo=null,anterior=null,siguiente=null;
    
    public nodoMatriz(String hijo,String padre){
        this.padre=padre;
        this.hijo=hijo;
    }
    
    public nodoMatriz(){
        this.root="/";
    }
    
    public nodoMatriz(String carpeta){
        this.carpeta=carpeta;
    }

    
    
}
