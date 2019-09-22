package com.example.fblaappv01;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // to tell our app that we want to use our toolbar as our actionbar, because we removed the default actionbar
        Toolbar toolbar = findViewById(R.id.toolbar); //creates a toolbar variable that is linked to the toolbar we created
        setSupportActionBar(toolbar); //sets our toobar as our actionbar

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nagivation_drawer_open, R.string.nagivation_drawer_close);
        //creating a new actionbardrawertoggle named toggle, with the context as "this", passing the variable "drawer" and "toolbar" becuase these are the two vairbales that will be connected and synchronized
        //then we pass the two string resources we created
        drawer.addDrawerListener(toggle); //then we take our drawer variable and call a drawer listener and pass this toggle variable
        toggle.syncState(); //then we call syncstate to take care of rotating our hamburger icon to get rid of the drawer itself


    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) { //if our drawer variable is open
            drawer.closeDrawer(GravityCompat.START); //then close it
        } else { //otherwise
            super.onBackPressed(); //close the activity as usual
        }
    }
}
