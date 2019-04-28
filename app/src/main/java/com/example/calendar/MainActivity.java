package com.example.calendar;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button selectDate;
    TextView date;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define Android Button, TextView and DatePickerDialog.
        selectDate = findViewById(R.id.btnDate);
        date = findViewById(R.id.tvSelectedDate);


        //make selectDate Button clickable, so define Android SetOnClickListener.
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //---------------------------------------------------------//
                // inside the Button OnClick method add the following code.
                // In this section, you will learn how you can fix the issue
                // about Android Date Picker showing the wrong date.
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                //In this section you need to define Android Calendar, using this
                // Calendar you will be able to get current year, month and day values
                //-------------------------------------------------//


                //Inside Android OnClick method is where you will define Android datepicker.
                //Now you need to change Android DatePickerDialog to be able to use the current date values
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                //Now you need to work on getting the selected date appears
                                // inside Android TextView, add the following code inside
                                // DatePickerDialog onDateSet method.
                                date.setText(day + "/" + (month + 1) + "/" + year);
                                //(month + 1): In this section, you will learn how you can fix issue
                                // that is causing Android Date Picker to show the wrong month.
                                //The reason why it’s giving you the wrong month, because in Android
                                // Date API the month index value is (0-11). So if you choose the
                                // month February you will get the month value as January,
                                // if you choose the month December you will get the month value as November.
                            }
                        }, year, month, dayOfMonth);

                //prevent the user from choosing past dates!
                //DatePickerDialog has a method called setMinDate which you need to pass the current time by calling System.currentTimeMillis(). This will disable previous dates based on the current time.
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());

                //One thing left before you can see Android DatePickerDialog is to call the following method.
                datePickerDialog.show();
            }
        });
    }
}