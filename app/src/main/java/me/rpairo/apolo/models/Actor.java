package me.rpairo.apolo.models;

import com.google.gson.annotations.SerializedName;

import me.rpairo.apolo.gson.JsonKeys;

/**
 * Created by Raul on 8/9/15.
 */
public class Actor {

    //region Variables
    @SerializedName(JsonKeys.FOTO_ACTOR)
    private String foto;

    @SerializedName(JsonKeys.NOMBRE_ACTOR)
    private String nombre;

    @SerializedName(JsonKeys.PERSONAJE)
    private String personaje;

    @SerializedName(JsonKeys.ID_ACTOR)
    private int id;
    //endregion

    //region Funciones
    //region Constructores
    public Actor(String foto, String nombre, String personaje, int id) {
        this.foto = foto;
        this.nombre = nombre;
        this.personaje = personaje;
        this.id = id;
    }
    //endregion

    //region Getters & Setters
    public String getFoto() {
        return "http://image.tmdb.org/t/p/original/" + this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //endregion
    //endregion
}