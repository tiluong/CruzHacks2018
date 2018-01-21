package tiff.cruzhacks2018;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DonorTasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_tasks);
    }

    public void onClickFood(View w){
        Intent food = new Intent(this, FoodButton.class); //goes to food page
        startActivity(food);
        Toast.makeText(this,
                "Donate Food Clicked!",
                Toast.LENGTH_SHORT).show();
    }

    public void onClickMoney(View w){
        Toast.makeText(this,
                "Donate Money Clicked!",
                Toast.LENGTH_SHORT).show();
        Uri uri = Uri.parse("https://venmo.com/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickV(View w){
        Intent i = new Intent(this, VolunteerButton.class);
        startActivity(i);
        Toast.makeText(this,
                "Volunteer to Work Clicked!",
                Toast.LENGTH_SHORT).show();
    }
}
