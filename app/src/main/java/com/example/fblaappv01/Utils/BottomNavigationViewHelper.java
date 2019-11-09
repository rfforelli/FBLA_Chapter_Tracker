package com.example.fblaappv01.Utils;

import android.content.Context;
import android.content.Intent;
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

    public static void setUpBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setUpBottomNavigationView: Setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(true);
        bottomNavigationViewEx.enableItemShiftingMode(true);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);

    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){

        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {



                switch (menuItem.getItemId()){
                    case R.id.ic_fbla_bottom_nav_icon:
                        Intent intent1 = new Intent(context, MainActivity.class); //ACTIVITY_NUM = 0
                        context.startActivity(intent1);
                        break;

                    case R.id.ic_icon_track_meetings:
                        Intent intent2 = new Intent(context, MeetingsActivity.class); //ACTIVITY_NUM = 1
                        context.startActivity(intent2);
                        break;
                }

                return false;
            }
        });
    }
}
