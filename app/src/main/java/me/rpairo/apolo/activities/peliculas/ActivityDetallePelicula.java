package me.rpairo.apolo.activities.peliculas;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import me.rpairo.apolo.R;
import me.rpairo.apolo.glide.GlideWrapper;
import me.rpairo.apolo.models.Pelicula;

/**
 * Created by Raul on 8/9/15.
 */

public class ActivityDetallePelicula extends AppCompatActivity {

    //region Variables
    private Pelicula pelicula;
    //endregion

    //region Funciones
    //region Funciones de la activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);

        this.pelicula = (Pelicula) getIntent().getSerializableExtra("pelicula");

        //añade la tollbar
        this.setToolbar();

        //habilita el up button
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapser = (CollapsingToolbarLayout) findViewById(R.id.collapser_detalle_pelicula);
        collapser.setTitle(this.pelicula.getTitulo());
        collapser.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));


        //añade el backdrop
        this.loadImageParallax(this.pelicula.getBackdrop());


        //añadir listener al fab
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_marcar_favorito_detalle_pelicula);

        if (pelicula.isFavorito())
            fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_white_48dp));
        else fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_border_white_48dp));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pelicula.isFavorito()) {
                    pelicula.setFavorito(false);
                    fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_border_white_48dp));
                } else {
                    pelicula.setFavorito(true);
                    fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_white_48dp));
                }
            }
        });

        //añade descripción
        TextView sinopsiTextView = (TextView) findViewById(R.id.sinopsis_detalle_pelicula);
        sinopsiTextView.setText(this.pelicula.getDescripcion());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion

    //TODO implementar listener en los botones para llamar a las activities detalladas

    //region Toolbar
    private void setToolbar() {
        // Añade la Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detalle_pelicula);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    //endregion

    //region Parallax
    private void loadImageParallax(String url) {
        ImageView image = (ImageView) findViewById(R.id.image_paralax_detalle_pelicula);
        GlideWrapper.setImage(this, url, image);
    }
    //endregion
    //endregion
}