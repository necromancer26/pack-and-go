package com.company.models;

public class SocialStyle {
    private  String socialId;
    private  String socialName;

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public void setSocialDetails(String socialDetails) {
        this.socialDetails = socialDetails;
    }

    private  String socialDetails;

    @Override
    public String toString() {
        return "SocialStyle{" +
                "socialId='" + socialId + '\'' +
                ", socialName='" + socialName + '\'' +
                ", socialDetails='" + socialDetails + '\'' +
                '}';
    }

    public SocialStyle(String socialId, String socialName, String socialDetails) {
        this.socialId = socialId;
        this.socialName = socialName;
        this.socialDetails = socialDetails;
    }

    public String getSocialId() {
        return socialId;
    }

    public String getSocialName() {
        return socialName;
    }

    public String getSocialDetails() {
        return socialDetails;
    }
}
