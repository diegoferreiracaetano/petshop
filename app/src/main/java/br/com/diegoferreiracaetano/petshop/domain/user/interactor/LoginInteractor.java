package br.com.diegoferreiracaetano.petshop.domain.user.interactor;


import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.data.database.interfaces.UserRepository;
import br.com.diegoferreiracaetano.petshop.domain.interfaces.InteractorMaybe;
import br.com.diegoferreiracaetano.petshop.domain.user.User;
import br.com.diegoferreiracaetano.petshop.util.Md5Helper;
import io.reactivex.Maybe;

public class LoginInteractor extends InteractorMaybe<User,LoginInteractor.Request> {

    UserRepository mRepository;

    @Inject
    public LoginInteractor(UserRepository mRepository) {
        this.mRepository = mRepository;
    }

    @Override
    protected Maybe<User> create(LoginInteractor.Request request) {

        return mRepository.getUser(request.getLogin())
                .filter(user -> user.validate(user, Md5Helper.add(request.getPassword())));
    }


    public static final class Request extends InteractorMaybe.Request {

        private String login;
        private String password;

        public Request(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
