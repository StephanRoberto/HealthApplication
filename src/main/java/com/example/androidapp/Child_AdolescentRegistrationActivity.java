package com.example.androidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;


public class Child_AdolescentRegistrationActivity extends AppCompatActivity {

    private TextView backButton;

    private Button pickDateBtn;
    private TextView selectedDateTV;
    Button registerButton;
    FirebaseDatabase database;
    DatabaseReference reference;



    private RadioGroup radioGroup;
    private Button submitButton;
    private TextView resultTextView;

    private Spinner spinner;
    private TextView textView;


    private RadioButton yesRadioButton;
    private RadioButton noRadioButton;
    private EditText chronicDiseaseEditText;
    private TextView chronicDiseaseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_adolescent_registration);



        backButton = findViewById(R.id.backButton);
        pickDateBtn = findViewById(R.id.idBtnPickDate);



        selectedDateTV = findViewById(R.id.idTVSelectedDate);
        registerButton = findViewById(R.id.registerButton);




        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.text_view);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        yesRadioButton = findViewById(R.id.yes_radio_button);
        noRadioButton = findViewById(R.id.no_radio_button);
        chronicDiseaseEditText = findViewById(R.id.chronic_disease_edit_text);
        chronicDiseaseTextView = findViewById(R.id.chronic_disease_text_view);


        final EditText registerFull = findViewById(R.id.registerFull);
        final EditText registerPhone = findViewById(R.id.registerPhone);
        final EditText date = findViewById(R.id.idTVSelectedDate);
        final EditText registerMail = findViewById(R.id.registerMail);
        final EditText registerPASS = findViewById(R.id.registerPASS);

        final TextView gender = findViewById(R.id.resultTextView);
        final TextView blood = findViewById(R.id.text_view);
        final EditText age = findViewById(R.id.age_edit_text);
        final EditText weight = findViewById(R.id.weight_edit_text);
        final EditText height = findViewById(R.id.height_edit_text);
        final EditText disease = findViewById(R.id.chronic_disease_edit_text);
        final TextView nochronic = findViewById(R.id.chronic_disease_text_view);

        radioGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.submitButton);
        resultTextView = findViewById(R.id.resultTextView);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedValue = selectedRadioButton.getText().toString();
                resultTextView.setText("Result: " + selectedValue);
            }
        });



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = parent.getItemAtPosition(position).toString();
                textView.setText(selectedOption);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // do nothing
            }
        });



        yesRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronicDiseaseEditText.setVisibility(View.VISIBLE);
                chronicDiseaseTextView.setVisibility(View.INVISIBLE);
            }
        });





        noRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronicDiseaseEditText.setVisibility(View.INVISIBLE);
                chronicDiseaseTextView.setVisibility(View.VISIBLE);
                chronicDiseaseTextView.setText("No chronic diseases");
            }
        });















        pickDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Child_AdolescentRegistrationActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        selectedDateTV.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });











        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");


                String name = registerFull.getText().toString();
                String email = registerMail.getText().toString();
                String phone = registerPhone.getText().toString();
                String password = registerPASS.getText().toString();
                String datepick = date.getText().toString();
                String gen = gender.getText().toString();
                String type = blood.getText().toString();
                String aage = age.getText().toString();
                String wweight = weight.getText().toString();
                String hheight = height.getText().toString();
                String yes = disease.getText().toString();
                String no = nochronic.getText().toString();

                HelperClass helperClass = new HelperClass(name, email, phone, password, datepick, gen, type, aage, wweight, hheight, yes, no);
                reference.child(phone).setValue(helperClass);
                Toast.makeText(Child_AdolescentRegistrationActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Child_AdolescentRegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Child_AdolescentRegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}