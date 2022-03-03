package com.company.models;

public class InteractionStyle {
    private final String interactionId;
    private final String interactionName;
    private final String interactionDetails;

    public InteractionStyle(String interactionId, String interactionName, String interactionMakingDetails) {
        this.interactionId = interactionId;
        this.interactionName = interactionName;
        this.interactionDetails = interactionMakingDetails;
    }

    @Override
    public String toString() {
        return "InteractionStyle{" +
                "interactionId='" + interactionId + '\'' +
                ", interactionName='" + interactionName + '\'' +
                ", interactionMakingDetails='" + interactionDetails + '\'' +
                '}';
    }

    public String getInteractionId() {
        return interactionId;
    }

    public String getInteractionName() {
        return interactionName;
    }

    public String getInteractionDetails() {
        return interactionDetails;
    }
}
