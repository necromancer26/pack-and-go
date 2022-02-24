/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.test;

import java.util.List;
import tn.edu.esprit.models.Commentaire;
import tn.edu.esprit.models.Resteau;
//import tn.edu.esprit.models.utilisateur;
import tn.edu.esprit.models.reservationR;
import tn.edu.esprit.services.ServiceResteau;
import tn.edu.esprit.utils.DataSource;
import tn.edu.esprit.services.CommentaireResteau;
//import tn.edu.esprit.services.Sutilisateur;
import tn.edu.esprit.services.cReservationR;
/**
 *
 * @author hp
 */
public class testMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    
        ServiceResteau sp = new ServiceResteau();
        Resteau R1 =new Resteau( "fast food","cool","ariena");
       
        //sp.ajouter(R1);
            //sp.supprimerR(new Resteau(12));
            //System.out.println(sp.modifier(new Resteau("m","chez tout","ariena",9)));

        // Sutilisateur U = new Sutilisateur();
       // utilisateur U1 = new utilisateur("eya","bouthouri","eya.bouthouri@esprit.tn");
         //U.AjouterU(U1);
         // sp.ajouter(R1);
                  CommentaireResteau C = new CommentaireResteau();
    // System.out.println(C.modifierCommentaire(new Commentaire(5,6,1,"eya")));
           Commentaire C1=new Commentaire(7,1,"waw ","10/21/20");
         C.AjouterCommentaire(C1);
           //System.out.println(C.modifierCommentaireR(new Commentaire(10,6,4,"eya")));
           //C.supprimerCommentaireR(new Commentaire(10));

                             cReservationR RE = new cReservationR();
                      reservationR RE1= new reservationR(7,1,10,"10:10","21/10/2021");
                     //RE.AjouterReservationR(RE1);
                      System.out.println(RE.modifierReservationR(new reservationR(3,7,1,50,"10:10","21/10/2021")) );
          // RE.supprimerReservationR(new reservationR(1));

         System.out.println(sp.getAll());
         System.out.println(C.getAll());
         System.out.println(RE.getAll());


        
    
}
}
