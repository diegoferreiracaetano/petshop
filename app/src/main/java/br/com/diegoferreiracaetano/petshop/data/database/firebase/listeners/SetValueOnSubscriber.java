package br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners;


import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;

public class SetValueOnSubscriber<T> implements CompletableOnSubscribe {

    private final T value;
    private final DatabaseReference databaseReference;

    SetValueOnSubscriber(T value, DatabaseReference databaseReference) {
        this.value = value;
        this.databaseReference = databaseReference;
    }

    @Override
    public void subscribe(CompletableEmitter e) throws Exception {
        databaseReference.setValue(value);
        e.onComplete();
    }

    private static class RxCompletionListener<T> implements DatabaseReference.CompletionListener {

        private final CompletableEmitter subscriber;


        public RxCompletionListener(CompletableEmitter subscriber) {
            this.subscriber = subscriber;
        }

        @Override
        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
            if (databaseError == null) {
                subscriber.onComplete();
            } else {
                subscriber.onError(databaseError.toException());
            }
        }
    }

}
