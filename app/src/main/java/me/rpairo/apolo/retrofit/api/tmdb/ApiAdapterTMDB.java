package me.rpairo.apolo.retrofit.api.tmdb;

import retrofit.RestAdapter;

/**
 * Created by Raul on 8/9/15.
 */
public class ApiAdapterTMDB {

    //region Variables
    private static ApiServiceTMDB apiServiceTMDB;
    //endregion

    //region Funciones
    //region Funciones de la Api
    public static ApiServiceTMDB getApiServiceTMDB() {

        if(apiServiceTMDB == null) {
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstantsTMDB.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();

            apiServiceTMDB = adapter.create(ApiServiceTMDB.class);
        }

        return apiServiceTMDB;
    }
    //endregion
    //endregion
}