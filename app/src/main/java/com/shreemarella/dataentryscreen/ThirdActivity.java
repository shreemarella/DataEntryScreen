package com.shreemarella.dataentryscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity
{
    private TextView txtcompliant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        txtcompliant = findViewById(R.id.txtDisplay);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String su = extras.getString("SuFix");
        String FN = extras.getString("firstName");
        String LN = extras.getString("lastName");
        String ES = extras.getString("empStatus");
        String DS = extras.getString("Desgs");
        String SNO = extras.getString("StreetNo");
        String SN = extras.getString("StreetName");
        String P = extras.getString("Province");
        String CI = extras.getString("City");
        String CY = extras.getString("Country");
        String PC = extras.getString("Postalcode");
        String EM = extras.getString("Email");
        String CYC = extras.getString("Countrycode");
        String CNO = extras.getString("Cellnumber");
        String DT = extras.getString("pickedDate");
        String IS = extras.getString("Issues");
        Float sev = extras.getFloat("seekbar");
        String DD = extras.getString("DetailDescription");





        txtcompliant.setText("*********COMPLAINTS FORM**********" +
                "**********\n"+"Name of Complainer:    "+su+ " "+FN+" "+LN+"\nEmployment status:    "+ES+"\nDesignation:    "+DS+"\nStreet no:    "+SNO+"\nStreet Name:    "+SN+"\nProvince:    "+
                P+"\nCity:    "+CI+"\nCountry:    "+CY+"\nPostal code:    "+PC+"\nEmail:    "+EM+"\nCountry Code:    "+CYC
                +"\nCell Number:    "+CNO+"\nComplaint Issue Date:    "+DT+"\nIssues:    "+IS+"\n Severity:   "+sev+"\nDetailed Description:    "+DD);
        txtcompliant.setTextColor(Color.BLUE);
        txtcompliant.setTextSize(16);
    }
}
