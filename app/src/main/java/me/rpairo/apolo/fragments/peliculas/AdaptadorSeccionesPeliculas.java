package me.rpairo.apolo.fragments.peliculas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raul on 7/9/15.
 */
public class AdaptadorSeccionesPeliculas extends FragmentStatePagerAdapter {

    private final List<Fragment> fragmentos = new ArrayList<>();
    private final List<String> titulosFragmentos = new ArrayList<>();

    public AdaptadorSeccionesPeliculas(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragmentos.get(position);
    }

    @Override
    public int getCount() {
        return this.fragmentos.size();
    }

    public void addFragment(Fragment fragment, String title) {
        this.fragmentos.add(fragment);
        this.titulosFragmentos.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.titulosFragmentos.get(position);
    }
}
