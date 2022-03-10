package models;

public class ProcessingStyle {
    public void setProcessingId(String processingId) {
        this.processingId = processingId;
    }

    public void setProcessingName(String processingName) {
        this.processingName = processingName;
    }

    public void setProcessingDetails(String processingDetails) {
        this.processingDetails = processingDetails;
    }

    private  String processingId;
    private  String processingName;
    private  String processingDetails;

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

    @Override
    public String toString() {
        return "ProcessingStyle{" +
                "processingId='" + processingId + '\'' +
                ", processingName='" + processingName + '\'' +
                ", processingDetails='" + processingDetails + '\'' +
                '}';
    }

    public String getProcessingDetails() {
        return processingDetails;
    }
}
