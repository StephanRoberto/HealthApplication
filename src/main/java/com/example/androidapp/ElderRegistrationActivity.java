package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class ElderRegistrationActivity extends AppCompatActivity {

    private TextView backButton;
    private Button pickDateBtn3;
    private TextView selectedDateTV3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elder_registration);

       backButton = findViewById(R.id.backButton);
       pickDateBtn3 = findViewById(R.id.idBtnPickDate3);
       selectedDateTV3 = findViewById(R.id.idTVSelectedDate3);

       backButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(ElderRegistrationActivity.this, LoginActivity.class);
               startActivity(intent);
           }
       });


       pickDateBtn3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               final Calendar c = Calendar.getInstance();
               int year = c.get(Calendar.YEAR);
               int month = c.get(Calendar.MONTH);
               int day = c.get(Calendar.DAY_OF_MONTH);

               DatePickerDialog datePickerDialog = new DatePickerDialog(ElderRegistrationActivity.this, new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                       selectedDateTV3.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                   }
               },year, month, day);
               datePickerDialog.show();
           }
       });



    }
}