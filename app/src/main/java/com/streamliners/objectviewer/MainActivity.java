package com.streamliners.objectviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.streamliners.objectviewer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setupHideErrorForEditText();
    }

    /**
     * text watcher to hide error for edit text
     */
    private void setupHideErrorForEditText() {
        TextWatcher myTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hideError();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        b.name.getEditText().addTextChangedListener(myTextWatcher);
        b.rollNo.getEditText().addTextChangedListener(myTextWatcher);
        b.phoneNo.getEditText().addTextChangedListener(myTextWatcher);

    }

    /**
     *  function to send the object by intent
     * @param view
     */
    public void save(View view) {
        //create intent
        Intent intent = new Intent(this, ViewActivity.class);

        //get values from input fields
        String name = b.name.getEditText().getText().toString().trim();
        if (name.isEmpty()) {
            b.name.setError("Please enter a name!");
            return;
        }

        int checkBox = b.gender.getCheckedRadioButtonId();
        String gender;
        if (checkBox == R.id.female)
            gender = "Female";
        else
            gender = "Male";

        String rollNo = b.rollNo.getEditText().getText().toString().trim();
        if (!rollNo.matches("\\d\\d[a-zA-Z]{4}\\d\\d\\d")) {
            b.rollNo.setError("Please enter a valid rollNo!");
            return;
        }

        String phoneNo = b.phoneNo.getEditText().getText().toString().trim();
        if (!phoneNo.matches("^\\d{10}$")) {
            b.phoneNo.setError("Invalid Mobile Number!");
            return;

        }

        //create student object
        Student student = new Student(name, gender, rollNo, phoneNo);
        intent.putExtra(Constants.STUDENT, (Parcelable) student);
        startActivity(intent);

    }
    //utility function
    private void hideError () {
        b.phoneNo.setError(null);
        b.rollNo.setError(null);
        b.name.setError(null);
    }

}