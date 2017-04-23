package br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners.single;


import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.Map;

import io.reactivex.SingleEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.SingleOnSubscribe;

public class UpdateValueOnSubscriber<T, U> implements SingleOnSubscribe<U> {

    private final Map<String, T>  value;
    private final DatabaseReference databaseReference;
    private final U returnValue;

    UpdateValueOnSubscriber(Map<String, T> value, DatabaseReference databaseReference, U returnValue) {
        this.value = value;
        this.databaseReference = databaseReference;
        this.returnValue = returnValue;
    }

    @Override
    public void subscribe(SingleEmitter<U> e) throws Exception {
        databaseReference.updateChildren((Map<String, Object>) value, new RxCompletionListener<>(e, returnValue));
    }

    private static class RxCompletionListener<T> implements DatabaseReference.CompletionListener {

        private final SingleEmitter<? super T> subscriber;
        private final T successValue;


        public RxCompletionListener(SingleEmitter<? super T> subscriber, T successValue) {
            this.subscriber = subscriber;
            this.successValue = successValue;
        }

        @Override
        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
            if (databaseError == null) {
                subscriber.onSuccess(successValue);
            } else {
                subscriber.onError(databaseError.toException());
            }
        }
    }

}
