package br.com.diegoferreiracaetano.petshop.presentation.login;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.domain.user.User;
import br.com.diegoferreiracaetano.petshop.domain.user.useCase.GetUserUseCase;
import br.com.diegoferreiracaetano.petshop.domain.user.useCase.ListUserUseCase;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.DisposableLambdaObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subscribers.DisposableSubscriber;

public class LoginPresenter implements LoginContract.Presenter {


    private static final String TAG = LoginPresenter.class.getSimpleName();

    LoginContract.View mView;
    ListUserUseCase mListUserUseCase;
    GetUserUseCase mGetUserUseCase;
    private CompositeDisposable mDisposable;

    @Inject
    public LoginPresenter(LoginContract.View mView, ListUserUseCase listUserUseCase, GetUserUseCase getUserUseCase) {
        this.mView = mView;
        this.mListUserUseCase = listUserUseCase;
        this.mGetUserUseCase = getUserUseCase;
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

    /*   @Override
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
    }*/

    public void getListUsers() {
        mDisposable.add(mListUserUseCase.execute(new ListUserUseCase.Request()).subscribeWith(new DisposableSubscriber<List<User>>() {
            @Override
            public void onNext(List<User> users) {
                Log.d("USER", users.toString());
            }

            @Override
            public void onError(Throwable t) {
                Log.e("USER", t.getMessage());
            }

            @Override
            public void onComplete() {

            }
        }));
    }

    @Override
    public void getUser() {

        mGetUserUseCase.execute(new GetUserUseCase.Request()).subscribe(new SingleObserver<User>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onSuccess(User user) {
                Log.d(TAG, " onNext value : " + user);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, " onError : " + e.getMessage());
            }
        });
    }
}
