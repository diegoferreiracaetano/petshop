package br.com.diegoferreiracaetano.petshop.presentation.login;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.domain.user.User;
import br.com.diegoferreiracaetano.petshop.domain.user.useCase.ListUserUseCase;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.internal.observers.DisposableLambdaObserver;
import io.reactivex.observers.DisposableObserver;

public class LoginPresenter implements LoginContract.Presenter {


    LoginContract.View mView;
    ListUserUseCase mListUserUseCase;
    private CompositeDisposable mDisposable;

    @Inject
    public LoginPresenter(LoginContract.View mView, ListUserUseCase listUserUseCase) {
        this.mView = mView;
        this.mListUserUseCase = listUserUseCase;
        this.mDisposable = new CompositeDisposable();
    }



    @Override
    public void onStart() {

    }

    @Override
    public void onDestroyView() {
        mDisposable.dispose();
    }


    @Inject
    public void setupListeners() {
        mView.setPresenter(this);
    }

    @Override
    public void getListUsers() {
        mDisposable.add(mListUserUseCase.execute(new ListUserUseCase.Request()).subscribeWith(new DisposableObserver<List<User>>() {
            @Override
            public void onNext(List<User> users) {

                Log.d("USER", users.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }));
    }



}
