package br.com.diegoferreiracaetano.petshop.domain.user.useCase;


import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.data.repository.UserRepository;
import br.com.diegoferreiracaetano.petshop.domain.UseCase;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import br.com.diegoferreiracaetano.petshop.util.dagger.qualify.Firebase;
import io.reactivex.Observable;

public class GetUserUseCase extends UseCase<User,SiginUseCase.Request> {

    UserRepository mRepository;

    @Inject
    public GetUserUseCase(@Firebase UserRepository mRepository) {
        this.mRepository = mRepository;
    }

    @Override
    protected Observable<User> createObservable(SiginUseCase.Request request) {
        return null;
    }


    public static final class Request extends UseCase.Request {

    }
}
