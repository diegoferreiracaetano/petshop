package br.com.diegoferreiracaetano.petshop.data.database.interfaces;

import br.com.diegoferreiracaetano.petshop.data.database.firebase.FirebaseRepositoryModule;
import br.com.diegoferreiracaetano.petshop.util.dagger.qualify.Firebase;
import dagger.Component;

@Component(modules = {FirebaseRepositoryModule.class})
public interface RepositoryComponent {

    @Firebase
    UserRepository getUserRepository();
}
