package br.com.diegoferreiracaetano.petshop.presentation.login;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.R;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import br.com.diegoferreiracaetano.petshop.domain.user.interactor.LoginInteractor;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableMaybeObserver;

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View mView;
    LoginInteractor mLoginInteractor;

    private CompositeDisposable mDisposable;

    @Inject
    public LoginPresenter(LoginContract.View view, LoginInteractor loginInteractor) {
        mView = view;
        mLoginInteractor = loginInteractor;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroyView() {
        mDisposable.dispose();
    }

    @Override
    public void login(String email, String password) {

        if (email.isEmpty()) {
            mView.showErrorEmail();
            return;
        }

        if (password.isEmpty()) {
            mView.showErrorPassword();
            return;
        }

        mDisposable.add(mLoginInteractor.execute(new LoginInteractor.Request(email,password)).subscribeWith(new DisposableMaybeObserver<User>() {
            @Override
            public void onSuccess(User value) {
                mView.show();
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorUser(e);
            }

            @Override
            public void onComplete() {
                mView.showUserNotFound();
            }
        }));
    }
}
