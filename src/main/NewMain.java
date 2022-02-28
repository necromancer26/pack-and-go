/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import models.Activite;
import models.Ticket;
import models.User;
import services.ServiceActivité;
import services.ServiceTicket;

import java.time.LocalDateTime;

import static models.Roles.CLIENT;


public class NewMain {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        ServiceActivité sa = new ServiceActivité();

        Activite activite = new Activite("Cinéma", "Mourouj",1,"Tunisie");
  /*  sa.ajouterActivité(activite);
        System.out.println(sa.getAll());

*/

        Activite activite2 = new Activite(6,"Karti", "Mourouj 300",4,"SANTAOLALLA");
        /*
 sa.modifier(activite2);
        sa.ajouterActivité(activite2);
        System.out.println(sa.getAll());
 */
    User u = new User(1,"Salah", "kakou", "s@g.com","sasa","azerty",28383838, CLIENT, LocalDateTime.of(2019, 03, 28, 14, 33, 48, 640000),LocalDateTime.of(2019, 03, 28, 14, 33, 48, 640000),LocalDateTime.of(2019, 03, 28, 14, 33, 48, 640000));
        Ticket t = new Ticket(2,10);
   ServiceTicket ticket =  new ServiceTicket();


      /* ticket.ajouterTicket(t,activite2,u);*/
    System.out.println(ticket.getAll());
    ticket.modifier(activite2,t,u);


    }
    
}
