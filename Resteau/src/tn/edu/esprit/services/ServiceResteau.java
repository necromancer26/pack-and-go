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
import tn.edu.esprit.models.Resteau;
import tn.edu.esprit.utils.DataSource;

/**
 *
 * @author hp
 */
public class ServiceResteau   implements IService<Resteau> {

    Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public void ajouter(Resteau t) {
      
    
          try {
            String req = "INSERT INTO resteau( idR,typeR,nomR,adressR) VALUES ('"+t.getIdR()+"','" + t.getTypeR()+ "','" + t.getnomR()+ "','" + t.getAdressR()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("resteau  ajoutée pravonnn !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    @Override

    public List<Resteau> getAll() {
        List<Resteau> list = new ArrayList<>();
        try {
            String req = "Select * from resteau";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Resteau R = new Resteau(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                list.add(R);
            }
                System.out.println("hay cv haw laffichage");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
        
    }

    @Override
      public boolean modifier(Resteau t) {
       boolean modif=true;
       try {
           String req = "UPDATE resteau SET  typeR=?, nomR=?, adressR=? WHERE idR =?";
           PreparedStatement ps = cnx.prepareStatement(req);
         //  super.modifier(t);
            ps.setString(1, t.getTypeR());
            ps.setString(2, t.getnomR());
            ps.setString(3, t.getAdressR());
            ps.setInt(4, t.getIdR());

            ps.executeUpdate(); 
            System.out.println("resteau Modifièè  sahyyyyt!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            modif=false;
        }
        return modif;
    }
    

    @Override
    public boolean supprimerR(Resteau t) {
        boolean modif=false;

        try {

            Statement st = cnx.createStatement();
            String req = "DELETE FROM resteau WHERE idR=?";
               PreparedStatement ps =  cnx.prepareStatement(req);
            ps.setInt(1, t.getIdR());
            ps.executeUpdate();
            System.out.println("fasakhtniii  Sa7yteekk !");

        } catch (SQLException ex) {
                        System.err.println(ex.getMessage());

        }
                return modif;

       
    }
   



   

}
