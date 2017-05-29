package br.com.diegoferreiracaetano.petshop.domain.useCase;


import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCaseMaybe<T, R extends UseCaseMaybe.Request> {

    protected abstract Maybe<T> createMaybe(R request);

    public Maybe<T> execute(R request){

        return createMaybe(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static abstract class Request {
    }
}




