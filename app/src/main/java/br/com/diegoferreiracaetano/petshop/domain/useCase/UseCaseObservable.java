package br.com.diegoferreiracaetano.petshop.domain.useCase;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCaseObservable<T, R extends UseCaseObservable.Request> {

    protected abstract Observable<T> createObservable(R request);

    public Observable<T> execute(R request){

        return createObservable(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static abstract class Request {
    }
}




