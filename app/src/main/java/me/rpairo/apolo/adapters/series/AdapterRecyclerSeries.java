package me.rpairo.apolo.adapters.series;

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
import me.rpairo.apolo.activities.series.ActivityDetallesSerie;
import me.rpairo.apolo.adapters.peliculas.fragments.ViewHolderPeliculas;
import me.rpairo.apolo.models.Serie;

/**
 * Created by Raul on 10/10/15.
 */
public class AdapterRecyclerSeries extends RecyclerView.Adapter<ViewHolderPeliculas> {

    //region Variables
    private List<Serie> items;
    private Context context;
    //endregion

    //region Funciones
    //region Constructores
    public AdapterRecyclerSeries(List<Serie> items, Context context) {
        this.items = items;
        this.context = context;
    }
    //endregion

    //region Funciones del Recycler
    @Override
    public ViewHolderPeliculas onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_pelicula, viewGroup, false);

        return new ViewHolderPeliculas(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderPeliculas viewHolderPeliculas, int i) {

        Glide.with(this.context)
                .load(this.items.get(i).getPoster())
                .override(350, 400)
                .animate(android.R.anim.slide_in_left)
                .into(viewHolderPeliculas.poster);

        viewHolderPeliculas.titulo.setText(this.items.get(i).getTitulo());

        viewHolderPeliculas.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ActivityDetallesSerie.class);

                intent.putExtra("serie", items.get(viewHolderPeliculas.getAdapterPosition()));
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
    public void addAll(ArrayList<Serie> series) {
        if (series == null)
            throw new NullPointerException("No puedes pasar una lista nula");

        this.items.addAll(series);
        this.notifyDataSetChanged();
    }
    //endregion
    //endregion
}
