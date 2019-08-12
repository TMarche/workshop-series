package com.willowtree.matthewcorbett.project_sanic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button submitButton;
    private EditText usernameText;
    private EditText passwordText;
    private CheckBox usernameChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find all our views
        submitButton = findViewById(R.id.submit_button);
        usernameText = findViewById(R.id.username_text);
        passwordText = findViewById(R.id.password_text);
        usernameChecked = findViewById(R.id.save_username);

        /* Set a listener on the button so that we can do something
        when the user clicks
         */
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the text from the text fields, and whether our username is checked
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                boolean isUsernameChecked = usernameChecked.isChecked();

                //A Toast will make a small alert at the bottom of our screen
                Toast.makeText(MainActivity.this, username + " " + password + " " + isUsernameChecked, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
