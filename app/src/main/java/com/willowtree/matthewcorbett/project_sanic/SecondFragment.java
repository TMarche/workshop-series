package com.willowtree.matthewcorbett.project_sanic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private TextView usernameTextView;
    private TextView passwordTextView;
    private TextView usernameCheckedTextView;

    public static SecondFragment newInstance(boolean isUsernameChecked,
                                             @Nullable String username,
                                             @Nullable String password) {
        Bundle arguments = new Bundle();
        if (username != null) {
            arguments.putString(SecondActivity.USERNAME, username);
        }
        if (password != null) {
            arguments.putString(SecondActivity.PASSWORD, password);
        }
        arguments.putBoolean(SecondActivity.USERNAME_CHECKED, isUsernameChecked);

        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(arguments);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        usernameTextView = view.findViewById(R.id.username_value);
        passwordTextView = view.findViewById(R.id.password_value);
        usernameCheckedTextView = view.findViewById(R.id.username_checked_value);

        if (getArguments() != null) {
            String username = getArguments().getString(SecondActivity.USERNAME);
            String password = getArguments().getString(SecondActivity.PASSWORD);
            boolean isUsernameChecked = getArguments().getBoolean(SecondActivity.USERNAME_CHECKED, false);

            usernameTextView.setText(username != null ? username : "No username");
            passwordTextView.setText(password != null ? password : "No password");
            usernameCheckedTextView.setText(String.valueOf(isUsernameChecked));
        }
    }
}
