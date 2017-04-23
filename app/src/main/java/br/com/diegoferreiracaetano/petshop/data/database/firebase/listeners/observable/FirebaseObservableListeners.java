package br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners.observable;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class FirebaseObservableListeners {

    public <T> Observable<T> listenToSingleValueEvents(Query query, Function<DataSnapshot, T> marshaller) {
        return Observable.create(new ListenToSingleValueOnSubscribe<>(query, marshaller));
    }

    public <T, U> Observable<U> setValueOnSubscriber(T value, DatabaseReference databaseReference, U returnValue) {
        return Observable.create(new SetValueOnSubscriber(value, databaseReference, returnValue));
    }

    public <T , U> Observable<U> updateValueOnSubscriber(Map<String, T> value, DatabaseReference databaseReference, U returnValue) {
        return Observable.create(new UpdateValueOnSubscriber(value, databaseReference, returnValue));
    }

    public <U> Observable<U> removeValueOnSubscriber(DatabaseReference databaseReference, U returnValue) {
        return Observable.create(new RemoveValueOnSubscriber(databaseReference, returnValue));
    }



}
