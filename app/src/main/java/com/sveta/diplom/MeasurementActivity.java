package com.sveta.diplom;

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
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sveta.diplom.api.AndroidHttpClient;
import com.sveta.diplom.api.model.HistoryOfSick;
import com.sveta.diplom.api.model.Indicator;

import java.io.IOException;
import java.util.ArrayList;

public class MeasurementActivity extends AppCompatActivity {

    private String login;
    private  String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement);
        TextView indicator = (TextView)findViewById(R.id.indicatorName);
        indicator.setText(getIntent().getCharSequenceExtra("name_indicator").toString());
    }

    public void send(View v)
    {
        EditText value = (EditText)findViewById(R.id.value);
        MeasurementTask measurementTask = new MeasurementTask();
        measurementTask.execute(getIntent().getCharSequenceExtra("login").toString(),getIntent().getCharSequenceExtra("password").toString(),getIntent().getCharSequenceExtra("id_indicator").toString(), value.getText().toString());
        login = getIntent().getCharSequenceExtra("login").toString();
        password = getIntent().getCharSequenceExtra("password").toString();
    }

    private class MeasurementTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {

            try {
                String jsonBody = AndroidHttpClient.executeGet("http://diplom-sveta.rhcloud.com/api/sendMeasurement", "?id_indicator="+params[2]+"&value="+params[3], params[0], params[1]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Intent intent = new Intent(MeasurementActivity.this, HistoryActivity.class);
            intent.putExtra("login", login);
            intent.putExtra("password", password);
            startActivity(intent);
        }
    }

}
