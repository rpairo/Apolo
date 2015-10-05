package me.rpairo.apolo.adapters.peliculas.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import me.rpairo.apolo.R;

/**
 * Created by Raul on 4/10/15.
 */
public class ViewHolderActores extends RecyclerView.ViewHolder {

    //region Variables
    public ImageView imagen;
    public TextView nombre;
    public TextView personaje;
    public RelativeLayout relativeLayout;
    //endregion

    //region Funciones
    //region Constructores
    public ViewHolderActores(View v) {
        super(v);
        imagen = (ImageView) v.findViewById(R.id.imagenActor);
        nombre = (TextView) v.findViewById(R.id.nombreActor);
        personaje = (TextView) v.findViewById(R.id.nombrePersonaje);
        relativeLayout = (RelativeLayout) v.findViewById(R.id.item_actor);
    }
    //endregion
    //endregion
}