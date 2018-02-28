package com.uniagustiniana.tecnologias.uniagustapp.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.uniagustiniana.tecnologias.uniagustapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_MyMap extends Fragment {


    public Fragment_MyMap() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment__my_map, container, false);

        WebView view=(WebView) v.findViewById(R.id.my_map);
        view.getSettings().setJavaScriptEnabled(true);

        view.loadUrl("file:///android_asset/mymap/my_map.html");

        return v;
    }

}
