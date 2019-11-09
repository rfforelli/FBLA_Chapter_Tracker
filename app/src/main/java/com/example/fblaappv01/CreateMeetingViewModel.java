package com.example.fblaappv01;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class CreateMeetingViewModel extends AndroidViewModel {
    private MeetingRepository repository;
    private LiveData<List<CreateNewMeeting>> allMeetings;

    public CreateMeetingViewModel(@NonNull Application application) {
        super(application);
        repository = new MeetingRepository(application);
        allMeetings = repository.getAllMeetings();
    }

    public void insert(CreateNewMeeting createNewMeeting){

        repository.insert(createNewMeeting);
    }

    public void update(CreateNewMeeting createNewMeeting) {
        repository.update(createNewMeeting);
    }

    public void delete(CreateNewMeeting createNewMeeting){
        repository.delete(createNewMeeting);
    }

    public void deleteAllMeetings() {
        repository.deleteAllMeetings();
    }

    public LiveData<List<CreateNewMeeting>> getAllMeetings() {
        return allMeetings;
    }
}
