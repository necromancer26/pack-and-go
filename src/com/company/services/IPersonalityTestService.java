package com.company.services;

import com.company.models.User;
import com.company.models.UserPersonality;

import java.util.HashMap;
import java.util.List;

public interface IPersonalityTestService {
    void ajouterUserPersonality(User user);

    void modifierUserPersonality(User user);

    void supprimerUserPersonality(User user);

    void supprimerUserPersonality(int userPersonalityId);

    List<UserPersonality> getAllPersonalityUsers();

    HashMap<String ,String> getPersonalityReport(User user);

}
