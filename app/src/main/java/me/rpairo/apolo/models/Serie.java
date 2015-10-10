package me.rpairo.apolo.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import me.rpairo.apolo.gson.JsonKeys;
import me.rpairo.apolo.retrofit.api.tmdb.ApiConstantsTMDB;

/**
 * Created by Raul on 10/10/15.
 */
public class Serie implements Serializable {
    //region Variables
    @SerializedName(JsonKeys.TITULO_SERIE)
    private String titulo;
    @SerializedName(JsonKeys.POSTER)
    private String poster;
    @SerializedName(JsonKeys.BACKDROP)
    private String backdrop;
    @SerializedName(JsonKeys.DESCRIPCION)
    private String descripcion;
    @SerializedName(JsonKeys.FECHA_SERIE)
    private String fecha;

    @SerializedName(JsonKeys.ID)
    private int id;

    private boolean favorito;

    private ArrayList<Actor> actores;
    //endregion

    //region Funciones
    //region Constructores
    public Serie() {
        this.titulo = "";
        this.poster = "";
        this.backdrop = "";
        this.descripcion = "";
        this.fecha = "";
        this.id = 0;
        this.favorito = false;
        this.actores = null;
    }

    public Serie(String titulo, String poster, String backdrop, String descripcion, String fecha, int id, boolean favorito, ArrayList<Actor> actores) {
        this.titulo = titulo;
        this.poster = poster;
        this.backdrop = backdrop;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.id = id;
        this.favorito = favorito;
        this.actores = actores;
    }
    //endregion

    //region Getters & Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPoster() {
        return ApiConstantsTMDB.PATH_GET_IMAGES +
                ApiConstantsTMDB.PATH_SIZE_POSTER +
                this.poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdrop() {
        return ApiConstantsTMDB.PATH_GET_IMAGES +
                ApiConstantsTMDB.PATH_SIZE_POSTER +
                this.backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }
    //endregion
    //endregion
}