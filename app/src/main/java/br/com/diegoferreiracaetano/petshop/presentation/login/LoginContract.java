package br.com.diegoferreiracaetano.petshop.presentation.login;


import java.util.List;

import br.com.diegoferreiracaetano.petshop.presentation.BasePresenter;
import br.com.diegoferreiracaetano.petshop.presentation.BaseView;

public interface LoginContract  {

    interface Presenter extends BasePresenter{

        void login(String email,String password);

    }

    interface View extends BaseView<Presenter> {
        void show();
        void showErrorEmail(int msg);
        void showErrorPassword(int msg);

    }
}
