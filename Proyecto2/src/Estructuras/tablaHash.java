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
    
    public tablaHash(){
        
    }
    
    //CREA LA TABLA CON LOS PRIMEROS 7 INDICES
    public void crearTabla(){
        for (int i = 0; i <=7; i++) {
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
            nodoHash nuevo = new nodoHash(nombre,contrahash);
            temp.sigdatos=nuevo;
            llenos+=1;
            comprobarLlenos();
            n=1;
        }else{
            n+=1;
            agregarUsuario(nombre,contra);
        }
        
    }
    
    
    
    // BUSCAR MI INDICE
    private int buscarIndice(String cadena){
        int totalascii=0;
        for (int i = 0; i < cadena.length(); i++){
            char letra = cadena.charAt(i);
            totalascii+=(int)letra;
        }
        
        int miposicion = (int)((Math.pow(totalascii, n))+n)%size;
        System.out.println(totalascii+"^"+n+"%"+size);
        return miposicion;
        
    }
    
    
    
    
    
    
    
    
    //AGREGA LOS INDICES HASTA EL PRIMO MAS CERCANO
    public void agregarindices(){
        int inicio=Integer.parseInt(fin.indice)+1;
        System.out.println("Comienzo de busqueda:"+fin.indice);
        int finindice = buscarPrimo(inicio);
        //inicio+=1;
        for (int i = inicio; i <=finindice; i++) {
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
        System.out.println("Se agrego nuevo indice "+index+" size: "+size);
        
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
        //System.out.println("LLenos: "+llenos);
        //System.out.println("Completo: "+completo);
        if (llenos>=completo) {
            //System.out.println("Se llego a 75%");
            this.agregarindices();
            llenos=0;
            this.nuevosIndices();
        }
        
    }
    
    
    
    public void vaciarTabla(){
        nodoHash temp = raiz;
        
        while(temp!=null){
            if (temp.sigdatos!=null) {
                cola.Ingresar(temp.sigdatos.nombre, temp.sigdatos.contra);
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
        System.out.println("Se vacio la tabla");
        reinsertar();
        System.out.println("Se reinsertaron los indices");
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
