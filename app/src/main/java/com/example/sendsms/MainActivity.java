package com.example.sendsms;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);

    }

    public void sendSMS(View v) {

        phone = findViewById(R.id.phone);
        String number = phone.getText().toString();

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(number, null, "Blah", null, null);
    }

    public void siren(View v){
        Intent myIntent = new Intent(MainActivity.this, Siren.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void firebase(View v){
        Intent myIntent = new Intent(MainActivity.this, frmdata.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void askSec(View v){
        Intent myIntent = new Intent(MainActivity.this , Sec.class);
        MainActivity.this.startActivity(myIntent);
    }

}
