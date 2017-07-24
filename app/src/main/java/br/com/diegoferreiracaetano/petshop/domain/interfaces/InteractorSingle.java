package br.com.diegoferreiracaetano.petshop.domain.interfaces;


import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class InteractorSingle<T, R extends InteractorSingle.Request> {

    protected abstract Single<T> create(R request);

    public Single<T> execute(R request){

        return create(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static abstract class Request {
    }
}




