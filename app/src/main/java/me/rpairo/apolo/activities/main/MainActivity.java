package me.rpairo.apolo.activities.main;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import me.rpairo.apolo.R;
import me.rpairo.apolo.activities.search.SearchResults;
import me.rpairo.apolo.fragments.github.FragmentoGitHub;
import me.rpairo.apolo.fragments.musica.FragmentoMusica;
import me.rpairo.apolo.fragments.peliculas.FragmentoPeliculas;
import me.rpairo.apolo.fragments.series.FragmentoSeries;

/**
 * Created by Raul on 5/9/15.
 */

public class MainActivity extends AppCompatActivity {

    //region Variables
    private DrawerLayout drawerLayout;
    public final static String LOG = "apolo";
    private SearchView searchView;
    //endregion

    //region Funciones
    //region Funciones de la Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.agregarToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null) {
            this.prepararDrawer(navigationView);

            //establecimiento del layout por defecto como el primero del menu
            seleccionarItem(navigationView.getMenu().getItem(0));
        }
    }
    //endregion

    //region NavigationView
    private void prepararDrawer(NavigationView navigationView) {

        ImageView imageView = (ImageView) findViewById(R.id.logo_navigation);

        Glide.with(this.getApplicationContext())
                .load(R.drawable.ic_launcher)
                .into(imageView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                seleccionarItem(menuItem);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void seleccionarItem(MenuItem itemDrawer) {
        Fragment fragmentoGenerico = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (itemDrawer.getItemId()) {
            case R.id.item_peliculas:
                fragmentoGenerico = new FragmentoPeliculas();
                break;
            case R.id.item_series:
                fragmentoGenerico = new FragmentoSeries();
                break;
            case R.id.item_musica:
                fragmentoGenerico = new FragmentoMusica();
                break;
            case R.id.item_github:
                fragmentoGenerico = new FragmentoGitHub();
                break;
        }

        if (fragmentoGenerico != null)
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor_principal, fragmentoGenerico)
                    .commit();

        this.setTitle(itemDrawer.getTitle());
    }
    //endregion

    //region Toolbar
    //region Funciones auxiliares
    private void agregarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();

        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }
    //endregion

    //region Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);

        MenuItem searchItem = menu.findItem(R.id.search);

        SearchManager searchManager = (SearchManager) MainActivity.this.getSystemService(Context.SEARCH_SERVICE);

        if (searchItem != null)
            searchView = (SearchView) searchItem.getActionView();

        if (searchItem != null)
            searchView.setSearchableInfo(searchManager.getSearchableInfo(MainActivity.this.getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                //searchView.setQuery("", false);
                searchView.onActionViewCollapsed();

                startActivity(new Intent(getApplicationContext(), SearchResults.class).putExtra("search", query));
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                this.drawerLayout.openDrawer(GravityCompat.START);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    //endregion
    //endregion
    //endregion
}