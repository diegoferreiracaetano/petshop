package br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.Map;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.functions.Function;

public class FirebaseObservableListeners {

    public <T> Maybe<T> singleValeu(Query query, Function<DataSnapshot, T> marshaller) {
        return Maybe.create(new GetMaybeValueOnSubscribe<>(query, marshaller));
    }

    public <T> Flowable<T> realTimeValeu(Query query, Function<DataSnapshot, T> marshaller) {
        return Flowable.create(new ListenValueOnSubscribe<>(query, marshaller), BackpressureStrategy.BUFFER);
    }

    public <T> Completable setValue(T value, DatabaseReference databaseReference) {
        return Completable.create(new SetValueOnSubscriber(value, databaseReference));
    }

    public <T> Completable updateValue(Map<String, T> value, DatabaseReference databaseReference) {
        return Completable.create(new UpdateValueOnSubscriber(value, databaseReference));
    }

    public <U> Completable removeValue(DatabaseReference databaseReference) {
        return Completable.create(new RemoveValueOnSubscriber(databaseReference));
    }
}
