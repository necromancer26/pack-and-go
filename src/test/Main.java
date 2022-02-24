/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Date;
import static java.sql.Date.valueOf;
import models.Chambre;
import models.Hotel;
import models.ReservationChambre;
import services.ControllerChambre;
import services.ControllerHotel;
import services.ControllerReservationChambre;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import static java.util.Date.parse;
import models.Roles;
import models.User;
import services.ServiceUser;
/**
 *
 * @author dorsaf
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ControllerHotel sh = new ControllerHotel();       
        Hotel h = new Hotel("anantara", 5,60, "tozeur", "tunisie", 5412365,"anantara@gmail.fr");
        Hotel h2 = new Hotel("aaa",5,60, "sousse","tunisie", 5412365,"movenpick@gmail.fr");
        Hotel h3 = new Hotel("africa jad",5,60, "tabarka","tunisie", 5412365,"africajad@gmail.fr");
        Hotel h4 = new Hotel("4 seaons",5,60, "tunis","tunisie", 5412365,"russelior@gmail.fr");     
        Hotel h5 = new Hotel("russelior",5,60, "hammemet","tunisie", 5412365,"anantara@gmail.fr");
        Hotel h6 = new Hotel("anantara",5,60, "tozeur","tunisie", 5412365,"anantara@gmail.fr");
     //  sh.ajouter(h);
      //  sh.ajouter(h2);
     //  sh.ajouter(h3);
      //  sh.ajouter(h4);
      //  sh.ajouter(h5);
      //  sh.ajouter(h6);
        System.out.println(sh.getAll());
     //  sh.modifier(new Hotel(10,"anantaraaa", 5, 60,"tozeur"," test", 54, "anantara"));
    //   sh.supprimer(10);

        ControllerChambre sch = new ControllerChambre();
        Chambre ch = new Chambre(201, "doubeeele",2,300,12);
        Chambre ch2 = new Chambre(201, "doubeeele",2,300);
// num chambre, type, etage, prix, id_hotel
     //  Chambre ch2 = new Chambre(55,"triple",1,410);
      //  Chambre ch3 = new Chambre(54,"suite",3,680);
    //    Chambre ch4 = new Chambre(58,"double",3,320);
    //    Chambre ch5 = new Chambre(52,"quadruple",1,500);
      //  sch.ajouter(ch);
       // sch.ajouter(ch2);
      //  sch.ajouter(ch3);
        //sch.ajouter(ch4);
        //sch.ajouter(ch5);
      //  System.out.println(sch.getAll());
      //  sch.modifier(new Chambre(5, 201, "ok", 2, 1000,11)); // id_chambre, num_chambre, type, etage, prix, id_hotel
    //  sch.supprimer(4); 
      ControllerReservationChambre sreserv = new ControllerReservationChambre();      
         ReservationChambre rch = new ReservationChambre( Date.valueOf("2002-03-30") , Date.valueOf("2002-04-30") ,1,27);
    //       sreserv.ajouter(rch);
      // System.out.println(sreserv.getAll());
       /// sreserv.modifier(new ReservationChambre(9, Date.valueOf("2003-03-03") ,Date.valueOf("2005-03-30"), 5));
       // sreserv.supprimer(9); 
       
       
       
       
       
       
       
       
        ServiceUser serviceUser = new ServiceUser();
        //add user
        User user = new User("Wala", "Djobbi", "wala@gmail.com", "wala123", "wala123", 55111222, Roles.ADMIN,LocalDateTime.of(1998, Month.MARCH, 3, 17, 45), LocalDateTime.now(), LocalDateTime.now());
        serviceUser.ajouter(user);
        //modifier
        /*User user = new User("Wala", "Djobbi", "wala@gmail.com", "wala123", "wala123", 22222222, Roles.ADMIN,LocalDateTime.of(1998, Month.MARCH, 3, 17, 45), LocalDateTime.now(), LocalDateTime.now());
        serviceUser.modifier(2, user);*/

        //supprimer
        /*serviceUser.supprimer(1);*/
    }
    
}