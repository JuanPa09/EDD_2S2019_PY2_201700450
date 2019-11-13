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
public class Matriz {
    nodoMatriz raiz;
    
    
    public Matriz(){
        raiz = new nodoMatriz();
    }
    
    private nodoMatriz buscar_fila(String padre){
        nodoMatriz temp = raiz;
        
        while(temp!=null){
            if (temp.padre==padre) {
                return temp;
            }
            temp=temp.abajo;
        }
        return null;
    }
    
    private nodoMatriz buscar_columna(String hijo){
        nodoMatriz temp = raiz;
        
        while(temp!=null){
            if (temp.hijo==hijo) {
                return temp;
            }
            temp=temp.siguiente;
        }
        return null; 
    }
    
    private void crearCarpetaHijo(String carpeta){
        nodoMatriz temp = raiz;
        nodoMatriz nuevo = new nodoMatriz(carpeta);
        while(temp.siguiente!=null){
            temp=temp.siguiente;
        }
        temp.siguiente=nuevo;
        nuevo.anterior=temp;
    }
    
    private void crearCarpetaPadre(String carpeta){
        nodoMatriz temp = raiz;
        nodoMatriz nuevo = new nodoMatriz(carpeta);
        while(temp.abajo!=null){
            temp=temp.abajo;
        }
        temp.abajo=nuevo;
        nuevo.arriba=temp;
        
        crearCarpetaHijo(carpeta);
        
    }
    
    private void Enlace(nodoMatriz hijo, nodoMatriz padre){
        
        nodoMatriz nuevo=new nodoMatriz(hijo.hijo,padre.padre);
                
        padre.siguiente=nuevo;
        nuevo.anterior=padre;
        
        hijo.abajo=nuevo;
        nuevo.arriba=hijo;
        
    }
    
    

    
    
    
    
    

    
    
}
