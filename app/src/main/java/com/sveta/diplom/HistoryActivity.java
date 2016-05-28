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
import java.util.List;

public class HistoryActivity extends ListActivity {

    private ListView indicatorsList;
    private ArrayAdapter<String> listAdapter;
    private ArrayList<String> masForIDs;
    private String login;
    private String password;
    private List<String> masForName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        HistoryOfSick history = new HistoryOfSick();
        java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());
        login = getIntent().getCharSequenceExtra("login").toString();
        password = getIntent().getCharSequenceExtra("password").toString();
        masForIDs = getIntent().getStringArrayListExtra("indicatorsList");
        masForName = getIntent().getStringArrayListExtra("indicatorsNamesList");
        listAdapter = new ArrayAdapter<String>(HistoryActivity.this, R.layout.simplerow, R.id.listText, masForName);
        setListAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(HistoryActivity.this, MeasurementActivity.class);
        intent.putExtra("id_indicator", masForIDs.get(position));
        intent.putExtra("name_indicator", masForName.get(position));
        intent.putExtra("login", login);
        intent.putExtra("password", password);
        startActivity(intent);
    }

}
