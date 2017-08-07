package br.com.diegoferreiracaetano.petshop.di.components;

import br.com.diegoferreiracaetano.petshop.di.modules.RepositoryModule;
import br.com.diegoferreiracaetano.petshop.data.database.interfaces.UserRepository;
import dagger.Component;

@Component(modules = {RepositoryModule.class})
public interface RepositoryComponent {

    UserRepository getUserRepository();
}
