package br.com.diegoferreiracaetano.petshop.presentation.login;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = LoginSubcomponent.class)
public abstract class LoginModule {

    @Binds abstract LoginContract.View provideView(LoginActivity loginActivity);

}
