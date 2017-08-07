package br.com.diegoferreiracaetano.petshop.di.components;

import br.com.diegoferreiracaetano.petshop.di.modules.AuthModule;
import br.com.diegoferreiracaetano.petshop.di.modules.RepositoryModule;
import br.com.diegoferreiracaetano.petshop.di.modules.ActivityBuilder;
import br.com.diegoferreiracaetano.petshop.AppApplication;
import br.com.diegoferreiracaetano.petshop.di.modules.AppModule;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        AppModule.class,
        RepositoryModule.class,
        AuthModule.class
})
public interface AppComponent extends AndroidInjector<AppApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<AppApplication> {}

}
