/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficar;

import Estructuras.nodoMatriz;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author juanp
 */
public class graficaGrafos {
    nodoMatriz raiz;
    
    public graficaGrafos(nodoMatriz raiz){
        this.raiz=raiz;
    }
    
    public void crearDot() throws IOException{
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
        fw = new FileWriter("nuevo.txt");
        pw=new PrintWriter(fw);
        pw.println("digraph G{");
        pw.println("node[shape=record]");
        grafo(pw);
        pw.println("}");
        pw.close();
        fw.close();
        }catch(IOException ex){
            
        }
        graficar();
    }
    
    public void grafo(PrintWriter pw){
        int nPadre=0; //Filas
        int nHijo=0; //Columnas
        
        nodoMatriz tempPadre = raiz.abajo;
        while(tempPadre!=null){
            pw.println(tempPadre.carpeta.replace("/", "a").replace(" ", "_")+nPadre+"[label=\""+tempPadre.carpeta+"\"]");
            if (tempPadre.siguiente!=null) { //Si tiene hijo
                
                
                
                nodoMatriz tempPadreHijo=tempPadre.siguiente;
                int n=0; //no. Hijo
                while(tempPadreHijo!=null){//Recorrer todos sus hijos
                    //Crear todos los nodos de sus hijos
                    
                    nodoMatriz tempHijo = raiz.siguiente;
                    for (int i = 0; i <= nPadre-1; i++) {
                        tempHijo=tempHijo.siguiente;           
                    }
                    nHijo=nPadre;
                    while(!tempHijo.carpeta.equals(tempPadreHijo.hijo)){
                        tempHijo=tempHijo.siguiente;
                        nHijo+=1;//Esta el la posicion del group
                    }
                    
                    pw.println(tempPadre.carpeta.replace("/", "a").replace(" ", "_")+nPadre+"->"+tempHijo.carpeta.replace("/", "a").replace(" ", "_")+(nHijo+1));
                    
                    
                    tempPadreHijo=tempPadreHijo.siguiente;
                    
                }
                
                
                
            }  
          nPadre+=1;
          tempPadre=tempPadre.abajo;
        }
    
    
    }
    
    
    
    public void graficar(){
        try {
            Runtime.getRuntime().exec("dot -Tpng nuevo.txt -o imagen.png");
        } catch (IOException ex) {
            
        }
        
        
    }
    
    
    
}
