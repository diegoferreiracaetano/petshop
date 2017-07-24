package br.com.diegoferreiracaetano.petshop.presentation.login;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.R;
import br.com.diegoferreiracaetano.petshop.presentation.main.MainActivity;
import br.com.diegoferreiracaetano.petshop.util.DialogHelper;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class LoginActivity extends DaggerAppCompatActivity implements LoginContract.View {


    @BindView(R.id.login_email)
    TextInputLayout TI_email;

    @BindView(R.id.login_email_text)
    EditText email;

    @BindView(R.id.login_password)
    TextInputLayout TI_password;

    @BindView(R.id.login_password_text)
    EditText passoword;


    @Inject
    LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        initDagger();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    private void initDagger() {

        AndroidInjection.inject(this);
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
