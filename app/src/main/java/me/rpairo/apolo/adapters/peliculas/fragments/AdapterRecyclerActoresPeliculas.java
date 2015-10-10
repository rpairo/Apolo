package me.rpairo.apolo.adapters.peliculas.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import me.rpairo.apolo.R;
import me.rpairo.apolo.activities.peliculas.ActivityDetallesPelicula;
import me.rpairo.apolo.models.Actor;

/**
 * Created by Raul on 4/10/15.
 */
public class AdapterRecyclerActoresPeliculas extends RecyclerView.Adapter<ViewHolderActores> {

    //region Variables
    private List<Actor> items;
    private Context context;
    //endregion

    //region Funciones
    //region Constructores
    public AdapterRecyclerActoresPeliculas(List<Actor> items, Context context) {
        this.items = items;
        this.context = context;
    }
    //endregion

    //region Funciones del adapter
    @Override
    public ViewHolderActores onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_actor, parent, false);

        return new ViewHolderActores(v);
    }

    @Override
    public void onBindViewHolder(ViewHolderActores holder, int position) {


        Glide.with(this.context)
                .load(this.items.get(position).getFoto())
                .centerCrop()
                .into(holder.imagen);

        holder.personaje.setText(this.items.get(position).getPersonaje());
        holder.nombre.setText(this.items.get(position).getNombre());

        this.pintarPalette(ActivityDetallesPelicula.getBackdrop(), holder);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
    //endregion

    //region Funciones Auxiliares
    public void addAll(ArrayList<Actor> actors) {
        if (actors == null)
            throw new NullPointerException("The items cannot be null");

        this.items.addAll(actors);
        notifyDataSetChanged();
    }

    public void pintarPalette(Bitmap bitmap, final ViewHolderActores holder) {

        // extrae los colores de la imagen
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {

            public void onGenerated(Palette p) {

                if (p != null) {

                    Palette.Swatch vibrantLightSwatch = p.getLightVibrantSwatch();
                    Palette.Swatch mutedLightSwatch = p.getLightMutedSwatch();

                    if (mutedLightSwatch != null)
                        holder.relativeLayout.setBackgroundColor(mutedLightSwatch.getRgb());
                    else if (vibrantLightSwatch != null)
                        holder.relativeLayout.setBackgroundColor(vibrantLightSwatch.getRgb());

                    if (mutedLightSwatch != null)
                        holder.personaje.setTextColor(mutedLightSwatch.getTitleTextColor());
                    else if (vibrantLightSwatch != null)
                        holder.personaje.setTextColor(vibrantLightSwatch.getTitleTextColor());

                    if (mutedLightSwatch != null)
                        holder.nombre.setTextColor(mutedLightSwatch.getBodyTextColor());
                    else if (vibrantLightSwatch != null)
                        holder.nombre.setTextColor(vibrantLightSwatch.getBodyTextColor());
                }
            }
        });
    }
    //endregion
    //endregion
}