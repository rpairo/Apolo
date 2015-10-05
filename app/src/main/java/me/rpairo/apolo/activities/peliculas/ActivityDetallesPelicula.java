package me.rpairo.apolo.activities.peliculas;

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
import me.rpairo.apolo.fragments.peliculas.FragmentoPeliculasActores;
import me.rpairo.apolo.fragments.peliculas.FragmentoPeliculasImagenes;
import me.rpairo.apolo.fragments.peliculas.FragmentoPeliculasSinopsis;
import me.rpairo.apolo.models.Pelicula;

/**
 * Created by Raul on 8/9/15.
 */

public class ActivityDetallesPelicula extends AppCompatActivity {

    //region Variables
    private static Pelicula pelicula;
    private static Bitmap backdrop;
    private FloatingActionButton fab;
    //endregion

    //region Funciones
    //region Funciones de la activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_detalles);

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
        this.fab = (FloatingActionButton) findViewById(R.id.fab_marcar_favorito_detalle_pelicula);

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
    }


    private void detallesViewPager() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.htab_viewpager);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        AdapterFragmentsDetalles adapter = new AdapterFragmentsDetalles(getSupportFragmentManager());
        adapter.addFrag(new FragmentoPeliculasSinopsis(), "Sinopsis");
        adapter.addFrag(new FragmentoPeliculasActores(), "Actores");
        adapter.addFrag(new FragmentoPeliculasImagenes(), "Imagenes");
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

    public static Pelicula getPelicula() {
        if(pelicula != null)
            return pelicula;
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