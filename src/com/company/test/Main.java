package com.company.test;
import com.company.models.User;
import com.company.models.Roles;
import com.company.services.PersonalityTest;
import com.company.models.UserPersonality;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        // write your code here

       User user = new User("khalil", "ch", "kh@gmail.com", "aesthetik", "1234", 55111222, Roles.CLIENT, LocalDateTime.of(1995, Month.JUNE, 26, 17, 45), LocalDateTime.now(), LocalDateTime.now());
        PersonalityTest personalityTest= new PersonalityTest();
        List<UserPersonality>personalityUsers= personalityTest.getAllPersonalityUsers();
        System.out.println(personalityUsers);
        personalityTest.ajouterUserPersonality(user);
        personalityTest.modifierUserPersonality(user);
        personalityTest.supprimerUserPersonality(user);
        System.out.println(personalityUsers.size());
        //personalityTest.supprimerUserPersonality(personalityUsers.get(personalityUsers.size()-1).getUserPersonalityId());
    }
}
