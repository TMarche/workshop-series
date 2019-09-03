package com.willowtree.matthewcorbett.project_sanic;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String USERNAME_CHECKED = "USERNAME_CHECKED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        boolean isUserNameChecked = getIntent().getBooleanExtra(USERNAME_CHECKED, false);
        String username = getIntent().getStringExtra(USERNAME);
        String password = getIntent().getStringExtra(PASSWORD);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.second_container, SecondFragment.newInstance(isUserNameChecked, username, password))
                    .commit();
        }
    }
}
