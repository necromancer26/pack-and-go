package com.company.services;

public class PersonalityUser {
    private String personality;
    private int userId;

    @Override
    public String toString() {
        return "PersonalityUser{" +
                "personality='" + personality + '\'' +
                ", userId=" + userId +
                '}';
    }

    public PersonalityUser(String personality, int userId) {
        this.personality = personality;
        this.userId = userId;
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
