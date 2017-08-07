package br.com.diegoferreiracaetano.petshop.di.modules;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.diegoferreiracaetano.petshop.data.database.firebase.UserFirebaseRepository;
import br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners.FirebaseObservableListeners;
import br.com.diegoferreiracaetano.petshop.data.database.interfaces.UserRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    DatabaseReference getDatabaseReference(){
        return FirebaseDatabase.getInstance().getReference();
    }

    @Provides
    FirebaseObservableListeners getObservableListeners() {
        return new FirebaseObservableListeners();
    }


    @Provides
    UserRepository getUserFirebaseRepository(DatabaseReference reference, FirebaseObservableListeners mFirebaseObservableListeners){
        return new UserFirebaseRepository(reference, mFirebaseObservableListeners);
    }
}
