package com.company.models;

public class InteractionStyle {
    private final String interactionId;
    private final String interactionName;
    private final String interactionMakingDetails;

    public InteractionStyle(String interactionId, String interactionName, String interactionMakingDetails) {
        this.interactionId = interactionId;
        this.interactionName = interactionName;
        this.interactionMakingDetails = interactionMakingDetails;
    }

    public String getInteractionId() {
        return interactionId;
    }

    public String getInteractionName() {
        return interactionName;
    }

    public String getInteractionMakingDetails() {
        return interactionMakingDetails;
    }
}
