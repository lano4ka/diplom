package com.sveta.diplom;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sveta.diplom.api.AndroidHttpClient;
import com.sveta.diplom.api.model.User;

import java.io.IOException;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void login(View view) {
        EditText login = (EditText)findViewById(R.id.loginField);
        EditText password = (EditText)findViewById(R.id.passwordField);
        User user = new User();
        UserTask userTask = new UserTask(user);
        userTask.execute(login.getText().toString(), password.getText().toString());
    }

    private class UserTask extends AsyncTask<String, Void, User> {
    private User user;

        public UserTask(User user)
        {
            this.user = user;
        }

        @Override
        protected User doInBackground(String... params) {
            EditText login = (EditText)findViewById(R.id.loginField);
            EditText password = (EditText)findViewById(R.id.passwordField);
            // Конструируем запрос на авторизацию.
            // Util.convertToHeader принимает логин и пароль, преобразовывает их в
            // base64, и возвращает строку типа "Basic ia83jf032j09fd93".
            User user = null;
            try {
                ObjectMapper mapper = new ObjectMapper();
                String jsonBody = AndroidHttpClient.executeGet("http://diplom-sveta.rhcloud.com/api/auth", "", params[0], params[1]);
                user = mapper.readValue(jsonBody, User.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return user;
        }
        @Override
       protected void onPostExecute(User result) {
            TextView message = (TextView)findViewById(R.id.textView9);
            message.setText((CharSequence) result.getName());
            user = result;
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            intent.putExtra("password", result.getPassword());
            intent.putExtra("login", result.getLogin());
            startActivity(intent);
        }
    }


}
