package br.com.diegoferreiracaetano.petshop.di.components;

import br.com.diegoferreiracaetano.petshop.data.auth.interfaces.AuthRepository;
import br.com.diegoferreiracaetano.petshop.di.modules.AuthModule;
import dagger.Component;

@Component(modules = {AuthModule.class})
public interface AuthComponent {
    AuthRepository getAuthRepository();
}
