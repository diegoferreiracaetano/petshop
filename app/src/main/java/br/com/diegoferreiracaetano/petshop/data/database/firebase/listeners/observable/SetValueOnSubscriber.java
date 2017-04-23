package br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners.observable;


import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class SetValueOnSubscriber<T, U> implements ObservableOnSubscribe<U> {

    private final T value;
    private final DatabaseReference databaseReference;
    private final U returnValue;

    SetValueOnSubscriber(T value, DatabaseReference databaseReference, U returnValue) {
        this.value = value;
        this.databaseReference = databaseReference;
        this.returnValue = returnValue;
    }

    @Override
    public void subscribe(ObservableEmitter<U> e) throws Exception {
        databaseReference.setValue(value, new RxCompletionListener<>(e, returnValue));
    }

    private static class RxCompletionListener<T> implements DatabaseReference.CompletionListener {

        private final ObservableEmitter<? super T> subscriber;
        private final T successValue;


        public RxCompletionListener(ObservableEmitter<? super T> subscriber, T successValue) {
            this.subscriber = subscriber;
            this.successValue = successValue;
        }

        @Override
        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
            if (databaseError == null) {
                subscriber.onNext(successValue);
                subscriber.onComplete();
            } else {
                subscriber.onError(databaseError.toException());
            }
        }
    }

}
