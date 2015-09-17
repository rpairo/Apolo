package me.rpairo.apolo.adapters.peliculas.search;

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
 * Created by Raul on 15/9/15.
 */
public class AdapterRecyclerPeliculasSearch extends RecyclerView.Adapter<PeliculasViewHolderSearch> {

    //region Variables
    private List<Pelicula> items;
    private Context context;
    //endregion

    //region Funciones
    //region Constructores
    public AdapterRecyclerPeliculasSearch(List<Pelicula> items, Context context) {
        this.items = items;
        this.context = context;
    }
    //endregion

    //region Funciones del Recycler
    @Override
    public PeliculasViewHolderSearch onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_pelicula_search, viewGroup, false);

        return new PeliculasViewHolderSearch(view);
    }

    @Override
    public void onBindViewHolder(final PeliculasViewHolderSearch peliculasViewHolderSearch, int i) {

        Glide.with(this.context)
                .load(this.items.get(i).getPoster())
                .override(85, 120)
                .animate(android.R.anim.slide_in_left)
                .into(peliculasViewHolderSearch.poster);

        peliculasViewHolderSearch.titulo.setText(this.items.get(i).getTitulo());
        peliculasViewHolderSearch.fecha.setText(this.items.get(i).getFecha());

        Glide.with(this.context)
                .load(R.drawable.ic_star_border_black_48dp)
                .into(peliculasViewHolderSearch.fav);

        Glide.with(this.context)
                .load(R.drawable.ic_visibility_black_48dp)
                .into(peliculasViewHolderSearch.detalles);

        Glide.with(this.context)
                .load(R.drawable.ic_delete_black_48dp)
                .into(peliculasViewHolderSearch.eliminar);

        peliculasViewHolderSearch.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchActivityDetalles(peliculasViewHolderSearch.getAdapterPosition());

            }
        });


        peliculasViewHolderSearch.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (items.get(peliculasViewHolderSearch.getAdapterPosition()).isFavorito()) {
                    items.get(peliculasViewHolderSearch.getAdapterPosition()).setFavorito(false);
                    peliculasViewHolderSearch.fav.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_border_black_48dp));
                } else {
                    items.get(peliculasViewHolderSearch.getAdapterPosition()).setFavorito(true);
                    peliculasViewHolderSearch.fav.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_black_48dp));
                }
            }
        });

        peliculasViewHolderSearch.detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivityDetalles(peliculasViewHolderSearch.getAdapterPosition());
            }
        });

        peliculasViewHolderSearch.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.remove(peliculasViewHolderSearch.getAdapterPosition());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
    //endregion

    //region Funciones Auxiliares
    public void addAll(ArrayList<Pelicula> peliculas) {
        if (peliculas == null)
            throw new NullPointerException("No puedes pasar una lista nula");

        this.items.addAll(peliculas);
        this.notifyDataSetChanged();
    }

    private void launchActivityDetalles(int position) {
        Intent intent = new Intent(context, ActivityDetallePelicula.class);

        intent.putExtra("pelicula", items.get(position));
        context.startActivity(intent);
    }
    //endregion
    //endregion
}