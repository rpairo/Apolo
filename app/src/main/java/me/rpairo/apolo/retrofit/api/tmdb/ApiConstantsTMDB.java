package me.rpairo.apolo.retrofit.api.tmdb;

/**
 * Created by Raul on 8/9/15.
 */
public class ApiConstantsTMDB {

    //region Constantes
    public static final String API_KEY = "452cce8f527688dcda20118eaa3d672e";
    public static final String URL_BASE = "http://api.themoviedb.org";

    public static final String PATH_VERSION = "/3";
    public static final String PATH_LANGUAGE = "es";

    public static final String PATH_GET_MOVIES_POPULAR = "/movie/popular";
    public static final String PATH_GET_MOVIES_UPCOMING = "/movie/upcoming";
    public static final String PATH_GET_MOVIES_VIDEOS = "/movie/{id}/videos";
    public static final String PATH_GET_MOVIES_IMAGES = "/movie/{id}/images";
    public static final String PATH_GET_MOVIES_CREDITS = "/movie/{id}/credits";
    public static final String PATH_GET_MOVIES_REVIEWS = "/movie/{id}/reviews";
    public static final String PATH_GET_MOVIES_TOP_RATED = "/movie/top_rated";
    public static final String PATH_SEARCH_MOVIE = "/search/movie";
    public static final String PATH_GET_MOVIES_NOW_PLAYING = "/movie/now_playing";


    public static final String PATH_GET_SHOWS_ONAIR = "/tv/on_the_air";
    public static final String PATH_GET_SHOWS_POPULAR = "/tv/popular";
    public static final String PATH_GET_SHOWS_TOP_RATED = "/tv/top_rated";

    public static final String PATH_GET_SHOWS_CREDITS = "/tv/{id}/credits";

    //TODO añadir busqueda por series o pelicula, dependiendo del valor que se haya añadido a una variable estatica del buscador


    public static final String PATH_GET_IMAGES = "http://image.tmdb.org/t/p";
    public static final String PATH_SIZE_POSTER = "/original";

    public static final String PARAM_QUERY_SEARCH_MOVIE = "query";
    public static final String PARAM_API_KEY = "api_key";
    public static final String PARAM_LANGUAGE = "language";
    //endregion
}