package br.com.diegoferreiracaetano.petshop;

import android.app.Activity;

import br.com.diegoferreiracaetano.petshop.presentation.login.LoginActivity;
import br.com.diegoferreiracaetano.petshop.presentation.login.LoginSubcomponent;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public abstract class BuildersModule {

    @Binds
    @IntoMap
    @ActivityKey(LoginActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>  bindLoginActivityInjectorFactory(LoginSubcomponent.Builder builder);
}
