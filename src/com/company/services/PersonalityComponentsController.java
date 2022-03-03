package com.company.services;

import com.company.models.*;
import com.company.util.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonalityComponentsController implements IPersonalityComponentsService {
    Connection cnx = DataSource.getInstance().getCnx();

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
            String req = "Select * from social_style";
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
            String req = "Select * from social_style";
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
        interactionStyles.forEach(interactionStyle -> {
            System.out.println(interactionStyle.toString());
        });
        return interactionStyles;
    }

}
