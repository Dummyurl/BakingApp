package com.example.boris.bakingapp.mvp.ui.mainActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.boris.bakingapp.R;
import com.example.boris.bakingapp.RecipeWidgetService;
import com.example.boris.bakingapp.RecipesWidgetProvider;
import com.example.boris.bakingapp.mvp.presentation.mainActivity.MainActivityPresenter;
import com.example.boris.bakingapp.mvp.presentation.mainActivity.MainView;
import com.example.boris.bakingapp.mvp.ui.recipeListFragment.RecipeListFragment;

import static com.example.boris.bakingapp.constants.Contract.TAG_VAR_VALUE;
import static com.example.boris.bakingapp.constants.Contract.TAG_WORK_CHECKING;


public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Log.d(TAG_WORK_CHECKING, "MainActivity - savedInstanceState == null");
            openFragment();
        }



//
       /*
        if (config.smallestScreenWidthDp >= 600)
        {

            setContentView(R.layout.activity_main);
        }
        else
        {
            Log.d(TAG_WORK_CHECKING, "MainActivity - onCreate - NOT config.smallestScreenWidthDp >= 600 ");
            setContentView(R.layout.activity_main);
            DetailedFragment detailedFragment = new DetailedFragment();
            //detailedFragment.onCreateView();
        }*/

    }


    @Override
    public void openFragment() {
        Log.d(TAG_WORK_CHECKING, "MainActivity - openFragment");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        RecipeListFragment recipeListFragment = new RecipeListFragment();
        fragmentTransaction.replace(R.id.main_frame_list, recipeListFragment);
        fragmentTransaction.commit();
    }

}
