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
    private List<String> GOOD_NAMES = Arrays.asList("justin", "troy", "tmarches", "matt");
    private String PASS_ERROR = "Password must be at least " + MIN_PASSWORD_LENGTH +
            " characters long";

    private TextInputLayout usernameEditText;
    private TextInputLayout passwordEditText;
    private RadioGroup radioGroup;
    private CheckBox saveUsername;
    private CheckBox savePassword;
    private Switch shareLocation;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycoolapp);
        setupUsernameField();
        setupPasswordField();
        setupRadioGroup();
        setupBooleanFields();
        setupSubmitButton();
    }

    private void setupUsernameField() {
        usernameEditText = findViewById(R.id.username);

        usernameEditText.getEditText().addTextChangedListener(new TextWatcher() {
            private boolean autoChange = true;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText eText = usernameEditText.getEditText();

                // Check length
                if ( s.length() > MAX_USERNAME_LENGTH) {
                    usernameEditText.setError("Username must be at most "
                    + MAX_USERNAME_LENGTH + " characters long.");
                } else {
                    usernameEditText.setError(null);
                }
                // Check special names
                handleSpecialNames(eText, BAD_NAMES, "sucks");
                handleSpecialNames(eText, GOOD_NAMES, "is cool");
            }

            private void handleSpecialNames(EditText eText, List<String> names, String modifier) {
                String text = eText.getText().toString();
                for (int i = 0; i < names.size(); i++) {
                    if (autoChange && text.toLowerCase().contains( names.get(i))) {
                        autoChange = false;
                        eText.setText( names.get(i) + " " + modifier);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) { autoChange = true; }

        });
    }

    private void setupPasswordField() {
        passwordEditText = findViewById(R.id.password);

        // NOTE: This should occur upon clicking the submit button.
        passwordEditText.getEditText().addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ( ! isValidPassword(s) ){
                    passwordEditText.setError(PASS_ERROR);
                } else {
                    passwordEditText.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}

        });
    }

    private void setupRadioGroup() {
        radioGroup = findViewById(R.id.radiogroup);
    }

    private void setupBooleanFields() {
        saveUsername = findViewById(R.id.save_user);
        savePassword = findViewById(R.id.save_password);
        shareLocation = findViewById(R.id.share_location);
    }

    private void setupSubmitButton() {
        submitButton = findViewById(R.id.submit);
        final TextInputLayout passwordEditText = findViewById(R.id.password);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Do stuff
                Context context = getApplicationContext();
                CharSequence text;
                int duration = Toast.LENGTH_LONG;

                // Check if password meets requirements
                if ( ! isValidPassword(passwordEditText.getEditText().getText() )) {
                    text = PASS_ERROR;
                } else {
                    text = generateToastString();
                }

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    public boolean isValidPassword(CharSequence s) {
        return s.length() >= MIN_PASSWORD_LENGTH;
    }

    private String generateToastString() {
        String username = usernameEditText.getEditText().getText().toString();
        String password = passwordEditText.getEditText().getText().toString();
        int checked = radioGroup.getCheckedRadioButtonId();
        RadioButton checkedButton = findViewById(checked);
        String fontPreference = checkedButton.getText().toString();
        String saveUser = Boolean.toString(saveUsername.isChecked());
        String savePass = Boolean.toString(savePassword.isChecked());
        String shareLoc = Boolean.toString(shareLocation.isChecked());

        return String.format("Username: %s\nPassword: %s\nFont: %s\nSave Username: %s\n" +
                        "Save Password: %s\nShare Location: %s",
                username,
                password,
                fontPreference,
                saveUser,
                savePass,
                shareLoc);
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
