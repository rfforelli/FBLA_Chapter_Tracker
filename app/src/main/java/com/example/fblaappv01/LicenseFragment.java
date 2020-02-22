package com.example.fblaappv01;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;

public class LicenseFragment extends Fragment {
    PDFView pdfView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_license, container, false);

        getActivity().setTitle("Chapter Tracker License");

        pdfView = (PDFView) v.findViewById(R.id.pdfView);
        pdfView.fromAsset("mit_license.pdf").load();

        return v;
    }


}