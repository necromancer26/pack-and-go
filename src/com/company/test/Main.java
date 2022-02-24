package com.company.test;
import com.company.models.Personne;
import com.company.services.PersonalityTest;
import com.company.services.PersonalityUser;
import com.company.services.ServicePersonne;
import com.company.services.User;
import com.company.utils.DataSource;

import java.util.List;


public class Main {

    public static void main(String[] args) {
	// write your code here
        ServicePersonne sp = new ServicePersonne();
        User user = new User("walddha","ggggg","gaussian@g.com","wawwwlha06","123",1,"client");
        sp.ajouter(user);
        PersonalityTest personalityTest= new PersonalityTest();
        List<PersonalityUser>personalityUsers= personalityTest.getAllPersonalityUsers();
        System.out.println(personalityUsers);
        //personalityTest.supprimerUserPersonality(user);
        personalityTest.ajouterUserPersonality(user);
        //personalityTest.modifierUserPersonality(user);

        //System.out.println(sp.getAll());
    }
}
