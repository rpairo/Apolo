package me.rpairo.apolo.adapters.peliculas.search;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import me.rpairo.apolo.R;

/**
 * Created by Raul on 15/9/15.
 */
public class PeliculasViewHolderSearch extends RecyclerView.ViewHolder {

    //region Variables
    public ImageView poster;
    public TextView titulo;
    public TextView fecha;
    public ImageView fav;
    public ImageView detalles;
    public ImageView eliminar;
    //endregion

    //region Funciones
    //region Constructores
    public PeliculasViewHolderSearch(View view) {
        super(view);

        this.poster = (ImageView) view.findViewById(R.id.poster_pelicula);
        this.titulo = (TextView) view.findViewById(R.id.titulo_pelicula);
        this.fecha = (TextView) view.findViewById(R.id.fecha_search);
        this.fav = (ImageView) view.findViewById(R.id.fav_search);
        this.detalles = (ImageView) view.findViewById(R.id.ver_detalles);
        this.eliminar = (ImageView) view.findViewById(R.id.eliminar_search);
    }
    //endregion
    //endregion
}