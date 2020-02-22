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
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddEditMeetingActivity extends AppCompatActivity {

    public static final String EXTRA_ID =
            "com.example.fblaappv01.EXTRA_ID";
    public static final String EXTRA_TITLE =
            "com.example.fblaappv01.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "com.example.fblaappv01.EXTRA_DESCRIPTION";
    public static final String EXTRA_DATE =
            "com.example.fblaappv01.EXTRA_DATE";
    public static final String EXTRA_ATTENDENCE =
            "com.example.fblaappv01.EXTRA_ATTENDENCE";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private EditText editTextDate;
    private NumberPicker numberPickerAttendence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();


        Intent intent = getIntent();


        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        editTextDate = findViewById(R.id.edit_text_date);
        numberPickerAttendence = findViewById(R.id.number_picker_attendence);


        numberPickerAttendence.setMinValue(1);
        numberPickerAttendence.setMaxValue(100);


        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Meeting Log");
            editTextTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            editTextDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            editTextDate.setText(intent.getStringExtra(EXTRA_DATE));
            numberPickerAttendence.setValue(intent.getIntExtra(EXTRA_ATTENDENCE, 1));
        } else {
            setTitle("Log New Chapter Meeting");
        }
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

    }

    private void saveMeeting() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String date = editTextDate.getText().toString();
        int attendence = numberPickerAttendence.getValue();

        if (title.trim().isEmpty() || date.trim().isEmpty()) {
            Toast.makeText(this, "Please insert meeting type and date", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_DATE, date);
        data.putExtra(EXTRA_ATTENDENCE, attendence);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

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