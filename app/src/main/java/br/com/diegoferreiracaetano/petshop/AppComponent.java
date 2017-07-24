package br.com.diegoferreiracaetano.petshop;

import javax.inject.Singleton;

import br.com.diegoferreiracaetano.petshop.presentation.login.LoginModule;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class,BuildersModule.class})
public interface AppComponent extends AndroidInjector<AppApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<AppApplication> {}

}
