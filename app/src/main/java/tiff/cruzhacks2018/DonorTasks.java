package tiff.cruzhacks2018;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DonorTasks extends AppCompatActivity {

    String address;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        name = i.getStringExtra("Name");
        address = i.getStringExtra("Address");
        setContentView(R.layout.activity_donor_tasks);
        TextView tv = (TextView) findViewById(R.id.nameaddress);
        tv.setText(address);

        android.support.v7.app.ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle(name);
//        mActionBar.setDisplayShowTitleEnabled(false);
//        mActionBar.setDisplayShowCustomEnabled(true);
//        View customView = getLayoutInflater().inflate(R.layout.actionbar_title, null);
//        TextView customTitle = (TextView) customView.findViewById(R.id.actionbarTitle);
//        customTitle.setText(name);
//        customTitle.setTextSize(20);
//        mActionBar.setCustomView(customView);
    }

    public void onClickFood(View w){
        Intent food = new Intent(this, FoodButton.class); //goes to food page
        food.putExtra("name", name);
        startActivity(food);
//        Toast.makeText(this,
//                "Donate Food Clicked!",
//                Toast.LENGTH_SHORT).show();
    }

    public void onClickMoney(View w){
//        Toast.makeText(this,
//                "Donate Money Clicked!",
//                Toast.LENGTH_SHORT).show();
        Uri uri = Uri.parse("https://venmo.com/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickV(View w){
        Intent i = new Intent(this, VolunteerButton.class);
        i.putExtra("name", name);
        startActivity(i);
//        Toast.makeText(this,
//                "Volunteer to Work Clicked!",
//                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.donor_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch(id){
            case R.id.openMaps:
                String uriAddress = name.replace(" ", "+");
                uriAddress = uriAddress.replace(".","");
                Uri uri = Uri.parse("https://www.google.com/maps/search/?api=1&query="+uriAddress);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
