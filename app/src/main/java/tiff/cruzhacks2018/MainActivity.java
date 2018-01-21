package tiff.cruzhacks2018;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements LocationListener {

    Double Longitude;
    Double Latitude;

    Button getLocationBtn;
    Button giveLocationBtn;
    LocationManager locationManager;
    TextView locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        getLocationBtn = (Button)findViewById(R.id.R);
        giveLocationBtn = (Button)findViewById(R.id.G);
//        locationText = (TextView)findViewById(R.id.TV);

        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{
                    android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }

        getLocation();

        getLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, MapsActivity2.class);
//                System.out.println("asdfd");
//                System.out.print("Long:"+Longitude+" Lat:"+Latitude);
//                try {
//                    TimeUnit.SECONDS.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                myIntent.putExtra("Long", Longitude);
                myIntent.putExtra("Lat", Latitude);
                myIntent.putExtra("type", "getting");

//                Toast.makeText(MainActivity.this, "Long:"+Longitude+" Lat:"+Latitude, Toast.LENGTH_SHORT).show();
                startActivity(myIntent);
            }
        });

        giveLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, MapsActivity2.class);
//                System.out.println("asdfd");
//                System.out.print("Long:"+Longitude+" Lat:"+Latitude);
//                try {
//                    TimeUnit.SECONDS.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                myIntent.putExtra("Long", Longitude);
                myIntent.putExtra("Lat", Latitude);
                myIntent.putExtra("type", "giving");
//                Toast.makeText(MainActivity.this, "Long:"+Longitude+" Lat:"+Latitude, Toast.LENGTH_SHORT).show();
                startActivity(myIntent);
            }
        });
    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

//    public void onClickG(View v){
//        Intent myIntent = new Intent(this, MapsActivity2.class);
//        myIntent.putExtra("Long", Longitude);
//        myIntent.putExtra("Lat", Latitude);
//        startActivity(myIntent);
//    }

    public void onClickR(View v){
        Intent myIntent = new Intent(this, Receive.class);
        startActivity(myIntent);
    }

    @Override
    public void onLocationChanged(Location location) {
        Longitude = location.getLongitude();
        Latitude = location.getLatitude();
//        locationText.setText("Latitude: " + Latitude + "\n Longitude: " + Longitude);
//        Toast.makeText(MainActivity.this, "Long:"+Longitude+" Lat:"+Latitude, Toast.LENGTH_SHORT).show();

        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
//            locationText.setText(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
//                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));
        }catch(Exception e)
        {

        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }
}
