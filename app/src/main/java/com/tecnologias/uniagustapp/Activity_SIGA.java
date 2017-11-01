package com.tecnologias.uniagustapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity_SIGA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PackageManager manager = this.getPackageManager();
        String name= "com.datasae.siga";
        try{
            Intent intent = manager.getLaunchIntentForPackage(name);
            if(intent != null){
                try {
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    finish();
                }
            }else{
                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.datasae.siga&hl=es");
                Intent i = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
                finish();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
