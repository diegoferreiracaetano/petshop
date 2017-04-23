package br.com.diegoferreiracaetano.petshop.domain.useCase;


import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCaseFlowable<T, R extends UseCaseFlowable.Request> {

    protected abstract Flowable<T> createFlowable(R request);

    public Flowable<T> execute(R request){

        return createFlowable(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static abstract class Request {
    }
}




