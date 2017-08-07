package br.com.diegoferreiracaetano.petshop.di.modules;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthModule {

    @Provides
    FirebaseAuth getFirebaseAuth(){
        return FirebaseAuth.getInstance();
    }
}
