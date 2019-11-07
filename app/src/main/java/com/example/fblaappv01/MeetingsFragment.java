package com.example.fblaappv01;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MeetingsFragment extends Fragment {

    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Chapter Meetings");

        createExampleList();



        View view;
        view = inflater.inflate( R.layout.fragment_meetings, container, false);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mAdapter = new ExampleAdapter(mExampleList);


        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);



//        FloatingActionButton floatingActionButton = view.findViewById(R.id.add_meeting_Btn);
//        floatingActionButton.setOnClickListener(new View

        //return null;

        FloatingActionButton floatingActionButton = view.findViewById(R.id.add_meeting_Btn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr =  getFragmentManager().beginTransaction();

                fr.replace(R.id.fragment_container, new CreateMeetingEntry());
                fr.commit();
            }
        });

        return view;
    }

    public void createExampleList(){
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.ic_list_meeting3, "Discussion", "9/28/19"));
        mExampleList.add(new ExampleItem(R.drawable.ic_list_meeting3, "Discussion", "9/28/19"));
        mExampleList.add(new ExampleItem(R.drawable.ic_list_meeting3, "Discussion", "9/28/19"));
        mExampleList.add(new ExampleItem(R.drawable.ic_list_meeting3, "Discussion", "9/28/19"));

    }

    }


