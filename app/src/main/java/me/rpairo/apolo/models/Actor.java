package me.rpairo.apolo.models;

/**
 * Created by Raul on 8/9/15.
 */
public class Actor {

    //region Variables
    private String foto;
    private String nombre;
    private String personaje;

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
        return foto;
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