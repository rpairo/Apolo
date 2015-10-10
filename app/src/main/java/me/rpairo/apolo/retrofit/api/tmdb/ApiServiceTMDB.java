package me.rpairo.apolo.retrofit.api.tmdb;

import me.rpairo.apolo.retrofit.responses.ResponseActores;
import me.rpairo.apolo.retrofit.responses.ResponsePeliculas;
import me.rpairo.apolo.retrofit.responses.ResponseSeries;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Raul on 8/9/15.
 */
public interface ApiServiceTMDB {

    //region Funciones de la Api
    //devuelve un lista de las peliculas populares del momento
    @GET(ApiConstantsTMDB.PATH_VERSION + ApiConstantsTMDB.PATH_GET_MOVIES_POPULAR)
    void getPeliculasPopulares(@Query(ApiConstantsTMDB.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsTMDB.PARAM_API_KEY) String apiKey, Callback<ResponsePeliculas> serverResponse);

    //devuelve una lista de los proximos estrenos
    @GET(ApiConstantsTMDB.PATH_VERSION + ApiConstantsTMDB.PATH_GET_MOVIES_UPCOMING)
    void getPeliculasProximas(@Query(ApiConstantsTMDB.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsTMDB.PARAM_API_KEY) String apiKey, Callback<ResponsePeliculas> serverResponse);

    //devuelve una lista de las peliculas que estan en cartelera
    @GET(ApiConstantsTMDB.PATH_VERSION + ApiConstantsTMDB.PATH_GET_MOVIES_NOW_PLAYING)
    void getPeliculasCartelera(@Query(ApiConstantsTMDB.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsTMDB.PARAM_API_KEY) String apiKey, Callback<ResponsePeliculas> serverResponse);

    //devuelve una lista de las peliculas mejor valoradas
    @GET(ApiConstantsTMDB.PATH_VERSION + ApiConstantsTMDB.PATH_GET_MOVIES_TOP_RATED)
    void getPeliculasMejorValoradas(@Query(ApiConstantsTMDB.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsTMDB.PARAM_API_KEY) String apiKey, Callback<ResponsePeliculas> serverResponse);

    //devuelve una lista de las peliculas que coinciden con el titulo que buscamos
    @GET(ApiConstantsTMDB.PATH_VERSION + ApiConstantsTMDB.PATH_SEARCH_MOVIE)
    void getPeliculaInfo(@Query(ApiConstantsTMDB.PARAM_QUERY_SEARCH_MOVIE) String nombrePelicula, @Query(ApiConstantsTMDB.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsTMDB.PARAM_API_KEY) String apiKey, Callback<ResponsePeliculas> serverResponse);

    //devuelve una lista de los actores que aparecen en la pelicula indicada por el ID
    @GET(ApiConstantsTMDB.PATH_VERSION + ApiConstantsTMDB.PATH_GET_MOVIES_CREDITS)
    void getActoresPelicula(@Path("id") int idPelicula, @Query(ApiConstantsTMDB.PARAM_API_KEY) String apiKey, Callback<ResponseActores> serverResponse);

    //devuelve un lista de las series populares del momento
    @GET(ApiConstantsTMDB.PATH_VERSION + ApiConstantsTMDB.PATH_GET_SHOWS_POPULAR)
    void getSeriesPopulares(@Query(ApiConstantsTMDB.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsTMDB.PARAM_API_KEY) String apiKey, Callback<ResponseSeries> serverResponse);

    //devuelve un lista de las series que estan en emisión
    @GET(ApiConstantsTMDB.PATH_VERSION + ApiConstantsTMDB.PATH_GET_SHOWS_ONAIR)
    void getSeriesEmision(@Query(ApiConstantsTMDB.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsTMDB.PARAM_API_KEY) String apiKey, Callback<ResponseSeries> serverResponse);

    //devuelve un lista de las series que mejor valoradas
    @GET(ApiConstantsTMDB.PATH_VERSION + ApiConstantsTMDB.PATH_GET_SHOWS_TOP_RATED)
    void getSeriesMejorValoradas(@Query(ApiConstantsTMDB.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsTMDB.PARAM_API_KEY) String apiKey, Callback<ResponseSeries> serverResponse);

    //devuelve una lista de los actores que aparecen en la pelicula indicada por el ID
    @GET(ApiConstantsTMDB.PATH_VERSION + ApiConstantsTMDB.PATH_GET_SHOWS_CREDITS)
    void getActoresSerie(@Path("id") int idSerie, @Query(ApiConstantsTMDB.PARAM_API_KEY) String apiKey, Callback<ResponseActores> serverResponse);

    //endregion
}