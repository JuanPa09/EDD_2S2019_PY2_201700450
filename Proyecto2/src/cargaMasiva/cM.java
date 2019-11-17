/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargaMasiva;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author juanp
 */
public class cM {
    
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
                
                //Imprime datos.
                
               System.out.println(datos[0] + ", " + datos[1]);
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
