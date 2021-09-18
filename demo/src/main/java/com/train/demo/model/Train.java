package com.train.demo.model;

import javax.persistence.*;

@Entity
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column
    private String Name;
    private String Description;
    @Column
    private String Distance;
    @Column
    private String Speed;
    @Column
    private boolean sharingTrack;
    @Column
    private boolean GradeCrossing;
    @Column
    private String Frequency;
    @Column
    private String Aminities;


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

