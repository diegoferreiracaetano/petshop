package br.com.diegoferreiracaetano.petshop.presentation.login;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.R;
import br.com.diegoferreiracaetano.petshop.domain.user.interactor.LoginInteractor;
import io.reactivex.disposables.CompositeDisposable;

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
        if(email.isEmpty()){
            mView.showErrorEmail(R.string.msg_error_login_empty);
            return;
        }

        if(password.isEmpty()){
            mView.showErrorPassword(R.string.msg_error_password_empty);
            return;
        }
    }
}
