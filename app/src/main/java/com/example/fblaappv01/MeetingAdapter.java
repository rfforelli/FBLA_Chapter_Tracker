package com.example.fblaappv01;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MeetingAdapter extends ListAdapter<CreateNewMeeting, MeetingAdapter.MeetingHolder> {


    private OnitemClickListener listener;

    public MeetingAdapter() {

        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<CreateNewMeeting> DIFF_CALLBACK = new DiffUtil.ItemCallback<CreateNewMeeting>() {
        @Override
        public boolean areItemsTheSame(@NonNull CreateNewMeeting oldItem, @NonNull CreateNewMeeting newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull CreateNewMeeting oldItem, @NonNull CreateNewMeeting newItem) {
            return oldItem.getTitle().equals(newItem.getTitle()) && oldItem.getDescription().equals(newItem.getDescription()) && oldItem.getDate().equals(newItem.getDate()) && oldItem.getAttendence() == newItem.getAttendence();
        }
    };

    @NonNull
    @Override
    public MeetingHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.meeting_item, viewGroup, false);
        return new MeetingHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingHolder meetingHolder, int position) {

        CreateNewMeeting currentMeeting = getItem(position);
        meetingHolder.textViewTitle.setText(currentMeeting.getTitle());
        meetingHolder.textViewDescription.setText(currentMeeting.getDescription());
        meetingHolder.textViewDate.setText(currentMeeting.getDate());
        meetingHolder.textViewAttendence.setText(String.valueOf(currentMeeting.getAttendence()));

    }

    public CreateNewMeeting getMeetingAt(int position) {
        return getItem(position);


    }

    class MeetingHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewDate;
        private TextView textViewAttendence;


        public MeetingHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.tex_view_description);
            textViewDate = itemView.findViewById(R.id.tex_view_date);
            textViewAttendence = itemView.findViewById(R.id.text_view_attendence);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
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