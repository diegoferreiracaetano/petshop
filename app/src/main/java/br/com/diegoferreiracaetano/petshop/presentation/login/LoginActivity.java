package br.com.diegoferreiracaetano.petshop.presentation.login;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.AppApplication;
import br.com.diegoferreiracaetano.petshop.ApplicationComponent;
import br.com.diegoferreiracaetano.petshop.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static dagger.internal.Preconditions.checkNotNull;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {


    @BindView(R.id.login_email)
    EditText email;

    @BindView(R.id.login_password)
    EditText passoword;


    @Inject
    LoginPresenter mLoginPresenter;
    private LoginContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initDagger();

    }

    private void initDagger() {

        DaggerLoginComponent.builder()
                .applicationComponent(AppApplication.getApplicationComponent())
                .repositoryComponent(AppApplication.getRepositoryComponent())
                .loginModule(new LoginModule(this)).build()
                .inject(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getListUsers();
    }

    @OnClick(R.id.login_entrar)
    public void sigin(Button button){
        mPresenter.getListUsers();
    }

    @Override
    public void setPresenter(@NonNull LoginContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter, "the presenter can't be null");
    }

    @Override
    public void showMessageError(String error) {

    }
}
