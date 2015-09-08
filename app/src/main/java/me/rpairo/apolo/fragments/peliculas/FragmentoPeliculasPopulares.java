package me.rpairo.apolo.fragments.peliculas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import me.rpairo.apolo.R;
import me.rpairo.apolo.adapters.peliculas.AdapterRecyclerPeliculas;
import me.rpairo.apolo.models.Pelicula;
import me.rpairo.apolo.retrofit.api.peliculas.ApiAdapterPeliculas;
import me.rpairo.apolo.retrofit.api.peliculas.ApiConstantsPeliculas;
import me.rpairo.apolo.retrofit.responses.ResponsePelicula;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Raul on 7/9/15.
 */

public class FragmentoPeliculasPopulares extends Fragment implements retrofit.Callback<ResponsePelicula>{

    //region Variables
    private RecyclerView recycler;
    private LayoutManager layoutManager;
    private AdapterRecyclerPeliculas adapterRecyclerPeliculas;
    private ArrayList<Pelicula> peliculas;
    //endregion

    //region Funciones
    //region Constructores
    public FragmentoPeliculasPopulares() {

    }
    //endregion

    //region Funciones del Fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.peliculas = new ArrayList<Pelicula>();
        return inflater.inflate(R.layout.fragment_peliculas_populares, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Obtención del RecyclerView
        this.recycler = (RecyclerView) view.findViewById(R.id.recycler_peliculas_populares);

        //Creación del LayoutManager del RecyclerView
        this.layoutManager = new GridLayoutManager(view.getContext(), 2);
        this.recycler.setLayoutManager(this.layoutManager);

        this.adapterRecyclerPeliculas = new AdapterRecyclerPeliculas(this.peliculas, view.getContext());
        this.recycler.setAdapter(this.adapterRecyclerPeliculas);

        this.recycler.refreshDrawableState();

        this.request();
    }
    //endregion

    //region Funciones de Retrofit
    //region Funciones auxiliares de Retrofit
    private void request() {
        ApiAdapterPeliculas.getApiServicePeliculas()
                .getPeliculasPopulares("es", ApiConstantsPeliculas.API_KEY, this);
    }
    //endregion

    //region Funciones del callback de Retrofit
    @Override
    public void success(ResponsePelicula responsePelicula, Response response) {
        this.peliculas = responsePelicula.getPeliculas();
        this.adapterRecyclerPeliculas.addAll(this.peliculas);
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
    //endregion
    //endregion
    //endregion
}