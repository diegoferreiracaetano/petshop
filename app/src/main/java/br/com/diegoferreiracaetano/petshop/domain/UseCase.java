package br.com.diegoferreiracaetano.petshop.domain;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class  UseCase<T, R extends UseCase.Request> {

    protected abstract Observable<T> createObservable(R request);

    public Observable<T> execute(R request){

        return createObservable(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static abstract class Request {
    }
}




