package com.example.fblaappv01;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class EventsFragment extends Fragment {

    WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_events, container, false);


        getActivity().setTitle("Competitive Events");


        webView = (WebView) v.findViewById(R.id.webView);


        WebSettings webSetting = webView.getSettings();
        webSetting.setJavaScriptEnabled(true);


        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/fbla_competitive_events.html");
        return v;
    }

    private class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }


}