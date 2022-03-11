/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import MailingHotel.Mail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.ReservationChambre;
import utils.DataSource;
import utils.UserSession;

/**
 *
 * @author dorsaf
 */
public class ServiceReservationChambre implements IHotel<ReservationChambre>{
    Connection cnx = DataSource.getInstance().getCnx();

    public void ajouter(ReservationChambre t) {
        try {
            String req = "INSERT INTO `reservationchambre`(`check_in`, `check_out`, `id_user`, `id_chambre`) VALUES (?,?,?,?)";
            if (UserSession.getInstace() != null) {
               int  userId = UserSession.getInstace().getUserId().intValue();
                String req1 = "select email from user where id_user="+userId;
                PreparedStatement ps = cnx.prepareStatement(req);
                ResultSet rs = ps.executeQuery(req1);
                while(rs.next()){
                    Mail.sendMail(rs.getString(1));
                }
            ps.setDate(1, t.getCheck_in() );          
            ps.setDate(2, t.getCheck_out());
            ps.setInt(3, t.getId_user());
            ps.setInt(4, t.getId_chambre());
            ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }     
    }

    @Override
    public List<ReservationChambre> getAll() {
        List<ReservationChambre> list = new ArrayList<>();
        try {
            String req = "Select * from reservationchambre";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                ReservationChambre h = new ReservationChambre(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getInt(5));
                list.add(h);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;  
    }

    @Override
    public void modifier(ReservationChambre t) {
       try {
            String req = "UPDATE reservationchambre SET  check_in=?, check_out=?, id_chambre=? WHERE num_reservation =?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setDate(1, t.getCheck_in() );          
            ps.setDate(2, t.getCheck_out());
            ps.setInt(3, t.getId_chambre());            
            ps.setInt(4, t.getNum_reservation());
            ps.executeUpdate(); 
            System.out.println("modification saretttt !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public void supprimer(int num_reservation) {
        try {
            String req = "DELETE FROM reservationchambre WHERE num_reservation =?";
            PreparedStatement ps =  cnx.prepareStatement(req);
            ps.setInt(1, num_reservation);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ObservableList<ReservationChambre> getListReservations() {
        ObservableList<ReservationChambre> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from reservationchambre";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                ReservationChambre h = new ReservationChambre(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getInt(5));
                list.add(h);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;  
    }
    
}
