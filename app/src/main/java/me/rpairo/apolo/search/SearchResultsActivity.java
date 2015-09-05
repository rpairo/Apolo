package me.rpairo.apolo.search;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import me.rpairo.apolo.MainActivity;

/**
 * Created by Raul on 5/9/15.
 */
public class SearchResultsActivity extends Activity{

    //region Funciones
    //region Funciones de la Activity
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }
    //endregion

    //region Funciones de usabilidad
    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            //texto obtenido
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.d(MainActivity.LOG, query);
        }
    }
    //endregion
    //endregion
}
