package br.com.diegoferreiracaetano.petshop.domain.interfaces;


import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class InteractorMaybe<T, R extends InteractorMaybe.Request> {

    protected abstract Maybe<T> create(R request);

    public Maybe<T> execute(R request){

        return create(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static abstract class Request {
    }
}




