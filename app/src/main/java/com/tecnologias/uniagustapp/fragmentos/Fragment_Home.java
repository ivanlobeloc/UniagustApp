package com.tecnologias.uniagustapp.fragmentos;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tecnologias.uniagustapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Home extends Fragment {

    public Fragment_Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment__home, container, false);

        final Fragment noticias = new Fragment_Noticias();
        /*
        final Fragment calendario = new Calendario();
        final Fragment ubicacion = new Map_Fragment();
        final Fragment pqrs = new PQRS();
        final Fragment preinscrip = new PreInscripcion();
        */

        BottomNavigationView navigation = (BottomNavigationView) v.findViewById(R.id.navigation);
        navigation.setItemIconTintList(null);//Los iconos del menu Bottom toman su color original
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (item.getItemId() == R.id.noticias) {
                    fragmentTransaction.replace(R.id.content_main, noticias).commit();
                } else if (item.getItemId() == R.id.rutas) {

                } else if (item.getItemId() == R.id.cal_aca) {

                } else if (item.getItemId() == R.id.pqrs) {

                } else if (item.getItemId() == R.id.preinscripcion) {

                }
                return true;
            }
        });//*

        return v;
    }

    private FragmentManager getSupportFragmentManager() {
        return getFragmentManager();
    }

}
