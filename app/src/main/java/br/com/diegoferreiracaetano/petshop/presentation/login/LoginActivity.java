package br.com.diegoferreiracaetano.petshop.presentation.login;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.AppApplication;
import br.com.diegoferreiracaetano.petshop.ApplicationComponent;
import br.com.diegoferreiracaetano.petshop.R;
import br.com.diegoferreiracaetano.petshop.presentation.main.MainActivity;
import br.com.diegoferreiracaetano.petshop.util.DialogHelper;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static dagger.internal.Preconditions.checkNotNull;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {


    @BindView(R.id.login_email)
    TextInputLayout TI_email;

    @BindView(R.id.login_email_text)
    EditText email;

    @BindView(R.id.login_password)
    TextInputLayout TI_password;

    @BindView(R.id.login_password_text)
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
    }

    @OnClick(R.id.login_entrar)
    public void sigin(Button button){
        mPresenter.login(email.getText().toString(),passoword.getText().toString());
    }

    @Override
    public void setPresenter(@NonNull LoginContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter, "the presenter can't be null");
    }

    @Override
    public void showMessageError(int title,int msg) {
       DialogHelper.dialogMessage(this,title,msg).create();
    }


    @Override
    public void show() {
        MainActivity.start(this);
    }

    @Override
    public void showErrorEmail(int msg) {
        TI_email.setError(getString(msg));
    }

    @Override
    public void showErrorPassword(int msg) {
        TI_password.setError(getString(msg));
    }
}
