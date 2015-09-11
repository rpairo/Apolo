package me.rpairo.apolo.retrofit.api.peliculas;

import me.rpairo.apolo.retrofit.responses.ResponsePelicula;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Raul on 8/9/15.
 */
public interface ApiServicePeliculas {

    //region Funciones de la Api
    @GET(ApiConstantsPeliculas.PATH_VERSION + ApiConstantsPeliculas.PATH_GET_MOVIES_POPULAR)
    void getPeliculasPopulares(@Query(ApiConstantsPeliculas.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsPeliculas.PARAM_API_KEY) String apiKey, Callback<ResponsePelicula> serverResponse);

    @GET(ApiConstantsPeliculas.PATH_VERSION + ApiConstantsPeliculas.PATH_GET_MOVIES_UPCOMING)
    void getPeliculasProximas(@Query(ApiConstantsPeliculas.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsPeliculas.PARAM_API_KEY) String apiKey, Callback<ResponsePelicula> serverResponse);

    @GET(ApiConstantsPeliculas.PATH_VERSION + ApiConstantsPeliculas.PATH_GET_MOVIES_NOW_PLAYING)
    void getPeliculasCartelera(@Query(ApiConstantsPeliculas.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsPeliculas.PARAM_API_KEY) String apiKey, Callback<ResponsePelicula> serverResponse);
    //endregion
}