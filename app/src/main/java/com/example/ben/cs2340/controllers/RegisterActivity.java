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

import com.example.ben.cs2340.model.Accounts;
import com.example.ben.cs2340.model.Credentials;
import com.example.ben.cs2340.R;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /* ************************
        Widgets we will need for binding and getting information
     */

    private EditText nameField;
    private EditText usernameField;
    private EditText passwordField;
    private EditText confirmPasswordField;
    private Spinner credentialsSpinner;

    /* ************************
       Keeping track of spinner changes.  Not really used right now, probably don't need this.
     */
    private String _major = "NA";

    /* ***********************
       Data for student being edited.
     */
    private Accounts _account;

    /* ***********************
       flag for whether this is a new student being added or an existing student being edited;
     */
    private boolean editing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        /**
         * Grab the dialog widgets so we can get info for later
         */
        nameField = (EditText) findViewById(R.id.name_input);
        credentialsSpinner = (Spinner) findViewById(R.id.credentials_spinner);

        /*
          Set up the adapter to display the allowable majors in the spinner
         */


        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Credentials.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        credentialsSpinner.setAdapter(adapter);


    /**
     * Button handler for the add new student button
     * @param view the button
     */
    public void onAddPressed(View view) {
        Log.d("Edit", "Add Student");
        Model model = Model.getInstance();

        _student.setName(nameField.getText().toString());
        _student.setMajor((String) majorSpinner.getSelectedItem());
        _student.setClassStanding((ClassStanding) classSpinner.getSelectedItem());

        Log.d("Edit", "Got new student data: " + _student);
        if (!editing) {
            model.addStudent(_student);
        }  else {
            model.replaceStudentData(_student);
        }

        finish();
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

          _major = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        _major = "NA";
    }
}
