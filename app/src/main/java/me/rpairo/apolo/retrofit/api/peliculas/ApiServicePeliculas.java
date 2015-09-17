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
    //devuelve un lista de las peliculas populares del momento
    @GET(ApiConstantsPeliculas.PATH_VERSION + ApiConstantsPeliculas.PATH_GET_MOVIES_POPULAR)
    void getPeliculasPopulares(@Query(ApiConstantsPeliculas.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsPeliculas.PARAM_API_KEY) String apiKey, Callback<ResponsePelicula> serverResponse);

    //devuelve una lista de los proximos estrenos
    @GET(ApiConstantsPeliculas.PATH_VERSION + ApiConstantsPeliculas.PATH_GET_MOVIES_UPCOMING)
    void getPeliculasProximas(@Query(ApiConstantsPeliculas.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsPeliculas.PARAM_API_KEY) String apiKey, Callback<ResponsePelicula> serverResponse);

    //devuelve una lista de las peliculas que estan en cartelera
    @GET(ApiConstantsPeliculas.PATH_VERSION + ApiConstantsPeliculas.PATH_GET_MOVIES_NOW_PLAYING)
    void getPeliculasCartelera(@Query(ApiConstantsPeliculas.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsPeliculas.PARAM_API_KEY) String apiKey, Callback<ResponsePelicula> serverResponse);

    //devuelve una lista de las peliculas que coinciden con el titulo que buscamos
    @GET(ApiConstantsPeliculas.PATH_VERSION + ApiConstantsPeliculas.PATH_SEARCH_MOVIE)
    void getPeliculaInfo(@Query(ApiConstantsPeliculas.PARAM_QUERY_SEARCH_MOVIE) String nombrePelicula, @Query(ApiConstantsPeliculas.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsPeliculas.PARAM_API_KEY) String apiKey, Callback<ResponsePelicula> serverResponse);
    //endregion
}