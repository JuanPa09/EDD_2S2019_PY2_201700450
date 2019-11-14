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
    
    public String hijo;
    public String root;
    public String carpeta;
    public nodoMatriz arriba=null,abajo=null,anterior=null,siguiente=null;
    public arbolAVL archivos;
    

    
    public nodoMatriz(arbolAVL archivos){
        this.carpeta="root";
        
        nodoMatriz node = new nodoMatriz("/",archivos); 
        this.abajo=node;
        
    }
    //Carpeta Padre
    public nodoMatriz(String carpeta,arbolAVL archivos){
        this.carpeta=carpeta;
        this.archivos=archivos;
    }
    //Carpeta hijo
    public nodoMatriz(String carpeta){
        this.carpeta=carpeta;
    }

    public nodoMatriz(String padre,String hijo){
        this.carpeta=padre+"/"+hijo;
        this.hijo=hijo;
    }
    
    
}
