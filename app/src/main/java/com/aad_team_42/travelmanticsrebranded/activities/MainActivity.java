package com.aad_team_42.travelmanticsrebranded.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.aad_team_42.travelmanticsrebranded.R;

public class MainActivity extends AppCompatActivity {

    EditText edit1;
    EditText edit2;
    EditText edit3;
    EditText edit4;
    String nameString, descString, feeString, chooseString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.name);
        edit2 = (EditText) findViewById(R.id.desc);
        edit3 = (EditText) findViewById(R.id.fee);
        edit4 = (EditText) findViewById(R.id.choose);

        nameString = edit1.getText().toString();
        descString = edit2.getText().toString();
        feeString = edit3.getText().toString();
        chooseString = edit4.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
