package com.uniagustiniana.tecnologias.uniagustapp.fragmentos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.uniagustiniana.tecnologias.uniagustapp.Activity_Tour360;
import com.uniagustiniana.tecnologias.uniagustapp.Activity_Tour360Suba;
import com.uniagustiniana.tecnologias.uniagustapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Roundme extends Fragment {


    public Fragment_Roundme() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_roundme, container, false);

        ImageButton imgBtn01 = (ImageButton)v.findViewById(R.id.imgBtn01);
        ImageButton imgBtn02 = (ImageButton)v.findViewById(R.id.imgBtn02);

        imgBtn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Activity_Tour360.class);
                startActivity(i);
            }
        });

        imgBtn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getContext(), Activity_Tour360Suba.class);
                startActivity(i2);
            }
        });

        return v;
    }

}
