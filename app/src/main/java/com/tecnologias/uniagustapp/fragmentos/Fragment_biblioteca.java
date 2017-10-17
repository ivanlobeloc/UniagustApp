package com.tecnologias.uniagustapp.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.tecnologias.uniagustapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_biblioteca extends Fragment {


    public Fragment_biblioteca() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_biblioteca, container, false);

        String url="http://uniagustiniana.edu.co/biblioteca-uniagustiniana";
        WebView view=(WebView) v.findViewById(R.id.wv_biblioteca);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);

        return v;
    }

}
