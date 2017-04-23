package br.com.diegoferreiracaetano.petshop;

import android.app.Application;

import br.com.diegoferreiracaetano.petshop.data.database.interfaces.DaggerRepositoryComponent;
import br.com.diegoferreiracaetano.petshop.data.database.interfaces.RepositoryComponent;
import br.com.diegoferreiracaetano.petshop.data.database.firebase.FirebaseRepositoryModule;
import br.com.diegoferreiracaetano.petshop.data.storage.firebase.StorageFirebaseModule;
import br.com.diegoferreiracaetano.petshop.data.storage.interfaces.DaggerStorageComponent;
import br.com.diegoferreiracaetano.petshop.data.storage.interfaces.StorageComponent;

public class AppApplication extends Application{

    private static ApplicationComponent mApplicationComponent;
    private static RepositoryComponent mRepositoryComponent;
    private static StorageComponent mStorageComponent;

    @Override
    public void onCreate() {
        super.onCreate();

       mApplicationComponent =  DaggerApplicationComponent.builder()
                                .applicationModule(new ApplicationModule(getApplicationContext()))
                                .build();

       mRepositoryComponent = DaggerRepositoryComponent.builder()
                                .firebaseRepositoryModule(new FirebaseRepositoryModule())
                                .build();


        mStorageComponent = DaggerStorageComponent.builder()
                .storageFirebaseModule(new StorageFirebaseModule())
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public static RepositoryComponent getRepositoryComponent() {
        return mRepositoryComponent;
    }

    public static StorageComponent getStorageComponent() {
        return mStorageComponent;
    }
}
