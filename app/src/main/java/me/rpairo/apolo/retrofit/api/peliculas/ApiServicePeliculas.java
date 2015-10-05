package me.rpairo.apolo.retrofit.api.peliculas;

import me.rpairo.apolo.retrofit.responses.ResponseActores;
import me.rpairo.apolo.retrofit.responses.ResponsePeliculas;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Raul on 8/9/15.
 */
public interface ApiServicePeliculas {

    //region Funciones de la Api
    //devuelve un lista de las peliculas populares del momento
    @GET(ApiConstantsPeliculas.PATH_VERSION + ApiConstantsPeliculas.PATH_GET_MOVIES_POPULAR)
    void getPeliculasPopulares(@Query(ApiConstantsPeliculas.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsPeliculas.PARAM_API_KEY) String apiKey, Callback<ResponsePeliculas> serverResponse);

    //devuelve una lista de los proximos estrenos
    @GET(ApiConstantsPeliculas.PATH_VERSION + ApiConstantsPeliculas.PATH_GET_MOVIES_UPCOMING)
    void getPeliculasProximas(@Query(ApiConstantsPeliculas.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsPeliculas.PARAM_API_KEY) String apiKey, Callback<ResponsePeliculas> serverResponse);

    //devuelve una lista de las peliculas que estan en cartelera
    @GET(ApiConstantsPeliculas.PATH_VERSION + ApiConstantsPeliculas.PATH_GET_MOVIES_NOW_PLAYING)
    void getPeliculasCartelera(@Query(ApiConstantsPeliculas.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsPeliculas.PARAM_API_KEY) String apiKey, Callback<ResponsePeliculas> serverResponse);

    //devuelve una lista de las peliculas mejor valoradas
    @GET(ApiConstantsPeliculas.PATH_VERSION + ApiConstantsPeliculas.PATH_GET_MOVIES_TOP_RATED)
    void getPeliculasMejorValoradas(@Query(ApiConstantsPeliculas.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsPeliculas.PARAM_API_KEY) String apiKey, Callback<ResponsePeliculas> serverResponse);

    //devuelve una lista de las peliculas que coinciden con el titulo que buscamos
    @GET(ApiConstantsPeliculas.PATH_VERSION + ApiConstantsPeliculas.PATH_SEARCH_MOVIE)
    void getPeliculaInfo(@Query(ApiConstantsPeliculas.PARAM_QUERY_SEARCH_MOVIE) String nombrePelicula, @Query(ApiConstantsPeliculas.PARAM_LANGUAGE) String lenguaje, @Query(ApiConstantsPeliculas.PARAM_API_KEY) String apiKey, Callback<ResponsePeliculas> serverResponse);

    //devuelve una lista de los actores que aparecen en la pelicula indicada por el ID
    @GET(ApiConstantsPeliculas.PATH_VERSION + ApiConstantsPeliculas.PATH_GET_MOVIES_CREDITS)
    void getActores(@Path("id") int idPelicula, @Query(ApiConstantsPeliculas.PARAM_API_KEY) String apiKey, Callback<ResponseActores> serverResponse);
    //endregion
}