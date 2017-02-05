package br.com.diegoferreiracaetano.petshop.data.persitence.firebase;

import java.util.List;

import io.reactivex.Observable;

public interface Repository {

    void save(Object object);

    void update(Object object);

    List<Observable<Object>> getList(Object object);


}

