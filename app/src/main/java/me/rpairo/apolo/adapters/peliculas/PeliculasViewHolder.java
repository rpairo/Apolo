package me.rpairo.apolo.adapters.peliculas;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import me.rpairo.apolo.R;

/**
 * Created by Raul on 8/9/15.
 */
public class PeliculasViewHolder extends RecyclerView.ViewHolder{

    //region Variables
    public ImageView poster;
    public TextView titulo;
    //endregion

    //region Funciones
    //region Constructores
    public PeliculasViewHolder(View view) {
        super(view);

        this.poster = (ImageView) view.findViewById(R.id.poster_pelicula);
        this.titulo = (TextView) view.findViewById(R.id.titulo_pelicula);
    }
    //endregion
    //endregion
}