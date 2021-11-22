package com.example.findlocationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.location.Geocoder;
import android.location.Address;
import android.content.Context;
import java.util.List;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button getloc = (Button) findViewById(R.id.btnGetLocation);
        getloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText place = (EditText)findViewById(R.id.address);
                getLocationFromAddress(place.getText().toString());
            }
        });

    }

    public void getLocationFromAddress(String strAddress) {

        Geocoder coder = new Geocoder(getApplicationContext());
        List<Address> address;
        TextView showloc = (TextView) findViewById(R.id.showLocation);
        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                System.out.println("Address not found.");
            }
            showloc.setText("Latitude : " + address.get(0).getLatitude() + "\nLongitude : " + address.get(0).getLongitude());

        } catch (Exception ex) {

            ex.printStackTrace();
            showloc.setText("ERROR");
        }
    }
}
