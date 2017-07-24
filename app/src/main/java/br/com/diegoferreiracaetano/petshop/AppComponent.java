package br.com.diegoferreiracaetano.petshop;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class,ActivityModule.class})
public interface AppComponent extends AndroidInjector<AppApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<AppApplication> {}

}
