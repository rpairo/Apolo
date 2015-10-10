package me.rpairo.apolo.activities.series;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import me.rpairo.apolo.R;
import me.rpairo.apolo.adapters.peliculas.fragments.AdapterFragmentsDetalles;
import me.rpairo.apolo.effects.DepthPageTransformer;
import me.rpairo.apolo.fragments.series.FragmentoSeriesActores;
import me.rpairo.apolo.fragments.series.FragmentoSeriesSinopsis;
import me.rpairo.apolo.models.Serie;

/**
 * Created by Raul on 10/10/15.
 */
public class ActivityDetallesSerie extends AppCompatActivity {

    //region Variables
    private static Serie serie;
    private static Bitmap backdrop;
    private FloatingActionButton fab;
    //endregion

    //region Funciones
    //region Funciones de la activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_detalles);

        this.serie = (Serie) getIntent().getSerializableExtra("serie");

        //añade la tollbar
        this.setToolbar();

        //habilita el up button
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapser = (CollapsingToolbarLayout) findViewById(R.id.collapser_detalle_pelicula);
        collapser.setTitle(this.serie.getTitulo());
        collapser.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        //añade el backdrop
        this.loadImageParallax(this.serie.getBackdrop());


        //añadir listener al fab
        this.fab = (FloatingActionButton) findViewById(R.id.fab_marcar_favorito_detalle_pelicula);

        if (serie.isFavorito())
            fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_white_48dp));
        else fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_border_white_48dp));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (serie.isFavorito()) {
                    serie.setFavorito(false);
                    fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_border_white_48dp));
                } else {
                    serie.setFavorito(true);
                    fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_white_48dp));
                }
            }
        });
    }


    private void detallesViewPager() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.htab_viewpager);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        AdapterFragmentsDetalles adapter = new AdapterFragmentsDetalles(getSupportFragmentManager());
        adapter.addFrag(new FragmentoSeriesSinopsis(), "Sinopsis");
        adapter.addFrag(new FragmentoSeriesActores(), "Actores");
        //adapter.addFrag(new FragmentoPeliculasImagenes(), "Imagenes");
        viewPager.setAdapter(adapter);
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

        Glide.with(this).load(url).asBitmap().animate(R.anim.anim_backdrop_peliculas_detalle).into(new BitmapImageViewTarget(image) {
            @Override
            protected void setResource(Bitmap resource) {
                image.setImageBitmap(resource);
                backdrop = resource;
                detallesViewPager();
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

                if (p != null) {

                    Palette.Swatch vibrantSwatch = p.getVibrantSwatch();
                    Palette.Swatch vibrantDarkSwatch = p.getDarkVibrantSwatch();
                    Palette.Swatch mutedSwatch = p.getMutedSwatch();
                    Palette.Swatch mutedDarkSwatch = p.getDarkMutedSwatch();

                    ViewPager vp = (ViewPager) findViewById(R.id.htab_viewpager);

                    if (vibrantDarkSwatch != null)
                        vp.setBackgroundColor(vibrantDarkSwatch.getRgb());
                    else if (mutedDarkSwatch != null)
                        vp.setBackgroundColor(mutedDarkSwatch.getRgb());

                    if (vibrantSwatch != null)
                        fab.setBackgroundTintList(ColorStateList.valueOf(vibrantSwatch.getRgb()));
                    else if (mutedSwatch != null)
                        fab.setBackgroundTintList(ColorStateList.valueOf(mutedSwatch.getRgb()));
                }
            }
        });
    }

    public static Serie getSerie() {
        if(serie != null)
            return serie;
        else return null;
    }

    public static Bitmap getBackdrop() {
        if(backdrop != null)
            return backdrop;
        else return null;
    }
    //endregion
    //endregion
}
