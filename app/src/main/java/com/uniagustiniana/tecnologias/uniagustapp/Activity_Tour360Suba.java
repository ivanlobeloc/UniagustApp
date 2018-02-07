package com.uniagustiniana.tecnologias.uniagustapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class Activity_Tour360Suba extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Muestra contenido en el navegador
        Uri uri = Uri.parse("https://roundme.com/tour/188384/view/490120/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        finish();
    }
}
