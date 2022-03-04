package com.company.services;

import com.company.models.*;
import com.company.util.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalityComponentsController implements IPersonalityComponentsService {
    Connection cnx = DataSource.getInstance().getCnx();

    public void editSocialStyle(SocialStyle socialStyle){
        try{
            //System.out.println(socialStyle.toString());
            String request="UPDATE `social_style` SET `social_name` = ?, `social_details`=? WHERE `social_style`.`social_id` = ?;";
            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setString(1, socialStyle.getSocialName());
            ps.setString(2, socialStyle.getSocialDetails());
            ps.setString(3, socialStyle.getSocialId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public void editInteractionStyle(InteractionStyle interactionStyle){
        try{
            //System.out.println(interactionStyle.toString());
            System.out.println("inside edit");
            String request="UPDATE `interaction_style` SET `interaction_name` = ?, `interaction_details`=? WHERE `interaction_style`.`interaction_id` = ?;";
            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setString(1, interactionStyle.getInteractionName());
            ps.setString(2, interactionStyle.getInteractionDetails());
            ps.setString(3, interactionStyle.getInteractionId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void editDecisionMakingStyle(DecisionMakingStyle decisionMakingStyle){
        try{
            //System.out.println(interactionStyle.toString());
            String request="UPDATE `decision_making_style` SET `decision_making_name` = ?, `decision_making_details`=? WHERE `decision_making_style`.`decision_making_id` = ?;";
            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setString(1, decisionMakingStyle.getDecisionMakingName());
            ps.setString(2, decisionMakingStyle.getDecisionMakingDetails());
            ps.setString(3, decisionMakingStyle.getDecisionMakingId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public void editProcessingStyle(ProcessingStyle processingStyle){
        try{
            String request="UPDATE `processing_style` SET `processing_name` = ?, `processing_details`=? WHERE `processing_style`.`processing_id` = ?;";
            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setString(1, processingStyle.getProcessingName());
            ps.setString(2, processingStyle.getProcessingDetails());
            ps.setString(3, processingStyle.getProcessingId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public List<SocialStyle> getSocialStyles() {
        List<SocialStyle> socialStyles = new ArrayList<>();
        try {
            String req = "Select * from social_style";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                //UserPersonality user = new UserPersonality(rs.getInt(1), rs.getInt(2), rs.getString(3));
                SocialStyle socialStyle = new SocialStyle(rs.getString(1), rs.getString(2), rs.getString(3));
                socialStyles.add(socialStyle);
            }

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }/*
        socialStyles.forEach(socialStyle -> {
            System.out.println(socialStyle.toString());
        });*/
        return socialStyles;

    }

    public List<ProcessingStyle> getProcessingStyles() {
        List<ProcessingStyle> processingStyles = new ArrayList<>();
        try {
            String req = "Select * from processing_style";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                //UserPersonality user = new UserPersonality(rs.getInt(1), rs.getInt(2), rs.getString(3));
                ProcessingStyle processingStyle = new ProcessingStyle(rs.getString(1), rs.getString(2), rs.getString(3));
                processingStyles.add(processingStyle);
            }

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }/*
        processingStyles.forEach(processingStyle -> {
            System.out.println(processingStyle.toString());
        });*/
        return processingStyles;
    }

    public List<DecisionMakingStyle> getDecisionMakingStyles() {
        List<DecisionMakingStyle> decisionMakingStyles = new ArrayList<>();
        try {
            String req = "Select * from decision_making_style";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                //UserPersonality user = new UserPersonality(rs.getInt(1), rs.getInt(2), rs.getString(3));
                DecisionMakingStyle decisionMakingStyle = new DecisionMakingStyle(rs.getString(1), rs.getString(2), rs.getString(3));
                decisionMakingStyles.add(decisionMakingStyle);
            }

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
/*        decisionMakingStyles.forEach(decisionMakingStyle -> {
            System.out.println(decisionMakingStyle.toString());
        });*/
        return decisionMakingStyles;
    }

    public List<InteractionStyle> getInteractionStyles() {
        List<InteractionStyle> interactionStyles = new ArrayList<>();
        try {
            String req = "Select * from interaction_style";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                //UserPersonality user = new UserPersonality(rs.getInt(1), rs.getInt(2), rs.getString(3));
                InteractionStyle interactionStyle = new InteractionStyle(rs.getString(1), rs.getString(2), rs.getString(3));
                interactionStyles.add(interactionStyle);
            }

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
        /*
        interactionStyles.forEach(interactionStyle -> {
            System.out.println(interactionStyle.toString());
        });*/
        return interactionStyles;
    }

}
