package com.example.fblaappv01;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {CreateNewMeeting.class}, version = 1)

public abstract class MeetingDatabase extends RoomDatabase {

    private static MeetingDatabase instance;

    public abstract MeetingsDao meetingsDao();

    public static synchronized MeetingDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), MeetingDatabase.class, "meeting_database").fallbackToDestructiveMigration()
                    .addCallback(roomCallback).build(); //increments database version number, for each new entry
        }
        return instance; //return already existing instance if the instance is not null (no changes have been made)
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private MeetingsDao meetingsDao;

        private PopulateDbAsyncTask(MeetingDatabase db){
            meetingsDao = db.meetingsDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            meetingsDao.insert(new CreateNewMeeting("Title 1", "Description", "11/7/19"));
            meetingsDao.insert(new CreateNewMeeting("Title 2", "Description1", "11/8/19"));
            meetingsDao.insert(new CreateNewMeeting("Title 3", "Description2", "11/9/19"));

            return null;
        }
    }
}
