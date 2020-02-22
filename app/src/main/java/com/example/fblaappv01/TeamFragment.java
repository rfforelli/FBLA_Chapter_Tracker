package com.example.fblaappv01;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TeamFragment extends Fragment {

    //private TextView testTextView;
    private TextView presTextView;
    private TextView vicePresTextView;
    private TextView secTextView;
    private TextView tresTextView;
    //private EditText testEditText;
    private EditText presEditText;
    private EditText vicePresEditText;
    private EditText secEditText;
    private EditText tresEditText;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_team, container, false);


        getActivity().setTitle("Local Officer Team");


        Button button = (Button) v.findViewById(R.id.recordBtn);

        presEditText = v.findViewById(R.id.presEditText);
        vicePresEditText = v.findViewById(R.id.vicePresEditText);
        secEditText = v.findViewById(R.id.secEditText);
        tresEditText = v.findViewById(R.id.tresEditText);


        pref = this.getActivity().getSharedPreferences("my_pref",
                Context.MODE_PRIVATE);
        editor = pref.edit();

        presTextView = (TextView) v.findViewById(R.id.presSetTextView);
        vicePresTextView = (TextView) v.findViewById(R.id.vicePresSetTextView);
        secTextView = (TextView) v.findViewById(R.id.secSetTextView);
        tresTextView = (TextView) v.findViewById(R.id.tresSetTextView);

        final EditText presEditText = (EditText) v.findViewById(R.id.presEditText);
        final EditText vicePresEditText = (EditText) v.findViewById(R.id.vicePresEditText);
        final EditText secEditText = (EditText) v.findViewById(R.id.secEditText);
        final EditText tresEditText = (EditText) v.findViewById(R.id.tresEditText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presTextView.setText(presEditText.getText().toString());
                vicePresTextView.setText(vicePresEditText.getText().toString());
                secTextView.setText(secEditText.getText().toString());
                tresTextView.setText(tresEditText.getText().toString());
                editor.putString("val4", presEditText.getText().toString());
                editor.putString("val5", vicePresEditText.getText().toString());
                editor.putString("val6", secEditText.getText().toString());
                editor.putString("val7", tresEditText.getText().toString());
                editor.apply();

            }
        });

        return v;

    }

    @Override
    public void onStart() {
        super.onStart();
        String val4 = this.getActivity().getSharedPreferences("my_pref",
                Context.MODE_PRIVATE).getString("val4", " ");
        String val5 = this.getActivity().getSharedPreferences("my_pref",
                Context.MODE_PRIVATE).getString("val5", " ");
        String val6 = this.getActivity().getSharedPreferences("my_pref",
                Context.MODE_PRIVATE).getString("val6", " ");
        String val7 = this.getActivity().getSharedPreferences("my_pref",
                Context.MODE_PRIVATE).getString("val7", " ");

        if (!val4.equals(" ")) {
            presTextView.setText(val4);
            presEditText.setText(val4);
            vicePresTextView.setText(val5);
            vicePresEditText.setText(val5);
            secTextView.setText(val6);
            secEditText.setText(val6);
            tresTextView.setText(val7);
            tresEditText.setText(val7);
        }

    }

}