package com.tecnologias.uniagustapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Activity_Virtualidad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtualidad);

        WebView view=(WebView) this.findViewById(R.id.wv_virtualidad);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new WebViewClient());//
        view.loadUrl("http://eduvirtual.uniagustiniana.edu.co/login/index.php");

    }
}