package com.example.sendsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class frmdata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frmdata);
        Toast.makeText(frmdata.this, "Firebase connection lit af", Toast.LENGTH_LONG).show();
    }
}
