package br.com.diegoferreiracaetano.petshop.presentation.login;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = LoginModule.class)
public interface LoginSubcomponent extends AndroidInjector<LoginActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<LoginActivity> {}

}
