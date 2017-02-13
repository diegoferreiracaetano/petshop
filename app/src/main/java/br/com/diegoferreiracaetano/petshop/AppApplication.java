package br.com.diegoferreiracaetano.petshop;

import android.app.Application;

import br.com.diegoferreiracaetano.petshop.data.repository.DaggerRepositoryComponent;
import br.com.diegoferreiracaetano.petshop.data.repository.RepositoryComponent;
import br.com.diegoferreiracaetano.petshop.data.repository.firebase.FirebaseRepositoryModule;

public class AppApplication extends Application{

    private static ApplicationComponent mApplicationComponent;
    private static RepositoryComponent mRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

       mApplicationComponent =  DaggerApplicationComponent.builder()
                                .applicationModule(new ApplicationModule(getApplicationContext()))
                                .build();

       mRepositoryComponent = DaggerRepositoryComponent.builder()
                                .firebaseRepositoryModule(new FirebaseRepositoryModule())
                                .build();

    }

    public static ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public static RepositoryComponent getRepositoryComponent() {
        return mRepositoryComponent;
    }
}
