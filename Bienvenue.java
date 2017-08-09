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

public class Bienvenue extends JFrame implements ActionListener 
{ 
        private String prenom;
        private String email;
        JButton     quitt =      new JButton("Quitter");
              
        
/** gestion de la fenetre bienvenue une seule action quitter
 * @param prenom1 le prenom issu de connexion ou inscription
 * @param email1  le email issu de  connexion ou inscription
 * 
 */
        
        public Bienvenue(String prenom1, String email1)
        {
        JLabel      welcm =      new JLabel("bienvenue LOLO");
        JLabel      emailf =     new JLabel("lolo.fonq@mii.fr");
        
                
        quitt.setEnabled(true);
        this.setVisible(true);
        this.setTitle("Bienvenue");
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
         welcm.setBounds(020,20,150,20); 
        emailf.setBounds(020,50,150,20); 
         quitt.setBounds(020,80,150,20);
         String bienvenue = "Bienvenue " + prenom1;   
        
        this.getContentPane().add(quitt);
        
        this.quitt.addActionListener(this);
        welcm.setText(bienvenue);
        emailf.setText(email1);
        this.getContentPane().add(welcm);
        this.getContentPane().add(emailf);
        //this.resultat = res1;
        this.prenom = prenom1;
        this.email  = email1;
        }

/** gestion de l'affichage bienvenue "machin " action quitter possible
 *  
 * @param ae argument
 */        
    
        public void actionPerformed(ActionEvent ae)                
        {
            Object source = ae.getSource();
                               
            JOptionPane jop = new JOptionPane();

          
            if (source == quitt) 
               {               
                dispose();
               }
        
        }           
}
