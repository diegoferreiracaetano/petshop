package br.com.diegoferreiracaetano.petshop.data.repository.firebase.listeners;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Query;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class FirebaseObservableListeners {

    public<T>Observable<T> listValuesEvent(Query query, Function<DataSnapshot, T> mFunction){
        return Observable.create(new ListenValueOnSubscribe<T>(query,mFunction));
    }
}
