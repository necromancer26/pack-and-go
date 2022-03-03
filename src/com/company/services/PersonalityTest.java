package com.company.services;
import com.company.models.User;
import com.company.models.UserPersonality;
import com.company.util.DataSource;

import java.sql.*;
import java.util.*;

public class PersonalityTest implements IPersonalityTestService {
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
    public void supprimerUserPersonality(int userPersonalityId){
        try {
            String req="DELETE FROM `user_personality` WHERE `user_personality`.`user_personality_id`=? LIMIT1;";
            //String req = "INSERT INTO `user_personality` (`user_id`, `personality_id`) VALUES ((SELECT `id_user` FROM `user` WHERE (`username`=?)LIMIT 1), ?);";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, userPersonalityId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public List<UserPersonality> getAllPersonalityUsers(){
            List<UserPersonality> list = new ArrayList<>();
            try {
                String req = "Select * from user_personality";
                Statement st = cnx.createStatement();
                ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                UserPersonality user = new UserPersonality(rs.getInt(1),rs.getInt(2),rs.getString(3));
                list.add(user);
            }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
            return list;

    }

    @Override
    public HashMap<String,String > getPersonalityReport(User user) {
        HashMap<String, String> hashMap = new HashMap<>();
        List<String> queryList=new ArrayList<>();
        //PreparedStatement preparedStatement;
        queryList.add("SELECT `social_name`, `social_details` FROM `social_style` WHERE `social_id` LIKE ( SELECT `social` FROM `personality` WHERE `personality_id` LIKE ( SELECT `personality_id` FROM `user_personality` WHERE `user_id` LIKE ( SELECT `id_user` FROM `user` WHERE (`user`.`username` = '"+user.getUsername()+"') ) LIMIT 1 ) );");
        queryList.add("SELECT `processing_name`, `processing_details` FROM `processing_style` WHERE `processing_id` LIKE ( SELECT `processing` FROM `personality` WHERE `personality_id` LIKE ( SELECT `personality_id` FROM `user_personality` WHERE `user_id` LIKE ( SELECT `id_user` FROM `user` WHERE (`user`.`username` = '"+user.getUsername()+"') ) LIMIT 1 ) );");
        queryList.add("SELECT `decision_making_name`, `decision_making_details` FROM `decision_making_style` WHERE `decision_making_id` LIKE ( SELECT `decision_making` FROM `personality` WHERE `personality_id` LIKE ( SELECT `personality_id` FROM `user_personality` WHERE `user_id` LIKE( SELECT `id_user` FROM `user` WHERE (`username` = '"+user.getUsername()+"') ) LIMIT 1 ) );");
        queryList.add("SELECT `interaction_name`, `interaction_details` FROM `interaction_style` WHERE `interaction_id` LIKE ( SELECT `interaction` FROM `personality` WHERE `personality_id` LIKE ( SELECT `personality_id` FROM `user_personality` WHERE `user_id` LIKE( SELECT `id_user` FROM `user` WHERE (`username` = '"+user.getUsername()+"') ) LIMIT 1 ) );");
        queryList.forEach(request->{
            try {
                Statement statement=cnx.createStatement();
                ResultSet resultSet= statement.executeQuery(request);
                while(resultSet.next()){

                    hashMap.put(resultSet.getString(1),resultSet.getString(2));
                }
            }catch (Exception exception){
                System.err.println(exception.getMessage());
            }
        });
/*        try {
            String req1="SELECT `social_name`,`social_details` FROM `social_style` WHERE `social_id` LIKE (SELECT `social` FROM `personality` WHERE `personality_id` LIKE (SELECT `personality_id` FROM `user_personality` WHERE (`user_id` ="+n+") ));";
            //String req1 ="SELECT `personality_id` FROM `user_personality` WHERE (`user_personality`.`user_id` = "+n+") ;";
            //Statement st = cnx.createStatement();
            PreparedStatement ps = cnx.prepareStatement(req1);
            //ps.setInt(1, 6);
            ResultSet rs = ps.executeQuery(req1);
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
        }catch (Exception exception){
            System.err.println(exception.getMessage());
        }*/
        return hashMap;
    }
}
