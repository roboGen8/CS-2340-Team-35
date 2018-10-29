package com.example.ben.cs2340.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.annotation.NonNull;

import com.example.ben.cs2340.model.Credentials;
import com.example.ben.cs2340.R;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    /* ************************
        Widgets we will need for binding and getting information
     */

    private static final String TAG = "RegisterActivity";

    private EditText mEmailField;
    private EditText mPasswordField;
    private Spinner mCredentialsField;
    private Credentials credentials = Credentials.USER;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Fields
        mEmailField = (EditText) findViewById(R.id.username_input);
        mPasswordField = (EditText) findViewById(R.id.password_input);
        mCredentialsField = (Spinner) findViewById(R.id.credentials_spinner);
        mAuth = FirebaseAuth.getInstance();

        // Buttons
        findViewById(R.id.register_register).setOnClickListener(this);


        // Set up the adapter to display the allowable credentials in the spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, Credentials.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCredentialsField.setAdapter(adapter);
    }

    private void registerUser(String email, String pass, String creds) {

        Log.d(TAG, email.toString());
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email.trim(), pass.trim())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(RegisterActivity.this, "User Created",
                                    Toast.LENGTH_SHORT).show();

                            FirebaseUser user = mAuth.getCurrentUser();

                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed:" +
                                    task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    /**
     * Button handler for cancel
     *
     * @param view the button pressed
     */
    public void onCancelPressed(View view) {
        finish();
    }

    /**
     * Checks to see if the values typed in to the form are valid
     * @return true if valid, false otherwise
     */
    private boolean validateForm() {
        boolean valid = true;

        String email = mEmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmailField.setError("Please enter a valid email");
            valid = false;
        } else {
            mEmailField.setError(null);
        }

        String password = mPasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required.");
            valid = false;
        } else {
            mPasswordField.setError(null);
        }

        // Auth requires passwords to be at least 6 characters
        if (password.length() < 6) {
            mPasswordField.setError("Password must be at least 6 characters");
            return false;
        } else {
            mPasswordField.setError(null);
        }

        return valid;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.register_register) {
            registerUser(mEmailField.getText().toString(), mPasswordField.getText().toString(),
                    mCredentialsField.toString());
        }
    }
}

