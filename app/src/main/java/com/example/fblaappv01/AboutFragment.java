package com.example.fblaappv01;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AboutFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("About FBLA");
        //getActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        return inflater.inflate(R.layout.fragment_about, container, false); //write this to inflate our fragment layout
    }
}
