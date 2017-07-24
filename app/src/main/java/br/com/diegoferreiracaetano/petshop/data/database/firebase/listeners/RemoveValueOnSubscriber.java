package br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners;


import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;

public class RemoveValueOnSubscriber implements CompletableOnSubscribe {
    private final DatabaseReference databaseReference;

    RemoveValueOnSubscriber(DatabaseReference databaseReference) {
        this.databaseReference = databaseReference;
    }

    @Override
    public void subscribe(CompletableEmitter e) throws Exception {
        databaseReference.removeValue(new RxCompletionListener(e));
    }

    private static class RxCompletionListener implements DatabaseReference.CompletionListener {

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
