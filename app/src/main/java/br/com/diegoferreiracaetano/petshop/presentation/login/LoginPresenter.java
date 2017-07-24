package br.com.diegoferreiracaetano.petshop.presentation.login;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.R;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import br.com.diegoferreiracaetano.petshop.domain.user.useCase.LoginUseCase;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableMaybeObserver;

public class LoginPresenter implements LoginContract.Presenter {


    private static final String TAG = LoginPresenter.class.getSimpleName();

    LoginContract.View mView;
    LoginUseCase mLoginUseCase;
    private CompositeDisposable mDisposable;

    @Inject
    public LoginPresenter(LoginContract.View view, LoginUseCase loginUseCase) {
        mView = view;
        mLoginUseCase = loginUseCase;
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


        mLoginUseCase.execute(new LoginUseCase.Request(email,password)).subscribeWith(new DisposableMaybeObserver<User>() {
            @Override
            public void onSuccess(User value) {
                if(value.getName() == null){
                    mView.showMessageError(R.string.title_user_not_found, R.string.msg_error_user_not_found);
                }else{
                    mView.show();
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.showMessageError(R.string.title_error,R.string.msg_error_general);
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
