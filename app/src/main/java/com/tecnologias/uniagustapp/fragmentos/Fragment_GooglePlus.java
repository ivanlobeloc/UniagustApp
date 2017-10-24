package com.tecnologias.uniagustapp.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tecnologias.uniagustapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_GooglePlus extends Fragment {

    private WebView iWebView;


    public Fragment_GooglePlus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_googleplus, container, false);

        iWebView = (WebView) v.findViewById(R.id.wv_googlep);
        iWebView.loadUrl("http://bit.ly/2jenzri");
        // Enable Javascript
        WebSettings webSettings = iWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Force links and redirects to open in the WebView instead of in a browser
        iWebView.setWebViewClient(new WebViewClient());

        return  v;
    }

}
