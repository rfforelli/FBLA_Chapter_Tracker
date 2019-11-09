package com.example.fblaappv01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddMeetingActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE =
            "com.example.fblaappv01.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "com.example.fblaappv01.EXTRA_DESCRIPTION";
    public static final String EXTRA_DATE =
            "com.example.fblaappv01.EXTRA_DATE";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private EditText editTextDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);


        //ActionBar actionBar = getActionBar();
        //getActionBar().show();

        //setTitle("My new title");
        //getActionBar().setIcon(R.drawable.ic_add_black_24dp);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();



        //getActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        //getSupportActionBar().setTitle(Html.fromHtml("<font color='"+white+"'>"+"Home"+"</font>"));
        //Html.fromHtml("<![CDATA[<font color='#FFFFFF'>text</font>]]>");
        //getSupportActionBar().setTitle(Html.fromHtml("<font color=\"colorwhite\">" + "Add Note" + "</font>"));
        //int orange = getResources().getColor(R.color.colorWhite);
        //String htmlColor = String.format(Locale.US, "#%06X", (0xFFFFFF & Color.argb(0, Color.red(orange), Color.green(orange), Color.blue(orange))));




        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        editTextDate = findViewById(R.id.edit_text_date);


        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);

        //toolbar.setNavigationIcon(R.drawable.ic_close_black_24dp);

        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_close_black_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();

                }
            });
        }



        setTitle("Log New Chapter Meeting");



        //ActionBar actionBar = getActionBar();

        // show the action bar title
        //actionBar.setDisplayShowTitleEnabled(true);

        //getActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);


        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        //getActionBar().setTitle("Add Note");

        //((AppCompatActivity)getApplicationContext()).getSupportActionBar().setSubtitle(R.drawable.ic_close_black_24dp);

        // getActionBar()
        //setTitle("Add Note");
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        //getActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);

    }
    private void saveMeeting() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String date = editTextDate.getText().toString();

        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_DATE, date);

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_meeting_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_meeting:
                saveMeeting();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}