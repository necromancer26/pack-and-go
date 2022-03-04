package com.company.models;

public class UserPersonality implements Comparable{


    private int userPersonalityId;
    private String personality;
    private int userId;

    public UserPersonality(int userPersonalityId, int userId,String personality ) {
        this.userPersonalityId = userPersonalityId;
        this.personality = personality;
        this.userId = userId;
    }

    public void setUserPersonalityId(int userPersonalityId) {
        this.userPersonalityId = userPersonalityId;
    }

    @Override
    public String toString() {
        return "UserPersonality{" +
                "userPersonalityId=" + userPersonalityId +
                ", userId=" + userId + '\'' +
                ", personality='" + personality +
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

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
