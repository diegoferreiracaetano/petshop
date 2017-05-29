package br.com.diegoferreiracaetano.petshop.data.database.interfaces;

import java.util.List;

import br.com.diegoferreiracaetano.petshop.domain.user.User;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface UserRepository {

    Maybe<User> getUser(String email);

    Flowable<List<User>> getList();
}
