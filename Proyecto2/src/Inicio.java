
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
       //table.agregarUsuario("Juan", "4525612");
       //table.agregarUsuario("Astrid", "4525612");
       //table.agregarUsuario("Jose", "M0t0cr05");
       //table.agregarUsuario("Guillermo", "C0ntrasena");
       //table.agregarUsuario("Andres", "8494");
       //table.agregarUsuario("Meli", "8494");
       //table.imprimirIndices();
       
       
       
            
        
        //NewJFrame frame = new NewJFrame();
        //frame.show();
    
       Login login = new Login();
       login.tabla=table;
       
       
       
       login.show();
               
        
       //Show_Image imagen = new Show_Image();
       //imagen.show();
    
    
    
    }
    
    
}
