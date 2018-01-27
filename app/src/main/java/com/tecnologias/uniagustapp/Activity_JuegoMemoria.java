package com.tecnologias.uniagustapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;


public class Activity_JuegoMemoria extends AppCompatActivity {
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_memoria);

        wv=(WebView)this.findViewById(R.id.wv_juego01);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebChromeClient(new WebChromeClient());
        wv.loadUrl("file:///android_asset/memorygame/index.html");
    }
}