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

public class SignUpFragment extends Fragment {
    private WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        getActivity().setTitle("Competitive Event Sign-Up");
        ConnectivityManager connMgr = (ConnectivityManager) getActivity()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()/* && mWebView == null*/) {
            View v = inflater.inflate(R.layout.fragment_signup, container, false);
            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            imageView.setVisibility(View.INVISIBLE);
            WebView webView = (WebView) v.findViewById(R.id.webView);
            webView.getSettings().setJavaScriptEnabled(true); //enables javascript
            webView.restoreState(savedInstanceState);
            webView.setWebViewClient((new WebViewClient())); //creates a new WebViewCLient in order to allow the link to open in the app
            webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSd2BIuBXTVOKDo1tO6RD0251KyuKDQlTLZYcGyca-RzAeW_KQ/viewform?usp=sf_link"); //Loads the url in the quotation marks
            return v;
        } else {
            Toast.makeText(getActivity(), "Oops! You must be connected to the internet to access the competitive event sign-up form!", Toast.LENGTH_LONG).show();
            View v = inflater.inflate(R.layout.fragment_signup, container, true);
            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            imageView.setVisibility(View.VISIBLE);

            return null;

        }


    }


}