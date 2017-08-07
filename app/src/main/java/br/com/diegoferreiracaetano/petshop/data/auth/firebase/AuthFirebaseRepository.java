package br.com.diegoferreiracaetano.petshop.data.auth.firebase;

import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.data.auth.interfaces.AuthRepository;

public class AuthFirebaseRepository implements AuthRepository{

    FirebaseAuth mFirebaseAuth;

    @Inject
    public AuthFirebaseRepository(FirebaseAuth firebaseAuth) {
        this.mFirebaseAuth = firebaseAuth;
    }

    @Override
    public void login() {
    }
}
