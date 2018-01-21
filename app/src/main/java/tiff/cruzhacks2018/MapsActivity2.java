package tiff.cruzhacks2018;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.net.URI;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Double Longitude;
    Double Latitude;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        type = i.getStringExtra("type");
        Longitude = i.getDoubleExtra("Long", 0.00);
        Latitude = i.getDoubleExtra("Lat", 0.00);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        final LatLng yourLoc = new LatLng(Latitude, Longitude);
        mMap.addMarker(new MarkerOptions().position(yourLoc).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Loc1 = new LatLng(36.9798201, -122.030718);
        mMap.addMarker(new MarkerOptions().position(Loc1).title("St. Francis Catholic Kitchen").snippet("205 Mora St, Santa Cruz, CA"));

        LatLng Loc2 = new LatLng(36.9787263, -122.030684);
        mMap.addMarker(new MarkerOptions().position(Loc2).title("Holy Cross Food Pantry").snippet("210 High St, Santa Cruz, CA"));

        LatLng Loc3 = new LatLng(36.9787499, -122.030246);
        mMap.addMarker(new MarkerOptions().position(Loc3).title("Holy Cross Food Pantry").snippet("126 High St, Santa Cruz, CA"));

        LatLng Loc4 = new LatLng(36.9611139, -122.044361);
        mMap.addMarker(new MarkerOptions().position(Loc4).title("Garfield Park Community Church").snippet("849 Almar Ave, Santa Cruz, CA"));

        LatLng Loc5 = new LatLng(36.9600301, -122.037249);
        mMap.addMarker(new MarkerOptions().position(Loc5).title("Word of Life Church of God in Christ").snippet("231 Wilkes Cir, Santa Cruz, CA"));

        mMap.addMarker(new MarkerOptions().position(new LatLng(36.9944, -122.0549)).title("SUA Food Pantry").snippet("1156 High St, Santa Cruz, CA"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.9681, -122.0310)).title("Salvation Army Santa Cruz Corps").snippet("721 Laurel St, Santa Cruz, CA"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.9688, -122.0156)).title("Nueva Vista Community Center").snippet("711 E Cliff Dr, Santa Cruz, CA"));

        float zoom = 12;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(yourLoc, zoom));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener(){

            @Override
            public void onInfoWindowClick(Marker marker) {
                if(type.equals("giving")){
                    LatLng position = marker.getPosition();
                    Intent myIntent = new Intent(MapsActivity2.this, DonorTasks.class);
//                    myIntent.putExtra("Lat", position.latitude);
//                    myIntent.putExtra("long", position.longitude);
                    myIntent.putExtra("Name", marker.getTitle());
                    myIntent.putExtra("Address", marker.getSnippet());
                    startActivity(myIntent);

                }else{
                    String replacement = marker.getSnippet().replace(" ", "+");
                    replacement = replacement.replace(",","%2C");
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin"+yourLoc.latitude+","+yourLoc.longitude+"&destination="+replacement);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

            }
        });
    }

}
