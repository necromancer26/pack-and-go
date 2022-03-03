package com.company.models;

public class SocialStyle {
    private final String socialId;
    private final String socialName;
    private final String socialDetails;

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
