package br.com.diegoferreiracaetano.petshop.domain.user.useCase;


import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.data.repository.UserRepository;
import br.com.diegoferreiracaetano.petshop.domain.UseCase;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import br.com.diegoferreiracaetano.petshop.util.dagger.qualify.Firebase;
import io.reactivex.Observable;

public class SiginUseCase extends UseCase<User,SiginUseCase.Request>{

    private UserRepository mRepository;

    @Inject
    public SiginUseCase(@Firebase UserRepository repository) {
        this.mRepository = repository;
    }

    @Override
    protected Observable<User> createObservable(Request request) {
        return null;
    }

    public static final class Request extends UseCase.Request {

    }
}
