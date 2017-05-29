package br.com.diegoferreiracaetano.petshop.data.database.firebase.listeners.observable;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

public class ListenToSingleValueOnSubscribe<T> implements ObservableOnSubscribe<T> {

    private Query mQuery;
    private Function<DataSnapshot, T> mMarshaller;


    public ListenToSingleValueOnSubscribe(Query query, Function<DataSnapshot, T> marshaller) {
        mQuery = query;
        mMarshaller = marshaller;
    }

    @Override
    public void subscribe(ObservableEmitter<T> e) throws Exception {
        mQuery.addListenerForSingleValueEvent(new RxSingleValueListener<>(e, mMarshaller));
    }


    private static class RxSingleValueListener<T> implements ValueEventListener {

        private final ObservableEmitter<T> subscriber;
        private final Function<DataSnapshot, T> marshaller;

        RxSingleValueListener(ObservableEmitter<T> subscriber, Function<DataSnapshot, T> marshaller) {
            this.subscriber = subscriber;
            this.marshaller = marshaller;
        }

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            try {

                if(marshaller.apply(dataSnapshot) != null)
                    subscriber.onNext(marshaller.apply(dataSnapshot));


                subscriber.onComplete();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            subscriber.onError(databaseError.toException());
        }
    }
}
