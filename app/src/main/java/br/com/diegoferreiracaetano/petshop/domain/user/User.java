package br.com.diegoferreiracaetano.petshop.domain.user;

import android.support.annotation.NonNull;

public class User {

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String name;

    public User() {
    }

    public User(@NonNull String email, @NonNull String password) {
        this.email = email;
        this.password = password;
    }

    public User(@NonNull String email, @NonNull String password, @NonNull String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
