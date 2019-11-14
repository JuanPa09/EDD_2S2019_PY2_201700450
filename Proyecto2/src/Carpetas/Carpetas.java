/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carpetas;

import Estructuras.nodoMatriz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author juanp
 */
public class Carpetas {
    
    
    
    public void mostrarCarpetas(nodoMatriz padre){
        nodoMatriz temp=padre.siguiente;
        
        while(temp!=null){
            System.out.println(temp.carpeta);
            temp=temp.siguiente;
        }
        
    
    }
    
    public void agregarCarpetas(JPanel panel){
        int n=0;
        int p=0;
        
        for (int i = 0; i <= 9; i++) {
            if (i==8) {
                p+=1;
                n=0;
            }
            
            
            
        JLabel label = new JLabel("Hola");
        label.setText("asdasd");
        label.setVisible(true);
        label.setOpaque(true);
        label.setBackground(Color.red);
        int yy = 14+(p*80);
        int x = 10+(n*80);
         
        label.setBounds(new Rectangle(x, yy, 60, 60));
            System.out.println("cuadro"+i+": "+label.getBounds());
        panel.add(label);
        panel.repaint();
        n+=1;
        
        
        }
        //this.paintAll(this.getGraphics());
    }
    
}
