package com.tecnologias.uniagustapp.fragmentos;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
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
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        final Fragment noticias = new Fragment_Noticias();
        final Fragment calendario = new Fragment_Calendario();
        final Fragment pqrs = new Fragment_PQRS();
        final Fragment preinscrip = new Fragment_Pre_Inscripcion();
        final Fragment rutas = new Fragment_Rutas();

        BottomNavigationView navigation = (BottomNavigationView) v.findViewById(R.id.navigation);
        navigation.setItemIconTintList(null);//Los iconos del menu Bottom toman su color original
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);

                if (item.getItemId() == R.id.noticias) {
                    fragmentTransaction.replace(R.id.content_main, noticias).commit();
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Noticias");//Agrega titulo a ActionBar
                } else if (item.getItemId() == R.id.rutas) {
                    fragmentTransaction.replace(R.id.content_main, rutas).commit();
                } else if (item.getItemId() == R.id.cal_aca) {
                    fragmentTransaction.replace(R.id.content_main, calendario).commit();
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Calendario Académico");//Agrega titulo a ActionBar
                } else if (item.getItemId() == R.id.pqrs) {
                    fragmentTransaction.replace(R.id.content_main, pqrs).commit();
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Servicio al Cliente");//Agrega titulo a ActionBar
                } else if (item.getItemId() == R.id.preinscripcion) {
                    fragmentTransaction.replace(R.id.content_main, preinscrip).commit();
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Diligenciar Formulario");//Agrega titulo a ActionBar
                }
                return true;
            }
        });

        return v;
    }

    private FragmentManager getSupportFragmentManager() {
        return getFragmentManager();
    }

}
