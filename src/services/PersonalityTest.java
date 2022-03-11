package services;
import models.User;
import models.UserPersonality;
import utils.DataSource;

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

    public void ajouterUserPersonality(long userId,String personalityResult) {
        try {
            System.out.println("inside ajout");
            System.out.println(userId);
            System.out.println(personalityResult);
            System.out.println("inside ajout");
            //String req = "INSERT INTO `user_personality` (`user_id`, `personality_id`) VALUES ((SELECT `id_user` FROM `user` WHERE (`username`=?)LIMIT 1), ?) ;";
            String req="INSERT INTO `user_personality` (`user_id`, `personality_id`) VALUES ( ?, ? ) ON DUPLICATE KEY UPDATE `personality_id` = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setLong(1, userId);
            ps.setString(2, personalityResult);
            ps.setString(3, personalityResult);
            //ps.setString(3, personalityResult);
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
    public void modifierUserPersonality(UserPersonality userPersonality) {
        try {
            String req="UPDATE `user_personality` SET `user_personality_id` = ? WHERE `user_personality`.`user_id` = ?;";
            //String req="UPDATE `user_personality` SET `personality_id` = ? WHERE `user_personality`.`user_id` = ? ;";
            //String req = "INSERT INTO `user_personality` (`user_id`, `personality_id`) VALUES ((SELECT `id_user` FROM `user` WHERE (`username`=?)LIMIT 1), ?);";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, userPersonality.getUserPersonalityId());
            ps.setInt(2, userPersonality.getUserId());
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

    @Override
    public void supprimerUserPersonality(int userPersonalityId) {

    }

    public void supprimerUserPersonality(UserPersonality userPersonality){
        try {
            String req="DELETE FROM `user_personality` WHERE `user_personality`.`user_personality_id`= ? ;";
            //String req = "INSERT INTO `user_personality` (`user_id`, `personality_id`) VALUES ((SELECT `id_user` FROM `user` WHERE (`username`=?)LIMIT 1), ?);";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, userPersonality.getUserPersonalityId());
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
    public HashMap<String,String > getPersonalityReport(long userId) {
        HashMap<String, String> hashMap = new HashMap<>();
        List<String> queryList=new ArrayList<>();
        //PreparedStatement preparedStatement;
        queryList.add("SELECT `social_name`,\n" +
                "    `social_details`\n" +
                "FROM `social_style`\n" +
                "WHERE `social_id` LIKE (\n" +
                "        SELECT `social`\n" +
                "        FROM `personality`\n" +
                "        WHERE `personality_id` LIKE (\n" +
                "                SELECT `personality_id`\n" +
                "                FROM `user_personality`\n" +
                "                WHERE `user_id` = "+userId +" \n" +
                "                LIMIT 1\n" +
                "            )\n" +
                "    );");
        queryList.add("SELECT `processing_name`,\n" +
                "    `processing_details`\n" +
                "FROM `processing_style`\n" +
                "WHERE `processing_id` LIKE (\n" +
                "        SELECT `processing`\n" +
                "        FROM `personality`\n" +
                "        WHERE `personality_id` LIKE (\n" +
                "                SELECT `personality_id`\n" +
                "                FROM `user_personality`\n" +
                "                WHERE `user_id` = "+userId +"\n" +
                "                LIMIT 1\n" +
                "            )\n" +
                "    );");
        queryList.add("SELECT `decision_making_name`,\n" +
                "    `decision_making_details`\n" +
                "FROM `decision_making_style`\n" +
                "WHERE `decision_making_id` LIKE (\n" +
                "        SELECT `decision_making`\n" +
                "        FROM `personality`\n" +
                "        WHERE `personality_id` LIKE (\n" +
                "                SELECT `personality_id`\n" +
                "                FROM `user_personality`\n" +
                "                WHERE `user_id` = "+userId +"\n" +
                "                LIMIT 1\n" +
                "            )\n" +
                "    );");
        queryList.add("SELECT `interaction_name`,\n" +
                "    `interaction_details`\n" +
                "FROM `interaction_style`\n" +
                "WHERE `interaction_id` LIKE (\n" +
                "        SELECT `interaction`\n" +
                "        FROM `personality`\n" +
                "        WHERE `personality_id` LIKE (\n" +
                "                SELECT `personality_id`\n" +
                "                FROM `user_personality`\n" +
                "                WHERE `user_id` = "+userId +"\n" +
                "                LIMIT 1\n" +
                "            )\n" +
                "    );");
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
        return hashMap;
    }
}
