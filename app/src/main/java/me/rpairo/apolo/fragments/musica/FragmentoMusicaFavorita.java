package me.rpairo.apolo.fragments.musica;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import me.rpairo.apolo.R;

/**
 * Created by Raul on 7/9/15.
 */

public class FragmentoMusicaFavorita extends Fragment {

    //region Variables
    private LinearLayout ly;
    //endregion

    //region Funciones
    //region Constructores
    public FragmentoMusicaFavorita() {

    }
    //endregion

    //region Funciones del Fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_musica_favorita, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.ly = (LinearLayout) getView().findViewById(R.id.musica_vacia);
        this.activarAnimacionListaVacia();
    }

    //Detecta si el fragmento es visible al usuario
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser) {
            if(this.ly != null)
                this.activarAnimacionListaVacia();
        } else {
            if (this.ly != null)
                this.ly.setVisibility(View.INVISIBLE);
        }
    }
    //endregion

    //region Funciones auxiliares
    //region Animación
    private void activarAnimacionListaVacia() {
        AnimatorSet mAnimationSet = new AnimatorSet();

        ObjectAnimator fadeInLY = ObjectAnimator.ofFloat(ly, "alpha", 0.0f, 1f);
        fadeInLY.setDuration(800);

        ly.setVisibility(View.VISIBLE);
        mAnimationSet.play(fadeInLY);
        mAnimationSet.start();
    }
    //endregion
    //endregion
    //endregion
}