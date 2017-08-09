package projettp2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


/**
 *
 * @author Laurent Fonquerne
 * @version 1.0
 */

public class Inscription extends JFrame implements ActionListener , KeyListener 
{
        JButton     inscr =     new JButton("Inscription");
        
        JLabel      noml =      new JLabel("Nom");
        JLabel      pnml =      new JLabel("Prenom");
        JLabel      pwdl =      new JLabel("Mot de Passe");
        JTextField  nomo =      new JTextField();
        JTextField  pnmo =      new JTextField();
        JTextField  pwdo =      new JTextField();
        static int nbinscriptions = 0;

/** appel de la fenetre d'inscription
 * 
 */
        
        public Inscription()
        {
        
        inscr.setEnabled(false);
        this.setVisible(true);
        this.setTitle("Inscription");
        this.setSize(500,200);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        noml.setBounds(020,20,150,20); nomo.setBounds (180,20,150,20); 
        pnml.setBounds(020,50,150,20); pnmo.setBounds (180,50,150,20);
        pwdl.setBounds(020,80,150,20); pwdo.setBounds (180,80,150,20);
                                       inscr.setBounds(180,120,150,20);
                
        this.getContentPane().add(noml);
        this.getContentPane().add(pnml);
        this.getContentPane().add(pwdl);
        this.getContentPane().add(nomo);
        this.getContentPane().add(pnmo);
        this.getContentPane().add(pwdo);
        this.getContentPane().add(inscr);
                        
        this.inscr.addActionListener(this);
        this.nomo.addKeyListener(this);
        this.pnmo.addKeyListener(this);
        this.pwdo.addKeyListener(this);
        }

/** gestion du keypressed gestion des touches
 * 
 * @param e argument visibilite inscription si nom prenom et pwd saisi
 */
        
        public void keyPressed(KeyEvent e)
        {
        if ((!nomo.getText().isEmpty()) &&
            (!pnmo.getText().isEmpty()) &&
            (!pwdo.getText().isEmpty()))
           inscr.setEnabled(true);
        else
           inscr.setEnabled(false);
        }
/** gestion du keyreleased gestion des touches
 * 
 * 
 * @param e argument visibilite inscription si nom prenom et pwd saisi
 */        
        
        public void keyReleased(KeyEvent e) 
        {
        if ((!nomo.getText().isEmpty()) &&
            (!pnmo.getText().isEmpty()) &&
            (!pwdo.getText().isEmpty()))
           inscr.setEnabled(true);
        else
           inscr.setEnabled(false);
        
        }
/** gestion du keytyped gestion des touches
 * 
 * @param e argument visibilite inscription si nom prenom et pwd saisi
 */        
        public void keyTyped(KeyEvent e)                 
        {
        if ((!nomo.getText().isEmpty()) &&
            (!pnmo.getText().isEmpty()) &&
            (!pwdo.getText().isEmpty()))
           inscr.setEnabled(true);
        else
           inscr.setEnabled(false);
        }
/** gestion de l'affichage fenêtre et restitution des résultats
 *  
 * @param ae argument
 */        
    
        public void actionPerformed(ActionEvent ae)                
        {
            Object source = ae.getSource();
            BufferedWriter bw = null;
            
            int choice    = 0;
            int somme     = 0;
            int moins     = 0;
            int produit   = 0;
            int divise    = 0;
            int resultat  = 0;
            String restxt = "00";
            String nom = "titi";
            String pwd = "titi" ;
            String pnm = "coco";
            Boolean okconnect = false ;       
            String msg = "xxx";
       
            JOptionPane jop = new JOptionPane();
            nom = nomo.getText();
            pnm = pnmo.getText();
            pwd = pwdo.getText();
            
/** si inscription réussie ecriture dans fichier et fenetre de bienvenue
 *     @see Bienvenue
 * 
 */            
          if (source == inscr) 
               {
                   nbinscriptions = nbinscriptions + 1;                   
                   String ligne;
                   String email = nomo.getText() + "." +
                                  pnmo.getText() + "." +
                                  nbinscriptions + "@mii.fr" ;
                   
                   String element = nomo.getText() + " " +
                                    pnmo.getText() + " " +
                                    email          + " " +  
                                    pwdo.getText();
                                    
                   try{
                                                          
                    
                // instanciation du buffer
                // affect ligne suiv dans ligne
                     bw = new BufferedWriter(new FileWriter("membre.txt",true)) ;
                     bw.write(element);                
                     bw.newLine();
                     bw.close();
                     Bienvenue b = new Bienvenue(pnmo.getText(), email);
                    
                
            } 
         catch(FileNotFoundException e) {e.printStackTrace();}
         catch(IOException e)           {e.printStackTrace();} 
                                        
            }
           
        
        }           
}
