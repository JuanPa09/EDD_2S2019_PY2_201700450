/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargaMasiva;

import Estructuras.Bitacora;
import Estructuras.tablaHash;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author juanp
 */
public class cM {
    Bitacora bitacora;
    tablaHash tabla;
    
    public cM(Bitacora bitacora,tablaHash tabla){
        this.bitacora=bitacora;
        this.tabla=tabla;
    }
    
    
    public void cmUsuarios(String archivo){
        String csvFile = archivo;
        BufferedReader br = null;
        String line = "";
        //Se define separador ","
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {                
                String[] datos = line.split(cvsSplitBy);
                
                //Ingresar Datos
                if (datos[1].length()>=8) {
                    System.out.println("Comprueba antes de ingresar");
                if (tabla.Comprobar(datos[0], "")) {
                    System.out.println("Se ingreso "+datos[0]);
                    tabla.agregarUsuario(datos[0], datos[1]);
                    
                }else{
                    bitacora.insertar("El nombre de usuario "+datos[0]+" ya existe ;Admin");
                }
                }else{
                    bitacora.insertar("La contrasena de "+datos[0]+" tiene menos de 8 caracteres; Admin");
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
    
        }
    
    
    
    public void buscar(){
        JFileChooser jf = new JFileChooser();
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("csv","Csv");
        jf.setFileFilter(filtro);
        jf.showOpenDialog(jf);
        File archivo = jf.getSelectedFile();
        if (archivo !=null){
            cmUsuarios(archivo.getAbsolutePath());
        }
        
        
        
    }
          
    }
