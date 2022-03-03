package com.company.services;

import com.company.models.Personality;
import com.company.models.User;
import com.company.models.UserPersonality;

import java.util.List;

public interface IPersonalityService {
    Personality getPersonality(User user);
    Personality getPersonality(String personalityId);
    List<Personality> getAllPersonality();

}
