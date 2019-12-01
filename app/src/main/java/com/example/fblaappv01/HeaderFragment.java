package com.example.fblaappv01;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HeaderFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //LayoutInflater inflater1 = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Inflater inflater1 = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View vi = inflater1.inflate(R.layout.nav_header, null);
        //View v = inflater.inflate(R.layout.fragment_team, container, false);
        View v = inflater.inflate(R.menu.drawer_menu, null);


        //getActivity().setTitle("Local Officer Team");


        return v;

    }


}