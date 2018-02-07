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
import com.uniagustiniana.tecnologias.uniagustapp.utils.Connectivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Eventos extends Fragment {

    private static ConnectivityManager manager;

    public Fragment_Eventos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_eventos, container, false);

        String url="http://uniagustiniana.edu.co/eventos/";
        WebView view=(WebView) v.findViewById(R.id.wv_eventos);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new WebViewClient());// Agregamos un WebViewCliente, esto permite que se sigan ejecutando los links dentro de este WebView
        if (Connectivity.isOnline(getActivity())) {
            view.loadUrl(url);
            //Toast.makeText(getActivity(),"SI hay conexión!",Toast.LENGTH_SHORT).show();
        } else {
            //view.loadUrl("file:///android_asset/html/pagina_error.html");
            Toast.makeText(getActivity(),"NO hay conexión!",Toast.LENGTH_SHORT).show();
        }

        return v;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    public interface OnFragmentInteractionListener {
    }
}
