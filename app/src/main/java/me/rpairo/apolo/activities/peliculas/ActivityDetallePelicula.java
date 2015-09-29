package me.rpairo.apolo.activities.peliculas;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import me.rpairo.apolo.R;
import me.rpairo.apolo.models.Pelicula;

/**
 * Created by Raul on 8/9/15.
 */

public class ActivityDetallePelicula extends AppCompatActivity {

    //region Variables
    private Pelicula pelicula;
    private FloatingActionButton fab;
    private NestedScrollView nsv;
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
        this.fab  = (FloatingActionButton) findViewById(R.id.fab_marcar_favorito_detalle_pelicula);

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
        final ImageView image = (ImageView) findViewById(R.id.image_paralax_detalle_pelicula);

        Glide.with(this).load(url).asBitmap().into(new BitmapImageViewTarget(image) {
            @Override
            protected void setResource(Bitmap resource) {
                image.setImageBitmap(resource);
                pintarPalette(resource, fab);
            }
        });
    }
    //endregion

    //region Funciones auxiliares
    public void pintarPalette(Bitmap bitmap, final FloatingActionButton fab) {

        // extrae los colores de la imagen
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {

            public void onGenerated(Palette p) {
                // Use generated instance

                if (p != null) {

                    Palette.Swatch vibrantSwatch = p.getVibrantSwatch();
                    Palette.Swatch vibrantLightSwatch = p.getLightVibrantSwatch();
                    Palette.Swatch vibrantDarkSwatch = p.getDarkVibrantSwatch();
                    Palette.Swatch mutedSwatch = p.getMutedSwatch(); // null
                    Palette.Swatch mutedLightSwatch = p.getLightMutedSwatch(); //null
                    Palette.Swatch mutedDarkSwatch = p.getDarkMutedSwatch(); // null


                    CardView cv = (CardView) findViewById(R.id.cardViewDetalle);
                    nsv = (NestedScrollView) findViewById(R.id.scroll_detalle_pelicula);
                    TextView tv = (TextView) findViewById(R.id.sinopsis_detalle_pelicula);
                    TextView tvT = (TextView) findViewById(R.id.titulo_sinopsis_detalle_pelicula);


                    if(vibrantDarkSwatch != null)
                        nsv.setBackgroundColor(vibrantDarkSwatch.getRgb());

                    if(mutedLightSwatch != null)
                        cv.setBackgroundColor(mutedLightSwatch.getRgb());

                    if(mutedLightSwatch != null)
                        tvT.setTextColor(mutedLightSwatch.getTitleTextColor());
                    if(mutedLightSwatch != null)
                        tv.setTextColor(mutedLightSwatch.getBodyTextColor());

                    if(vibrantSwatch != null)
                        fab.setBackgroundTintList(ColorStateList.valueOf(vibrantSwatch.getRgb()));

                    fab.setVisibility(View.VISIBLE);
                    nsv.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    //endregion
    //endregion
}