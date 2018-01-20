package tiff.cruzhacks2018;

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
        Toast.makeText(this,
                "Donate Food Clicked!",
                Toast.LENGTH_SHORT).show();
    }

    public void onClickMoney(View w){
        Toast.makeText(this,
                "Donate Money Clicked!",
                Toast.LENGTH_SHORT).show();
    }

    public void onClickV(View w){
        Toast.makeText(this,
                "Volunteer to Work Clicked!",
                Toast.LENGTH_SHORT).show();
    }
}
