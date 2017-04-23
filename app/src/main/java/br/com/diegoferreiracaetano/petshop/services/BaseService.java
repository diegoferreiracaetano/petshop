package br.com.diegoferreiracaetano.petshop.services;

import android.support.annotation.NonNull;

public interface BaseService<T> {

    void setPresenter(@NonNull T presenter);

}
