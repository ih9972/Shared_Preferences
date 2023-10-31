package com.example.sharedpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;

import java.util.prefs.AbstractPreferences;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    int num;
    SharedPreferences settings;
    SharedPreferences.Editor editor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editTextText);
        settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        editor=settings.edit();
        editText.setText(settings.getString("user_name","name"));
        if (editText.getText().equals("name"))
            editText.setHint("name");
        num = settings.getInt("num",0);
        textView.setText(""+num);
    }

    public void count(View view) {
        num += 1;
        textView.setText(""+num);
    }

    public void reset(View view) {
        num = 0;
        textView.setText(""+num);
    }

    public void Exit(View view) {
        editor.putString("user_name",editText.getText().toString());
        editor.putInt("num",num);
        editor.commit();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * this method matches the credit to the option that is selected.
     * @param item The menu item that was selected.
     *
     * @return
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("Credits screen")) {
            Intent si = new Intent(this, MainActivity2.class);
            startActivity(si);
        }
        return super.onOptionsItemSelected(item);
    }

}