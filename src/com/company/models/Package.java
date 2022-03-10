package com.company.models;

public class Package {
    private int packageId;
    private String packageName;
    private String personalityId;
    private int hotelId;
    private int restaurantId;
    private int activityId;
    private int price;

    @Override
    public String toString() {
        return "Package{" +
                "packageId=" + packageId +
                ", packageName='" + packageName + '\'' +
                ", personalityId='" + personalityId + '\'' +
                ", hotelId=" + hotelId +
                ", restaurantId=" + restaurantId +
                ", activityId=" + activityId +
                ", price=" + price +
                '}';
    }

    public Package(String packageName, String personalityId, int hotelId, int restaurantId, int activityId, int price) {
        this.packageName = packageName;
        this.personalityId = personalityId;
        this.hotelId = hotelId;
        this.restaurantId = restaurantId;
        this.activityId = activityId;
        this.price = price;
    }

    public Package(int packageId, String packageName, String personalityId, int hotelId, int restaurantId, int activityId, int price) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.personalityId = personalityId;
        this.hotelId = hotelId;
        this.restaurantId = restaurantId;
        this.activityId = activityId;
        this.price = price;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setPersonalityId(String personalityId) {
        this.personalityId = personalityId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getPersonalityId() {
        return personalityId;
    }

    public int getPrice() {
        return price;
    }

    public int getHotelId() {
        return hotelId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public int getActivityId() {
        return activityId;
    }
}
