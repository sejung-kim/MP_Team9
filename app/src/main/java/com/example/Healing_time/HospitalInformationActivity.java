package com.example.Healing_time;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HospitalInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_information);

    }

    public void onClick_edit_camp_button(View view){
        Intent intent = new Intent(HospitalInformationActivity.this, HospitalUploadActivity.class);
        startActivity(intent);
    }
}