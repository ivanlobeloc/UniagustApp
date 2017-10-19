package com.tecnologias.uniagustapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

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
import com.tecnologias.uniagustapp.fragmentos.Fragment_Home;
import com.tecnologias.uniagustapp.fragmentos.Fragment_Preguntas;
import com.tecnologias.uniagustapp.models.ItemMenu;
import com.tecnologias.uniagustapp.models.MenuCategoria;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
    implements Fragment_Biblioteca.OnFragmentInteractionListener {

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

        //RecyclerView en el navigationDrawer
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        getCateg();
        mAdapter = new MenuAdapter(menuCategorias);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setAdapter(mAdapter);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {//Permite fijar una pantalla de inicio, en este caso Fragment_Home
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, new Fragment_Home()).commit();
        }

        mAdapter.setOnClickListener(new MenuAdapter.EventoOnItemClick() { // *


            //FragmentManager fragmentManager = getFragmentManager();
            //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            @Override // *
            public void onItemClick(int posicion) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                switch (posicion) {
                    case 1:
                        Toast.makeText(MainActivity.this, "Home "+posicion, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.replace(R.id.content_main, home).commit();
                        break;

                    case 2:
                        fragmentTransaction.replace(R.id.content_main, biblioteca).commit();
                        break;

                    case 3:
                        fragmentTransaction.replace(R.id.content_main, evu).commit();
                        break;

                    case 4:
                        fragmentTransaction.replace(R.id.content_main, directorio).commit();
                        break;

                    case 5:
                        fragmentTransaction.replace(R.id.content_main, preguntas).commit();
                        break;

                    case 7:
                        Toast.makeText(MainActivity.this, "Siga "+posicion, Toast.LENGTH_SHORT).show();
                        break;

                    case 8:
                        Toast.makeText(MainActivity.this, "Apoyo a la presencialidad "+posicion, Toast.LENGTH_SHORT).show();
                        break;

                    case 9:
                        Toast.makeText(MainActivity.this, "Virtualidad "+posicion, Toast.LENGTH_SHORT).show();
                        break;
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);//permite que se oculte el DrawerLayout una vez seleccionado un item del menu
            }
        });

    }

    public void getCateg() {

        menuCategorias = new ArrayList<>(2);

        List<ItemMenu> itemMenus1 = new ArrayList<>(5);
        itemMenus1.add(new ItemMenu("Home", R.mipmap.home)); // comentarié los demás submenus para ensayar solo con uno
        itemMenus1.add(new ItemMenu("Biblioteca", R.mipmap.biblioteca));
        itemMenus1.add(new ItemMenu("EduVirtual", R.mipmap.eduvirtual));
        itemMenus1.add(new ItemMenu("Directorio", R.mipmap.directorio));
        itemMenus1.add(new ItemMenu("Preguntas", R.mipmap.preguntasf));
        menuCategorias.add(new MenuCategoria("Portal", itemMenus1));

        List<ItemMenu> itemMenus2 = new ArrayList<>(3);
        itemMenus2.add(new ItemMenu("Siga",R.mipmap.siga));
        itemMenus2.add(new ItemMenu("Apoyo a la Presencialidad",R.mipmap.eduvirtual));
        itemMenus2.add(new ItemMenu("Virtualidad",R.mipmap.eduvirtual));
        menuCategorias.add(new MenuCategoria("Plataformas", itemMenus2));
        /*
        itemMenus = new ArrayList<>(7);
        itemMenus.add(new ItemMenu("Facebook"));
        itemMenus.add(new ItemMenu("Twitter"));
        itemMenus.add(new ItemMenu("Linkedin"));
        itemMenus.add(new ItemMenu("Flicker"));
        itemMenus.add(new ItemMenu("Youtube"));
        itemMenus.add(new ItemMenu("Google +"));
        itemMenus.add(new ItemMenu("Instagram"));
        menuCategorias.add(new MenuCategoria("Redes Sociales", itemMenus));
        */
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
