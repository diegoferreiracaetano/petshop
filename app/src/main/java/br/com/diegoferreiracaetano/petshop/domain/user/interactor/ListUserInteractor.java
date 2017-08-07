package br.com.diegoferreiracaetano.petshop.domain.user.interactor;


import java.util.List;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.data.database.interfaces.UserRepository;
import br.com.diegoferreiracaetano.petshop.domain.interfaces.InteractorMaybe;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import io.reactivex.Maybe;

public class ListUserInteractor extends InteractorMaybe<List<User>, ListUserInteractor.Request> {

    UserRepository mRepository;

    @Inject
    public ListUserInteractor(UserRepository userRepository) {
        this.mRepository = userRepository;
    }

    @Override
    protected Maybe<List<User>> create(Request request) {
        return mRepository.getList();
    }


    public static final class Request extends InteractorMaybe.Request {

    }
}
