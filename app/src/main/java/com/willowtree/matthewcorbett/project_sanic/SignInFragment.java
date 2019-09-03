package com.willowtree.matthewcorbett.project_sanic;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

public class SignInFragment extends Fragment {

    private TextView loginText;

    private Button submitButton;
    private EditText usernameText;
    private EditText passwordText;
    private CheckBox usernameChecked;

    private TextInputLayout usernameTextInput;


    public static SignInFragment newInstance() {
        return new SignInFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Find all our views
        submitButton = view.findViewById(R.id.submit_button);
        usernameText = view.findViewById(R.id.username_text);
        passwordText = view.findViewById(R.id.password_text);
        usernameChecked = view.findViewById(R.id.save_username);
        loginText = view.findViewById(R.id.login_text);

        usernameTextInput = view.findViewById(R.id.username_text_input);

        usernameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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

                if (getActivity() != null) {
                    Intent intent = new Intent(getActivity(), SecondActivity.class);
                    intent.putExtra(SecondActivity.USERNAME_CHECKED, isUsernameChecked);
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
    }
}
