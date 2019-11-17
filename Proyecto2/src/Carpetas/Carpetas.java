/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carpetas;


import Estructuras.Matriz;
import Estructuras.nodoMatriz;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author juanp
 */
public class Carpetas{
    
    
    
    public void mostrarCarpetas(nodoMatriz padre){
        nodoMatriz temp=padre.siguiente;
        
        while(temp!=null){
            System.out.println(temp.carpeta);
            temp=temp.siguiente;
            
        }
        
    
    }
    
    public void agregarCarpetas(JPanel panel, nodoMatriz padre, Matriz matriz, JLabel laruta){
        int n=0;
        int p=0;
        nodoMatriz temp = padre.siguiente;
        while(temp!=null){
            if (n==8 || n== 16 || n==24 || n == 32) {
                p+=1;
                n=0;
            }
            JLabel label = new JLabel(temp.hijo,SwingConstants.CENTER);
        //label.setText(temp.carpeta);
        label.setVisible(true);
        label.setOpaque(true);
        label.setBackground(Color.red);
        int yy = 14+(p*80);
        int x = 10+(n*80);
        nodoMatriz retornoPadre = padre;
        Matriz matrix = matriz;
        String hijo = temp.hijo;
        label.setBounds(new Rectangle(x, yy, 60, 60));
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    TimeUnit.SECONDS.sleep((long) 0.5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Carpetas.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (e.getClickCount()==2) {
                    System.out.println("Double Clicked");
                }else{
                    System.out.println("Clicked");
                }

            }
                
        });
        panel.add(label);
        panel.repaint();
            
            
            
        n+=1;
        temp=temp.siguiente;
    }
       
        
        
        /*
        for (int i = 0; i <= 31; i++) {
            
            
            
            
        JLabel label = new JLabel("Hola");
        label.setText("asdasd");
        label.setVisible(true);
        label.setOpaque(true);
        label.setBackground(Color.red);
        int yy = 14+(p*80);
        int x = 10+(n*80);
         
        label.setBounds(new Rectangle(x, yy, 60, 60));
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    TimeUnit.SECONDS.sleep((long) 0.5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Carpetas.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (e.getClickCount()==2) {
                    System.out.println("Double Clicked");
                }else{
                    System.out.println("Clicked");
                }

            }
                
        });
        panel.add(label);
        panel.repaint();
        n+=1;
            
        }*/
    }
    
}
