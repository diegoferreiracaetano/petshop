package br.com.diegoferreiracaetano.petshop.presentation;

import android.support.annotation.NonNull;

public interface BaseView<T> {

   void setPresenter(@NonNull T presenter);

   void showMessageError(int title,int msg);

}