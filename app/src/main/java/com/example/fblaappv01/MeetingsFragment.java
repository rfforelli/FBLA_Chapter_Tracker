package com.example.fblaappv01;

/*import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class MeetingsFragment extends Fragment {

    public static final int ADD_MEETING_REQUEST = 1;

    private CreateMeetingViewModel createMeetingViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Chapter Meetings");
        //getActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        View view;
        view = inflater.inflate( R.layout.fragment_meetings, container, false);

        FloatingActionButton buttonAddMeeting = view.findViewById(R.id.button_add_meeting);
        buttonAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddMeetingActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        final MeetingAdapter adapter = new MeetingAdapter();
        recyclerView.setAdapter(adapter);


        createMeetingViewModel = ViewModelProviders.of(this).get(CreateMeetingViewModel.class);
        createMeetingViewModel.getAllMeetings().observe(this, new Observer<List<CreateNewMeeting>>() {
            @Override
            public void onChanged(@Nullable List<CreateNewMeeting> createNewMeetings) {
                adapter.setCreateNewMeetings(createNewMeetings);
                //updates the recycler view (meetings list)
                //Toast.makeText(getContext(), "onChanged", Toast.LENGTH_LONG).show();
                // ;
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_MEETING_REQUEST && resultCode == RESULT_OK){
            String title = data.getStringExtra(AddMeetingActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddMeetingActivity.EXTRA_DESCRIPTION);
            String date = data.getStringExtra(AddMeetingActivity.EXTRA_DATE);

            CreateNewMeeting createNewMeeting = new CreateNewMeeting(title, description, date);
            createMeetingViewModel.insert(createNewMeeting);
            Toast.makeText(getContext(), "Note Saved", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getContext(), "Note not saved", Toast.LENGTH_SHORT).show();
        }
    }
}
*/