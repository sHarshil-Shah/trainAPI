package com.train.demo.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Scanner;

@Entity
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    @Column(length = 10000)
    private String description;
    @Column(name="distance_between_stop")
    private String distance;
    @Column(name="max_speed")
    private String speed;
    @Column(name="sharing_tracks")
    private boolean sharingTrack;
    @Column(name="grade_crossing")
    private boolean gradeCrossing;
    @Column(name="train_frequency")
    private String frequency;
    @Column
    private String amenities;

    private String errorMsg;

    public static HashMap<String, String> hasMapColumn = new HashMap<>();

    public Train(long id, String name, String description, String distance, String speed, boolean sharingTrack, boolean gradeCrossing, String frequency, String amenities) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.distance = distance;
        this.speed = speed;
        this.sharingTrack = sharingTrack;
        this.gradeCrossing = gradeCrossing;
        this.frequency = frequency;
        this.amenities = amenities;
    }

    public Train() {
        hasMapColumn.put("max-speed", "speed");
        hasMapColumn.put("id", "id");
        hasMapColumn.put("name", "name");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getSpeed() {
        return new Scanner(speed).useDelimiter("\\D+").nextInt(); //get firs speed from whole string
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public boolean isSharingTrack() {
        return sharingTrack;
    }

    public void setSharingTrack(boolean sharingTrack) {
        this.sharingTrack = sharingTrack;
    }

    public boolean isGradeCrossing() {
        return gradeCrossing;
    }

    public void setGradeCrossing(boolean gradeCrossing) {
        this.gradeCrossing = gradeCrossing;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
}

