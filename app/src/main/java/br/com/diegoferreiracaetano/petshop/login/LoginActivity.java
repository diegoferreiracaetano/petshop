package br.com.diegoferreiracaetano.petshop.login.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import br.com.diegoferreiracaetano.petshop.R;
import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.login_email)
    EditText email;

    @BindView(R.id.login_password)
    EditText passoword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    @OnClick(R.id.login_entrar)
    public void sigin(Button button){

    }
}
