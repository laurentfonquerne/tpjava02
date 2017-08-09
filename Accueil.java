package projettp2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

import java.awt.event.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Laurent Fonquerne
 * @version 1.0
 */

public class Accueil extends JFrame implements ActionListener 
{ 
        JButton     connx =      new JButton("Connexion");
        JButton     inscr =      new JButton("Inscription");
        JButton     quitt =      new JButton("Quitter");
        
        

/** appel de la fenetre d'accueil connexion inscription quitter
 * 
 */
        
        public Accueil()
        {
        connx.setEnabled(true);
        inscr.setEnabled(true);
        quitt.setEnabled(true);
        this.setVisible(true);
        this.setTitle("Accueil");
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        connx.setBounds(020,20,150,20); 
        inscr.setBounds(020,50,150,20); 
        quitt.setBounds(020,80,150,20);
                
        this.getContentPane().add(connx);
        this.getContentPane().add(inscr);
        this.getContentPane().add(quitt);
                        
        this.connx.addActionListener(this);
        this.inscr.addActionListener(this);
        this.quitt.addActionListener(this);
        
        }

/** gestion de l'affichage accueil et ventilation selon actions
 *  
 * @param ae argument
 */        
    
        public void actionPerformed(ActionEvent ae)                
        {
            Object source = ae.getSource();
                      
       
            JOptionPane jop = new JOptionPane();
          
            
/** si accueil
 *     @see Inscription
 *     @see Connexion
 ** sinon
 **    Fermeture de la fenetre et lancement de missile en corée du nord
 * 
 */            
            if (source == quitt) 
               {dispose();
                }
            
            if (source == connx) 
               {
               Connexion c = new Connexion();   
               }
            
            if (source == inscr) 
               {
               Inscription i = new Inscription();
               }
        }           
}
