package com.uniagustiniana.tecnologias.uniagustapp.fragmentos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.uniagustiniana.tecnologias.uniagustapp.CustomSwipeAadapter;

import com.uniagustiniana.tecnologias.uniagustapp.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Home extends Fragment {

    //ViewPager
    ViewPager viewPager;
    CustomSwipeAadapter adapter;

    public Fragment_Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        //ViewPager
        View viewPagerView = v.findViewById(R.id.view_pager);// resuelto con pregunta: https://es.stackoverflow.com/q/118826/34903
        if (viewPagerView != null ) {
            viewPager = (ViewPager)viewPagerView;
            adapter = new CustomSwipeAadapter(getContext());
            viewPager.setAdapter(adapter);

            Timer timer = new Timer();
            timer.schedule(new MyTimerTask(), 3000, 4000);
        }

        //Instancias para los botones del menú
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
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Rutas");//Agrega titulo a ActionBar
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

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

           if(getActivity() != null) {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                        //viewPager.setCurrentItem(1, true);
                    }else if(viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                        //viewPager.setCurrentItem(2, true);
                    }else if(viewPager.getCurrentItem()==2){
                        viewPager.setCurrentItem(0);
                        //viewPager.setCurrentItem(0, true);
                    }
                }
            });

           }
        }
    }

    private FragmentManager getSupportFragmentManager() {
        return getFragmentManager();
    }
}
