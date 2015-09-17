package me.rpairo.apolo.activities.search;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import me.rpairo.apolo.R;
import me.rpairo.apolo.adapters.peliculas.search.AdapterRecyclerPeliculasSearch;
import me.rpairo.apolo.models.Pelicula;
import me.rpairo.apolo.retrofit.api.peliculas.ApiAdapterPeliculas;
import me.rpairo.apolo.retrofit.api.peliculas.ApiConstantsPeliculas;
import me.rpairo.apolo.retrofit.responses.ResponsePelicula;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Raul on 15/9/15.
 */

public class SearchResults extends AppCompatActivity implements retrofit.Callback<ResponsePelicula> {

    //region Variables
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterRecyclerPeliculasSearch adapterRecyclerPeliculasSearch;
    private ArrayList<Pelicula> peliculas;
    private ProgressDialog proDialog;
    //endregion

    //region Funciones
    //region Funciones de la Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        this.peliculas = new ArrayList<Pelicula>();

        this.agregarToolbar();

        String busqueda = getIntent().getStringExtra("search");

        this.recycler = (RecyclerView) findViewById(R.id.recycler_search_results);

        //Creación del LayoutManager del RecyclerView
        this.layoutManager = new LinearLayoutManager(this);
        this.recycler.setLayoutManager(this.layoutManager);

        this.adapterRecyclerPeliculasSearch = new AdapterRecyclerPeliculasSearch(this.peliculas, this);
        this.recycler.setAdapter(this.adapterRecyclerPeliculasSearch);

        this.recycler.refreshDrawableState();

        this.request(busqueda);
    }
    //endregion

    //region Toolbar
    //region Funciones Toolbar auxiliares
    private void agregarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_search);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion
    //endregion

    //region Funciones de Retrofit
    //region Funciones auxiliares de Retrofit
    private void request(String titulo) {
        this.startLoading();
        ApiAdapterPeliculas.getApiServicePeliculas()
                .getPeliculaInfo(titulo, "es", ApiConstantsPeliculas.API_KEY, this);
    }
    //endregion

    //region Funciones del callback de Retrofit
    @Override
    public void success(ResponsePelicula responsePelicula, Response response) {
        this.stopLoading();
        this.peliculas = responsePelicula.getPeliculas();
        this.adapterRecyclerPeliculasSearch.addAll(this.peliculas);
    }

    @Override
    public void failure(RetrofitError error) {
        this.stopLoading();
        error.printStackTrace();
    }
    //endregion
    //endregion

    //region Funciones del Progress Dialog
    protected void startLoading() {

        proDialog = new ProgressDialog(this);
        proDialog.setMessage("Cargando...");
        proDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        proDialog.setCancelable(false);
        proDialog.show();
    }

    protected void stopLoading() {

        proDialog.dismiss();
        proDialog = null;
    }
    //endregion
    //endregion
}