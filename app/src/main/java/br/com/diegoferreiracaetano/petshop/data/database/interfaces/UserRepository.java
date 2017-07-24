package br.com.diegoferreiracaetano.petshop.data.database.interfaces;

import java.util.List;

import br.com.diegoferreiracaetano.petshop.domain.user.User;
import io.reactivex.Maybe;

public interface UserRepository {

    Maybe<User> getUser(String email);

    Maybe<List<User>> getList();
}
