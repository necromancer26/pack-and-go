/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Chambre;
import utils.DataSource;

/**
 *
 * @author dorsaf
 */
public class ServiceChambre implements IHotel<Chambre>{

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Chambre t) {
        try {
          // PreparedStatement ps = cnx.prepareStatement("INSERT INTO hotel(id_service, nom_service, nbr_etoiles, nbr_chambres, adresse, tel, email) VALUES('"+t.getId_service()+"', ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS); 
            String req = "INSERT INTO `chambre`(`num_chambre`, `type_chambre`, `etage`, `prix`, `image` ,`id_hotel` ) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, t.getNum_chambre());            
            ps.setString(2, t.getType_chambre());
            ps.setInt(3, t.getEtage());
            ps.setInt(4, t.getPrix());
            ps.setString(5, t.getImage());
            ps.setInt(6, t.getId_hotel()); 
            ps.executeUpdate();
            System.out.println("Chambre ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }  
    }

    @Override
    public List<Chambre> getAll() {
         List<Chambre> list = new ArrayList<>();
        try {
            String req = "Select * from chambre";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Chambre h = new Chambre(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
                list.add(h);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void modifier(Chambre t) {
       try {
           String req = "UPDATE chambre SET  num_chambre=?, type_chambre=?, etage=?, prix=? WHERE id_chambre =?";
           PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, t.getNum_chambre());           
            ps.setString(2, t.getType_chambre());
            ps.setInt(3, t.getEtage());
            ps.setInt(4, t.getPrix());
            ps.setInt(5, t.getId_chambre());
            ps.executeUpdate(); 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void supprimer(int id) {
         try {
            String req = "DELETE FROM chambre WHERE id_chambre =?";
            PreparedStatement ps =  cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ObservableList<Chambre> getListchambres() {
        ObservableList<Chambre> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from chambre";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Chambre h = new Chambre(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
                list.add(h);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
    public ObservableList<Chambre> getListchambresByID(int id_hotel) {
        ObservableList<Chambre> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from chambre WHERE id_hotel ="+id_hotel;
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Chambre h = new Chambre(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
                list.add(h);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
    public Chambre getChambreByID(int id_chambre) {
        Chambre ch = null;
        try {
            String req = "Select * from chambre WHERE id_chambre ="+id_chambre;
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 ch = new Chambre(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return ch;
    }
    
    public int getPrixByID(int id_chambre) {
        int p  = 0;
        try {
            String req = "Select prix from chambre WHERE id_chambre ="+id_chambre;
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 p = rs.getInt("prix");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return p;
    }
    
    public String getNomByID(int chambre) {
        String nom  ="";
        try {
            String req = "Select nom_hotel from hotel  WHERE id_hotel = (select id_hotel from chambre where id_chambre ="+chambre + ")";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 nom = rs.getString("nom_hotel");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return nom;
    }
}
