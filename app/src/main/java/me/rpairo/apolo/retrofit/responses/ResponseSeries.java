package me.rpairo.apolo.retrofit.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import me.rpairo.apolo.gson.JsonKeys;
import me.rpairo.apolo.models.Serie;

/**
 * Created by Raul on 10/10/15.
 */
public class ResponseSeries {
    //region Variables
    @SerializedName(JsonKeys.RESULTS)
    private ArrayList<Serie> series;
    //endregion

    //region Funciones
    //region Funciones auxiliares
    public ArrayList<Serie> getSeries() {
        return this.series;
    }
    //endregion
    //endregion
}