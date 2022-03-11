package models;

public class Personality {
    private final String personalityId;
    private final String social;
    private final String processing;
    private final String decisionMaking;
    private final String interaction;

    public Personality(String personalityId, String social, String processing, String decisionMaking, String interaction) {
        this.personalityId = personalityId;
        this.social = social;
        this.processing = processing;
        this.decisionMaking = decisionMaking;
        this.interaction = interaction;
    }

    public String getPersonalityId() {
        return personalityId;
    }

    public String getSocial() {
        return social;
    }

    public String getProcessing() {
        return processing;
    }

    public String getDecisionMaking() {
        return decisionMaking;
    }

    public String getInteraction() {
        return interaction;
    }

    @Override
    public String toString() {
        return "Personality{" +
                "personalityId='" + personalityId + '\'' +
                ", social='" + social + '\'' +
                ", processing='" + processing + '\'' +
                ", decisionMaking='" + decisionMaking + '\'' +
                ", interaction='" + interaction + '\'' +
                '}';
    }
}
