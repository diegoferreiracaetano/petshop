package br.com.diegoferreiracaetano.petshop.data.repository;

import java.util.List;

import br.com.diegoferreiracaetano.petshop.domain.user.User;
import io.reactivex.Observable;

public interface UserRepository {

    Observable<User> signIn(User user);

    Observable<User> getUser();

    Observable<List<User>> getList();
}
