package com.tecnologias.uniagustapp.fragmentos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.tecnologias.uniagustapp.Activity_JuegoMemoria;
import com.tecnologias.uniagustapp.Activity_JuegoSudoku;
import com.tecnologias.uniagustapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Juegos extends Fragment {

    public Fragment_Juegos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_juegos, container, false);

        ImageButton imgBtn01 = (ImageButton)v.findViewById(R.id.imgBtn01);
        ImageButton imgBtn02 = (ImageButton)v.findViewById(R.id.imgBtn02);
        ImageButton imgBtn03 = (ImageButton)v.findViewById(R.id.imgBtn03);

        imgBtn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Activity_JuegoMemoria.class);
                startActivity(i);
            }
        });

        imgBtn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Activity_JuegoSudoku.class);
                startActivity(i);
            }
        });

        imgBtn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(getContext(), Activity_JuegoAjedrez.class);
                //startActivity(i);
                Toast.makeText(getActivity(),"Este juego aun no está disponible",Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

}
