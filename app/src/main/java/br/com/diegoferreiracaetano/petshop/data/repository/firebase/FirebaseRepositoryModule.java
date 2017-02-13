package br.com.diegoferreiracaetano.petshop.data.repository.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.diegoferreiracaetano.petshop.data.repository.UserRepository;
import br.com.diegoferreiracaetano.petshop.data.repository.firebase.listeners.FirebaseObservableListeners;
import br.com.diegoferreiracaetano.petshop.util.dagger.qualify.Firebase;
import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseRepositoryModule {

    @Provides
    DatabaseReference getDatabaseReference(){
        return FirebaseDatabase.getInstance().getReference();
    }

    @Provides
    FirebaseObservableListeners getObservableListeners() {
        return new FirebaseObservableListeners();
    }


    @Provides
    @Firebase
    UserRepository getUserFirebaseRepository(DatabaseReference reference,FirebaseObservableListeners mFirebaseObservableListeners){
        return new UserFirebaseRepository(reference, mFirebaseObservableListeners);
    }
}
