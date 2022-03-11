package models;

import java.util.*;

public class Packages {

    private  Map<String, String> packageMap;

    public  HashMap<String, String> getPackageMap() {
        return (HashMap<String, String>) packageMap;
    }

    public Packages() {
        packageMap.put("You’re a soul-searching traveler.", "You travel not just to discover the world but to discover yourself and your place within it. Through each new experience, each new adventure, and each new fascinating personality you meet, you come to understand a little bit more about where you fit in the grand scheme of it all. What may seem like a series of disjointed adventures to others is actually a life-long journey that you’re taking inside of yourself—each new excursion teaches you a meaningful lesson and helps you construct a more holistic worldview.");
        packageMap.put("You’re an imaginative traveler.", "When you travel, you aren’t just seeing new lands or meeting new people. Rather, you’re telling yourself a story inside your mind—one that educates, inspires and revitalizes you, every step of the way. For you, travel isn’t about being in the moment; it’s about reflecting upon the moment and coming to understand what it has taught you. You enjoy dreaming up the adventures you’ll have (and reflecting upon what past adventures have taught you) even more than you enjoy actually going on them. You may internally embellish your experiences once they’re over, but why not? Some of the best moments in your life have taken place inside your mind.");
        packageMap.put("You’re a people-focused traveler.", "For you, the trip isn’t as much about the sights you see or the places you explore as it is about the people you meet (or take with you) along the way. There’s nothing you value more than forming quality memories with loved ones, and travel allots you the opportunity to do just that. You tend to look back on your trips and remember not the details of the places you visited, but the essence of the fascinating and invigorating people you met along the way, each of whom made you fall in love with your location that much more.");
        packageMap.put("You’re a slow and inquisitive traveler.", "You aren’t one for whirlwind vacations or sight-seeing trips, you want to travel slowly, meaningfully and inquisitively. You seek to learn what life is like in each new place you visit and to arrive at a profound understanding of how cultural and geographical context affects the human experience across the globe. For you, travel isn’t just a source of pleasure but a source of education. Unless you take the time to educate yourself thoroughly and meaningfully, your trip simply hasn’t served its purpose.");
    }

}
