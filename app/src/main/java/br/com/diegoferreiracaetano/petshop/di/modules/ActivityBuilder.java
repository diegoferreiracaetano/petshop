package br.com.diegoferreiracaetano.petshop.di.modules;

import br.com.diegoferreiracaetano.petshop.presentation.login.LoginActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {LoginModule.class})
    abstract LoginActivity contributeLoginActivity();

}