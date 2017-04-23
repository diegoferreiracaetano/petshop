package br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners.flowable;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.Map;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;

public class FirebaseFlowableListeners {

    public <T> Flowable<T> listenToSingleValueEvents(Query query, Function<DataSnapshot, T> marshaller) {
        return Flowable.create(new ListenToSingleValueOnSubscribe(query, marshaller), BackpressureStrategy.ERROR);
    }

    public <T, U> Flowable<U> setValueOnSubscriber(T value, DatabaseReference databaseReference, U returnValue) {
        return Flowable.create(new SetValueOnSubscriber(value, databaseReference, returnValue),BackpressureStrategy.ERROR);
    }

    public <T , U> Flowable<U> updateValueOnSubscriber(Map<String, T> value, DatabaseReference databaseReference, U returnValue) {
        return Flowable.create(new UpdateValueOnSubscriber(value, databaseReference, returnValue),BackpressureStrategy.ERROR);
    }

    public <U> Flowable<U> removeValueOnSubscriber(DatabaseReference databaseReference, U returnValue) {
        return Flowable.create(new RemoveValueOnSubscriber(databaseReference, returnValue),BackpressureStrategy.ERROR);
    }



}
