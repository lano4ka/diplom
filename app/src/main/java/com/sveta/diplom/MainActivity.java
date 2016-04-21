package com.sveta.diplom;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.sveta.diplom.api.AuthService;
import com.sveta.diplom.api.Util;
import com.sveta.diplom.domain.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private AuthService mAuthService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuthService = new Retrofit.Builder()
                .baseUrl("http://diplom-sveta.rhcloud.com/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build().create(AuthService.class);
    }

    public void login(View view) {
        // Get login and password from view
        EditText login = (EditText)findViewById(R.id.loginField);
        EditText password = (EditText)findViewById(R.id.passwordField);
        // Конструируем запрос на авторизацию.
        // Util.convertToHeader принимает логин и пароль, преобразовывает их в
        // base64, и возвращает строку типа "Basic ia83jf032j09fd93".
        Call<User> result = mAuthService.login(Util
                .convertToHeader(login.getText().toString(), password.getText().toString()));
        try {
            User user = result.execute().body();
        } catch (IOException e) {
            Log.d(MainActivity.class.getName(), "IOException was catched", e);
        }
    }

}
