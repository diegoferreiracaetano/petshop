package br.com.diegoferreiracaetano.petshop.data.storage.interfaces;

import br.com.diegoferreiracaetano.petshop.data.storage.firebase.StorageFirebaseModule;
import br.com.diegoferreiracaetano.petshop.util.dagger.qualify.Firebase;
import dagger.Component;

@Component(modules = {StorageFirebaseModule.class})
public interface StorageComponent {

    @Firebase
    StorageInterface getFirebaseStorage();


}
