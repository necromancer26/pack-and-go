/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MailingHotel;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import utils.DataSource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import models.User;
import services.ServiceUser;


/**
 *
 * @author dorsaf
 */
public class Mail {
     private Connection cnx;
    private Statement st;
    ServiceUser su = new ServiceUser();

    public Mail() {
        cnx = DataSource.getInstance().getCnx();

    }

     public static void sendMail(String recepient) throws Exception {
        Properties properties = new Properties();
        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "465");
       properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      //  properties.put("mail.smtp.socketFactory.fallback", "false");
        //Your gmail address
        String myAccountEmail = "packandgomail@gmail.com";
        //Your gmail password
        String password = "packandgo2022";
        //dorsaf.charfeddine@gmail.com
        //Create a session with accosunt credentials
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        //Prepare email message
        Message message = prepareMessage(session, myAccountEmail, recepient);

        //Send mail
        Transport.send(message);        
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("PACK AND GO");
            String htmlCode = "<h1 style='color: green;'> Voucher Client </h1> <br/> <h2><b> Cher(e) Mr/Mme </b></h2> <h3><b> Nous vous remercions d'avoir choisir PACK AND GO pour la "
                    + "réservation de votre séjour, ci joint votre Voucher. </b> </h3> Merci pour votre confiance. <b><h3> Réservation </h3><b> ";
            message.setContent(htmlCode, "text/html");
            return message;
        } catch (Exception ex) {
        }
        return null;
    }
}
