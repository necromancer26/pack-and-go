package services;

import models.Personality;
import models.User;

import java.util.List;

public interface IPersonalityService {
    Personality getPersonality(User user);
    Personality getPersonality(String personalityId);
    List<Personality> getAllPersonality();

}
