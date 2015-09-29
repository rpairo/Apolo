package me.rpairo.apolo.fragments.peliculas;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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
import me.rpairo.apolo.adapters.peliculas.fragments.AdaptadorFragmentsPeliculas;
import me.rpairo.apolo.activities.main.MainActivity;

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

        // Habilita el modo scrollable para el TabLayout
        this.tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

        //Floating action menu & buttons
        this.fam = (FloatingActionsMenu) view.findViewById(R.id.fam_peliculas);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_buscar_peliculas);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar();
            }
        });

        fab = (FloatingActionButton) view.findViewById(R.id.fab_asistente_peliculas);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asistente();
            }
        });

        this.zoomIn(view.findViewById(R.id.fab_expand_menu_button), 500, 0);

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
        AdaptadorFragmentsPeliculas adapter = new AdaptadorFragmentsPeliculas(this.getFragmentManager());
        adapter.addFragment(new FragmentoPeliculasFavoritas(), this.getString(R.string.titulo_tab_favoritas));
        adapter.addFragment(new FragmentoPeliculasCartelera(), this.getString(R.string.titulo_tab_cartelera));
        adapter.addFragment(new FragmentoPeliculasPopulares(), this.getString(R.string.titulo_tab_populares));
        adapter.addFragment(new FragmentoPeliculasProximas(), this.getString(R.string.titulo_tab_proximas));
        adapter.addFragment(new FragmentoPeliculasValoradas(), this.getString(R.string.titulo_tab_valoradas));

        viewPager.setAdapter(adapter);

        //TODO crear fragment de: mejor valoradas y proximas
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

    //region Animación FloatActionButton
    private ObjectAnimator zoomIn(View v, long duration, long delay){
        v.setScaleX(0);
        v.setScaleY(0);

        PropertyValuesHolder propx = PropertyValuesHolder.ofFloat("scaleX", 1);
        PropertyValuesHolder propy = PropertyValuesHolder.ofFloat("scaleY", 1);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(v, propx, propy);
        animator.setStartDelay(delay);
        animator.setDuration(duration);
        animator.start();
        return animator;
    }

    private ObjectAnimator zoomOut(View v, long duration, long delay){
        PropertyValuesHolder propx = PropertyValuesHolder.ofFloat(View.SCALE_X, 0);
        PropertyValuesHolder propy = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(v, propx, propy);
        animator.setStartDelay(delay);
        animator.setDuration(duration);
        animator.start();
        return animator;
    }
    //endregion
    //endregion
}