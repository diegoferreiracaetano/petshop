package br.com.diegoferreiracaetano.petshop.domain.user.useCase;


import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.data.database.interfaces.UserRepository;
import br.com.diegoferreiracaetano.petshop.domain.useCase.UseCaseSingle;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import br.com.diegoferreiracaetano.petshop.util.dagger.qualify.Firebase;
import io.reactivex.Observable;
import io.reactivex.Single;

public class GetUserUseCase extends UseCaseSingle<User,GetUserUseCase.Request> {

    UserRepository mRepository;

    @Inject
    public GetUserUseCase(@Firebase UserRepository mRepository) {
        this.mRepository = mRepository;
    }

    @Override
    protected Single<User> createSingle(GetUserUseCase.Request request) {

        return mRepository.getUser();
    }


    public static final class Request extends UseCaseSingle.Request {

    }
}
