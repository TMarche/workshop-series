package com.willowtree.troy.project_sanic;
import android.content.Context;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;
import com.willowtree.matthewcorbett.project_sanic.R;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private int MAX_USERNAME_LENGTH = 16;
    private int MIN_PASSWORD_LENGTH = 8;
    private List<String> BAD_NAMES = Arrays.asList("emily", "ejasieno", "eijasien");
    private List<String> GOOD_NAMES = Arrays.asList("troy", "tmarches", "matt");

    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycoolapp);
        setupSubmitButton();
        setupUsernameField();
        setupPasswordField();

    }

    private void setupSubmitButton() {
        submitButton = findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do stuff
                Context context = getApplicationContext();
                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    private void setupRadioGroup() {
        RadioGroup radioGroup = findViewById(R.id.radiogroup);
    }

    private void setupUsernameField() {
        final TextInputLayout usernameEditText = findViewById(R.id.username);

        usernameEditText.getEditText().addTextChangedListener(new TextWatcher() {
            private boolean autoChange = true;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText eText = usernameEditText.getEditText();
                String text = eText.getText().toString();

                // Check length
                if ( s.length() > MAX_USERNAME_LENGTH) {
                    usernameEditText.setError("Username must be at most "
                    + MAX_USERNAME_LENGTH + " characters long.");
                } else {
                    usernameEditText.setError(null);
                }
                // Check special names
                for ( int i = 0; i < BAD_NAMES.size(); i++) {
                    if ( autoChange && text.toLowerCase().contains( BAD_NAMES.get(i) )) {
                        autoChange = false;
                        eText.setText( BAD_NAMES.get(i) + " sucks");
                    }
                    if ( autoChange && text.toLowerCase().contains( GOOD_NAMES.get(i) )) {
                        autoChange = false;
                        eText.setText( GOOD_NAMES.get(i) + " is cool");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) { autoChange = true; }

        });
    }

    private void setupPasswordField() {
        final TextInputLayout passwordEditText = findViewById(R.id.password);

        // NOTE: This should occur upon clicking the submit button.
        passwordEditText.getEditText().addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ( s.length() < MIN_PASSWORD_LENGTH) {
                    passwordEditText.setError("Password must be at least "
                            + MIN_PASSWORD_LENGTH + " characters long.");
                } else {
                    passwordEditText.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
