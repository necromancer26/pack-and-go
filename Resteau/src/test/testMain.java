/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import models.Commentaire;
import models.Resteau;
//import tn.edu.esprit.models.utilisateur;
import models.reservationR;
import services.ServiceResteau;
import utils.DataSource;
import services.CommentaireResteau;
//import tn.edu.esprit.services.Sutilisateur;
import services.cReservationR;
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
        Resteau R1 =new Resteau( "cafe","aa","mourouj","tunis","25456965","");
       
        //sp.ajouter(R1);
            //sp.supprimerR(new Resteau(12));
            //System.out.println(sp.modifier(new Resteau("m","chez tout","ariena","tounes","86528965289",15)));

                  CommentaireResteau C = new CommentaireResteau();
    // System.out.println(C.modifierCommentaire(new Commentaire(5,6,1,"eya")));
           Commentaire C1=new Commentaire(30,1," sbdcj,kwxl<");
         System.out.println(  C.getListCommentaireByID(15));
         //C.AjouterCommentaire(C1);
        //  System.out.println(C.modifierCommentaireR(new Commentaire(19,8,1,"je n aime pas")));
          // C.supprimerCommentaireR(new Commentaire(19));

                             cReservationR RE = new cReservationR();
              //  reservationR( int idR, int id_user, int nbrPersonneR,String timeR ,String dateR)
               
                     reservationR RE1= new reservationR(15,1,10,"10:10","21/10/2021");
                     //RE.AjouterReservationR(RE1);
                      //System.out.println(RE.modifierReservationR(new reservationR(3,7,1,50,"10:10","21/10/2021")) );
          // RE.supprimerReservationR(new reservationR(1));
         sp.TRIRestau();
         //System.out.println(C.getCommentaireById(15));
      //  System.out.println(sp.getAll());
        // System.out.println(C.getAll());
       //  System.out.println(RE.getAll());


        
    
}
}
