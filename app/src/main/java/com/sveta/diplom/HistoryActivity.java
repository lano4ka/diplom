package com.sveta.diplom;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sveta.diplom.api.AndroidHttpClient;
import com.sveta.diplom.api.model.HistoryOfSick;
import com.sveta.diplom.api.model.Indicator;
import com.sveta.diplom.api.model.User;

import java.io.IOException;
import java.util.ArrayList;

public class HistoryActivity extends ListActivity {

    private ListView indicatorsList;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        HistoryOfSick history = new HistoryOfSick();
        HistoryTask historyTask = new HistoryTask(history);
        historyTask.execute(getIntent().getCharSequenceExtra("login").toString(), getIntent().getCharSequenceExtra("password").toString());
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = String.valueOf(v.getId());
        String g = null;
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
            history = result;
            ArrayList<String> data = new ArrayList<String>();
            for (Indicator i: result.getIndicators())
            {
                data.add(i.getName());
            }
            listAdapter = new ArrayAdapter<String>(HistoryActivity.this, R.layout.simplerow, R.id.listText, data);
            HistoryActivity.this.setListAdapter(listAdapter);
        }
    }

}
