package com.example.fblaappv01;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

public class CalenderFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Calender");
        ConnectivityManager connMgr = (ConnectivityManager) getActivity()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            View v = inflater.inflate(R.layout.fragment_news, container, false); //write this to inflate our fragment layout
            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            //Button refreshBtn = (Button) v.findViewById(R.id.refreshBtn);
            imageView.setVisibility(View.INVISIBLE);
            //refreshBtn.setVisibility(View.INVISIBLE);
            WebView webView = (WebView) v.findViewById(R.id.webView);
            webView.getSettings().setJavaScriptEnabled(true); //enables javascript
            webView.setWebViewClient((new WebViewClient())); //creates a new WebViewCLient in order to allow the link to open in the app
            webView.loadUrl("https://calendar.google.com/calendar/r"); //Loads the url in the quotation marks
            return v;
        } else {
            Toast.makeText(getActivity(),"Oops! You must be connected to the internet to get the latest FBLA news!",Toast.LENGTH_LONG).show();
            View v = inflater.inflate(R.layout.fragment_news, container, true); //write this to inflate our fragment layout
            //Button refreshBtn = (Button) v.findViewById(R.id.refreshBtn);
            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            //refreshBtn.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.VISIBLE);
            return null;

        }
    }
}
