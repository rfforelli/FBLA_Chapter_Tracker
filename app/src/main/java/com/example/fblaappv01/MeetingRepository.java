package com.example.fblaappv01;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class MeetingRepository {

    private MeetingsDao meetingsDao;
    private LiveData<List<CreateNewMeeting>> allMeetings;

    public MeetingRepository(Application application){
        MeetingDatabase database = MeetingDatabase.getInstance(application);
        meetingsDao = database.meetingsDao();
        allMeetings = meetingsDao.getAllMeetings();
    }

    public void insert(CreateNewMeeting createNewMeeting){

        new InsertMeetingAsyncTask(meetingsDao).execute(createNewMeeting);

    }

    public void update(CreateNewMeeting createNewMeeting){

        new UpdateMeetingAsyncTask(meetingsDao).execute(createNewMeeting);

    }
    public void delete(CreateNewMeeting createNewMeeting){

        new DeleteMeetingAsyncTask(meetingsDao).execute(createNewMeeting);

    }
    public void deleteAllMeetings(){
        new DeleteAllMeetingsAsyncTask(meetingsDao).execute();

    }

    public LiveData<List<CreateNewMeeting>> getAllMeetings() {
        return allMeetings;
    }

    private static class InsertMeetingAsyncTask extends AsyncTask<CreateNewMeeting, Void, Void> {
        private MeetingsDao meetingsDao;

        private InsertMeetingAsyncTask(MeetingsDao meetingsDao){

            this.meetingsDao = meetingsDao;
        }

        @Override
        protected Void doInBackground(CreateNewMeeting... createNewMeetings) {

            meetingsDao.insert(createNewMeetings[0]);
            return null;
        }
    }

    private static class UpdateMeetingAsyncTask extends AsyncTask<CreateNewMeeting, Void, Void> {
        private MeetingsDao meetingsDao;

        private UpdateMeetingAsyncTask(MeetingsDao meetingsDao){

            this.meetingsDao = meetingsDao;
        }

        @Override
        protected Void doInBackground(CreateNewMeeting... createNewMeetings) {

            meetingsDao.update(createNewMeetings[0]);
            return null;
        }
    }

    private static class DeleteMeetingAsyncTask extends AsyncTask<CreateNewMeeting, Void, Void> {
        private MeetingsDao meetingsDao;

        private DeleteMeetingAsyncTask(MeetingsDao meetingsDao){

            this.meetingsDao = meetingsDao;
        }

        @Override
        protected Void doInBackground(CreateNewMeeting... createNewMeetings) {

            meetingsDao.delete(createNewMeetings[0]);
            return null;
        }
    }

    private static class DeleteAllMeetingsAsyncTask extends AsyncTask<Void, Void, Void> {
        private MeetingsDao meetingsDao;

        private DeleteAllMeetingsAsyncTask(MeetingsDao meetingsDao){

            this.meetingsDao = meetingsDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            meetingsDao.deleteAllMeetings();
            return null;
        }
    }
}
