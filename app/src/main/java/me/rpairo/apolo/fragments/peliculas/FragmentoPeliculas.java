package me.rpairo.apolo.fragments.peliculas;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
    private ViewPager viewPager;
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

        if (savedInstanceState == null)
            this.insertarTabs(container);

        this.viewPager = (ViewPager) view.findViewById(R.id.pager);
        this.poblarViewPager(this.viewPager);
        this.tabs.setupWithViewPager(this.viewPager);

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

    //Se encarga de llenar el ViewPager con los fragments como pestañas
    private void poblarViewPager(ViewPager viewPager) {
        AdaptadorSeccionesPeliculas adapter = new AdaptadorSeccionesPeliculas(this.getFragmentManager());
        adapter.addFragment(new FragmentoPeliculasFavoritas(), this.getString(R.string.titulo_tab_favoritas));
        adapter.addFragment(new FragmentoPeliculasPopulares(), this.getString(R.string.titulo_tab_populares));
        viewPager.setAdapter(adapter);
    }
    //endregion
    //endregion
}