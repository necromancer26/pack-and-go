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
import tn.edu.esprit.models.reservationR;
import tn.edu.esprit.utils.DataSource;

/**
 *
 * @author hp
 */
public class cReservationR implements Ireserv <reservationR> {
   
    Connection cnx = DataSource.getInstance().getCnx();
     @Override
    public void AjouterReservationR(reservationR t) {
   try {
              
               String req = "INSERT INTO `ReservationR`( idreservationR, idR, id_user, nbrPersonneR,timeR ,dateR) VALUES (Null, '"+t.getIdR()+"', '"+t.getId_user()+"' ,  '"+t.getNbrPersonneR()+"' ,  '"+t.getTimeR()+"' ,  '"+t.getDateR()+"');";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Commentaire créé Pravoonn!");
          } catch (SQLException ex) {
                          System.out.println(ex.getMessage());

          }  
    
    }

    @Override
    public boolean modifierReservationR(reservationR t ) {
          boolean modif=true;
       try {
           String req = "UPDATE ReservationR SET  idR=?,id_user=?,nbrPersonneR=?,timeR=?,dateR=?  WHERE idreservationR =?";
           PreparedStatement ps = cnx.prepareStatement(req);
         //  super.modifier(t);
            ps.setInt(1,t.getIdR());     
            ps.setInt(2, t.getId_user());
            ps.setInt(3, t.getNbrPersonneR());
            ps.setString(4,t.getTimeR());
            ps.setString(5,t.getDateR());
            ps.setInt(6,t.getIdreservationR());     

            ps.executeUpdate(); 
            System.out.println("reservation Modifièè ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            modif=false;
        }
        return modif;
    }

    @Override
    public boolean supprimerReservationR(reservationR t) {
    boolean modif=false;
                  

        try {

            Statement st = cnx.createStatement();
            String req = "DELETE FROM ReservationR WHERE idreservationR=?";
               PreparedStatement ps =  cnx.prepareStatement(req);
            ps.setInt(1, t.getIdreservationR());
            ps.executeUpdate();
            System.out.println("ReservationR a supprimee !");

        } catch (SQLException ex) {
                        System.err.println(ex.getMessage());

        }
                return modif;

       
    }
   
   
    @Override
       public List<reservationR> getAll() {
        List<reservationR> list = new ArrayList<>();
        try {
            String req = "Select * from ReservationR";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                reservationR R = new reservationR(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(4),rs.getString(5));
                list.add(R);
            }
                System.out.println("affichage");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
        
    } 


}
