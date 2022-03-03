package src.services;
//import models.modelVol;
//import utils.connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import src.models.modelVol;
import src.utils.connection;
//import services.interVol;


public class implVol implements interVol {
    connection k;

    @Override
    public void insert(modelVol m) {
        k = new connection();
        PreparedStatement ps;
        try {
            ps = k.connect().prepareStatement("insert into vols values(?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, m.getId());
            ps.setString(2, m.get_compagnie_aerien());
            ps.setString(3, m.get_depart());
            ps.setString(4, m.get_destination());
            ps.setDate(5, (Date) m.get_date_depart());
            System.out.println("Date depart : " + m.get_date_depart());
            ps.setDate(6, (Date) m.get_date_arrive());
            ps.setString(7, m.get_prix().toString());
            ps.setString(8, m.get_type_avion());
            //ps.setString(9, m.get_image());
            ps.setString(9, m.get_duree());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(implVol.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(modelVol m) {
        k = new connection();
        PreparedStatement ps;
        try {
            ps = k.connect().prepareStatement("delete from vols where id = ?");

            ps.setString(1, Integer.toString(m.getId()));
            ps.execute();
        } catch (Exception e) {
            // Logger.getLogger(implVol.class.getId()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(modelVol m) {
        k = new connection();
        PreparedStatement ps;
        try {
            ps = k.connect().prepareStatement("UPDATE vols SET compagnie_aerien=?, depart=?, destination=?, date_depart=?, date_arrive=?, prix=?, type_avion=?, duree=? WHERE id = ?");
            //    ps.setInt(1,m.getId());
            ps.setString(1, m.get_compagnie_aerien());
            ps.setString(2, m.get_depart());
            ps.setString(3, m.get_destination());
            ps.setDate(4, (Date) m.get_date_depart());
            ps.setDate(5, (Date) m.get_date_arrive());
            ps.setString(6, m.get_prix().toString());
            ps.setString(7, m.get_type_avion());
            //ps.setString(8, m.get_image());
            ps.setString(8, m.get_duree());
            ps.setInt(9, m.getId());
            System.out.println(m.getId());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(implVol.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    @Override
    public ObservableList<modelVol> getAll() {
        k = new connection();
        ObservableList<modelVol> listData = FXCollections.observableArrayList();
        try {
            String sql = "select * from vols";
            ResultSet rs = k.connect().createStatement().executeQuery(sql);
            while (rs.next()) {
                modelVol m = new modelVol();
//int myint = parseInt(rs.getInteger(1));
                m.setId(rs.getInt(1));
                m.set_compagnie_aerien(rs.getString(2));
                m.set_depart(rs.getString(3));
                m.set_destination(rs.getString(4));
                m.set_date_depart(rs.getDate(5));
                m.set_date_arrive(rs.getDate(6));
                m.set_prix(rs.getFloat(7));
                m.set_type_avion(rs.getString(8));
                //m.set_image(rs.getString(9));
                m.set_duree(rs.getString(9));

                listData.add(m);
            }
        } catch (Exception ex) {
            //   Logger.getLogger(implVol.class.getId()).log(Level.SEVERE, null, ex);
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
    public void autoId(modelVol m) {
        k = new connection();
        try {
            ResultSet rs = k.connect().createStatement().executeQuery("select * from vols");
            while (rs.next()) {
                int code = rs.getInt(1);
                code++;
                m.setId(code);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(implVol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}