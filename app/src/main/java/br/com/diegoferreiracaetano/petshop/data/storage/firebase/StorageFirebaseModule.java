package br.com.diegoferreiracaetano.petshop.data.storage.firebase;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import br.com.diegoferreiracaetano.petshop.data.storage.interfaces.StorageInterface;
import br.com.diegoferreiracaetano.petshop.util.FileManager;
import br.com.diegoferreiracaetano.petshop.util.dagger.qualify.Firebase;
import dagger.Module;
import dagger.Provides;

@Module
public class StorageFirebaseModule {


    @Provides
    StorageReference getDatabaseReference() {
        return FirebaseStorage.getInstance().getReference();
    }

    @Provides
    FileManager getFileManager() {
        return new FileManager();
    }

    @Provides
    @Firebase
    StorageInterface getStorageFirebase(StorageReference storageReference) {
        return new StorageFirebase(storageReference);
    }

}
