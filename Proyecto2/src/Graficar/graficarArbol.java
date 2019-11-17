/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficar;

import Estructuras.nodoAVL;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author juanp
 */
public class graficarArbol {
    nodoAVL raiz;
    public graficarArbol(nodoAVL raiz){
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
        graphArbol(this.raiz,pw);
        pw.println("}");
        pw.close();
        fw.close();
        }catch(IOException ex){
            
        }
        graficar();
    }
    
    
    
    
    public void graphArbol(nodoAVL raiz,PrintWriter pw){
        pw.println(raiz.nombre.replace(".", "")+"[label=\""+raiz.nombre+"\\n"+raiz.contenido+"\\n"+raiz.fe+"\\n"+raiz.timestamp+"\\n"+raiz.Propietario+" \"]");
        if (raiz!=null) {
            //LEFT
            if (raiz.left!=null) {
                pw.println(raiz.nombre.replace(".", "")+"->"+raiz.left.nombre.replace(".", ""));
                graphArbol(raiz.left,pw);
            }else{
                pw.println(raiz.nombre.replace(".", "")+"a[label=\"NULL\"]");
                pw.println(raiz.nombre.replace(".", "")+"->"+raiz.nombre.replace(".", "")+"a");
            }
            
            //RIGHT
            if (raiz.right!=null) {
                pw.println(raiz.nombre.replace(".", "")+"->"+raiz.right.nombre.replace(".", ""));
                graphArbol(raiz.right,pw);
            }else{
                pw.println(raiz.nombre.replace(".", "")+"b[label=\"NULL\"]");
                pw.println(raiz.nombre.replace(".", "")+"->"+raiz.nombre.replace(".", "")+"b");
            }   
        }
    
    }
    
    
    
    
    
    
    public void graficar(){
        try {
            Runtime.getRuntime().exec("dot -Tpng nuevo.txt -o imagen.png");
        } catch (IOException ex) {
            
        }
        
        
    }
    
}
