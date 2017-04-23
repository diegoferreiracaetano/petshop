package br.com.diegoferreiracaetano.petshop.presentation.login;

import br.com.diegoferreiracaetano.petshop.ApplicationComponent;
import br.com.diegoferreiracaetano.petshop.data.database.interfaces.RepositoryComponent;
import br.com.diegoferreiracaetano.petshop.util.dagger.scope.ActivityScope;
import dagger.Component;

@ActivityScope
@Component(dependencies = {ApplicationComponent.class, RepositoryComponent.class},modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);
}
