package me.rpairo.apolo.fragments.series;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.rpairo.apolo.R;
import me.rpairo.apolo.activities.series.ActivityDetallesSerie;

/**
 * Created by Raul on 10/10/15.
 */
public class FragmentoSeriesSinopsis extends Fragment {

    //region Variables
    private Bitmap bitmap;
    //endregion

    //region Funciones
    //region Constructores
    public FragmentoSeriesSinopsis() {

    }
    //endregion

    //region Funciones del Fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_peliculas_detalles_sinopsis, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView sinopsiTextView = (TextView) view.findViewById(R.id.sinopsis_detalle_pelicula);
        sinopsiTextView.setText(ActivityDetallesSerie.getSerie().getDescripcion());

        if (this.bitmap == null)
            this.bitmap = ActivityDetallesSerie.getBackdrop();

        pintarPalette(view, this.bitmap);
    }
    //endregion

    //region Funciones Auxiliares
    public void pintarPalette(final View view, Bitmap bitmap) {

        // extrae los colores de la imagen
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {

            public void onGenerated(Palette p) {

                if (p != null) {

                    Palette.Swatch vibrantLightSwatch = p.getLightVibrantSwatch();
                    Palette.Swatch vibrantDarkSwatch = p.getDarkVibrantSwatch();
                    Palette.Swatch mutedLightSwatch = p.getLightMutedSwatch();
                    Palette.Swatch mutedDarkSwatch = p.getDarkMutedSwatch();

                    LinearLayout ll = (LinearLayout) view.findViewById(R.id.linear_layout_pelicula_sinopsis);
                    CardView cv = (CardView) view.findViewById(R.id.cardViewDetalle);
                    TextView tv = (TextView) view.findViewById(R.id.sinopsis_detalle_pelicula);
                    TextView tvT = (TextView) view.findViewById(R.id.titulo_sinopsis_detalle_pelicula);

                    if (vibrantDarkSwatch != null)
                        ll.setBackgroundColor(vibrantDarkSwatch.getRgb());
                    else if (mutedDarkSwatch != null)
                        ll.setBackgroundColor(mutedDarkSwatch.getRgb());

                    if (mutedLightSwatch != null)
                        cv.setBackgroundColor(mutedLightSwatch.getRgb());
                    else if (vibrantLightSwatch != null)
                        cv.setBackgroundColor(vibrantLightSwatch.getRgb());

                    if (mutedLightSwatch != null)
                        tvT.setTextColor(mutedLightSwatch.getTitleTextColor());
                    else if (vibrantLightSwatch != null)
                        tvT.setTextColor(vibrantLightSwatch.getTitleTextColor());

                    if (mutedLightSwatch != null)
                        tv.setTextColor(mutedLightSwatch.getBodyTextColor());
                    else if (vibrantLightSwatch != null)
                        tv.setTextColor(vibrantLightSwatch.getBodyTextColor());
                }
            }
        });
    }
    //endregion
    //endregion
}
