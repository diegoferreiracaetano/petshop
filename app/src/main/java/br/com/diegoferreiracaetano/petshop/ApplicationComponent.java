package br.com.diegoferreiracaetano.petshop;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context getContext();

    SharedPreferences getSharedPreferences();

}
