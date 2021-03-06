package com.uniagustiniana.tecnologias.uniagustapp.fragmentos;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.uniagustiniana.tecnologias.uniagustapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_PQRS extends Fragment {

    private static ConnectivityManager manager;

    public Fragment_PQRS() {
        // Required empty public constructor
    }

    //wv_pqrs
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_pqrs, container, false);

        WebView view=(WebView) v.findViewById(R.id.wv_pqrs);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new WebViewClient());// Agregamos un WebViewCliente, esto permite que se sigan ejecutando los links dentro de este WebView
        //view.loadUrl(url);
        /****************************************/
        if (isOnline(getActivity())) {
            String url="http://www.uniagustiniana.edu.co/servicio-al-cliente-uniagustiniana";
            view.loadUrl(url);
            //Toast.makeText(getActivity(),"SI hay conexión!",Toast.LENGTH_SHORT).show();
        } else {
            view.loadUrl("file:///android_asset/html/pagina_error.html");
            Toast.makeText(getActivity(),"NO hay conexión!",Toast.LENGTH_SHORT).show();
        }
        /****************************************/

        return v;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

}
