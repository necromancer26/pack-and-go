/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Activite;
import models.Ticket;
import models.User;
import utils.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ServiceActivité implements IService<Activite> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Activite t) {
        try {

            String req = "INSERT INTO `Activite`(`nom_activite`, `type_activite`, `adresse`, `pays`) VALUES ('" + t.getNom_activite() + "',"+ t.getType_activite()+",'" + t.getAdresse() + "','" + t.getPays() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void ajouter2(Ticket t, Activite t1, User t2) {

    }




    //@Override
   // public Activite getById(int id) {
     //   return
         //To change body of generated methods, choose Tools | Templates.
    //}

    @Override
    public List<Activite> getAll() {
        List<Activite> list = new ArrayList<>();
        try {
            String req = "Select * from Activite";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Activite p = new Activite(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(1),rs.getString(4));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void modifier(Activite t) {
        try {

            String req = "UPDATE `Activite` SET `nom_activite`=['" + t.getNom_activite() + "'],`type_activite`=['"+ t.getType_activite()+"'],`adresse`=['" + t.getAdresse() + "'],`pays`=['"+ t.getPays() +"'] ";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(Activite t) {
        try {

            String req = "DELETE FROM `Activite` where `id_activite` ='" + t.getId_activite()  + "' ";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
