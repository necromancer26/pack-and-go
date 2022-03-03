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
import models.Hotel;

import utils.DataSource;

/**
 *
 * @author dorsaf
 */

public class ServiceHotel implements IHotel<Hotel>{
    
    Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public void ajouter(Hotel t) {
        try {
           // PreparedStatement ps = cnx.prepareStatement("INSERT INTO hotel(id_service, nom_service, nbr_etoiles, nbr_chambres, adresse, tel, email) VALUES('"+t.getId_service()+"', ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS); 
          String req = "INSERT INTO `hotel`(`nom_hotel`, `nbr_etoiles`, `nbr_chambres`, `adresse`, `pays`, `tel`, `email`, `image`) VALUES (?,?,?,?,?,?,?,?)";
          PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getNom_hotel());
            ps.setInt(2, t.getNbr_etoiles());
            ps.setInt(3, t.getNbr_chambres());
            ps.setString(4, t.getAdresse());
            ps.setString(5, t.getPays()); 
            ps.setInt(6, t.getTel());
            ps.setString(7, t.getEmail());
            ps.setString(8, t.getImage());
            ps.executeUpdate();
            System.out.println("hotel ajouté avec succès!");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Hotel> getAll() {
        List<Hotel> list = new ArrayList<>();
        try {
            String req = "Select * from hotel";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Hotel h = new Hotel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9));
                list.add(h);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list; 
    }

    @Override
    public void modifier(Hotel t) {
       try {
           String req = "UPDATE hotel SET  nom_hotel=?, nbr_etoiles=?, nbr_chambres=?, adresse=? ,pays=? ,tel= ?, email=?, image=? WHERE id_hotel =?";
           PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getNom_hotel());
            ps.setInt(2, t.getNbr_etoiles());
            ps.setInt(3, t.getNbr_chambres());
            ps.setString(4, t.getAdresse());
            ps.setString(5, t.getPays()); 
            ps.setInt(6, t.getTel());
            ps.setString(7, t.getEmail());
            ps.setString(8, t.getEmail());
            ps.setInt(9, t.getId_hotel());
            ps.executeUpdate(); 
            System.out.println("modification saretttt !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM hotel WHERE id_hotel =?";
            PreparedStatement ps =  cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public ObservableList<Hotel> getListHotels() {
        ObservableList<Hotel> HotelList = FXCollections.observableArrayList();
        try {
            String req = "Select * from hotel";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Hotel h = new Hotel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9));
                HotelList.add(h);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return HotelList; 
    }
    
    

    public String getNomByIDHotel(int id_hotel) {
        String nom  ="";
        try {
            String req = "Select nom_hotel from hotel  WHERE id_hotel ="+id_hotel;
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
    
    public String getImageByid(int id_hotel) {
        String image  ="";
        try {
            String req = "Select image from hotel  WHERE id_hotel ="+id_hotel;
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 image = rs.getString("image");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return image;
    }
    
    

}
