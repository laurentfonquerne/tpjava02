package projettp2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


/**
 *
 * @author Laurent Fonquerne
 * @version 1.0
 */

public class Connexion extends JFrame implements ActionListener , KeyListener 
{
        JButton     connx =     new JButton("Connexion");
        
        JLabel      emal =      new JLabel("E-mail");
        
        JLabel      pwdl =      new JLabel("Mot de Passe");
        JTextField  emao =      new JTextField();
        
        JTextField  pwdo =      new JTextField();
        static int nbconnexions = 0;

/** appel de la fenetre de connexion
 * 
 */
        
        public Connexion()
        {
        
        connx.setEnabled(false);
        this.setVisible(true);
        this.setTitle("Connexion");
        this.setSize(500,200);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        emal.setBounds(020,20,150,20); emao.setBounds (180,20,150,20); 
        
        pwdl.setBounds(020,50,150,20); pwdo.setBounds (180,50,150,20);
                                       connx.setBounds(180,80,150,20);
                
        this.getContentPane().add(emal);
        
        this.getContentPane().add(pwdl);
        this.getContentPane().add(emao);
        
        this.getContentPane().add(pwdo);
        this.getContentPane().add(connx);
                        
        this.connx.addActionListener(this);
        this.emao.addKeyListener(this);
        
        this.pwdo.addKeyListener(this);
        }

/** gestion du keypressed si email saisi et pwd saisi activation
 * 
 * @param e argument visibilite connexion si email et pwd saisi
 */
        
        public void keyPressed(KeyEvent e)
        {
        if ((!emao.getText().isEmpty()) &&
            (!pwdo.getText().isEmpty()))
            connx.setEnabled(true);
        else
            connx.setEnabled(false);
        }
/** gestion du keyreleased gestion des touches
 * 
 * 
 * @param e argument visibilite connexion si email et pwd saisi
 */        
        
        public void keyReleased(KeyEvent e) 
        {
        if ((!emao.getText().isEmpty()) &&
            (!pwdo.getText().isEmpty()))
           connx.setEnabled(true);
        else
           connx.setEnabled(false);
        
        }
/** gestion du keytyped gestion des touches
 * 
 * @param e argument visibilite connexion si email et pwd saisi
 */        
        public void keyTyped(KeyEvent e)                 
        {
        if ((!emao.getText().isEmpty()) &&
            (!pwdo.getText().isEmpty()))
           connx.setEnabled(true);
        else
           connx.setEnabled(false);
        }
/** gestion de l'affichage bienvenue restitution prenom  email si ok connexion
 *  
 * @param ae argument
 */        
    
        public void actionPerformed(ActionEvent ae)                
        {
            Object source = ae.getSource();
            BufferedReader br = null;
            boolean trouvee = false;
           
            String nom = "titi";
            String pnm = "tutu";
            String ema = "toto";        
            String pwd = "titi" ;
            
            JOptionPane jop = new JOptionPane();
           
            
/** si authentification réussie en moins de 3 appels
 *     @see Bienvenue
 ** sinon
 **    Fermeture de la fenetre et lancement de missile en corée du nord
 * 
 */            
          
            if (source == connx) 
               {
                if (nbconnexions >= 2)
                   dispose();
                else 
                   { // lecture du fichier membre
                      String lign2;
                                        
                    try{
                      StringTokenizer s = null;

                      br = new BufferedReader(new FileReader("membre.txt")) ;
                      
                        while ( (lign2 = br.readLine() )!= null && !trouvee){
                            s = new StringTokenizer(lign2);
                            nom = s.nextToken();
                            pnm = s.nextToken();
                            ema = s.nextToken();
                            pwd = s.nextToken();
                            
                            if ( (ema.compareTo(emao.getText())==0) && (pwd.compareTo(pwdo.getText())==0 ) )    
                               trouvee =true;
                        }
                        if (trouvee){ // appel de la fenetre bienvenue
                            Bienvenue b = new Bienvenue(pnm, ema);
                            }
                        if (!trouvee) {
                            String msg = "email ou mot de passe incorrect";
                            jop.showMessageDialog(null, msg ,"MSG INFO",JOptionPane.INFORMATION_MESSAGE);
                            nbconnexions = nbconnexions + 1;
                            }     
                        }
                    catch(FileNotFoundException e) {e.printStackTrace();}
                    catch(IOException e)           {e.printStackTrace();} 
                     // fin du pavé fichier
                    
                   } 
            
                }
        
        }           
}
