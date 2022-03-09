/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.test;


import pidev.services.ServiceUser;

import java.sql.SQLException;

/**
 *
 * @author Wala
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        ServiceUser serviceUser = new ServiceUser();
        //add user
        /*User user = new User("Wala", "Djobbi", "wala@gmail.com", "wala123", "wala123", 55111222, Roles.ADMIN,LocalDateTime.of(1998, Month.MARCH, 3, 17, 45), LocalDateTime.now(), LocalDateTime.now());
        serviceUser.ajouter(user);*/
        //modifier
        /*User user = new User("Wala", "Djobbi", "wala@gmail.com", "wala123", "wala123", 22222222, Roles.ADMIN,LocalDateTime.of(1998, Month.MARCH, 3, 17, 45), LocalDateTime.now(), LocalDateTime.now());
        serviceUser.modifier(2, user);*/

        //supprimer
        /*serviceUser.supprimer(1);*/
    }

}
