package com.company.services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.company.utils.DataSource;

public class ServicePersonne implements IService<User> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(User t) {
        try {
            String req = "INSERT INTO `user` ( `first_name`, `last_name`, `email`, `username`, `password`, `number`, `role`) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getFirstName());
            ps.setString(2, t.getLastName());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getUsername());
            ps.setString(5, t.getPassword());
            ps.setInt(6, t.getNumber());
            ps.setString(7, t.getRole());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }/*
        try {
            String req = "INSERT INTO `personnes` (`nom`, `prenom`) VALUES ('" +t.getNom() + "', '" + t.getPrenom() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }*/
    }

    @Override
    public User getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try {
            String req = "Select * from user";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
/*            while(rs.next()){
                User user = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
                list.add(user);
            }*/
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }




    @Override
    public boolean supprimer(User user) {
        return false;
    }

    @Override
    public boolean modifier(User t) {
        return false;
        //To change body of generated methods, choose Tools | Templates.
    }

/*    @Override
    public boolean supprimer(User t) {
        try {
            String req = "DELETE FROM `perssonnes` WHERE `Personnes`.`id` = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, Integer.toString(t.getId()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } //To change body of generated methods, choose Tools | Templates.
        return true;
    }*/

}