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
public class Fragment_Facebook extends Fragment {

    private WebView iWebView;


    public Fragment_Facebook() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_facebook, container, false);

        iWebView = (WebView) v.findViewById(R.id.wv_facebook);
        iWebView.loadUrl("http://www.facebook.com/uniagustiniana?ref=hl/");
        // Enable Javascript
        WebSettings webSettings = iWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Force links and redirects to open in the WebView instead of in a browser
        iWebView.setWebViewClient(new WebViewClient());

        return v;
    }

}
