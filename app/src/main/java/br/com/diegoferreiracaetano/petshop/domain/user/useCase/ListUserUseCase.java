package br.com.diegoferreiracaetano.petshop.domain.user.useCase;


import java.util.List;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.data.database.interfaces.UserRepository;
import br.com.diegoferreiracaetano.petshop.domain.interfaces.InteractorMaybe;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import io.reactivex.Maybe;

public class ListUserUseCase extends InteractorMaybe<List<User>, ListUserUseCase.Request> {

    UserRepository mRepository;

    @Inject
    public ListUserUseCase(UserRepository userRepository) {
        this.mRepository = userRepository;
    }

    @Override
    protected Maybe<List<User>> create(Request request) {
        return mRepository.getList();
    }


    public static final class Request extends InteractorMaybe.Request {

    }
}
