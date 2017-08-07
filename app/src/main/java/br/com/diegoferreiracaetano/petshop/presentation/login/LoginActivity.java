package br.com.diegoferreiracaetano.petshop.presentation.login;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.crash.FirebaseCrash;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.R;
import br.com.diegoferreiracaetano.petshop.presentation.main.MainActivity;
import br.com.diegoferreiracaetano.petshop.util.DialogHelper;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {


    @BindView(R.id.login_email)
    TextInputLayout text_input_email;

    @BindView(R.id.login_email_text)
    EditText email;

    @BindView(R.id.login_password)
    TextInputLayout text_input_password;

    @BindView(R.id.login_password_text)
    EditText passoword;

    @Inject
    LoginContract.Presenter mPresenter;

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
    public void sigin(){
        mPresenter.login(email.getText().toString(),passoword.getText().toString());
    }

    @Override
    public void showErrorUser( Throwable throwable) {
        DialogHelper.dialogMessage(this,R.string.title_error,R.string.msg_error_general).show();
        FirebaseCrash.report(throwable);
    }

    @Override
    public void showUserNotFound() {
        DialogHelper.dialogMessage(this,R.string.title_user_not_found, R.string.msg_error_user_not_found).show();
    }

    @Override
    public void show() {
        MainActivity.start(this);
    }

    @Override
    public void showErrorEmail() {
        text_input_email.setError(getString(R.string.msg_error_login_empty));
    }

    @Override
    public void showErrorPassword() {
        text_input_password.setError(getString(R.string.msg_error_password_empty));
    }
}
