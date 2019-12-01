package com.example.fblaappv01.Utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.fblaappv01.MainActivity;
import com.example.fblaappv01.MeetingsActivity;
import com.example.fblaappv01.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setUpBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {

        Log.d(TAG, "setUpBottomNavigationView: Setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(true); //Bottom nav bar setup
        bottomNavigationViewEx.enableItemShiftingMode(true);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(true);
        bottomNavigationViewEx.setIconSize(30, 30); //sets nav bar icon size
        bottomNavigationViewEx.setIconTintList(0, ColorStateList.valueOf(Color.GRAY));
        bottomNavigationViewEx.setIconTintList(1, ColorStateList.valueOf(Color.GRAY));

    }

    public static void enableNavigation(final Context context, final BottomNavigationViewEx view) {


        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.ic_fbla_bottom_nav_icon:
                        Intent intent1 = new Intent(context, MainActivity.class); //ACTIVITY_NUM = 0
                        context.startActivity(intent1); // When the FBLA icon is selected, start the actvitiy defined in intent 1

                        break;

                    case R.id.ic_icon_track_meetings:
                        Intent intent2 = new Intent(context, MeetingsActivity.class); //ACTIVITY_NUM = 1
                        context.startActivity(intent2);// When the FBLA icon is selected, start the actvitiy defined in intent 2
                        break;
                }

                return false;
            }
        });
    }
}
