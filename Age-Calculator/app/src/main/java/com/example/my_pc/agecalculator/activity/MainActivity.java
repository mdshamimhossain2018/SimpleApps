package com.example.my_pc.agecalculator.activity;

/**
 * Created by Md Shamim Hossain
 */

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.my_pc.agecalculator.model.AgeCalculation;
import com.example.my_pc.agecalculator.model.AgeDetails;
import com.example.my_pc.agecalculator.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.dd_dob)
    EditText ddDob;
    @BindView(R.id.mm_dob)
    EditText mmDob;
    @BindView(R.id.yyyy_dob)
    EditText yyyyDob;
    @BindView(R.id.dd_td)
    EditText ddTd;
    @BindView(R.id.mm_td)
    EditText mmTd;
    @BindView(R.id.yyyy_td)
    EditText yyyyTd;

    private int startYear, startMonth, startDay;
    private int endYear, endMonth, endDay;

    int year, month, day;
    private AgeCalculation age = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ddTd.setText("");
                mmTd.setText("");
                yyyyTd.setText("");

                ddDob.setText("");
                mmDob.setText("");
                yyyyDob.setText("");

            }
        });


        setTitle("Age Calculator");

        age = new AgeCalculation();

        init();
        setTodaysDate();

    }

    private void init() {
        final DatePicker datePicker = new DatePicker(this);

        year = datePicker.getYear();
        month = datePicker.getMonth() + 1;
        day = datePicker.getDayOfMonth();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == R.id.action_exit) {
            this.finish();
        }

        if (id == R.id.action_home) {
            startActivity(new Intent(this, About.class));
        }


        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.calenderBtn)
    public void onCalenderBtnClicked() {

        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {


                ddDob.setText(String.valueOf(i2));
                mmDob.setText(String.valueOf((i1 + 1)));
                yyyyDob.setText(String.valueOf(i));

            }
        }, year, month, day).show();
    }

    @OnClick(R.id.calenderBtn2)
    public void onCalenderBtn2Clicked() {

        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {


                ddTd.setText(String.valueOf(i2));
                mmTd.setText(String.valueOf((i1 + 1)));
                yyyyTd.setText(String.valueOf(i));

            }
        }, year, month, day).show();
    }

    @OnClick(R.id.angry_btn)
    public void onAgeCalBtnClicked() {

        try {

            startDay = Integer.parseInt(ddDob.getText().toString().trim());
            startMonth = Integer.parseInt(mmDob.getText().toString().trim());
            startMonth--;
            startYear = Integer.parseInt(yyyyDob.getText().toString().trim());

            endDay = Integer.parseInt(ddTd.getText().toString().trim());
            endMonth = Integer.parseInt(mmTd.getText().toString().trim());
            endMonth--;
            endYear = Integer.parseInt(yyyyTd.getText().toString().trim());

        } catch (Exception e) {

            Toast.makeText(this, "Please input every fields with valid number", Toast.LENGTH_SHORT).show();
            return;
        }



        age.setDateOfBirth(startYear, startMonth, startDay);

        age.endDay = endDay;
        age.endMonth = endMonth + 1;
        age.endYear = endYear;

        calculateAge();

    }

    private void calculateAge() {

        age.calcualteYear();
        age.calcualteMonth();
        age.calcualteDay();

        AgeDetails.year = age.resYear;
        AgeDetails.month = age.resMonth;
        AgeDetails.day = age.resDay;


        startActivity(new Intent(this, AgeDetailsActivity.class));
    }

    private void setTodaysDate() {

        age.getCurrentDate();

        if (age.endDay < 10) {
            ddTd.setText("0" + String.valueOf(age.endDay));
        } else {
            ddTd.setText(String.valueOf(age.endDay));
        }

        if (age.endMonth < 10) {
            mmTd.setText("0" + String.valueOf(age.endMonth));
        } else {
            mmTd.setText(String.valueOf(age.endMonth));
        }
        yyyyTd.setText(String.valueOf(age.endYear));
    }
}
