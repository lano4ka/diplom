package com.sveta.diplom;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sveta.diplom.api.AndroidHttpClient;
import com.sveta.diplom.api.model.HistoryOfSick;
import com.sveta.diplom.api.model.Indicator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PatientActivity extends AppCompatActivity {

    private String login;
    private String password;
    private HistoryOfSick history;
    private String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        HistoryOfSick history = new HistoryOfSick();
        HistoryTask historyTask = new HistoryTask(history);
        historyTask.execute(getIntent().getCharSequenceExtra("login").toString(), getIntent().getCharSequenceExtra("password").toString());
        login = getIntent().getCharSequenceExtra("login").toString();
        password = getIntent().getCharSequenceExtra("password").toString();
        TextView name = (TextView)findViewById(R.id.user);
        name.setText(getIntent().getCharSequenceExtra("name").toString());
        Integer i = null;
    }

    public void goToIndicators(View view)
    {
        Intent intent = new Intent(PatientActivity.this, HistoryActivity.class);
        ArrayList<String> indicatorsList = new ArrayList<String>();
        ArrayList<String> indicatorsNamesList = new ArrayList<String>();
        for (Indicator ind: history.getIndicators())
        {
            indicatorsList.add(ind.getId_indicator().toString());
            indicatorsNamesList.add(ind.getName());
        }
        intent.putStringArrayListExtra("indicatorsList", indicatorsList);
        intent.putStringArrayListExtra("indicatorsNamesList", indicatorsNamesList);
        intent.putExtra("login",login);
        intent.putExtra("password", password);
        startActivity(intent);

    }

    private class HistoryTask extends AsyncTask<String, Void, HistoryOfSick> {
        private HistoryOfSick history;

        public HistoryTask(HistoryOfSick history)
        {
            this.history = history;
        }

        @Override
        protected HistoryOfSick doInBackground(String... params) {
            EditText login = (EditText)findViewById(R.id.loginField);
            EditText password = (EditText)findViewById(R.id.passwordField);
            // Конструируем запрос на авторизацию.
            // Util.convertToHeader принимает логин и пароль, преобразовывает их в
            // base64, и возвращает строку типа "Basic ia83jf032j09fd93".
            HistoryOfSick history = null;
            try {
                ObjectMapper mapper = new ObjectMapper();
                String jsonBody = AndroidHttpClient.executeGet("http://diplom-sveta.rhcloud.com/api/getCurrentHistory", "", params[0], params[1]);
                history = mapper.readValue(jsonBody, HistoryOfSick.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return history;
        }

        @Override
        protected void onPostExecute(HistoryOfSick result) {
            TextView diagnoz = (TextView)findViewById(R.id.diagnoz);
            diagnoz.setText(result.getDiagnoz().getName());
            PatientActivity.this.history = result;

        }
    }
}
