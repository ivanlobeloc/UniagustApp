package com.tecnologias.uniagustapp;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.tecnologias.uniagustapp.adapters.MenuAdapter;
import com.tecnologias.uniagustapp.fragmentos.Fragment_Biblioteca;
import com.tecnologias.uniagustapp.fragmentos.Fragment_Directorio;
import com.tecnologias.uniagustapp.fragmentos.Fragment_EVU;
import com.tecnologias.uniagustapp.fragmentos.Fragment_Facebook;
import com.tecnologias.uniagustapp.fragmentos.Fragment_Flickr;
import com.tecnologias.uniagustapp.fragmentos.Fragment_GooglePlus;
import com.tecnologias.uniagustapp.fragmentos.Fragment_Home;
import com.tecnologias.uniagustapp.fragmentos.Fragment_Instagram;
import com.tecnologias.uniagustapp.fragmentos.Fragment_LinkedIn;
import com.tecnologias.uniagustapp.fragmentos.Fragment_Preguntas;
import com.tecnologias.uniagustapp.fragmentos.Fragment_Twitter;
import com.tecnologias.uniagustapp.fragmentos.Fragment_Youtube;
import com.tecnologias.uniagustapp.models.ItemMenu;
import com.tecnologias.uniagustapp.models.MenuCategoria;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
    implements Fragment_Biblioteca.OnFragmentInteractionListener, Fragment_Directorio.OnFragmentInteractionListener, Fragment_Home.OnFragmentInteractionListener,
        Fragment_Preguntas.OnFragmentInteractionListener, Fragment_EVU.OnFragmentInteractionListener {

    //variables recyclerview
    private RecyclerView mRecyclerView;
    private MenuAdapter mAdapter;
    private List<MenuCategoria> menuCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Instancias de cada uno de los fragmentos que se van a cargar en el content main
        final Fragment home = new Fragment_Home();
        final Fragment biblioteca = new Fragment_Biblioteca();
        final Fragment evu = new Fragment_EVU();
        final Fragment directorio = new Fragment_Directorio();
        final Fragment preguntas = new Fragment_Preguntas();
        //Redes Sociales
        final Fragment youtube = new Fragment_Youtube();
        final Fragment twitter = new Fragment_Twitter();
        final Fragment facebook = new Fragment_Facebook();
        final Fragment flickr = new Fragment_Flickr();
        final Fragment googlep = new Fragment_GooglePlus();
        final Fragment instagram = new Fragment_Instagram();
        final Fragment linkedin = new Fragment_LinkedIn();

        //RecyclerView en el navigationDrawer
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        getCateg();
        mAdapter = new MenuAdapter(menuCategorias);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setAdapter(mAdapter);//*

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {//Permite fijar una pantalla de inicio, en este caso Fragment_Home
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, new Fragment_Home()).commit();
        }

        mAdapter.setOnClickListener(new MenuAdapter.EventoOnItemClick() { // *

            @Override // *
            public void onItemClick(int posicion) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                switch (posicion) {
                    case 1:
                        Toast.makeText(MainActivity.this, "Home "+posicion, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.content_main, home).commit();
                        break;

                    case 2:
                        Toast.makeText(MainActivity.this, "Biblioteca "+posicion, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.content_main, biblioteca).commit();
                        break;

                    case 3:
                        Toast.makeText(MainActivity.this, "EVU "+posicion, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.content_main, evu).commit();
                        break;

                    case 4:
                        Toast.makeText(MainActivity.this, "Directorio "+posicion, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.content_main, directorio).commit();
                        break;

                    case 5:
                        Toast.makeText(MainActivity.this, "Preguntas "+posicion, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.content_main, preguntas).commit();
                        break;

                    case 7:
                        Toast.makeText(MainActivity.this, "Siga PENDIENTE "+posicion, Toast.LENGTH_SHORT).show();
                        break;

                    case 8:
                        Toast.makeText(MainActivity.this, "Apoyo a la presencialidad "+posicion, Toast.LENGTH_SHORT).show();
                        Intent i1 = new Intent(MainActivity.this, Activity_VirtualApoyo.class);
                        startActivity(i1);
                        break;

                    case 9:
                        Toast.makeText(MainActivity.this, "Virtualidad "+posicion, Toast.LENGTH_SHORT).show();
                        Intent i2 = new Intent(MainActivity.this, Activity_Virtualidad.class);
                        startActivity(i2);
                        break;

                    //REDES SOCIALES

                    case 12:
                        Toast.makeText(MainActivity.this, "Youtube "+posicion, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.content_main, youtube).commit();
                        break;

                    case 13:
                        Toast.makeText(MainActivity.this, "Twitter "+posicion, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.content_main, twitter).commit();
                        break;

                    case 14:
                        Toast.makeText(MainActivity.this, "Facebook "+posicion, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.content_main, facebook).commit();
                        break;

                    case 15:
                        Toast.makeText(MainActivity.this, "Flickr "+posicion, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.content_main, flickr).commit();
                        break;

                    case 16:
                        Toast.makeText(MainActivity.this, "Google + "+posicion, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.content_main, googlep).commit();
                        break;

                    case 17:
                        Toast.makeText(MainActivity.this, "Instagram "+posicion, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.content_main, instagram).commit();
                        break;

                    case 18:
                        Toast.makeText(MainActivity.this, "LinkedIn "+posicion, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.content_main, linkedin).commit();
                        break;

                }//*
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);//permite que se oculte el DrawerLayout una vez seleccionado un item del menu
            }
        });
    }

    public void getCateg() {

        menuCategorias = new ArrayList<>();

        List<ItemMenu> itemMenus1 = new ArrayList<>();
        itemMenus1.add(new ItemMenu("Home", R.mipmap.home)); // comentarié los demás submenus para ensayar solo con uno
        itemMenus1.add(new ItemMenu("Biblioteca", R.mipmap.biblioteca));
        itemMenus1.add(new ItemMenu("EduVirtual", R.mipmap.eduvirtual));
        itemMenus1.add(new ItemMenu("Directorio", R.mipmap.directorio));
        itemMenus1.add(new ItemMenu("Preguntas", R.mipmap.preguntasf));
        menuCategorias.add(new MenuCategoria("Portal", itemMenus1));

        List<ItemMenu> itemMenus2 = new ArrayList<>();
        itemMenus2.add(new ItemMenu("Siga",R.mipmap.siga));
        itemMenus2.add(new ItemMenu("Siga",R.mipmap.siga));
        itemMenus2.add(new ItemMenu("Apoyo a la Presencialidad",R.mipmap.eduvirtual));
        itemMenus2.add(new ItemMenu("Virtualidad",R.mipmap.eduvirtual));
        menuCategorias.add(new MenuCategoria("Plataformas", itemMenus2));

        List<ItemMenu> itemMenus3 = new ArrayList<>();
        itemMenus3.add(new ItemMenu("Youtube",R.mipmap.youtube));
        itemMenus3.add(new ItemMenu("Twitter",R.mipmap.twitter));
        itemMenus3.add(new ItemMenu("Facebook",R.mipmap.facebook));
        itemMenus3.add(new ItemMenu("Flicker",R.mipmap.flickr));
        itemMenus3.add(new ItemMenu("Google +",R.mipmap.googlep));
        itemMenus3.add(new ItemMenu("Instagram",R.mipmap.instagram));
        itemMenus3.add(new ItemMenu("LinkedIn",R.mipmap.linkedin));
        menuCategorias.add(new MenuCategoria("Redes Sociales", itemMenus3));

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
