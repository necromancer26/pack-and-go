package com.company.services;
import com.company.models.Personne;
import com.company.utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonalityTest {
    Connection cnx = DataSource.getInstance().getCnx();
    private double score;
    public static String test(){
        String result="";
        int response = 0;
        Scanner scanner = new Scanner(System.in);
        do {
        System.out.println("do you prefer:");
        System.out.println("1 social activities");
        System.out.println("2 wander alone?");
        response=scanner.nextInt();
        }while (response!=1 && response!=2);
        result = response == 1 ? "E" : "I";
        do {
            System.out.println("do you prefer:");
            System.out.println("1 sensing");
            System.out.println("2 intuition?");
            response=scanner.nextInt();
        }while (response!=1 && response!=2);
        result += response == 1 ? "S" : "N";
        do {
            System.out.println("do you prefer:");
            System.out.println("1 feeling");
            System.out.println("2 thinking?");
            response=scanner.nextInt();
        }while (response!=1 && response!=2);
        result += response == 1 ? "F" : "T";
        do {
            System.out.println("do you prefer:");
            System.out.println("1 perceiving");
            System.out.println("2 judging?");
            response=scanner.nextInt();
        }while (response!=1 && response!=2);
        result += response == 1 ? "P" : "J";
        return result;
    }

    public void ajouterUserPersonality(User user) {
        try {
            String req = "INSERT INTO `user_personality` (`user_id`, `personality_id`) VALUES ((SELECT `id_user` FROM `user` WHERE (`username`=?)LIMIT 1), ?);";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, user.getUsername());
            ps.setString(2, test());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void modifierUserPersonality(User user) {
        try {
            String req="UPDATE `user_personality` SET `personality_id` = ? WHERE `user_personality`.`user_id` = (SELECT `id_user` FROM `user` WHERE (`username`=?)LIMIT 1);";
            //String req = "INSERT INTO `user_personality` (`user_id`, `personality_id`) VALUES ((SELECT `id_user` FROM `user` WHERE (`username`=?)LIMIT 1), ?);";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, test());
            ps.setString(2, user.getUsername());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public void supprimerUserPersonality(User user){
        try {
            String req="DELETE FROM `user_personality` WHERE `user_personality`.`user_id`=(SELECT `id_user` FROM `user` WHERE (`username`=?)LIMIT 1);";
            //String req = "INSERT INTO `user_personality` (`user_id`, `personality_id`) VALUES ((SELECT `id_user` FROM `user` WHERE (`username`=?)LIMIT 1), ?);";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, user.getUsername());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public List<PersonalityUser> getAllPersonalityUsers(){
            List<PersonalityUser> list = new ArrayList<>();
            try {
                String req = "Select * from user_personality";
                Statement st = cnx.createStatement();
                ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                PersonalityUser user = new PersonalityUser(rs.getString(2),rs.getInt(1));
                list.add(user);
            }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
            return list;

    }
}
