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
public class Fragment_Pre_Inscripcion extends Fragment {


    public Fragment_Pre_Inscripcion() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pre_inscripcion, container, false);

        //String url="http://siga.uniagustiniana.edu.co///paquetes/admision/preinscripciondeadmision/index_publico.php?accion=Nuevo";
        String url="https://siga.uniagustiniana.edu.co/paquetes/modulo_preinscripcion/app.php/preinscripcion";
        WebView view=(WebView) v.findViewById(R.id.wv_preinscripcion);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);

        return v;
    }
}
