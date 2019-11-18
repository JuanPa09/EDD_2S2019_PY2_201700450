/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficar;

import Estructuras.nodoBitacora;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author juanp
 */
public class graficaBitacora {
    nodoBitacora raiz;
    
    public graficaBitacora(nodoBitacora raiz){
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
        graphBitacora(pw);
        pw.println("}");
        pw.close();
        fw.close();
        }catch(IOException ex){
            
        }
        graficar();
    }
    
    
    public void graphBitacora(PrintWriter pw){
        nodoBitacora temp = raiz;
        int n=0;
         while(temp.siguiente!=null){
            pw.println(n+"[label=\""+temp.nombre.replace("\"", "")+"\\n"+temp.timestamp+"\"]");
            pw.println(n+"->"+(n+1));
            n+=1;
            temp=temp.siguiente;
        }
        pw.println(n+"[label=\""+temp.nombre+"\"]");
        
    }
    
    
    
    public void graficar(){
        try {
            Runtime.getRuntime().exec("dot -Tpng nuevo.txt -o imagen.png");
        } catch (IOException ex) {
            
        }
        
        
    }
    
    
}
