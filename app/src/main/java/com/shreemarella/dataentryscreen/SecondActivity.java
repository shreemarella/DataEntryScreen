package com.shreemarella.dataentryscreen;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity
{
    private String[] suffix;
    private Spinner sprSuffix;
    private String[] empstatus;
    private Spinner empstatusspr;
    private String[] issue;
    private  Spinner sprIssue ;
    private  String[] designation;
    private Spinner sprDesignation;


    private TextView FirstName;

    private TextView LastName;
    private TextView streetnumber;
    private TextView streetname;
    private TextView province;
    private TextView city;
    private TextView country;
    private TextView postalcode;
    private TextView email;
    private TextView  countrycode;
    private TextView cellnumber;
    private TextView detaildescription;
    private Button AddCompliant;
    private TextView Datetxt;
    private SeekBar severity;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        AddCompliant = findViewById(R.id.btnAdd);
        suffix = getResources().getStringArray(R.array.suffix);
        sprSuffix= findViewById(R.id.sprSuffix);
        empstatus = getResources().getStringArray(R.array.status);
        empstatusspr = findViewById(R.id.sprStatus);
        designation = getResources().getStringArray(R.array.designation);
        sprDesignation = findViewById(R.id.sprDesignation);
        issue =getResources().getStringArray(R.array.issue);
        sprIssue = findViewById(R.id.issue);
        FirstName = findViewById(R.id.txtFirstName);
        LastName = findViewById(R.id.txtLastName);
        streetnumber =findViewById(R.id.txtstreetno);
        streetname = findViewById(R.id.txtstreetname);
        province =findViewById(R.id.txtprovinance);
        city=findViewById(R.id.txtcity);
        country = findViewById(R.id.txtcountry);
        postalcode=findViewById(R.id.txtpostalcode);
        email=findViewById(R.id.txtemail);
        countrycode  =findViewById(R.id.txtcountrycode);
        cellnumber= findViewById(R.id.txtcellnumber);
        detaildescription=findViewById(R.id.edtdescription);
        Datetxt = findViewById(R.id.txtDate);
        severity = findViewById(R.id.sldseverity);
        ArrayAdapter<String> mStringArrayAdapter = new ArrayAdapter<>(SecondActivity.this,android.R.layout.simple_spinner_dropdown_item,suffix);
        sprSuffix.setAdapter(mStringArrayAdapter);
        sprSuffix.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SecondActivity.this,suffix[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SecondActivity.this,"onNothingSelected",Toast.LENGTH_SHORT).show();

            }
        });
        ArrayAdapter<String> eStringArrayAdapter = new ArrayAdapter<>(SecondActivity.this,android.R.layout.simple_spinner_dropdown_item,empstatus);
        empstatusspr.setAdapter(eStringArrayAdapter);
        empstatusspr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SecondActivity.this,empstatus[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SecondActivity.this,"onNothingSelected",Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String> dStringArrayAdapter = new ArrayAdapter<>(SecondActivity.this,android.R.layout.simple_spinner_dropdown_item,designation);
        sprDesignation.setAdapter(dStringArrayAdapter);
        sprDesignation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SecondActivity.this,designation[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SecondActivity.this,"onNothingSelected",Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String> iStringArrayAdapter = new ArrayAdapter<>(SecondActivity.this,android.R.layout.simple_spinner_dropdown_item,issue);
        sprIssue.setAdapter(iStringArrayAdapter);
        sprIssue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SecondActivity.this,issue[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SecondActivity.this,"onNothingSelected",Toast.LENGTH_SHORT).show();
            }
        });

        final Calendar myCalendar = Calendar.getInstance();


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                Datetxt.setText(sdf.format(myCalendar.getTime()));
            }
        };

        Datetxt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(SecondActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });


        AddCompliant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                Intent mintent = new Intent(SecondActivity.this, ThirdActivity.class);
                Bundle extras = new Bundle();

                extras.putString("SuFix",sprSuffix.getSelectedItem().toString());
                extras.putString("firstName",FirstName.getText().toString());
                extras.putString("lastName",LastName.getText().toString());
                extras.putString("empStatus",empstatusspr.getSelectedItem().toString());
                extras.putString("Desgs",sprDesignation.getSelectedItem().toString());
                extras.putString("StreetNo",streetnumber.getText().toString());
                extras.putString("StreetName",streetname.getText().toString());
                extras.putString("Province",province.getText().toString());
                extras.putString("City",city.getText().toString());
                extras.putString("Country",country.getText().toString());
                extras.putString("Postalcode",postalcode.getText().toString());
                extras.putString("Email",email.getText().toString());
                extras.putString("Countrycode",countrycode.getText().toString());
                extras.putString("Cellnumber",cellnumber.getText().toString());
                extras.putString("pickedDate",Datetxt.getText().toString());
                extras.putFloat("seekbar",severity.getProgress());
                extras.putString("Issues",sprIssue.getSelectedItem().toString());
                extras.putString("DetailDescription",detaildescription.getText().toString());
                mintent.putExtras(extras);
                startActivity(mintent);




            }
        });
    }
}
