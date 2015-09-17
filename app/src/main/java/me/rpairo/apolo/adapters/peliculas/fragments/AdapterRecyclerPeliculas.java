package me.rpairo.apolo.adapters.peliculas.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import me.rpairo.apolo.R;
import me.rpairo.apolo.activities.peliculas.ActivityDetallePelicula;
import me.rpairo.apolo.models.Pelicula;

/**
 * Created by Raul on 8/9/15.
 */
public class AdapterRecyclerPeliculas extends RecyclerView.Adapter<PeliculasViewHolder> {

    //region Variables
    private List<Pelicula> items;
    private Context context;
    //endregion

    //region Funciones
    //region Constructores
    public AdapterRecyclerPeliculas(List<Pelicula> items, Context context) {
        this.items = items;
        this.context = context;
    }
    //endregion

    //region Funciones del Recycler
    @Override
    public PeliculasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_pelicula, viewGroup, false);

        return new PeliculasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PeliculasViewHolder peliculasViewHolder, int i) {

        Glide.with(this.context)
                .load(this.items.get(i).getPoster())
                .override(350, 400)
                .animate(android.R.anim.slide_in_left)
                .into(peliculasViewHolder.poster);

        peliculasViewHolder.titulo.setText(this.items.get(i).getTitulo());

        peliculasViewHolder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ActivityDetallePelicula.class);

                intent.putExtra("pelicula", items.get(peliculasViewHolder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
    //endregion

    //region Funciones auxiliares
    public void addAll(ArrayList<Pelicula> peliculas) {
        if (peliculas == null)
            throw new NullPointerException("No puedes pasar una lista nula");

        this.items.addAll(peliculas);
        this.notifyDataSetChanged();
    }
    //endregion
    //endregion
}