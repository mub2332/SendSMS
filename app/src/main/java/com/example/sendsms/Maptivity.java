package com.example.sendsms;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Maptivity extends AppCompatActivity {

    private FusedLocationProviderClient mloc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maptivity);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }

        getDeviceLocation();
    }

    public Address getAddress(double latitude,double longitude)
    {
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(latitude,longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            return addresses.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void getDeviceLocation(){
        mloc = LocationServices.getFusedLocationProviderClient(this);
        if (ContextCompat.checkSelfPermission(Maptivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(Maptivity.this, "no permission", Toast.LENGTH_SHORT).show();
        }
        else {
            Task location = mloc.getLastLocation();

            location.addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if (task.isSuccessful()){
                        Location currentLocation = (Location) task.getResult();
                        Log.d("Location" , currentLocation.toString());
                        double x = currentLocation.getLatitude();
                        double y = currentLocation.getLongitude();

                        Address address = getAddress(x , y);
                        String addString = address.getAddressLine(0);
                        Log.d("tag" , addString);
                    }
                    else{
                        Toast.makeText(Maptivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
