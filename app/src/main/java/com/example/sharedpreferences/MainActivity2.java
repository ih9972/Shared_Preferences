package com.example.sharedpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.sharedpreferences.R;

public class MainActivity2 extends AppCompatActivity {
    TextView mTextView;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent gi = getIntent();
        mTextView = (TextView) findViewById(R.id.textView12);
        mTextView.setText("All of the credits belongs to Itai Hadar THE KING ");
    }

    /**
     * onCreateOptionsMenu method
     * <p> Creating the options menu
     * </p>
     *
     * @param menu the Menu object to pass to the inflater
     * @return true
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * this method matches the credit to the option that is selected.
     * @param item The menu item that was selected.
     *
     * @return
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        st = item.getTitle().toString();
        if (st.equals("Main screen")) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}