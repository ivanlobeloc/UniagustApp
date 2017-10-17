package com.tecnologias.uniagustapp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.tecnologias.uniagustapp.adapters.MenuAdapter;
import com.tecnologias.uniagustapp.models.ItemMenu;
import com.tecnologias.uniagustapp.models.MenuCategoria;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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

    }

    public void getCateg() {

        menuCategorias = new ArrayList<>(1);

        List<ItemMenu> itemMenus = new ArrayList<>(5);
        itemMenus.add(new ItemMenu("Home",R.mipmap.home)); // comentarié los demás submenus para ensayar solo con uno
        itemMenus.add(new ItemMenu("Biblioteca",R.mipmap.biblioteca));
        itemMenus.add(new ItemMenu("EduVirtual",R.mipmap.eduvirtual));
        itemMenus.add(new ItemMenu("Directorio",R.mipmap.directorio));
        itemMenus.add(new ItemMenu("Preguntas",R.mipmap.preguntasf));
        menuCategorias.add(new MenuCategoria("Portal", itemMenus));
/*
        itemMenus = new ArrayList<>(2);
        itemMenus.add(new ItemMenu("Siga"));
        itemMenus.add(new ItemMenu("Apoyo a la Presencialidad"));
        itemMenus.add(new ItemMenu("Virtualidad"));
        menuCategorias.add(new MenuCategoria("Plataformas", itemMenus));

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
