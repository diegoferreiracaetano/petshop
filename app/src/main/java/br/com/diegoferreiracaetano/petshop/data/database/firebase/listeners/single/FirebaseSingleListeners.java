package br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners.single;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.Map;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class FirebaseSingleListeners {

    public <T> Single<T> listenToSingleValueEvents(Query query, Function<DataSnapshot, T> marshaller) {

        return Single.create(new ListenToSingleValueOnSubscribe<>(query, marshaller));
    }

    public <T, U> Single<U> setValueOnSubscriber(T value, DatabaseReference databaseReference, U returnValue) {
        return Single.create(new SetValueOnSubscriber(value, databaseReference, returnValue));
    }

    public <T , U> Single<U> updateValueOnSubscriber(Map<String, T> value, DatabaseReference databaseReference, U returnValue) {
        return Single.create(new UpdateValueOnSubscriber(value, databaseReference, returnValue));
    }

    public <U> Single<U> removeValueOnSubscriber(DatabaseReference databaseReference, U returnValue) {
        return Single.create(new RemoveValueOnSubscriber(databaseReference, returnValue));
    }
}
