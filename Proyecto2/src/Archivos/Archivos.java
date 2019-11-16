/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Carpetas.Carpetas;
import Estructuras.nodoMatriz;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author juanp
 */
public class Archivos {
    
    
    
    public void agregarArchivos(nodoMatriz ruta,JPanel panel,int n, int p,String nombre,String contenido,JTextField content){
       
            
            
            
            JLabel label = new JLabel(nombre,SwingConstants.CENTER);
            JLabel labeltexto = new JLabel(nombre,SwingConstants.CENTER);
            //label.setText(temp.carpeta);
            label.setVisible(true);
            label.setOpaque(true);
            label.setBackground(panel.getBackground());
            labeltexto.setBackground(panel.getBackground());

            int yy = 14+(p*80);
            int x = 10+(n*80);
            System.out.println("Pos Carpeta: "+nombre+" x: "+x+" y:"+yy  );
            label.setBounds(new Rectangle(x, yy, 60, 60));
            labeltexto.setBounds(new Rectangle(x-5, yy+60, 70, 10));
            labeltexto.setVisible(true);
            labeltexto.setOpaque(true);
            
            
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
                    }

                }

            });
            panel.add(label);
            panel.add(labeltexto);
            panel.repaint();



         
    
    }
    
    
    
    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    } 
    
    
    
    
}
