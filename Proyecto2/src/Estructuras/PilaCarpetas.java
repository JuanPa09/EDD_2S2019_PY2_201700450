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
public class PilaCarpetas {
    public nodoPilaCarpetas top,bottom;
    
    public void insertar(nodoMatriz carpeta,String ruta){
        nodoPilaCarpetas nuevo= new nodoPilaCarpetas(carpeta,ruta);
        
        if (top==null) {
            top=nuevo;
            bottom=nuevo;
        }else{
            nodoPilaCarpetas temp = top;
            nuevo.siguiente=temp;
            top=nuevo;
        }
    }
    
    
    public nodoPilaCarpetas pop(){
        System.out.println("Se realizo un pop");
        nodoPilaCarpetas temp = top;
            
        top=top.siguiente;
        
        return temp;
        
    }


    
    public boolean vacia(){
        if (top==null) {
            return true;
        }
        return false;
        
    }
    
    public void peek(){
        System.out.println("Carpeta Anterior"+top.carpetaAnterior.carpeta+" Ruta: "+top.ruta);
    }
    
    public void vaciar(){
        this.top=null;
    
    }
    
    
}
