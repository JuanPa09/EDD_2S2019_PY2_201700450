
import Estructuras.arbolAVL;
import Estructuras.tablaHash;
import Graficar.graficaHash;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanp
 */
public class Inicio {
    
    public static void main(String[] args) throws IOException {
       
       tablaHash table = new tablaHash();
       table.crearTabla();
       table.agregarUsuario("Admin", "Admin");
       Login login = new Login();
       login.tabla=table;
       login.show();
               
       
       
        /*     
        
        
        arbolAVL arbolito = new arbolAVL();
        
        arbolito.insertar("Juan", "Mi");
        arbolito.insertar("Pablo", "Nombre");
        arbolito.insertar("Oscar", "Diego");
        arbolito.insertar("Juli", "Jose");
        arbolito.insertar("Astrid", "asd");
        arbolito.insertar("Meli", "dasda");
        arbolito.insertar("Diego", "dasda");
        arbolito.insertar("Juan", null);
        arbolito.inOrden(arbolito.raiz);
        */
        
    
    }
     
    
    
}
