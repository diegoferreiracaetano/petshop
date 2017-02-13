package br.com.diegoferreiracaetano.petshop.domain.user.useCase;


import java.util.List;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.data.repository.UserRepository;
import br.com.diegoferreiracaetano.petshop.domain.UseCase;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import br.com.diegoferreiracaetano.petshop.util.dagger.qualify.Firebase;
import io.reactivex.Observable;

public class ListUserUseCase extends UseCase<List<User>, ListUserUseCase.Request>{

    UserRepository mRepository;

    @Inject
    public ListUserUseCase(@Firebase UserRepository userRepository) {
        this.mRepository = userRepository;
    }

    @Override
    protected Observable<List<User>> createObservable(Request request) {
        return mRepository.getList();
    }


    public static final class Request extends UseCase.Request {

    }
}
