package me.rpairo.apolo.retrofit.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import me.rpairo.apolo.gson.JsonKeys;
import me.rpairo.apolo.models.Pelicula;

/**
 * Created by Raul on 8/9/15.
 */
public class ResponsePeliculas {

    //region Variables
    @SerializedName(JsonKeys.RESULTS)
    private ArrayList<Pelicula> peliculas;
    //endregion

    //region Funciones
    //region Funciones auxiliares
    public ArrayList<Pelicula> getPeliculas() {
        return this.peliculas;
    }
    //endregion
    //endregion
}