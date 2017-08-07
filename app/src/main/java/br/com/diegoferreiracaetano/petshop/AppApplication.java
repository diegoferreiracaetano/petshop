package br.com.diegoferreiracaetano.petshop;

import br.com.diegoferreiracaetano.petshop.di.components.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class AppApplication extends DaggerApplication{

    @Override
    protected AndroidInjector<AppApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}