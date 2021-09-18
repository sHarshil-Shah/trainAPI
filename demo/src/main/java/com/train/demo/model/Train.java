package com.train.demo.model;

import javax.persistence.*;

@Entity
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column
    private String Name;
    @Column(length = 10000)
    private String Description;
    @Column(name="distance_between_stop")
    private String distance;
    @Column(name="max_speed")
    private String Speed;
    @Column(name="sharing_tracks")
    private boolean sharingTrack;
    @Column(name="grade_crossing")
    private boolean GradeCrossing;
    @Column(name="train_frequency")
    private String Frequency;
    @Column
    private String amenities;


    public Train(long id, String name) {
        Id = id;
        Name = name;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

}

