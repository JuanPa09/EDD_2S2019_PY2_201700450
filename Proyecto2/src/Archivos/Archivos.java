/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Carpetas.Carpetas;
import Estructuras.Bitacora;
import Estructuras.nodoAVL;
import Estructuras.nodoHash;
import Estructuras.tablaHash;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author juanp
 */
public class Archivos {
    
    
    
    
    public void agregarArchivos(JPanel panel,int n, int p,String nombre,String contenido,String timestamp,JTextField content,nodoAVL actual,nodoAVL seleccionado,JLabel mostrar,JLabel aNombre, JLabel aContenido, JLabel aTimestamp){
       
      
            
            
            JLabel label = new JLabel(nombre,SwingConstants.CENTER);
            JLabel labeltexto = new JLabel(nombre,SwingConstants.CENTER);
            //label.setText(temp.carpeta);
            label.setVisible(true);
            label.setOpaque(true);
            label.setBackground(panel.getBackground());
            labeltexto.setBackground(panel.getBackground());

            int yy = 14+(p*80);
            int x = 10+(n*80);
            label.setBounds(new Rectangle(x, yy, 60, 60));
            labeltexto.setBounds(new Rectangle(x-5, yy+60, 70, 10));
            labeltexto.setVisible(true);
            labeltexto.setOpaque(true);
            
            final nodoAVL select=seleccionado;
            final nodoAVL act=actual;
            final String dir = System.getProperty("user.dir");
            try {
            BufferedImage bufImg=ImageIO.read(new File(dir+"\\archivo.jpg"));
                BufferedImage scaleImage = resize(bufImg,60,60);
                label.setIcon(new ImageIcon(scaleImage));
            }
            catch (IOException ex) {
                System.out.println("Unable to read image file");
            }
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        TimeUnit.SECONDS.sleep((long) 0.5);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Carpetas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (e.getClickCount()==2) {
                        content.setText(contenido);

                    }else{
                        //System.out.println("Clicked");
                        
                        aNombre.setText(nombre);
                        aContenido.setText(contenido);
                        aTimestamp.setText(timestamp);
                        mostrar.setText(nombre);
                        
                    }

                }

            });
            panel.add(label);
            panel.add(labeltexto);
            panel.repaint();



         
    
    }
    
    public void add2(nodoAVL seleccion,nodoAVL actua){
        JOptionPane.showMessageDialog(null, actua.nombre);
        seleccion = actua;
    }
    
    
    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
    
    
    public void compartir(String usuario,tablaHash tabla,String nombre,String contenido,String timestamp){
        if (!tabla.Comprobar(usuario, usuario)) {
            System.out.println("Se va a compartir");
            nodoHash temp = tabla.getUsuario(usuario);
            System.out.println(temp.nombre);
            temp.miscarpetas.raiz.abajo.archivos.insertar(nombre,contenido,timestamp,temp.nombre);
            
        }else{
            JOptionPane.showMessageDialog(null, "El usuario no existe");
        }
        
    
    
    }
    
    public void descarga(String nombre, String contenido){
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
        fw = new FileWriter(nombre);
        pw=new PrintWriter(fw);
        pw.println(contenido);
        
        pw.close();
        fw.close();
        }catch(IOException ex){
            
        }
        abrir(nombre);
    }
    
    public void abrir(String nombre){
        try {
            Runtime.getRuntime().exec("notepad "+nombre);
        } catch (IOException ex) {
            
        }
        
        
    }
    
    
    
    
}
