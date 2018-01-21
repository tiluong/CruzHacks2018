package tiff.cruzhacks2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickG(View v){
        Intent myIntent = new Intent(this, MapsActivity2.class);
        startActivity(myIntent);
    }

    public void onClickR(View v){
        Intent myIntent = new Intent(this, Receive.class);
        startActivity(myIntent);
    }

    public void onClickD(View v){
        Intent myIntent = new Intent(this, DonorTasks.class);
        startActivity(myIntent);
    }
}
