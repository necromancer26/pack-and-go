package models;

public class DecisionMakingStyle {
    private  String decisionMakingId;
    private  String decisionMakingName;
    private  String decisionMakingDetails;

    public void setDecisionMakingId(String decisionMakingId) {
        this.decisionMakingId = decisionMakingId;
    }

    public void setDecisionMakingName(String decisionMakingName) {
        this.decisionMakingName = decisionMakingName;
    }

    public void setDecisionMakingDetails(String decisionMakingDetails) {
        this.decisionMakingDetails = decisionMakingDetails;
    }

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
