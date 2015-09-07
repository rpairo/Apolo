package me.rpairo.apolo.fragments.peliculas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.rpairo.apolo.R;

public class FragmentoPeliculasPopulares extends Fragment {

    public FragmentoPeliculasPopulares() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_peliculas_populares, container, false);
    }
}