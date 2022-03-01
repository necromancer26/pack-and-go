package com.company.services;

public class UserPersonality {


    private int userPersonalityId;
    private String personality;
    private int userId;

    public UserPersonality(int userPersonalityId, String personality, int userId) {
        this.userPersonalityId = userPersonalityId;
        this.personality = personality;
        this.userId = userId;
    }

    public void setUserPersonalityId(int userPersonalityId) {
        this.userPersonalityId = userPersonalityId;
    }

    @Override
    public String toString() {
        return "PersonalityUser{" +
                "personality='" + personality + '\'' +
                ", userId=" + userId +
                '}';
    }

    public int getUserPersonalityId() {
        return userPersonalityId;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
