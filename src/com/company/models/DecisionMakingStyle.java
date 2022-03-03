package com.company.models;

public class DecisionMakingStyle {
    private final String decisionMakingId;
    private final String decisionMakingName;
    private final String decisionMakingDetails;

    public String getDecisionMakingId() {
        return decisionMakingId;
    }

    public String getDecisionMakingName() {
        return decisionMakingName;
    }

    public String getDecisionMakingDetails() {
        return decisionMakingDetails;
    }

    @Override
    public String toString() {
        return "DecisionMakingStyle{" +
                "decisionMakingId='" + decisionMakingId + '\'' +
                ", decisionMakingName='" + decisionMakingName + '\'' +
                ", decisionMakingDetails='" + decisionMakingDetails + '\'' +
                '}';
    }

    public DecisionMakingStyle(String decisionMakingId, String decisionMakingName, String decisionMakingDetails) {
        this.decisionMakingId = decisionMakingId;
        this.decisionMakingName = decisionMakingName;
        this.decisionMakingDetails = decisionMakingDetails;
    }
}
