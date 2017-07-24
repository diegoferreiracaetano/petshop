package br.com.diegoferreiracaetano.petshop;

import android.util.Log;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class AppApplication extends DaggerApplication{

    private static final String TAG = AppApplication.class.getSimpleName();

    @Inject
    void logInjection() {
        Log.i(TAG, "Injecting " + AppApplication.class.getSimpleName());
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<AppApplication> applicationInjector() {

        return DaggerAppComponent.builder().create(this);
    }
}