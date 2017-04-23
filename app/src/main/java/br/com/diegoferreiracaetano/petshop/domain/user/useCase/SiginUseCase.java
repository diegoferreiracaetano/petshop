package br.com.diegoferreiracaetano.petshop.domain.user.useCase;


import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.data.database.interfaces.UserRepository;
import br.com.diegoferreiracaetano.petshop.domain.useCase.UseCaseSingle;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import br.com.diegoferreiracaetano.petshop.util.dagger.qualify.Firebase;
import io.reactivex.Observable;
import io.reactivex.Single;

public class SiginUseCase extends UseCaseSingle<User,SiginUseCase.Request>{

    private UserRepository mRepository;

    @Inject
    public SiginUseCase(@Firebase UserRepository repository) {
        this.mRepository = repository;
    }

    @Override
    protected Single<User> createSingle(Request request) {
        return null;
    }

    public static final class Request extends UseCaseSingle.Request {

    }
}
