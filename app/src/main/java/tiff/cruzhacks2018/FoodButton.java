package tiff.cruzhacks2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;


//Goal: After the user opens the Google Map, selects a pantry location,
//there will be a page with 3 options: Donate cash, Donate food, Volunteer
//This file gives the Volunteer button an action listener that will open
//up another page when Volunteer is clicked.

public class FoodButton extends AppCompatActivity {

    Button submitButton;
    private Object v;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        android.support.v7.app.ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle(name);
        setContentView(R.layout.activity_food);

    }

    public void onClick(View w){
        Toast.makeText(this,
                "Thank you - We will connect you with one of our volunteer drivers to arrange a pickup location and time.",
                Toast.LENGTH_LONG).show();
    }
}
