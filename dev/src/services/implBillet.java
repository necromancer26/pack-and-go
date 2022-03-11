package services;

//import billet.connection.connection;
//fimport billet.model.modelBillet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.modelBillet;
import utils.connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class implBillet implements interBillet {
    connection k;
    //User current_user;

    @Override
    public void insert(modelBillet m) {
        k = new connection();
        PreparedStatement ps;
        try {
            ps = k.connect().prepareStatement("insert into billet values(?,?,?,?,?,?)");
            ps.setInt(1, m.getId());
            ps.setString(2, m.get_nom());
            ps.setString(3, m.get_prenom());
            ps.setString(4, m.get_cin().toString());
            ps.setDate(5, (Date) m.get_date_de_naissance());
            System.out.println("Date de naissance : "+m.get_date_de_naissance());
            //ps.setDate(6, (Date) m.get_date_arrive());
            //ps.setString(7, m.get_prix().toString());
            ps.setString(6, m.get_classe());
            //ps.setString(9, m.get_image());
            //ps.setString(9, m.get_duree());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(implBillet.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(modelBillet m) {
        k = new connection();
        PreparedStatement ps;
        try {
            ps = k.connect().prepareStatement("delete from billet where id = ?");
           
            ps.setString(1,Integer.toString(m.getId()));
            ps.execute();
        } catch (Exception e) {
           // Logger.getLogger(implVol.class.getId()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(modelBillet m) {
        k = new connection();
        PreparedStatement ps;
        try {
            ps = k.connect().prepareStatement("UPDATE billet SET nom=?, prenom=?, cin=?, date_de_naissance=?, classe=? WHERE id = ?");
        //    ps.setInt(1,m.getId());
            ps.setString(1, m.get_nom());
            ps.setString(2, m.get_prenom());
            ps.setInt(3, m.get_cin());
            ps.setDate(4, (Date) m.get_date_de_naissance());
            //ps.setDate(5, (Date) m.get_date_arrive());
            //ps.setString(6, m.get_prix().toString());
            ps.setString(5, m.get_classe());
           //ps.setString(8, m.get_image());
            //ps.setString(8, m.get_duree());
            //ps.setInt(9,m.getId());
            System.out.println(m.getId());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(implBillet.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    @Override
    public ObservableList<modelBillet> getAll() {
        k = new connection();
        ObservableList<modelBillet> listData = FXCollections.observableArrayList();
        try {
                String sql = "select * from billet";
                ResultSet rs = k.connect().createStatement().executeQuery(sql);
            while (rs.next()) {
                modelBillet m = new modelBillet();
//int myint = parseInt(rs.getInteger(1));
                m.setId(rs.getInt(1));
                m.set_nom(rs.getString(2));
                m.set_prenom(rs.getString(3));
                m.set_cin(rs.getInt(4));
            //    m.set_date_de_naissance(rs.getDate(5));
                //m.set_date_arrive(rs.getDate(6));
                //m.set_prix(rs.getFloat(7));
                m.set_classe(rs.getString(6));
                //m.set_image(rs.getString(9));
                //m.set_duree(rs.getString(9));
                
                listData.add(m);
             //   System.out.println("found "+listData.size()+" items");
             //   System.out.println(listData);
            }
        } catch (Exception ex) {
            Logger.getLogger(String.valueOf(listData.size())).log(Level.SEVERE, null, ex);
        }
        return listData;
    }

  /*  @Override
    public ObservableList<modelVol> likeByName(String a) {
        k = new connection();
        ObservableList<modelVol> listData = FXCollections.observableArrayList();
        try {
            String sql = "select * from vols where name like '%"+a+"%'";
            ResultSet rs = k.connect().createStatement().executeQuery(sql);
            while (rs.next()) {  
                modelVol m = new modelVol();
                m.setId(rs.getString(1));
                m.setName(rs.getString(2));
                m.setAddress(rs.getString(3));
                m.setBirthDate(rs.getDate(4));
                listData.add(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(implVol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }
*/
    @Override
    public void autoId(modelBillet m) {
       k = new connection();
        try {
            ResultSet rs = k.connect().createStatement().executeQuery("select * from billet");
            while(rs.next()){
                int code = rs.getInt(1);
                code ++;
                m.setId(code);
           }
        } catch (SQLException ex) {
          //Logger.getLogger(implVol.class.getName()).log(Level.SEVERE, null, ex);
       }
    } 
}
