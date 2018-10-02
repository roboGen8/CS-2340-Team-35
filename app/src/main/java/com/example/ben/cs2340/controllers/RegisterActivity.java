package com.example.ben.cs2340.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ben.cs2340.model.Account;
import com.example.ben.cs2340.model.AccountManager;
import com.example.ben.cs2340.model.Credentials;
import com.example.ben.cs2340.R;
import com.example.ben.cs2340.model.LoginService;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /* ************************
        Widgets we will need for binding and getting information
     */
    //private EditText nameField;
    private EditText usernameField;
    private EditText passwordField;
    //private EditText confirmPasswordField;
    private Spinner credentialsSpinner;

    private Credentials credentials = Credentials.USER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Grab the dialog widgets so we can get info for later
         */

        usernameField = (EditText) findViewById(R.id.username_input);
        passwordField = (EditText) findViewById(R.id.password_input);
        //confirmPasswordField = (EditText) findViewById(R.id.confirm_password_input);
        //nameField = (EditText) findViewById(R.id.name_input);
        credentialsSpinner = (Spinner) findViewById(R.id.credentials_spinner);

        /*
          Set up the adapter to display the allowable credentials in the spinner
         */
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Credentials.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        credentialsSpinner.setAdapter(adapter);
    }

    /**
     * Button handler for the add new student button
     * @param view the button
     */
    public void onRegisterPressed(View view) {
        LoginService model = LoginService.getInstance();

        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
//        String confirmPassword = confirmPasswordField.getText().toString();
        Credentials credentials = (Credentials) credentialsSpinner.getSelectedItem();

//        if (!password.equals(confirmPassword)) {
//            passwordField.setError("Passwords do not match");
//        } else {

        if (model.registerAccount(username, password, "", credentials)) {
            finish();
        } else {
            usernameField.setError("Username is taken");
        }
//        }
    }

    /**
     * Button handler for cancel
     *
     * @param view the button pressed
     */
    public void onCancelPressed(View view) {
        Log.d("Edit", "Cancel Student");
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        credentials = (Credentials) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        credentials = Credentials.USER;
    }
}

