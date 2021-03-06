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
public class Fragment_GooglePlus extends Fragment {

    //private WebView iWebView;
    private static ConnectivityManager manager;

    public Fragment_GooglePlus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_googleplus, container, false);

        /*
        iWebView = (WebView) v.findViewById(R.id.wv_googlep);
        iWebView.loadUrl("http://bit.ly/2jenzri");
        // Enable Javascript
        WebSettings webSettings = iWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Force links and redirects to open in the WebView instead of in a browser
        iWebView.setWebViewClient(new WebViewClient());
        */
        WebView view=(WebView) v.findViewById(R.id.wv_googlep);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new WebViewClient());// Agregamos un WebViewCliente, esto permite que se sigan ejecutando los links dentro de este WebView
        //view.loadUrl(url);
        /****************************************/
        if (isOnline(getActivity())) {
            String url="http://bit.ly/2jenzri";
            view.loadUrl(url);
            //Toast.makeText(getActivity(),"SI hay conexión!",Toast.LENGTH_SHORT).show();
        } else {
            view.loadUrl("file:///android_asset/html/pagina_error.html");
            Toast.makeText(getActivity(),"NO hay conexión!",Toast.LENGTH_SHORT).show();
        }
        /****************************************/

        return  v;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

}
