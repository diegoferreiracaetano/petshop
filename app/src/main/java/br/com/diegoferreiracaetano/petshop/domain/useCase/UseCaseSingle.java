package br.com.diegoferreiracaetano.petshop.domain.useCase;


import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCaseSingle<T, R extends UseCaseSingle.Request> {

    protected abstract Single<T> createSingle(R request);

    public Single<T> execute(R request){

        return createSingle(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static abstract class Request {
    }
}




