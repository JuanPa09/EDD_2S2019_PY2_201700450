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
    public nodoMatriz raiz;
    
    public Matriz(){
        arbolAVL arbol = new arbolAVL();
        nodoMatriz node = new nodoMatriz(arbol);
        this.raiz = node;
    }
    
    private nodoMatriz buscar_fila(nodoMatriz padre){
        nodoMatriz temp = raiz;
        
        while(temp!=null){
            if (temp==padre) {
                return temp;
            }
            temp=temp.abajo;
        }
        return null;
    }
    
    private nodoMatriz buscar_columna(nodoMatriz hijo){
        nodoMatriz temp = raiz;
        
        while(temp!=null){
            if (temp==hijo) {
                return temp;
            }
            temp=temp.siguiente;
        }
        return null; 
    }
    
    public nodoMatriz crearCarpetaHijo(String carpeta){
        nodoMatriz temp = raiz;
        nodoMatriz nuevo = new nodoMatriz(carpeta);
        while(temp.siguiente!=null){
            temp=temp.siguiente;
        }
        temp.siguiente=nuevo;
        nuevo.anterior=temp;
        
        //System.out.println("Se creo carpeta hijo");
        return nuevo;
        
    }
    
    public void crearCarpetaPadre(String carpeta){
        nodoMatriz temp = raiz;
        nodoMatriz nuevo = new nodoMatriz(carpeta,new arbolAVL());
        while(temp.abajo!=null){
            temp=temp.abajo;
        }
        temp.abajo=nuevo;
        nuevo.arriba=temp;
        //System.out.println("Se creo carpeta Padre");
    }
    
    
    public void nuevoArchivo(nodoMatriz padre,String nombreArchivo,String contenido,String timestamp,String propietario){
        padre.archivos.insertar(nombreArchivo, contenido,timestamp,propietario);
    }
    
    
    
    public void nuevaCarpeta(nodoMatriz padre,String nombreCarpeta){
        nodoMatriz hijo=crearCarpetaHijo(nombreCarpeta);  
        nodoMatriz nuevo = new nodoMatriz(padre.carpeta,nombreCarpeta);
        
        if (padre.siguiente==null) {
           padre.siguiente=nuevo;
           nuevo.anterior=padre;
           
           hijo.abajo=nuevo;
           nuevo.arriba=hijo;
           
        }else{
            nodoMatriz temp=padre;
            while(temp.siguiente!=null){
                temp=temp.siguiente;
            }
            temp.siguiente=nuevo;
            nuevo.anterior=temp;

            hijo.abajo=nuevo;
            nuevo.arriba=hijo;                   
        }
        //System.out.println("Se enlazaron las carpetas");
        crearCarpetaPadre(nombreCarpeta);
    }
    
    public nodoMatriz irCarpeta(nodoMatriz ruta,String carpeta){
        nodoMatriz temp = ruta;
        while(temp.carpeta.equals(carpeta)!=true){
            temp=temp.abajo;
        }
        return temp;
    }
    
    
    public void modificarNodos(String anterior, String ahora){
        //Hijo
        nodoMatriz temp = raiz;
        while((temp.carpeta.equals(anterior))!=true){
            temp=temp.siguiente;
        }
        temp.carpeta=ahora;
        
        //Padre
        temp=raiz;
        while(!temp.carpeta.equals(anterior)){
            temp=temp.abajo;
        }
        temp.carpeta=ahora; 
    }
    
    public void eliminar(nodoMatriz nodo){
        String carpeta=nodo.hijo;
        nodoMatriz temp = raiz;
        while((temp.carpeta.equals(carpeta))!=true){
            temp=temp.siguiente;
        }
        
        temp.anterior.siguiente=temp.siguiente;
        
        
        if (temp.siguiente!=null) {
            temp.siguiente.anterior=temp.anterior;
        }
        
        
        
        temp=raiz;
        while(temp.carpeta.equals(carpeta)!=true){
            temp=temp.abajo;
        }
        temp.arriba.abajo=temp.siguiente;
        if (temp.abajo!=null) {
            temp.abajo.arriba=temp.arriba;
        }
        
        //Buscar el padre para eliminar el siguiente;
        String padre=nodo.padre;
        temp=raiz;
        while(temp.carpeta.equals(padre)!=true){
            temp=temp.abajo;
        }
        
        while(temp!=nodo){
            temp=temp.siguiente;
        }
        temp.anterior.siguiente=temp.siguiente;
        
        
        if (temp.siguiente!=null) {
            temp.siguiente.anterior=temp.anterior;
        }
        
    
    }
    
    
    
    

    
    

    
    
    
    
    

    
    
}
