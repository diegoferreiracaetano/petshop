package br.com.diegoferreiracaetano.petshop.data.storage.interfaces;

import br.com.diegoferreiracaetano.petshop.data.storage.firebase.StorageFirebaseModule;
import dagger.Component;

@Component(modules = {StorageFirebaseModule.class})
public interface StorageComponent {

    StorageInterface getFirebaseStorage();


}
