package com.tecnologias.uniagustapp.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tecnologias.uniagustapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Preguntas extends Fragment {


    public Fragment_Preguntas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_preguntas, container, false);

        String url="http://www.uniagustiniana.edu.co/servicio-al-cliente-uniagustiniana/preguntas-frecuentes";
        WebView view=(WebView) v.findViewById(R.id.wv_preguntas);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new WebViewClient());// Agregamos un WebViewCliente, esto permite que se sigan ejecutando los links dentro de este WebView
        view.loadUrl(url);

        return  v;
    }

    public interface OnFragmentInteractionListener {
    }
}
