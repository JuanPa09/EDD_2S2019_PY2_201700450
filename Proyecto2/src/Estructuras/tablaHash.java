/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.security.MessageDigest;


public class tablaHash {
    public nodoHash raiz;
    public nodoHash fin;
    int size=0;
    int llenos=0;
    int n=1; //ELEVADO A LA N VECES (UTILIZADO PARA ENCONTRAR EL INDICE)
    Cola cola = new Cola();
    int Conteo = 0; // Cuenta las veces que se ha hecho unca colision
    public tablaHash(){
        
    }
    
    //CREA LA TABLA CON LOS PRIMEROS 7 INDICES
    public void crearTabla(){
        for (int i = 0; i <7; i++) {
            agregarindice(String.valueOf(i));
        }
    }
    
    
    //AGREGA UN USUARIO AL INDICE CORRECTO
    public void agregarUsuario(String nombre, String contra){
        int indice=buscarIndice(nombre);
        nodoHash temp=raiz;
        
        
        while(Integer.valueOf(temp.indice)!=indice){
            //System.out.println("Indice temp: "+temp.indice+" Mi indice: "+indice);
            temp=temp.siguiente;
            
        }
        
        if (temp.sigdatos==null) {
            String contrahash=sha256(contra);
            Matriz matriz = new Matriz();
            nodoHash nuevo = new nodoHash(nombre,contrahash,matriz);
            temp.sigdatos=nuevo;
            llenos+=1;
            comprobarLlenos();
            n=1;
        }else{
            n+=1;
            agregarUsuario(nombre,contra);
        }
        //System.out.println("Se agrego un nuevo usuario: "+nombre+" , "+contra);
        
    }
    
    
    
    public void agregarDeNuevo(String nombre, String contra,Matriz matriz){
        int indice=buscarIndice(nombre);
        nodoHash temp=raiz;
        
        
        while(Integer.valueOf(temp.indice)!=indice){
            //System.out.println("Indice temp: "+temp.indice+" Mi indice: "+indice);
            temp=temp.siguiente;
            
        }
        
        if (temp.sigdatos==null) {
            String contrahash=contra;
            nodoHash nuevo = new nodoHash(nombre,contrahash,matriz);
            temp.sigdatos=nuevo;
            llenos+=1;
            n=1;
        }else{
            n+=1;
            agregarDeNuevo(nombre,contra,matriz);
        }
        //System.out.println("Se agrego un nuevo usuario: "+nombre+" , "+contra);
        
    }
    
    
    
    // BUSCAR MI INDICE
    private int buscarIndice(String cadena){
        int totalascii=0;
        for (int i = 0; i < cadena.length(); i++){
            char letra = cadena.charAt(i);
            totalascii+=(int)letra;
        }
        int k=(int)((Math.pow(totalascii, n)));
        int miposicion = (n*(k))%size;
        if (miposicion<0) {
            miposicion=miposicion*(-1);
        }
        return miposicion;        
    }
    
    
    
    
    
    
    
    
    //AGREGA LOS INDICES HASTA EL PRIMO MAS CERCANO
    public void agregarindices(){
        int inicio=Integer.parseInt(fin.indice)+1;
        int finindice = buscarPrimo(inicio);
        //inicio+=1;
        for (int i = inicio; i <finindice; i++) {
            agregarindice(String.valueOf(i));
            
        }
            
        
    }
    
    
    
    
    
    //AGREGA UN INDICE
    private void agregarindice(String index){
        nodoHash nuevo = new nodoHash(index);
        
        if (raiz==null) {
            raiz=nuevo;
            fin=nuevo;
        }else{
            fin.siguiente=nuevo;
            fin=nuevo;
        }
        size+=1;
        
    }
    
