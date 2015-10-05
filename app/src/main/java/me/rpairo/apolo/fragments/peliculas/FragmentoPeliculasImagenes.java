package me.rpairo.apolo.fragments.peliculas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.rpairo.apolo.R;

/**
 * Created by Raul on 3/10/15.
 */
public class FragmentoPeliculasImagenes extends Fragment {

    //region Variables
    //endregion

    //region Funciones
    //region Constructores
    public FragmentoPeliculasImagenes() {

    }
    //endregion

    //region Funciones del Fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_peliculas_detalles_imagenes, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    //endregion
    //endregion
}