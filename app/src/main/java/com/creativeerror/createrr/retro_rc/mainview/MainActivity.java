package com.creativeerror.createrr.retro_rc.mainview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.creativeerror.createrr.retro_rc.R;
import com.creativeerror.createrr.retro_rc.maininteractor.InterfaceMain;

public class MainActivity extends AppCompatActivity implements InterfaceMain {
    private EditText mTextUsername;
    private EditText mTextPassword;
    private Button mButtonLogin;
    private MainPresenter mInsterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextUsername = (EditText) findViewById(R.id.editText);
        mTextPassword = (EditText) findViewById(R.id.editText2);
        mButtonLogin = (Button) findViewById(R.id.button);
        setTitle("Login");
        mInsterface = new MainPresenter(this);
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInsterface.login(mTextUsername.getText().toString(),mTextPassword.getText().toString());
            }
        });
    }

    @Override
    public void login(String username, String password) {

    }

    @Override
    public void messageinvalid() {
        Toast.makeText(this, R.string.logininvalid, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void messageempty() {
        Toast.makeText(this, R.string.loginempty, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginsukses(String username) {
        Toast.makeText(this, R.string.loginsukses, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,HomeActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

}
