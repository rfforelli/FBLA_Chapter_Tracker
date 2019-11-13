package com.example.fblaappv01;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MeetingsDao {

    @Insert
    void insert(CreateNewMeeting createNewMeeting);

    @Update
    void update(CreateNewMeeting createNewMeeting);

    @Delete
    void delete(CreateNewMeeting createNewMeeting);

    @Query("DELETE FROM meeting_table")
    void deleteAllMeetings();

    @Query("SELECT * FROM meeting_table ORDER BY attendence DESC")
    LiveData<List<CreateNewMeeting>> getAllMeetings();

}
