package com.tecnologias.uniagustapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class Activity_youtube extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Muestra contenido en el navegador
        //Uri uri = Uri.parse("https://www.youtube.com/user/Uniagustiniana");
        Uri uri = Uri.parse("http://bit.ly/29Z8XG8");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        finish();
    }
}
