/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.models.Commentaire;
import tn.edu.esprit.models.Resteau;
import tn.edu.esprit.utils.DataSource;
//import tn.edu.esprit.models.utilisateur; 


/**
 *
 * @author hp
 */
public class CommentaireResteau implements ICom<Commentaire>  {

    Connection cnx = DataSource.getInstance().getCnx();
     @Override
    public void AjouterCommentaire(Commentaire t) {
   try {
              
               String req = "INSERT INTO `commentaire`(idCommentaireR,id_user,idR,contenuCommentaireR,dateCR) VALUES ( NULL,'"+t.getid_user()+"', '"+t.getIdR()+"' , '"+t.getContenuCommentaireR()+"','"+t.getDateCR()+"');";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Commentaire créé Pravoonn!");
          } catch (SQLException ex) {
                          System.out.println(ex.getMessage());

          }  
    
    }

    @Override
    public boolean modifierCommentaireR(Commentaire t ) {
          boolean modif=true;
       try {
           String req = "UPDATE Commentaire SET  idR=?,id_user=?,contenuCommentaireR=?,DateCR=?  WHERE idCommentaireR =?";
           PreparedStatement ps = cnx.prepareStatement(req);
         //  super.modifier(t);
            ps.setInt(1,t.getIdR());     
            ps.setInt(2, t.getid_user());
            ps.setString(3, t.getContenuCommentaireR());
            ps.setInt(4,t.getIdCommentaireR());
            ps.setString(5,t.getDateCR());

            ps.executeUpdate(); 
            System.out.println("commentaire Modifièè  kahaw!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            modif=false;
        }
        return modif;
    }

    @Override
    public boolean supprimerCommentaireR(Commentaire t) {
    boolean modif=false;
                  

        try {

            Statement st = cnx.createStatement();
            String req = "DELETE FROM Commentaire WHERE idCommentaireR=?";
               PreparedStatement ps =  cnx.prepareStatement(req);
            ps.setInt(1, t.getIdCommentaireR());
            ps.executeUpdate();
            System.out.println("fasaaakh !");

        } catch (SQLException ex) {
                        System.err.println(ex.getMessage());

        }
                return modif;

       
    }
   
   
    @Override
       public List<Commentaire> getAll() {
        List<Commentaire> list = new ArrayList<>();
        try {
            String req = "Select * from commentaire";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Commentaire C = new Commentaire(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5));
                list.add(C);
            }
                System.out.println("hay cv haw laffichage");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
        
    }

}