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
public class Fragment_Pre_Inscripcion extends Fragment {


    public Fragment_Pre_Inscripcion() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pre_inscripcion, container, false);

        //http://siga.uniagustiniana.edu.co///paquetes/admision/preinscripciondeadmision/index_publico.php?accion=Nuevo
        //https://siga.uniagustiniana.edu.co/paquetes/modulo_preinscripcion/app.php/preinscripcion
        //https://docs.google.com/forms/d/e/1FAIpQLScqbZNAd2XPRtnNsTobVMLI29NOtk2x7_T59B38TYgMP5fciA/viewform?c=0&w=1
        //String url="https://docs.google.com/forms/d/e/1FAIpQLScqbZNAd2XPRtnNsTobVMLI29NOtk2x7_T59B38TYgMP5fciA/viewform?c=0&w=1";
        String url="https://docs.google.com/forms/d/e/1FAIpQLSczcsQy2uyRVkr-Ry-97ePB8qQL7mVCFkETUxHfJaZgDkqgig/viewform";
        WebView view=(WebView) v.findViewById(R.id.wv_preinscripcion);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);

        return v;
    }
}
