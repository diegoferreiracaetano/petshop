package br.com.diegoferreiracaetano.petshop.data.repository.firebase;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.data.repository.UserRepository;
import br.com.diegoferreiracaetano.petshop.data.repository.firebase.listeners.FirebaseFunctions;
import br.com.diegoferreiracaetano.petshop.data.repository.firebase.listeners.FirebaseObservableListeners;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class UserFirebaseRepository  implements UserRepository{

    private DatabaseReference mRoot;
    private final FirebaseObservableListeners mFirebaseObservableListeners;


    @Inject
    public UserFirebaseRepository(@NonNull DatabaseReference reference, FirebaseObservableListeners listeners) {
        this.mRoot = reference;
        this.mFirebaseObservableListeners = listeners;
    }

    @Override
    public Observable<User> signIn(User user) {
        return null;
    }

    @Override
    public Observable<User> getUser() {
        /*return Query userRef = mRootReference
                .child(USERS)
                .child("e3b1d2205dc352dc1cd73bbf42112e03");*/
        return null;
    }

    @Override
    public Observable<List<User>> getList() {
        Query query = mRoot.child("user");
        return mFirebaseObservableListeners.listValuesEvent(query,new FirebaseFunctions<User>(User.class).getList());
    }


}
