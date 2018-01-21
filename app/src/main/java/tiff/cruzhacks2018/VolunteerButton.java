package tiff.cruzhacks2018;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


//Goal: After the user opens the Google Map, selects a pantry location,
//there will be a page with 3 options: Donate cash, Donate food, Volunteer
//This file gives the Volunteer button an action listener that will open
//up another page when Volunteer is clicked.

public class VolunteerButton extends AppCompatActivity {

    String email, password1, password2;

    EditText emailInput;
    EditText passInput;
    EditText pass2Input;

    Button submitButton;
    private Object v;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);

        emailInput = (EditText) findViewById(R.id.emailInput);
        passInput = (EditText) findViewById(R.id.passInput);
        pass2Input = (EditText) findViewById(R.id.pass2Input);

        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailInput.getText().toString();
                password1 = passInput.getText().toString();
                password2 = pass2Input.getText().toString();

                if (password1.compareTo(password2)!=0 ){
                    Toast.makeText(VolunteerButton.this,
                            "Passwords do not match!",
                            Toast.LENGTH_SHORT).show();
                }
                showToast(email);

            }
        });

    }

    private void showToast(String text) {
//        Toast.makeText(VolunteerButton.this, text, Toast.LENGTH_SHORT).show();
    }
}

//    public void buttonOnClick(View v) {
//        Button btn=(Button) v;
//        ((Button) v).setText("clicked");
//        btn.setOnClickListener(new View.OnClickListener());
//
//    }

//}
