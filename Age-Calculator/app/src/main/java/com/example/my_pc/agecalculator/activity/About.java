package com.example.my_pc.agecalculator.activity;
/**
 * Created by Md Shamim Hossain
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.my_pc.agecalculator.R;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
