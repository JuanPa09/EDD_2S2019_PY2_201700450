/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficar;

import Estructuras.Matriz;
import Estructuras.nodoMatriz;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author juanp
 */
public class graficaMatriz {
    Matriz matriz;
    
    public graficaMatriz(Matriz matriz){
        this.matriz=matriz;
    }
    
        public void crearDot() throws IOException{
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
        fw = new FileWriter("nuevo.txt");
        pw=new PrintWriter(fw);
        pw.println("digraph G{");
        pw.println("node [margin=0 ranksep=\"0.1\", nodesep=\"0.1\" width=\"0.1\" height=\"0.1\" shape=Square ]");
        pw.println("root[group=0]");
        pw.println("root->hijonull0");
        pw.println("root->padrenull0");
        graphMatrix(pw);        
        pw.println("}");
        pw.close();
        fw.close();
        }catch(IOException ex){
            
        }
        graficar();
        
    }
            
    public void graphMatrix(PrintWriter pw){
        crearPadre(pw);
        crearHijo(pw);
        ePadre(pw);
        eHijo(pw);
        nodos(pw);
    }
        
        
    public void crearPadre(PrintWriter pw){
        nodoMatriz temp=matriz.raiz;
        int n=0;
        while(temp.abajo!=null){
            temp=temp.abajo;
            
            pw.println("padre"+temp.hijo+n+"[label=\""+temp.carpeta+"\" group=0]");
            n+=1;
        }
    }
    
    public void crearHijo(PrintWriter pw){
        nodoMatriz temp=matriz.raiz;
        int n=0;
        int x=0;
        while(temp.siguiente!=null){
            temp=temp.siguiente;
            pw.println("hijo"+temp.hijo+n+"[label=\""+temp.carpeta+"\" group="+x+"]");
            x+=1;
            n+=1;
        }
    }
    
    public void ePadre(PrintWriter pw){
        nodoMatriz temp = matriz.raiz.abajo;
        int n=0;
        while(temp.abajo!=null){
            pw.println("padre"+temp.hijo+n+"->"+"padre"+temp.abajo.hijo+(n+1));
            n+=1;
            
            temp=temp.abajo;
        }
    
    }
    
    public void eHijo(PrintWriter pw){
        nodoMatriz temp=matriz.raiz.siguiente;
        int n=0;
        String same="{rank=same;root";
        while(temp.siguiente!=null){
            pw.println("hijo"+temp.hijo+n+"->"+"hijo"+temp.siguiente.hijo+(n+1));
            same=same+";"+"hijo"+temp.hijo+n;
            n+=1;
            temp=temp.siguiente;
        }
        if (temp!=null) {
          same=same+";hijo"+temp.hijo+n+"}";  
        }else{
            same+="}";
        }
        
        pw.println(same);
    }
    
    
    public void nodos(PrintWriter pw){
        int nPadre=0; //Filas
        int nHijo=0; //Columnas
        
        nodoMatriz tempPadre = matriz.raiz;
        //Recorrer los padre
        tempPadre=tempPadre.abajo;//Comienza en la raiz
        while(tempPadre!=null){
            if (tempPadre!=null) { //Si tiene hijo
                
                
                nodoMatriz tempPadreHijo=tempPadre.siguiente;
                int n=0; //no. Hijo
                String same="{rank=same;"+"padre"+tempPadre.hijo+nPadre;
                while(tempPadreHijo!=null){//Recorrer todos sus hijos
                    //Crear todos los nodos de sus hijos
                    
                    nodoMatriz tempHijo = matriz.raiz.siguiente;
                    for (int i = 0; i <= nPadre-1; i++) {
                        tempHijo=tempHijo.siguiente;           
                    }
                    nHijo=nPadre;
                    while(!tempHijo.carpeta.equals(tempPadreHijo.hijo)){
                        tempHijo=tempHijo.siguiente;
                        nHijo+=1;//Esta el la posicion del group
                    }
                         
                    pw.println("node"+nPadre+tempPadreHijo.hijo+n+"[label=\""+tempPadreHijo.carpeta+"\" group="+nHijo+"]");
                    
                    if (tempPadre.siguiente==tempPadreHijo) {
                        pw.println("padre"+tempPadre.hijo+nPadre+"->"+"node"+nPadre+tempPadreHijo.hijo+n);
                    }else{
                        pw.println("node"+nPadre+tempPadreHijo.anterior.hijo+(n-1)+"->"+"node"+nPadre+tempPadreHijo.hijo+n);
                    }
                    pw.println("hijo"+tempHijo.hijo+nHijo+"->"+"node"+nPadre+tempPadreHijo.hijo+n);
                    same+=";node"+nPadre+tempPadreHijo.hijo+n;
                    n+=1;
                    tempPadreHijo=tempPadreHijo.siguiente;
                    
                }
                
                pw.println(same+"}");
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
