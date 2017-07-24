package br.com.diegoferreiracaetano.petshop.presentation;

import android.support.annotation.NonNull;

public interface BaseView<T> {

   void showMessageError(int title,int msg);

}