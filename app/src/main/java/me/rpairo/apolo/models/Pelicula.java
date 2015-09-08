package me.rpairo.apolo.models;

import java.util.ArrayList;

/**
 * Created by Raul on 8/9/15.
 */
public class Pelicula {

    //region Variables
    private String titulo;
    private String poster;
    private String backdrop;
    private String descripcion;
    private String fecha;

    private int id;

    private boolean favorito;

    private ArrayList<Actor> actores;
    //endregion

    //region Funciones
    //region Constructores
    public Pelicula(String titulo, String poster, String backdrop, String descripcion, String fecha, int id, boolean favorito, ArrayList<Actor> actores) {
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
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdrop() {
        return backdrop;
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