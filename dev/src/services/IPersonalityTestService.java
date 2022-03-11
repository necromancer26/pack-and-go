package services;

import models.User;
import models.UserPersonality;

import java.util.HashMap;
import java.util.List;

public interface IPersonalityTestService {
    void ajouterUserPersonality(User user,String personalityResult);

    void modifierUserPersonality(User user);

    void supprimerUserPersonality(User user);

    void supprimerUserPersonality(int userPersonalityId);

    List<UserPersonality> getAllPersonalityUsers();

    HashMap<String ,String> getPersonalityReport(User user);

}
