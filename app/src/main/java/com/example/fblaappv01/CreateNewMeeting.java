package com.example.fblaappv01;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "meeting_table") //for sq lite library


public class CreateNewMeeting {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;

    private String date;

    public CreateNewMeeting(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
}
