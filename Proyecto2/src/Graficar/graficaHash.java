/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficar;

import Estructuras.nodoHash;
import Estructuras.tablaHash;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author juanp
 */
public class graficaHash{
    tablaHash tabla;
    
    public graficaHash(tablaHash tabla){
        this.tabla=tabla;
    }
    
    
    public void crearDot() throws IOException{
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
        fw = new FileWriter("nuevo.txt");
        pw=new PrintWriter(fw);
        pw.println("digraph G{");
        pw.println("node[shape=record]");
        graphHash(pw,this.tabla);
        pw.println("}");
        pw.close();
        fw.close();
        }catch(IOException ex){
            
        }
        graficar();
    }
    
    private void graphHash(PrintWriter pw,tablaHash tabla){
        nodoHash temp = tabla.raiz;
        if (tabla.raiz.siguiente!=null) {
            while (temp!=null){

                while (temp!=null){
                if (temp.sigdatos!=null){
                  pw.println(temp.indice+"[label=\""+temp.indice+"|Usuario: "+temp.sigdatos.nombre+" Contrasena: "+temp.sigdatos.contra+" \"]");
                    

                }else{
                    pw.println(temp.indice+"[label=\""+temp.indice+"\"]");
                }
                
                if (temp.siguiente!=null) {
                        pw.println(temp.indice+"->"+temp.siguiente.indice);
                    }
                
                temp=temp.siguiente;
            }


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
