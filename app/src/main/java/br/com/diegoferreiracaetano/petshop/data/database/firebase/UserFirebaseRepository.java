package br.com.diegoferreiracaetano.petshop.data.database.firebase;

import android.support.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.List;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners.observable.FirebaseObservableListeners;
import br.com.diegoferreiracaetano.petshop.data.database.firebase.utils.FirebaseFunctions;
import br.com.diegoferreiracaetano.petshop.data.database.interfaces.UserRepository;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import br.com.diegoferreiracaetano.petshop.util.Md5Helper;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public class UserFirebaseRepository extends FirebaseFunctions<User> implements UserRepository {

    private DatabaseReference mRoot;
    private final FirebaseObservableListeners mFirebaseObservableListeners;

    @Inject
    public UserFirebaseRepository(@NonNull DatabaseReference reference,
                                  FirebaseObservableListeners firebaseObservableListeners) {

        this.mRoot = reference;
        this.mFirebaseObservableListeners = firebaseObservableListeners;
    }


    @Override
    public Maybe<User> getUser(String email) {
        String key = Md5Helper.add(email);
        Query query = mRoot.child("users").child(key);
        return mFirebaseObservableListeners.getMaybeValue(query,toClass());
    }

    @Override
    public Flowable<List<User>> getList() {
        Query query = mRoot.child("users");
        return mFirebaseObservableListeners.listenToSingleValueEvents(query,toList()).toFlowable(BackpressureStrategy.BUFFER);
    }


}

