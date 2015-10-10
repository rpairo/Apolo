package me.rpairo.apolo.fragments.series;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import me.rpairo.apolo.R;
import me.rpairo.apolo.adapters.series.AdapterRecyclerSeries;
import me.rpairo.apolo.models.Serie;
import me.rpairo.apolo.retrofit.api.tmdb.ApiAdapterTMDB;
import me.rpairo.apolo.retrofit.api.tmdb.ApiConstantsTMDB;
import me.rpairo.apolo.retrofit.responses.ResponseSeries;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Raul on 10/10/15.
 */
public class FragmentoSeriesValoradas extends Fragment implements retrofit.Callback<ResponseSeries>{

    //region Variables
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterRecyclerSeries adapterRecyclerSeries;
    private ArrayList<Serie> series;
    //endregion

    //region Funciones
    //region Constructores
    public FragmentoSeriesValoradas() {

    }
    //endregion

    //region Funciones del Fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.series = new ArrayList<Serie>();
        return inflater.inflate(R.layout.fragment_series_valoradas, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Obtención del RecyclerView
        this.recycler = (RecyclerView) view.findViewById(R.id.recycler_series_valoradas);

        //Creación del LayoutManager del RecyclerView
        this.layoutManager = new GridLayoutManager(view.getContext(), 2);
        this.recycler.setLayoutManager(this.layoutManager);

        this.adapterRecyclerSeries = new AdapterRecyclerSeries(this.series, view.getContext());
        this.recycler.setAdapter(this.adapterRecyclerSeries);

        this.recycler.refreshDrawableState();

        this.request();
    }
    //endregion

    //region Funciones de Retrofit
    //region Funciones auxiliares de Retrofit
    private void request() {
        ApiAdapterTMDB.getApiServiceTMDB()
                .getSeriesMejorValoradas("es", ApiConstantsTMDB.API_KEY, this);
    }
    //endregion

    //region Funciones del callback de Retrofit
    @Override
    public void success(ResponseSeries responseSeries, Response response) {
        this.series = responseSeries.getSeries();
        this.adapterRecyclerSeries.addAll(this.series);
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
    //endregion
    //endregion
    //endregion
}