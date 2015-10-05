package me.rpairo.apolo.fragments.peliculas;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import me.rpairo.apolo.R;
import me.rpairo.apolo.activities.peliculas.ActivityDetallesPelicula;
import me.rpairo.apolo.adapters.peliculas.fragments.AdapterRecyclerActores;
import me.rpairo.apolo.models.Actor;
import me.rpairo.apolo.retrofit.api.peliculas.ApiAdapterPeliculas;
import me.rpairo.apolo.retrofit.api.peliculas.ApiConstantsPeliculas;
import me.rpairo.apolo.retrofit.responses.ResponseActores;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Raul on 3/10/15.
 */
public class FragmentoPeliculasActores extends Fragment implements retrofit.Callback<ResponseActores> {

    //region Variables
    private ArrayList<Actor> actores;
    private AdapterRecyclerActores adapterRecyclerActores;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;
    private Bitmap bitmap;
    //endregion

    //region Funciones
    //region Constructores
    public FragmentoPeliculasActores() {

    }
    //endregion

    //region Funciones del Fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.actores = new ArrayList<>();

        return inflater.inflate(R.layout.fragment_peliculas_detalles_actores, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.recycler = (RecyclerView) view.findViewById(R.id.recycler_peliculas_actores);
        this.recycler.setHasFixedSize(true);

        this.layoutManager = new LinearLayoutManager(view.getContext());
        this.recycler.setLayoutManager(this.layoutManager);

        this.adapterRecyclerActores = new AdapterRecyclerActores(this.actores, view.getContext());
        this.recycler.setAdapter(this.adapterRecyclerActores);

        if (this.bitmap == null)
            this.bitmap = ActivityDetallesPelicula.getBackdrop();

        this.pintarPalette(view, this.bitmap);

        this.request();
    }
    //endregion

    //region Funciones de Retrofit
    //region Funciones auxiliares de Retrofit
    private void request() {
        ApiAdapterPeliculas.getApiServicePeliculas()
                .getActores(ActivityDetallesPelicula.getPelicula().getId(), ApiConstantsPeliculas.API_KEY, this);
    }
    //endregion

    //region Funciones del callback de Retrofit
    @Override
    public void success(ResponseActores responseActores, Response response) {
        this.actores = responseActores.getActores();

        this.adapterRecyclerActores.addAll(this.actores);
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
    //endregion
    //endregion

    //region Funciones Auxiliares
    public void pintarPalette(final View view, Bitmap bitmap) {

        // extrae los colores de la imagen
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {

            public void onGenerated(Palette p) {

                if (p != null) {

                    Palette.Swatch vibrantDarkSwatch = p.getDarkVibrantSwatch();
                    Palette.Swatch mutedDarkSwatch = p.getDarkMutedSwatch();

                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_peliculas_actores);

                    if (vibrantDarkSwatch != null)
                        recyclerView.setBackgroundColor(vibrantDarkSwatch.getRgb());
                    else if (mutedDarkSwatch != null)
                        recyclerView.setBackgroundColor(mutedDarkSwatch.getRgb());
                }
            }
        });
    }
    //endregion
    //endregion
}