package me.rpairo.apolo.retrofit.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import me.rpairo.apolo.gson.JsonKeys;
import me.rpairo.apolo.models.Actor;

/**
 * Created by Raul on 4/10/15.
 */
public class ResponseActores {

    //region Variables
    @SerializedName(JsonKeys.CAST)
    private ArrayList<Actor> actores;
    //endregion

    //region Funciones
    //region Funciones auxiliares
    public ArrayList<Actor> getActores() {
        return this.actores;
    }
    //endregion
    //endregion
}