    public boolean login(String nombre, String contra){
        int indice=buscarIndice(nombre);
        nodoHash temp=raiz;
        
        
        while(Integer.valueOf(temp.indice)!=indice){
            //System.out.println("Indice temp: "+temp.indice+" Mi indice: "+indice);
            temp=temp.siguiente;
            
        }
        
        if (temp.sigdatos==null) {
            n=1;
            Conteo=0;
            return false;
        }else{
            
            if (temp.sigdatos.nombre.equals(nombre) && temp.sigdatos.contra.equals(sha256(contra)) ) {
                n=1;
                Conteo=0;
                return true;
                
            }else{
                n+=1;
                Conteo+=1;
                if (Conteo==3) {
                    Conteo=0;
                    return false;
                }else{return login(nombre,contra);}
                
                
            }
            
            
        }
    
    }
    
    
    
     
    //BUSCA UN NUMERO PRIMO A PARTIR DE UN NUMERO
    public int buscarPrimo(int inicio){
        inicio+=1;
        while(esPrimo(inicio)!=true){
            inicio+=1;
        }
        return inicio;
    }
    
    //RETORNA TRUE CUANDO EL PARAMETRO ES UN PRIMO
    public boolean esPrimo(int numero){
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
            if (numero % contador == 0)
              primo = false;
            contador++;
        }
        return primo;
    }
    
    
    public static String sha256(String base) {
    try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(base.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
    }
    }
    
    public void comprobarLlenos(){
        int completo = (int) (size*0.70);
        if (llenos>=completo) {
            llenos=0;
            this.agregarindices();
            
            this.nuevosIndices();
        }
        
    }
    
    
    
    public void vaciarTabla(){
        nodoHash temp = raiz;
        
        while(temp!=null){
            if (temp.sigdatos!=null) {
                cola.Ingresar(temp.sigdatos.nombre, temp.sigdatos.contra,temp.sigdatos.miscarpetas);
                temp.sigdatos=null;
            }
            temp=temp.siguiente;
        }
    }
    
    public void reinsertar(){
        cola.Reinsertar(this);
    }
    
    public void nuevosIndices(){
        vaciarTabla();
        reinsertar();
    }
    
    
    public boolean Comprobar(String nombre, String contra){
        int indice=buscarIndice(nombre);
        nodoHash temp=raiz;  
        while(Integer.valueOf(temp.indice)!=indice){
            temp=temp.siguiente;
        }      
        if (temp.sigdatos==null) {
            n=1;
            return true;
        }else{   
            if (temp.sigdatos.nombre.equals(nombre)) {
                n=1;
                return false;
                
            }
            n+=1;
            return Comprobar(nombre,contra);
        }
    }
    
    public nodoHash getUsuario(String usuario){
        int indice=buscarIndice(usuario);
        nodoHash temp=raiz;  
        while(Integer.valueOf(temp.indice)!=indice){
            temp=temp.siguiente;
        }      
        if (temp.sigdatos==null) {
            n=1;
            return null;
        }else{   
            if (temp.sigdatos.nombre.equals(usuario)) {
                n=1;
                return temp.sigdatos;
            }
            n+=1;
            return getUsuario(usuario);
        }
    }
    
    
    
    public nodoHash nodo(String nombre, String contra){
        
        int indice=buscarIndice(nombre);
        nodoHash temp=raiz;
        
        
        while(Integer.valueOf(temp.indice)!=indice){
            //System.out.println("Indice temp: "+temp.indice+" Mi indice: "+indice);
            temp=temp.siguiente;
            
        }
        
        if (temp.sigdatos==null) {
            n=1;
            Conteo=0;
            System.out.println("Se retorno nulo 1");
            return null;
        }else{
            
            if (temp.sigdatos.nombre.equals(nombre) && temp.sigdatos.contra.equals(sha256(contra)) ) {
                n=1;
                Conteo=0;
                return temp.sigdatos;
                
            }else{
                n+=1;
                Conteo+=1;
                if (Conteo==3) {
                    Conteo=0;
                    System.out.println("Se retorno nulo 2");
                    return null;
                }else{return nodo(nombre,contra);}
                
                
            }
            
            
        }
    
    }
    
    
    //IMPRIME LOS INDICES
    public void imprimirIndices(){
        nodoHash temp = raiz;
        while (temp!=null){
            if (temp.sigdatos!=null){
            System.out.println("index: "+temp.indice+"->"+temp.sigdatos.nombre+","+temp.sigdatos.contra);
            }else{
                System.out.println("index: "+temp.indice);
            }
            
            temp=temp.siguiente;
        }
        
    }
    
    
}
