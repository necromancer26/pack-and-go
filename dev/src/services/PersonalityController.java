package services;


import models.Personality;
import models.User;
import utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalityController implements IPersonalityService {
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public List<Personality> getAllPersonality() {
        List<Personality> personalities = new ArrayList<>();
        try {
            String req = "SELECT * FROM `personality`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Personality personality = new Personality(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                personalities.add(personality);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return personalities;
    }

    @Override
    public Personality getPersonality(User user) {
        Personality personality = null;
        try {

            String req = "SELECT * FROM `personality` WHERE `personality`.`personality_id` LIKE (SELECT `personality_id` FROM `user_personality` WHERE `user_id` = (SELECT `user_id` FROM `user` WHERE `username` LIKE ? ) LIMIT 1 );";
            //Statement st = cnx.createStatement();
            PreparedStatement preparedStatement = cnx.prepareStatement(req);
            preparedStatement.setString(1, user.getUsername());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                personality = new Personality(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return personality;
    }
    @Override
    public Personality getPersonality(String personalityId) {
        Personality personality = null;
        try {

            String req = "SELECT * FROM `personality` WHERE `personality`.`personality_id` LIKE ?  LIMIT 1 ;";
            //Statement st = cnx.createStatement();
            PreparedStatement preparedStatement = cnx.prepareStatement(req);
            preparedStatement.setString(1, personalityId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                personality = new Personality(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return personality;
    }
}
