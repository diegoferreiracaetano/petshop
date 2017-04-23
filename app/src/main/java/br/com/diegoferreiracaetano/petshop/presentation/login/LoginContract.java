package br.com.diegoferreiracaetano.petshop.presentation.login;


import java.util.List;

import br.com.diegoferreiracaetano.petshop.presentation.BasePresenter;
import br.com.diegoferreiracaetano.petshop.presentation.BaseView;

public interface LoginContract  {

    interface Presenter extends BasePresenter{

        void getListUsers();

        void getUser();
    }

    interface View extends BaseView<Presenter> {

    }
}
