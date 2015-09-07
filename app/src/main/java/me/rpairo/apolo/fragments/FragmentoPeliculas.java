package me.rpairo.apolo.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.rpairo.apolo.R;

/**
 * Created by Raul on 7/9/15.
 */

public class FragmentoPeliculas extends Fragment {

    //region Variables
    private AppBarLayout appBarLayout;
    private TabLayout tabs;
    //endregion

    //region Funciones
    //region Constructores
    public FragmentoPeliculas() {

    }
    //endregion

    //region Funciones del Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_peliculas, container, false);

        if(savedInstanceState == null)
            this.insertarTabs(container);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.appBarLayout.removeView(this.tabs);
    }
    //endregion

    //region Funciones de auxiliares
    private void insertarTabs(ViewGroup container) {
        View padre = (View) container.getParent();
        this.appBarLayout = (AppBarLayout) padre.findViewById(R.id.appbar);
        this.tabs = new TabLayout(this.getActivity());
        this.tabs.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        this.appBarLayout.addView(this.tabs);
    }
    //endregion
    //endregion
}