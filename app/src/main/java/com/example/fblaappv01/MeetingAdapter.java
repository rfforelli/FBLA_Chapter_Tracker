package com.example.fblaappv01;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetingHolder> {

    private List<CreateNewMeeting> createNewMeetings = new ArrayList<>();

    private OnitemClickListener listener;

    @NonNull
    @Override
    public MeetingHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.meeting_item, viewGroup, false);
        return new MeetingHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingHolder meetingHolder, int i) {

        CreateNewMeeting currentMeeting = createNewMeetings.get(i);
        meetingHolder.textViewTitle.setText(currentMeeting.getTitle());
        meetingHolder.textViewDescription.setText(currentMeeting.getDescription());
        meetingHolder.textViewDate.setText(currentMeeting.getDate());

    }

    @Override
    public int getItemCount() {
        return createNewMeetings.size();
    }

    public void setCreateNewMeetings(List<CreateNewMeeting> createNewMeetings) {
        this.createNewMeetings = createNewMeetings;
        notifyDataSetChanged();
    }

    public CreateNewMeeting getMeetingAt(int position) {
        return createNewMeetings.get(position);


    }

    class MeetingHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewDate;


        public MeetingHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.tex_view_description);
            textViewDate = itemView.findViewById(R.id.tex_view_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(createNewMeetings.get(position));
                    }
                }
            });


        }


    }

    public interface OnitemClickListener {
        void onItemClick(CreateNewMeeting createNewMeeting); //for editing notes
    }

    public void setOnItemClickListener(OnitemClickListener listener) {
        this.listener = listener;

    }

}
