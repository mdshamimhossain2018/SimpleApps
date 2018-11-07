package com.example.my_pc.agecalculator.activity;

/**
 * Created by Md Shamim Hossain
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.my_pc.agecalculator.R;
import com.example.my_pc.agecalculator.model.AgeCalculation;
import com.example.my_pc.agecalculator.model.AgeDetails;
import com.example.my_pc.agecalculator.model.TimeConvert;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AgeDetailsActivity extends AppCompatActivity {

    @BindView(R.id.showYearsId)
    TextView showYearsId;
    @BindView(R.id.yearsId)
    TextView yearsId;
    @BindView(R.id.monthId)
    TextView monthId;
    @BindView(R.id.daysId)
    TextView daysId;
    @BindView(R.id.showTotalYears)
    TextView showTotalYears;
    @BindView(R.id.showTotalMonths)
    TextView showTotalMonths;
    @BindView(R.id.showTotalWeeks)
    TextView showTotalWeeks;
    @BindView(R.id.showTotalDays)
    TextView showTotalDays;
    @BindView(R.id.showTotalHours)
    TextView showTotalHours;
    @BindView(R.id.showTotalMinutes)
    TextView showTotalMinutes;
    @BindView(R.id.showTotalSeconds)
    TextView showTotalSeconds;

    private AgeCalculation age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_details);
        ButterKnife.bind(this);

        setTitle("Age Details");

        age = new AgeCalculation();


        try {
            init();

        } catch (Exception e) {
        }

        try {
            setAge();
        } catch (Exception e) {
        }

    }

    private void init() {


        long td = (long) TimeConvert.time("year", "day", AgeDetails.year);
        td += (TimeConvert.time("month", "day", AgeDetails.month));
        td += AgeDetails.day;

        AgeDetails.tDays = td;

        AgeDetails.tHours = (long) TimeConvert.time("day", "hour", AgeDetails.tDays);
        AgeDetails.tMinutes = (long) TimeConvert.time("day", "minute", AgeDetails.tDays);
        AgeDetails.tSeconds = (long) TimeConvert.time("day", "second", AgeDetails.tDays);

        AgeDetails.tMonths = (long) TimeConvert.time("day", "month", AgeDetails.tDays);
        AgeDetails.tWeeks = (long) TimeConvert.time("day", "week", AgeDetails.tDays);

    }

    private void setAge() {

        //showYearsId.setText(AgeDetails.year + " Years, " + AgeDetails.month + " Months, " + AgeDetails.day + " Days");
        yearsId.setText(String.valueOf(AgeDetails.year));
        monthId.setText(String.valueOf(AgeDetails.month));
        daysId.setText(String.valueOf(AgeDetails.day));

        showTotalYears.setText(String.valueOf(AgeDetails.year));
        showTotalMonths.setText(String.valueOf(AgeDetails.tMonths));
        showTotalWeeks.setText(String.valueOf(AgeDetails.tWeeks));
        showTotalDays.setText(String.valueOf(AgeDetails.tDays));
        showTotalHours.setText(String.valueOf(AgeDetails.tHours));
        showTotalMinutes.setText(String.valueOf(AgeDetails.tMinutes));
        showTotalSeconds.setText(String.valueOf(AgeDetails.tSeconds));

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
