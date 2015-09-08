package me.rpairo.apolo.retrofit.api.peliculas;

import retrofit.RestAdapter;

/**
 * Created by Raul on 8/9/15.
 */
public class ApiAdapterPeliculas {

    //region Variables
    private static ApiServicePeliculas apiServicePeliculas;
    //endregion

    //region Funciones
    //region Funciones de la Api
    public static ApiServicePeliculas getApiServicePeliculas() {

        if(apiServicePeliculas == null) {
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstantsPeliculas.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();

            apiServicePeliculas = adapter.create(ApiServicePeliculas.class);
        }

        return apiServicePeliculas;
    }
    //endregion
    //endregion
}