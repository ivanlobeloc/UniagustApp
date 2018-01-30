package com.uniagustiniana.tecnologias.uniagustapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

//import com.uniagustiniana.tecnologias.R;
import com.uniagustiniana.tecnologias.uniagustapp.fragmentos.Fragment_Biblioteca;
import com.uniagustiniana.tecnologias.uniagustapp.fragmentos.Fragment_Directorio;
import com.uniagustiniana.tecnologias.uniagustapp.fragmentos.Fragment_EVU;
import com.uniagustiniana.tecnologias.uniagustapp.fragmentos.Fragment_Facebook;
import com.uniagustiniana.tecnologias.uniagustapp.fragmentos.Fragment_Flickr;
import com.uniagustiniana.tecnologias.uniagustapp.fragmentos.Fragment_GooglePlus;
import com.uniagustiniana.tecnologias.uniagustapp.fragmentos.Fragment_Home;
import com.uniagustiniana.tecnologias.uniagustapp.fragmentos.Fragment_Juegos;
import com.uniagustiniana.tecnologias.uniagustapp.fragmentos.Fragment_PortalHome;
import com.uniagustiniana.tecnologias.uniagustapp.fragmentos.Fragment_Instagram;
import com.uniagustiniana.tecnologias.uniagustapp.fragmentos.Fragment_LinkedIn;
import com.uniagustiniana.tecnologias.uniagustapp.fragmentos.Fragment_Preguntas;
import com.uniagustiniana.tecnologias.uniagustapp.fragmentos.Fragment_Twitter;
import com.uniagustiniana.tecnologias.uniagustapp.objects.ElementoMenu;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
    implements Fragment_Biblioteca.OnFragmentInteractionListener, Fragment_Directorio.OnFragmentInteractionListener, Fragment_PortalHome.OnFragmentInteractionListener,
        Fragment_Preguntas.OnFragmentInteractionListener, Fragment_EVU.OnFragmentInteractionListener {

    //ExpandableListView para el menú
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<ElementoMenu>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Instancias de cada uno de los fragmentos que se van a cargar en el content main
        final Fragment home = new Fragment_Home();
        final Fragment p_home = new Fragment_PortalHome();
        final Fragment biblioteca = new Fragment_Biblioteca();
        final Fragment evu = new Fragment_EVU();
        final Fragment directorio = new Fragment_Directorio();
        final Fragment preguntas = new Fragment_Preguntas();
        //Plataformas

        //Redes Sociales
        final Fragment twitter = new Fragment_Twitter();
        final Fragment facebook = new Fragment_Facebook();
        final Fragment flickr = new Fragment_Flickr();
        final Fragment googlep = new Fragment_GooglePlus();
        final Fragment instagram = new Fragment_Instagram();
        final Fragment linkedin = new Fragment_LinkedIn();
        final Fragment juegos = new Fragment_Juegos();

        //ExpandableListView para el menú
        listView = (ExpandableListView)findViewById(R.id.ex_lits_menu);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader,listHash);
        listView.setAdapter(listAdapter);//*

        //ListView para el Directorio

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {//Permite fijar una pantalla de inicio, en este caso Fragment_PortalHome
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, new Fragment_Home()).commit();
            fragmentManager.popBackStack();
        }

        //listener
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String posicion;
                posicion = listHash.get(listDataHeader.get(groupPosition)).get(childPosition).getTitulo();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                switch(posicion) {
                    case "Home":
                        fragmentTransaction.replace(R.id.content_main, home).addToBackStack(null).commit();
                        getSupportActionBar().setTitle("Uniagustiniana App");//Agrega titulo a ActionBar
                        break;

                    case "Portal Home":
                        fragmentTransaction.remove(home);
                        fragmentTransaction.replace(R.id.content_main, p_home).addToBackStack(null).commit();
                        getSupportActionBar().setTitle("Portal Home");//Agrega titulo a ActionBar
                        break;

                    case "Biblioteca":
                        fragmentTransaction.replace(R.id.content_main, biblioteca).addToBackStack(null).commit();
                        getSupportActionBar().setTitle("Biblioteca");//Agrega titulo a ActionBar
                        break;

                    case "EduVirtual":
                        fragmentTransaction.replace(R.id.content_main, evu).addToBackStack(null).commit();
                        getSupportActionBar().setTitle("EVU Home");//Agrega titulo a ActionBar
                        break;

                    case "Directorio":
                        fragmentTransaction.replace(R.id.content_main, directorio).addToBackStack(null).commit();
                        getSupportActionBar().setTitle("Directorio");//Agrega titulo a ActionBar
                        break;

                    case "Preguntas":
                        fragmentTransaction.replace(R.id.content_main, preguntas).addToBackStack(null).commit();
                        getSupportActionBar().setTitle("PQRS");//Agrega titulo a ActionBar
                        break;

                    case "Siga":
                        Intent i1 = new Intent(MainActivity.this, Activity_SIGA.class);
                        startActivity(i1);
                        break;

                    case "Apoyo a la Presencialidad":
                        Intent i2 = new Intent(MainActivity.this, Activity_VirtualApoyo.class);
                        startActivity(i2);
                        break;

                    case "Programas Virtuales":
                        Intent i3 = new Intent(MainActivity.this, Activity_Virtualidad.class);
                        startActivity(i3);
                        break;

                    case "Youtube":
                        //fragmentTransaction.replace(R.id.content_main, youtube).addToBackStack(null).commit();
                        //getSupportActionBar().setTitle("Youtube");//Agrega titulo a ActionBar

                        Intent i4 = new Intent(MainActivity.this, Activity_youtube.class);
                        startActivity(i4);

                        break;

                    case "Twitter":
                        fragmentTransaction.replace(R.id.content_main, twitter).addToBackStack(null).commit();
                        getSupportActionBar().setTitle("Twitter");//Agrega titulo a ActionBar
                        break;

                    case "Facebook":
                        fragmentTransaction.replace(R.id.content_main, facebook).addToBackStack(null).commit();
                        getSupportActionBar().setTitle("Facebook");//Agrega titulo a ActionBar
                        break;

                    case "Flicker":
                        fragmentTransaction.replace(R.id.content_main, flickr).addToBackStack(null).commit();
                        getSupportActionBar().setTitle("Flicker");//Agrega titulo a ActionBar
                        break;

                    case "Google +":
                        fragmentTransaction.replace(R.id.content_main, googlep).addToBackStack(null).commit();
                        getSupportActionBar().setTitle("Google +");//Agrega titulo a ActionBar
                        break;

                    case "Instagram":
                        fragmentTransaction.replace(R.id.content_main, instagram).addToBackStack(null).commit();
                        getSupportActionBar().setTitle("Instagram");//Agrega titulo a ActionBar
                        break;

                    case "LinkedIn":
                        fragmentTransaction.replace(R.id.content_main, linkedin).addToBackStack(null).commit();
                        getSupportActionBar().setTitle("LinkedIn");//Agrega titulo a ActionBar
                        break;

                    case "Tour 360":
                        Intent i5 = new Intent(MainActivity.this, Activity_Tour360.class);
                        startActivity(i5);
                        break;

                    case "Juegos":
                        fragmentTransaction.replace(R.id.content_main, juegos).addToBackStack(null).commit();
                        getSupportActionBar().setTitle("Juegos");//Agrega titulo a ActionBar
                        //Intent i4 = new Intent(MainActivity.this, Activity_JuegoMemoria.class);
                        //startActivity(i4);
                        break;
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);//permite que se oculte el DrawerLayout una vez seleccionado un item del menu

                return false;
            }
        });
    }

    //Initialize ListView
    private void initData() {

        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Portal");
        listDataHeader.add("Plataformas");
        listDataHeader.add("Redes Sociales");
        listDataHeader.add("Entretenimiento");

        List<ElementoMenu> itemMenus1 = new ArrayList<>();

        ElementoMenu elemento = new ElementoMenu("Home", R.mipmap.home);
        itemMenus1.add(elemento);

        elemento = new ElementoMenu("Portal Home", R.mipmap.portal);
        itemMenus1.add(elemento);

        elemento = new ElementoMenu("Biblioteca", R.mipmap.biblioteca);
        itemMenus1.add(elemento);
        elemento = new ElementoMenu("EduVirtual", R.mipmap.eduvirtual);
        itemMenus1.add(elemento);
        elemento = new ElementoMenu("Directorio", R.mipmap.directorio);
        itemMenus1.add(elemento);
        elemento = new ElementoMenu("Preguntas", R.mipmap.preguntasf);
        itemMenus1.add(elemento);

        List<ElementoMenu> itemMenus2 = new ArrayList<>();
        elemento = new ElementoMenu("Siga", R.mipmap.siga);
        itemMenus2.add(elemento);
        elemento = new ElementoMenu("Apoyo a la Presencialidad", R.mipmap.eduvirtual);
        itemMenus2.add(elemento);
        elemento = new ElementoMenu("Programas Virtuales", R.mipmap.eduvirtual);
        itemMenus2.add(elemento);

        List<ElementoMenu> itemMenus3 = new ArrayList<>();
        elemento = new ElementoMenu("Youtube", R.mipmap.youtube);
        itemMenus3.add(elemento);
        elemento = new ElementoMenu("Twitter", R.mipmap.twitter);
        itemMenus3.add(elemento);
        elemento = new ElementoMenu("Facebook", R.mipmap.facebook);
        itemMenus3.add(elemento);
        elemento = new ElementoMenu("Flicker", R.mipmap.flickr);
        itemMenus3.add(elemento);
        elemento = new ElementoMenu("Google +", R.mipmap.googlep);
        itemMenus3.add(elemento);
        elemento = new ElementoMenu("Instagram", R.mipmap.instagram);
        itemMenus3.add(elemento);
        elemento = new ElementoMenu("LinkedIn", R.mipmap.linkedin);
        itemMenus3.add(elemento);

        List<ElementoMenu> itemMenus4 = new ArrayList<>();
        elemento = new ElementoMenu("Tour 360", R.mipmap.tour);
        itemMenus4.add(elemento);
        elemento = new ElementoMenu("Juegos", R.mipmap.eduvirtual);
        itemMenus4.add(elemento);

        listHash.put(listDataHeader.get(0),itemMenus1);
        listHash.put(listDataHeader.get(1),itemMenus2);
        listHash.put(listDataHeader.get(2),itemMenus3);
        listHash.put(listDataHeader.get(3),itemMenus4);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
