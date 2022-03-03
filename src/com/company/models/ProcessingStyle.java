package com.company.models;

public class ProcessingStyle {
    private final String processingId;
    private final String processingName;
    private final String processingDetails;

    public ProcessingStyle(String processingId, String processingName, String processingDetails) {
        this.processingId = processingId;
        this.processingName = processingName;
        this.processingDetails = processingDetails;
    }

    public String getProcessingId() {
        return processingId;
    }

    public String getProcessingName() {
        return processingName;
    }

    public String getProcessingDetails() {
        return processingDetails;
    }
}
