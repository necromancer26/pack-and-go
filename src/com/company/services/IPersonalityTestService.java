package com.company.services;

import com.company.models.User;
import com.company.models.UserPersonality;

import java.util.List;

public interface IPersonalityTestService {
    public void ajouterUserPersonality(User user);
    public void modifierUserPersonality(User user);
    public void supprimerUserPersonality(User user);
    public void supprimerUserPersonality(int userPersonalityId);
    public List<UserPersonality> getAllPersonalityUsers();
}
