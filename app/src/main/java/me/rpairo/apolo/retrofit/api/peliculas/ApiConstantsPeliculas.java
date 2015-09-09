package me.rpairo.apolo.retrofit.api.peliculas;

/**
 * Created by Raul on 8/9/15.
 */
public class ApiConstantsPeliculas {

    //region Variables
    public static final String API_KEY = "452cce8f527688dcda20118eaa3d672e";
    public static final String URL_BASE = "http://api.themoviedb.org";

    public static final String PATH_VERSION = "/3";
    public static final String PATH_LANGUAGE = "es";

    public static final String PATH_GET_MOVIES_POPULAR = "/movie/popular";
    public static final String PATH_GET_MOVIES_UPCOMING = "/movie/upcoming";
    public static final String PATH_GET_IMAGES = "http://image.tmdb.org/t/p";
    public static final String PATH_SIZE_POSTER = "/original";

    public static final String PARAM_QUERY_SEARCH_MOVIE = "query";
    public static final String PARAM_API_KEY = "api_key";
    public static final String PARAM_LANGUAGE = "language";
    //endregion
}