package br.com.diegoferreiracaetano.petshop.data.database.firebase;

import android.support.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.List;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners.flowable.FirebaseFlowableListeners;
import br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners.observable.FirebaseObservableListeners;
import br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners.single.FirebaseSingleListeners;
import br.com.diegoferreiracaetano.petshop.data.database.firebase.utils.FirebaseFunctions;
import br.com.diegoferreiracaetano.petshop.data.database.interfaces.UserRepository;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import br.com.diegoferreiracaetano.petshop.util.Md5Helper;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class UserFirebaseRepository extends FirebaseFunctions<User> implements UserRepository {

    private DatabaseReference mRoot;
    private final FirebaseSingleListeners mFirebaseSingleListeners;
    private final FirebaseObservableListeners mFirebaseObservableListeners;
    private final FirebaseFlowableListeners mFirebaseFlowableListeners;

    @Inject
    public UserFirebaseRepository(@NonNull DatabaseReference reference,
                                  FirebaseObservableListeners firebaseObservableListeners,
                                  FirebaseSingleListeners firebaseSingleListeners,
                                  FirebaseFlowableListeners firebaseFlowableListeners) {

        this.mRoot = reference;
        this.mFirebaseSingleListeners = firebaseSingleListeners;
        this.mFirebaseObservableListeners = firebaseObservableListeners;
        this.mFirebaseFlowableListeners = firebaseFlowableListeners;
    }

    @Override
    public Observable<User> signIn(User user) {
        return null;
    }

    @Override
    public Single<User> getUser() {
        String key = Md5Helper.add("di.cafe@hotmail.com");

        Query query = mRoot.child("users")
                    .child(key);

        return mFirebaseSingleListeners.listenToSingleValueEvents(query,toClass());
    }

    @Override
    public Flowable<List<User>> getList() {
        Query query = mRoot.child("users");
        return mFirebaseFlowableListeners.listenToSingleValueEvents(query,toList());
    }


}

