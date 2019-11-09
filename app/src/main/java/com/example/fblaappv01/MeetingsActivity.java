package com.example.fblaappv01;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.example.fblaappv01.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

public class MeetingsActivity extends AppCompatActivity {
    public static final int ADD_MEETING_REQUEST = 1;

    private static final String TAG = "MainActivity"; //for organizing logs
    private static final int ACTIVITY_NUM = 0;

    private CreateMeetingViewModel createMeetingViewModel;

    private Context mContext = MeetingsActivity.this;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0,0); //disables animation when transitioning from activity to activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_meetings);
        Log.d(TAG, "onCreate: starting."); //tags it, lets developer know what activity im in
        //setTitle("Add Note");


        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        setTitle("Chapter Meetings");






        //getActionBar().setHomeButtonEnabled(true);
        //getActionBar().setDisplayHomeAsUpEnabled(true);



        setupBottomNavigationView();


        FloatingActionButton buttonAddMeeting = findViewById(R.id.button_add_meeting);
        buttonAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MeetingsActivity.this, AddMeetingActivity.class); // GET APPLICATION CONTEXT IDK ANYMOOOOORE, nvm, I'm now able to change to meetingsactivity
                startActivityForResult(intent, ADD_MEETING_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        final MeetingAdapter adapter = new MeetingAdapter();
        recyclerView.setAdapter(adapter);

        createMeetingViewModel = ViewModelProviders.of(this).get(CreateMeetingViewModel.class);
        createMeetingViewModel.getAllMeetings().observe(this, new Observer<List<CreateNewMeeting>>() {
            @Override
            public void onChanged(@Nullable List<CreateNewMeeting> createNewMeetings) {
                adapter.setCreateNewMeetings(createNewMeetings);




            }
        });

        /*@Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == ADD_MEETING_REQUEST && resultCode == RESULT_OK) {
                String title = data.getStringExtra(AddMeetingActivity.EXTRA_TITLE);
                String description = data.getStringExtra(AddMeetingActivity.EXTRA_DESCRIPTION);
                String date = data.getStringExtra(AddMeetingActivity.EXTRA_DATE);

                CreateNewMeeting createNewMeeting = new CreateNewMeeting(title, description, date);
                createMeetingViewModel.insert(createNewMeeting);

                Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Note not saved", Toast.LENGTH_SHORT).show();
            }
        }*/

        //setTitle("Log New Chapter Meeting");










    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_MEETING_REQUEST && resultCode == RESULT_OK) {
            String title = data.getStringExtra(AddMeetingActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddMeetingActivity.EXTRA_DESCRIPTION);
            String date = data.getStringExtra(AddMeetingActivity.EXTRA_DATE);

            CreateNewMeeting createNewMeeting = new CreateNewMeeting(title, description, date);
            createMeetingViewModel.insert(createNewMeeting);

            Toast.makeText(this, "Meeting Logged", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Meeting Not Saved", Toast.LENGTH_SHORT).show();
        }
    }




    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView"); //so in the log we know the code has made it this far and wont crash
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationViewEx); //references helper so i dont have to update the nav view settings in each activities

        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);



        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }


}
