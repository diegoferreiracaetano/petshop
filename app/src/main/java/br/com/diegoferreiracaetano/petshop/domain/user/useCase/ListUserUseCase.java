package br.com.diegoferreiracaetano.petshop.domain.user.useCase;


import java.util.List;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.data.database.interfaces.UserRepository;
import br.com.diegoferreiracaetano.petshop.domain.useCase.UseCaseFlowable;
import br.com.diegoferreiracaetano.petshop.domain.useCase.UseCaseObservable;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import br.com.diegoferreiracaetano.petshop.util.dagger.qualify.Firebase;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class ListUserUseCase extends UseCaseFlowable<List<User>, ListUserUseCase.Request> {

    UserRepository mRepository;

    @Inject
    public ListUserUseCase(@Firebase UserRepository userRepository) {
        this.mRepository = userRepository;
    }

    @Override
    protected Flowable<List<User>> createFlowable(Request request) {
        return mRepository.getList();
    }


    public static final class Request extends UseCaseFlowable.Request {

    }
}
