package me.rpairo.apolo.fragments.musica;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.rpairo.apolo.R;

/**
 * Created by Raul on 7/9/15.
 */

public class FragmentoMusicaPopular extends Fragment {

    //region Funciones
    //region Constructores
    public FragmentoMusicaPopular() {
    }
    //endregion

    //region Funciones del Fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_musica_popular, container, false);
    }
    //endregion
    //endregion
}