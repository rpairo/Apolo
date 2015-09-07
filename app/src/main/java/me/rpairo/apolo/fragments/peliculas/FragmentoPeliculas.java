package me.rpairo.apolo.fragments.peliculas;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import me.rpairo.apolo.R;
import me.rpairo.apolo.adapters.peliculas.AdaptadorSeccionesPeliculas;
import me.rpairo.apolo.main.MainActivity;

/**
 * Created by Raul on 7/9/15.
 */

public class FragmentoPeliculas extends Fragment {

    //region Variables
    private AppBarLayout appBarLayout;
    private TabLayout tabs;
    private ViewPager viewPager;
    private FloatingActionsMenu fam;
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

        this.viewPager = (ViewPager) view.findViewById(R.id.pager_peliculas);
        this.poblarViewPager(this.viewPager);
        this.tabs.setupWithViewPager(this.viewPager);


        //Floating action menu & buttons
        this.fam = (FloatingActionsMenu) view.findViewById(R.id.fam_peliculas);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.action_buscar_peliculas);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar();
            }
        });

        fab = (FloatingActionButton) view.findViewById(R.id.action_asistente_peliculas);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asistente();
            }
        });

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

    private void buscar() {
        this.toogleFAB();
        Log.d(MainActivity.LOG, "Buscar");

    }

    private void asistente() {
        this.toogleFAB();
        Log.d(MainActivity.LOG, "Asistente");
    }

    private void toogleFAB() {
        if(this.fam.isExpanded())
            this.fam.collapse();
    }
    //endregion
    //endregion
}