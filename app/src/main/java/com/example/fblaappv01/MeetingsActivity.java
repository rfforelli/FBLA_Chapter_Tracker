package com.example.fblaappv01;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.fblaappv01.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

public class MeetingsActivity extends AppCompatActivity {
    public static final int ADD_MEETING_REQUEST = 1;
    public static final int EDIT_MEETING_REQUEST = 2;

    private static final String TAG = "MainActivity"; //for organizing logs
    private static final int ACTIVITY_NUM = 0;

    private CreateMeetingViewModel createMeetingViewModel;

    private Context mContext = MeetingsActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0); //disables animation when transitioning from activity to activity
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
                Intent intent = new Intent(MeetingsActivity.this, AddEditMeetingActivity.class); // GET APPLICATION CONTEXT IDK ANYMOOOOORE, nvm, I'm now able to change to meetingsactivity
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
                adapter.submitList(createNewMeetings);


            }
        });


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) { //Enables swiping right OR left to delete a note, can delete one if want only one
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {

                return false;
            }


            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                createMeetingViewModel.delete(adapter.getMeetingAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MeetingsActivity.this, "Meeting Log Deleted", Toast.LENGTH_SHORT).show();

            }


        })

                .attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new MeetingAdapter.OnitemClickListener() {
            @Override
            public void onItemClick(CreateNewMeeting createNewMeeting) {
                Intent intent = new Intent(MeetingsActivity.this, AddEditMeetingActivity.class);
                intent.putExtra(AddEditMeetingActivity.EXTRA_ID, createNewMeeting.getId());
                intent.putExtra(AddEditMeetingActivity.EXTRA_TITLE, createNewMeeting.getTitle());
                intent.putExtra(AddEditMeetingActivity.EXTRA_DESCRIPTION, createNewMeeting.getDescription());
                intent.putExtra(AddEditMeetingActivity.EXTRA_DATE, createNewMeeting.getDate());
                intent.putExtra(AddEditMeetingActivity.EXTRA_ATTENDENCE, createNewMeeting.getAttendence());
                startActivityForResult(intent, EDIT_MEETING_REQUEST);


            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_MEETING_REQUEST && resultCode == RESULT_OK) {
            String title = data.getStringExtra(AddEditMeetingActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddEditMeetingActivity.EXTRA_DESCRIPTION);
            String date = data.getStringExtra(AddEditMeetingActivity.EXTRA_DATE);
            int attendence = data.getIntExtra(AddEditMeetingActivity.EXTRA_ATTENDENCE, 1);

            CreateNewMeeting createNewMeeting = new CreateNewMeeting(title, description, date, attendence);
            createMeetingViewModel.insert(createNewMeeting);

            Toast toast = Toast.makeText(MeetingsActivity.this, "Meeting Logged", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 200);
            toast.show();

        } else if (requestCode == EDIT_MEETING_REQUEST && resultCode == RESULT_OK) {
            int id = data.getIntExtra(AddEditMeetingActivity.EXTRA_ID, -1);

            if (id == -1) {
                Toast toast = Toast.makeText(MeetingsActivity.this, "Meeting Log Can't Be Updated", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 200);
                toast.show();
                return;
            }

            Toast toast = Toast.makeText(MeetingsActivity.this, "Meeting Log Updated", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 200);
            toast.show();

            String title = data.getStringExtra(AddEditMeetingActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddEditMeetingActivity.EXTRA_DESCRIPTION);
            String date = data.getStringExtra(AddEditMeetingActivity.EXTRA_DATE);
            int attendence = data.getIntExtra(AddEditMeetingActivity.EXTRA_ATTENDENCE, 1);

            CreateNewMeeting createNewMeeting = new CreateNewMeeting(title, description, date, attendence);
            createNewMeeting.setId(id);
            createMeetingViewModel.update(createNewMeeting);


        } else {
            Toast toast = Toast.makeText(MeetingsActivity.this, "Meeting Log Not Updated", Toast.LENGTH_SHORT);
            //toast.setGravity(Gravity.BOTTOM, 0, 200);
            //toast.show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.meetings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all_logs:
                createMeetingViewModel.deleteAllMeetings();
                Toast.makeText(this, "All Logs Deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView"); //log, for debugging
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationViewEx);

        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);


        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }


}