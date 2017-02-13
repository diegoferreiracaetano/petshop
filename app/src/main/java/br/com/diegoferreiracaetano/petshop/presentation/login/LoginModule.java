package br.com.diegoferreiracaetano.petshop.presentation.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private LoginContract.View view;

    public LoginModule(LoginContract.View view) {
        this.view = view;
    }

    @Provides
    public LoginContract.View getView() {
        return view;
    }
}
