/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Roles;
import models.User;
import utils.DataSource;

/**
 *
 * @author Wala
 */
public class ServiceUser implements services.IService<User> {

    Connection cnx;

    public ServiceUser() {
        cnx = DataSource.getInstance().getCnx();
    }

    @Override
    public void ajouter(User user) throws SQLException {

        
            Statement st;
            st = cnx.createStatement();
            String hashedPassword = hashPassword(user.getPassword());
            user.setPassword(hashedPassword);
            String query = "INSERT INTO `user`(`first_name`, `last_name`, `email`, `number`,`username`, `password`, `role`,`birthday`, `date_created_user`, `last_updated_user`) VALUES ('" + user.getFirst_name() + "','" + user.getLast_name() + "','" + user.getEmail() + "','" + user.getNumber() + "','" + user.getUsername() + "','" + user.getPassword() + "','" + user.getRole() + "','" + user.getBirthday() + "','" + LocalDateTime.now() + "','" + LocalDateTime.now() + "')";
            st.executeUpdate(query);
   


    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> lp = new ArrayList<>();

        Statement stm = cnx.createStatement();

        String query = "SELECT * FROM user";
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            User user = new User();
            user.setId_user(rs.getInt("id_user"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setNumber(rs.getInt("number"));
            user.setRole(Roles.valueOf(rs.getString("role")));
            user.setBirthday(rs.getTimestamp(9).toLocalDateTime());
            user.setDate_created_user(rs.getTimestamp(10).toLocalDateTime());
            user.setLast_updated_user(rs.getTimestamp(11).toLocalDateTime());
            lp.add(user);
        }

        return lp;
    }

    @Override
    public void supprimer(long id_user) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "delete from user where id_user=" + id_user;
        stm.executeUpdate(query);

    }

    @Override
    public User getById(long id_user) throws SQLException {
        Statement stm = cnx.createStatement();
        User user = new User();
        String query = "select * from user where id_user=" + id_user;
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            user.setId_user(rs.getInt("id_user"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setNumber(rs.getInt("number"));
            user.setRole(Roles.valueOf(rs.getString("role")));
            user.setBirthday(rs.getTimestamp(9).toLocalDateTime());
            user.setDate_created_user(rs.getTimestamp(10).toLocalDateTime());
            user.setLast_updated_user(rs.getTimestamp(11).toLocalDateTime());
        }
        return user;
    }

    @Override
    public void modifier(long id_user_a_modifier, User user_modifier) throws SQLException {
        Statement stm = cnx.createStatement();
        User user = getById(id_user_a_modifier);
        String query = "UPDATE `user` SET `first_name`='" + user_modifier.getFirst_name() + "',`last_name`='" + user_modifier.getLast_name() + "',`email`='" + user_modifier.getEmail() + "',`number`='" + user_modifier.getNumber() + "',`username`='" + user_modifier.getUsername() + "',`password`='" + user_modifier.getPassword() + "',`role`='" + user_modifier.getRole() + "',`birthday`='" + user_modifier.getBirthday() + "',`date_created_user`='" + user.getDate_created_user() + "',`last_updated_user`='" + LocalDateTime.now() + "' where id_user=" + user.getId_user();
        stm.executeUpdate(query);
    }

    @Override
    public List<User> afficher() throws SQLException {
        List<User> lp = new ArrayList<>();

        Statement stm = cnx.createStatement();

        String query = "SELECT * FROM user";
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            User user = new User();
            user.setId_user(rs.getInt("id_user"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setNumber(rs.getInt("number"));
            user.setRole(Roles.valueOf(rs.getString("role")));
            user.setBirthday(rs.getTimestamp(9).toLocalDateTime());
            user.setDate_created_user(rs.getTimestamp(10).toLocalDateTime());
            user.setLast_updated_user(rs.getTimestamp(11).toLocalDateTime());
            lp.add(user);
        }

        return lp;
    }

    public int nbUser() {
        int nbuser = 0;
        try {
            ResultSet set = DataSource.getInstance().
                    getCnx().prepareStatement("SELECT COUNT(id_user) FROM user")
                    .executeQuery();
            if (set.next()) {
                nbuser = set.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nbuser;
    }

    public User SearchByUsername(String username) {
        try {
            Statement stm = cnx.createStatement();
        User user = new User();
        String query = "SELECT * FROM user where username='" + username + "'";
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            user.setId_user(rs.getInt("id_user"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setNumber(rs.getInt("number"));
            user.setRole(Roles.valueOf(rs.getString("role")));
            user.setBirthday(rs.getTimestamp(9).toLocalDateTime());
            user.setDate_created_user(rs.getTimestamp(10).toLocalDateTime());
            user.setLast_updated_user(rs.getTimestamp(11).toLocalDateTime());
        }
        return user;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User checkLogin(String email_username, String password) throws SQLException, NoSuchAlgorithmException {
        Statement stm = cnx.createStatement();
        String hashedPassword = hashPassword(password);
        String query = "SELECT * FROM user WHERE (email='" + email_username + "'OR username='" + email_username + "') AND password ='" + hashedPassword + "'";
        ResultSet rs = stm.executeQuery(query);
        User user = new User();
        while (rs.next()) {
            System.out.println("user exist");
            user.setId_user(rs.getInt("id_user"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setNumber(rs.getInt("number"));
            user.setRole(Roles.valueOf(rs.getString("role")));
            user.setBirthday(rs.getTimestamp(9).toLocalDateTime());
            user.setDate_created_user(rs.getTimestamp(10).toLocalDateTime());
            user.setLast_updated_user(rs.getTimestamp(11).toLocalDateTime());
        }
        return user;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

        // Add password bytes to digest
        md.update(password.getBytes());

        // Get the hash's bytes
        byte[] bytes = md.digest();

        // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        // Get complete hashed password in hex format
        String generatedPassword = sb.toString();

        return generatedPassword;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public User getUserById(long id_user) {
        User user = null;
        try {
            String req = "Select * from user WHERE id_user ="+id_user;
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), Roles.valueOf(rs.getString(8)), rs.getTimestamp(9).toLocalDateTime(), rs.getTimestamp(10).toLocalDateTime(), rs.getTimestamp(11).toLocalDateTime());
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return user;
    }
}
