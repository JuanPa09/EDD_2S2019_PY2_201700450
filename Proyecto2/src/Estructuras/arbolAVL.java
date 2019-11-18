/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Archivos.Archivos;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author juanp
 */
public class arbolAVL {
    public nodoAVL raiz;
    Archivos archivos = new Archivos();
    public arbolAVL(){
        raiz=null;
    }
    
    //Buscar
    public nodoAVL buscar(String nombre,nodoAVL r){
         
        if (r==null) {
            return null;
        }else if(stringCompare(r.nombre,nombre)==0){
            return r;
        }else if(stringCompare(r.nombre,nombre)<0){
            return buscar(nombre,r.right);
        }else{
            return buscar(nombre,r.left);
        }
        
    }
    
    public int obtenerFE(nodoAVL x){
        if (x==null) {
            return -1;
        }else{
            return x.fe;
        }
    }
    
    //Rotacion Simple Izquierda
    public nodoAVL rotacionIzquierda(nodoAVL c){
        nodoAVL auxiliar = c.left;
        c.left=auxiliar.right;
        auxiliar.right=c;
        c.fe=Math.max(obtenerFE(c.left),obtenerFE(c.right))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.left),obtenerFE(auxiliar.right))+1;
        return auxiliar;      
    }
    
    //Rotacion Simple Derecha
    public nodoAVL rotacionDerecha(nodoAVL c){
        nodoAVL auxiliar = c.right;
        c.right=auxiliar.left;
        auxiliar.left=c;
        c.fe=Math.max(obtenerFE(c.left),obtenerFE(c.right))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.left),obtenerFE(auxiliar.right))+1;
        return auxiliar;
    }
    
    //Rotacion Doble a la izquierda
    public nodoAVL rotacionDobleIzquierda(nodoAVL c){
        nodoAVL temporal;
        c.left=rotacionDerecha(c.left);
        temporal = rotacionIzquierda(c);
        return temporal;
    }
    
    //Rotacion Doble a la derecha
    public nodoAVL rotacionDobleDerecha(nodoAVL c){
        nodoAVL temporal;
        c.right=rotacionIzquierda(c.right);
        temporal=rotacionDerecha(c);
        return temporal;
    }
    
    //Metodo para insertar AVL
    public nodoAVL insertarAVL(nodoAVL nuevo, nodoAVL subAr){
        nodoAVL nuevoPadre=subAr;
        if (stringCompare(nuevo.nombre,subAr.nombre)<0) {
            if (subAr.left==null) {
                subAr.left=nuevo;
            }else{
                subAr.left=insertarAVL(nuevo,subAr.left);
                if ((obtenerFE(subAr.left)-(obtenerFE(subAr.right))==2)) {
                    if (stringCompare(nuevo.nombre,subAr.left.nombre)<0) {
                        nuevoPadre=rotacionIzquierda(subAr);
                    }
                }
            }
        }else if(stringCompare(nuevo.nombre,subAr.nombre)>0){
            if (subAr.right==null) {
                subAr.right=nuevo;
            }else{
                subAr.right=insertarAVL(nuevo,subAr.right);
                if ((obtenerFE(subAr.right)-obtenerFE(subAr.left))==2) {
                    if (stringCompare(nuevo.nombre,subAr.right.nombre)>0) {
                        nuevoPadre=rotacionDerecha(subAr);
                    }else{
                        nuevoPadre=rotacionDobleDerecha(subAr);
                    }
                }
            }
        }else{
            System.out.println("Nodo Duplicado");
        }
        
        //Actualizando Altura
        if ((subAr.left==null)&&(subAr.right!=null)) {
            subAr.fe=subAr.right.fe+1;
        }else if((subAr.right==null)&&(subAr.left!=null)){
            subAr.fe=subAr.left.fe+1;
        }else{
            subAr.fe=Math.max(obtenerFE(subAr.left), obtenerFE(subAr.right));
        }
        nuevo.fe=obtenerFE(nuevo);
        return nuevoPadre;
        
    }
    
    
    //Metodo para insertar
    public void insertar(String nombre,String contenido,String timestamp, String Propietario){
        nodoAVL nuevo = new nodoAVL(nombre,contenido,timestamp,Propietario);
        if (raiz==null) {
            raiz=nuevo;
        }else{
            raiz=insertarAVL(nuevo,raiz);
        }
       
    }
    
    public void preorder(nodoAVL r,colaAux cola){
        if (r!=null) {
            preorder(r.left,cola);
            cola.insertar(r);
            preorder(r.right,cola);
        }
    }
    
    //Recorridos
    public void NombreContenido(JPanel panel,int n, int p,nodoAVL r,JTextField content,nodoAVL seleccionado,JLabel mostrar,JLabel anombre,JLabel acontenido,JLabel atimestamp){   
        colaAux cola = new colaAux();
        preorder(this.raiz,cola);
        nodoColaAux temp = cola.raiz;
        while(temp!=null){
            n+=1;
            if (n==8 || n== 16 || n==24 || n == 32) {
                p+=1;
                n=0;
            }
            archivos.agregarArchivos(panel, n, p, temp.temp.nombre, temp.temp.contenido,temp.temp.timestamp,content,temp.temp,seleccionado,mostrar,anombre,acontenido,atimestamp);
            temp=temp.siguiente;
            
        }
        
    }
    
    
    public void Contenido(nodoAVL r){
        if (r!=null) {
            Contenido(r.left);
            System.out.println(r.nombre+", ");
            Contenido(r.right);
        }
        
    }
    
    
    
    
    
    
    
        public static int stringCompare(String str1, String str2) 
    { 
  
        int l1 = str1.length(); 
        int l2 = str2.length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)str1.charAt(i); 
            int str2_ch = (int)str2.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
  
        // Edge case for strings like 
        // String 1="Geeks" and String 2="Geeksforgeeks" 
        if (l1 != l2) { 
            return l1 - l2; 
        } 
  
        // If none of the above conditions is true, 
        // it implies both the strings are equal 
        else { 
            return 0; 
        } 
    }
    
}
