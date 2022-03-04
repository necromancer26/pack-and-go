package com.company.models;

public class InteractionStyle {
    private  String interactionId;
    private  String interactionName;
    private  String interactionDetails;


    public void setInteractionId(String interactionId) {
        this.interactionId = interactionId;
    }

    public void setInteractionName(String interactionName) {
        this.interactionName = interactionName;
    }

    public void setInteractionDetails(String interactionDetails) {
        this.interactionDetails = interactionDetails;
    }

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
